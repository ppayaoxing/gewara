/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.hbase.impl;

import com.gewara.hbase.AggregateData;
import com.gewara.hbase.HBaseService;
import com.gewara.hbase.HbaseData;
import com.gewara.hbase.Row;
import com.gewara.hbase.RowCallback;
import com.gewara.hbase.RowDataCallback;
import com.gewara.hbase.RowFilter;
import com.gewara.hbase.TableCallback;
import com.gewara.hbase.util.FilterBuilder;
import com.gewara.hbase.util.GroupFields;
import com.gewara.hbase.util.ScanBuilder;
import com.gewara.util.BeanUtil;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import com.gewara.util.ObjectId;
import com.gewara.util.ValidateUtil;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.apache.hadoop.hbase.client.coprocessor.LongColumnInterpreter;
import org.apache.hadoop.hbase.io.compress.Compression.Algorithm;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.InitializingBean;

public class HBaseServiceImpl implements HBaseService, InitializingBean {
	private final transient GewaLogger dbLogger = LoggerUtils.getLogger(HBaseServiceImpl.class);
	private static final byte[] columnFamily = "DF".getBytes();
	private String zookeeperQuorum;
	private Connection connection = null;
	private AggregationClient aggregationClient;
	private Configuration cfg;

	public void setZookeeperQuorum(String zookeeperQuorum) {
		this.zookeeperQuorum = zookeeperQuorum;
	}

	public HBaseServiceImpl() {
	}

	public HBaseServiceImpl(String zookeeperQuorum) {
		this.zookeeperQuorum = zookeeperQuorum;
	}

	public void setupHbase() {
		this.cfg = HBaseConfiguration.create();
		this.cfg.clear();
		this.cfg.set("hbase.zookeeper.quorum", this.zookeeperQuorum);
		this.cfg.set("hbase.zookeeper.property.clientPort", "2181");
		(new Thread(new Runnable() {
			public void run() {
				HBaseServiceImpl.this.dbLogger.warn("try setup HBase.....");

				try {
					HBaseServiceImpl.this.aggregationClient = new AggregationClient(HBaseServiceImpl.this.cfg);
				} catch (Exception arg1) {
					HBaseServiceImpl.this.dbLogger.warn("setup HBase aggregationClient failure:", arg1);
				}

				if (HBaseServiceImpl.this.getConnection() != null) {
					HBaseServiceImpl.this.dbLogger.warn("setup HBase success!!!!");
				} else {
					HBaseServiceImpl.this.dbLogger.warn("setup HBase failure!!!!");
				}

			}
		})).start();
	}

	private Connection getConnection() {
		if (this.connection == null || this.connection.isClosed()) {
			synchronized (this) {
				if (this.connection == null || this.connection.isClosed()) {
					try {
						this.connection = ConnectionFactory.createConnection(this.cfg);
					} catch (Exception arg3) {
						this.dbLogger.warn(arg3, 30);
						throw new IllegalStateException("can NOT get the connection from the Hbase", arg3.getCause());
					}
				}
			}
		}

		return this.connection;
	}

	private Admin getHBaseAdmin() {
		Admin hbaseAdmin = null;

		try {
			hbaseAdmin = this.getConnection().getAdmin();
			return hbaseAdmin;
		} catch (Exception arg2) {
			this.dbLogger.warn(arg2, 30);
			throw new IllegalStateException("can NOT get the connection from the Hbase", arg2.getCause());
		}
	}

	protected <T> T execute(String tablename, TableCallback<T> action) {
		Table hTable = null;

		Object arg4;
		try {
			hTable = this.getConnection().getTable(TableName.valueOf(tablename));
			Object e = action.doWithTable(hTable);
			arg4 = e;
		} catch (Exception arg13) {
			throw new RuntimeException(arg13);
		} finally {
			if (hTable != null) {
				try {
					hTable.close();
				} catch (Exception arg12) {
					this.dbLogger.warn(arg12, 30);
				}
			}

		}

		return arg4;
	}

	protected int executeWithScan(String tableName, Scan scan, RowCallback action, int maxnum) {
		HBaseServiceImpl.DefaultTableCallback callback = new HBaseServiceImpl.DefaultTableCallback(scan, action,
				maxnum);
		this.execute(tableName, callback);
		return callback.getProcessRows();
	}

	protected Row getRowData(Result row) {
		if (row.isEmpty()) {
			return null;
		} else {
			LinkedHashMap rowdata = new LinkedHashMap();
			NavigableMap map = row.getNoVersionMap();
			NavigableMap data = (NavigableMap) map.get(columnFamily);
			Iterator arg4 = data.entrySet().iterator();

			while (arg4.hasNext()) {
				Entry entry = (Entry) arg4.next();
				rowdata.put(Bytes.toString((byte[]) entry.getKey()), Bytes.toString((byte[]) entry.getValue()));
			}

			rowdata.put("rowid", Hex.encodeHexString(row.getRow()));
			return new Row(row.getRow(), rowdata);
		}
	}

	protected Map<Long, Map<String, String>> getMultiVerRowData(Result row) {
		TreeMap rowMap = new TreeMap();
		if (row.isEmpty()) {
			return rowMap;
		} else {
			NavigableMap multiData = row.getMap();
			NavigableMap data = (NavigableMap) multiData.get(columnFamily);
			Iterator arg4 = data.entrySet().iterator();

			while (arg4.hasNext()) {
				Entry entry = (Entry) arg4.next();
				NavigableMap coldata = (NavigableMap) entry.getValue();
				Iterator arg7 = coldata.keySet().iterator();

				while (arg7.hasNext()) {
					Long timestamp = (Long) arg7.next();
					Object rowdata = (Map) rowMap.get(timestamp);
					if (rowdata == null) {
						rowdata = new LinkedHashMap();
						rowMap.put(timestamp, rowdata);
					}

					((Map) rowdata).put("rowid", Hex.encodeHexString(row.getRow()));
					((Map) rowdata).put(Bytes.toString((byte[]) entry.getKey()),
							Bytes.toString((byte[]) coldata.get(timestamp)));
				}
			}

			return rowMap;
		}
	}

	private String getTimestr(byte[] rowid) {
		String timestr = "";
		if (rowid.length >= 4) {
			long time = (long) Bytes.toInt(Arrays.copyOfRange(rowid, 0, 4)) * 1000L;
			timestr = DateUtil.formatTimestamp(Long.valueOf(time));
		}

		return timestr;
	}

	public void saveRow(String tablename, Map<String, String> rowdata) {
		if (!rowdata.isEmpty()) {
			byte[] rowid = ObjectId.get().toByteArray();
			this.saveRow(tablename, rowid, rowdata);
		}
	}

	public void removeRowByHex(String tablename, String hexid) {
		try {
			byte[] e = Hex.decodeHex(hexid.toCharArray());
			this.removeRowById(tablename, e);
		} catch (DecoderException arg3) {
			this.dbLogger.warn(arg3, 50);
		}

	}

	public void removeRowById(String tablename, final byte[] rowid) {
		this.execute(tablename, new TableCallback() {
			public Object doWithTable(Table htable) throws Exception {
				Delete delete = new Delete(rowid);
				htable.delete(delete);
				return null;
			}
		});
	}

	public void saveRow(String tablename, final byte[] rowid, final Map<String, String> rowdata) {
		if (!rowdata.isEmpty()) {
			this.execute(tablename, new TableCallback() {
				public Object doWithTable(Table htable) throws Exception {
					Map data = BeanUtil.toSimpleStringMap(rowdata);
					Put put = new Put(rowid);
					Iterator arg3 = data.keySet().iterator();

					while (arg3.hasNext()) {
						String key = (String) arg3.next();
						if (StringUtils.isNotBlank((String) data.get(key))) {
							put.addColumn(HBaseServiceImpl.columnFamily, Bytes.toBytes(key),
									Bytes.toBytes((String) data.get(key)));
						}
					}

					htable.put(put);
					return null;
				}
			});
		}
	}

	public List<Row> getRowListByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime,
			final RowFilter filter, int maxnum) {
		final ArrayList result = new ArrayList();
		Scan scan = this.getScanBuilder(tableName, fb, starttime, endtime).buildScan();
		this.executeWithScan(tableName, scan, new RowCallback() {
			public void doInRow(Result row) throws Exception {
				Row rowdata = HBaseServiceImpl.this.getRowData(row);
				if (rowdata != null && (filter == null || filter.accept(rowdata))) {
					result.add(rowdata);
				}

			}
		}, maxnum);
		return result;
	}

	public List<byte[]> getRowidListByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime,
			int maxnum) {
		return this.getRowidListByRange(tableName, fb, starttime, endtime, maxnum, (String) null);
	}

	public List<byte[]> getRowidListByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime,
			int maxnum, String column) {
		final ArrayList result = new ArrayList();
		ScanBuilder scanBuilder = this.getScanBuilder(tableName, fb, starttime, endtime);
		Scan scan = scanBuilder.buildScan();
		if (StringUtils.isNotBlank(column) && scanBuilder.isEmptyCondition() && HbaseData.supportTimeRange(tableName)) {
			scan.addColumn(columnFamily, column.getBytes());
		}

		this.executeWithScan(tableName, scan, new RowCallback() {
			public void doInRow(Result row) throws Exception {
				result.add(row.getRow());
			}
		}, maxnum);
		return result;
	}

	public int removeByRange(final String tableName, FilterBuilder fb, Long starttime, Long endtime, String column) {
		final ArrayList rowidList = new ArrayList();
		ScanBuilder scanBuilder = this.getScanBuilder(tableName, fb, starttime, endtime);
		Scan scan = scanBuilder.buildScan();
		if (StringUtils.isNotBlank(column) && scanBuilder.isEmptyCondition() && HbaseData.supportTimeRange(tableName)) {
			scan.addColumn(columnFamily, column.getBytes());
		}

		final AtomicInteger count = new AtomicInteger(0);
		this.executeWithScan(tableName, scan, new RowCallback() {
			public void doInRow(Result row) throws Exception {
				rowidList.add(row.getRow());
				if (rowidList.size() >= 5000) {
					HBaseServiceImpl.this.removeRowList(tableName, rowidList);
					count.addAndGet(5000);
					rowidList.clear();
				}

			}
		}, 200000000);
		if (rowidList.size() > 0) {
			this.removeRowList(tableName, rowidList);
			count.addAndGet(rowidList.size());
		}

		return count.get();
	}

	public List<Row> getRowListByIdRange(String tableName, FilterBuilder fb, byte[] startRowId, byte[] endRowId,
			final RowFilter filter, int maxnum) {
		final ArrayList result = new ArrayList();
		Scan scan = this.getScan(fb, startRowId, endRowId);
		this.executeWithScan(tableName, scan, new RowCallback() {
			public void doInRow(Result row) throws Exception {
				Row rowdata = HBaseServiceImpl.this.getRowData(row);
				if (rowdata != null && (filter == null || filter.accept(rowdata))) {
					result.add(rowdata);
				}

			}
		}, maxnum);
		return result;
	}

	public List<Map<Long, Map<String, String>>> getMultiRowListByIdRange(String tableName, int maxVersions,
			FilterBuilder fb, byte[] startRowId, byte[] endRowId, int maxnum) {
		final ArrayList result = new ArrayList();
		Scan scan = this.getScan(fb, startRowId, endRowId);
		scan.setMaxVersions(maxVersions);
		this.executeWithScan(tableName, scan, new RowCallback() {
			public void doInRow(Result row) throws Exception {
				Map rowdata = HBaseServiceImpl.this.getMultiVerRowData(row);
				result.add(rowdata);
			}
		}, maxnum);
		return result;
	}

	public long getRowCountByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime) {
		Scan scan = this.getScanBuilder(tableName, fb, starttime, endtime).buildScan();
		scan.addFamily(columnFamily);
		LongColumnInterpreter columnInterpreter = new LongColumnInterpreter();
		long result = -1L;

		try {
			result = this.aggregationClient.rowCount(TableName.valueOf(tableName), columnInterpreter, scan);
		} catch (Throwable arg9) {
			this.dbLogger.warn(arg9, 30);
		}

		return result;
	}

	public void processRowListByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime,
			final RowDataCallback callback, final RowFilter filter) {
		Scan scan = this.getScanBuilder(tableName, fb, starttime, endtime).buildScan();
		this.executeWithScan(tableName, scan, new RowCallback() {
			public void doInRow(Result row) throws Exception {
				Row rowdata = HBaseServiceImpl.this.getRowData(row);
				if (rowdata != null && (filter == null || filter.accept(rowdata))) {
					callback.processRow(rowdata);
				}

			}
		}, -1);
	}

	public void processRowListByRowIdRange(String tableName, FilterBuilder fb, byte[] startRowId, byte[] endRowId,
			final RowDataCallback callback, final RowFilter filter) {
		Scan scan = this.getScan(fb, startRowId, endRowId);
		this.executeWithScan(tableName, scan, new RowCallback() {
			public void doInRow(Result row) throws Exception {
				Row rowdata = HBaseServiceImpl.this.getRowData(row);
				if (rowdata != null && (filter == null || filter.accept(rowdata))) {
					callback.processRow(rowdata);
				}

			}
		}, -1);
	}

	protected Scan getScan(FilterBuilder fb) {
		ScanBuilder sb = new ScanBuilder(fb);
		return sb.buildScan();
	}

	protected Scan getScan(FilterBuilder fb, byte[] startRow, byte[] stopRow) {
		fb.setStartRow(startRow);
		fb.setStopRow(stopRow);
		ScanBuilder sb = new ScanBuilder(fb);
		return sb.buildScan();
	}

	protected ScanBuilder getScanBuilder(String tablename, FilterBuilder fb, Long starttime, Long endtime) {
		if (fb == null) {
			fb = new FilterBuilder();
		}

		if (HbaseData.supportTimeRange(tablename)) {
			if (starttime != null) {
				fb.setStartRow(this.getStartRowId(starttime));
			}

			if (endtime != null) {
				fb.setStopRow(this.getEndRowId(endtime));
			}
		} else {
			fb.gte("addtime", DateUtil.formatTimestamp(starttime));
			fb.lte("addtime", DateUtil.formatTimestamp(endtime));
		}

		ScanBuilder sb = new ScanBuilder(fb);
		return sb;
	}

	private byte[] getStartRowId(Long timestamp) {
		byte[] b = new byte[12];
		ByteBuffer bb = ByteBuffer.wrap(b);
		bb.putInt((int) (timestamp.longValue() / 1000L));
		bb.putInt(0);
		bb.putInt(0);
		return b;
	}

	private byte[] getEndRowId(Long timestamp) {
		byte[] b = new byte[12];
		ByteBuffer bb = ByteBuffer.wrap(b);
		bb.putInt((int) (timestamp.longValue() / 1000L));
		bb.putInt(Integer.MAX_VALUE);
		bb.putInt(Integer.MAX_VALUE);
		return b;
	}

	public AggregateData getGroupData(String tablename, GroupFields gf, FilterBuilder fb, Long starttime, Long endtime,
			int maxRowScan, final RowFilter filter) {
		Scan scan = this.getScanBuilder(tablename, fb, starttime, endtime).buildScan();
		final AggregateData result = new AggregateData(gf);
		this.executeWithScan(tablename, scan, new RowCallback() {
			public void doInRow(Result row) throws Exception {
				Row data = HBaseServiceImpl.this.getRowData(row);
				if (data != null && (filter == null || filter.accept(data))) {
					result.processRow(data.getData());
				}

			}
		}, maxRowScan);
		return result;
	}

	public List<Row> getRowList(String tableName, FilterBuilder fb, int maxnum) {
		Scan scan = this.getScan(fb);
		final ArrayList result = new ArrayList();
		this.executeWithScan(tableName, scan, new RowCallback() {
			public void doInRow(Result row) throws Exception {
				Row rowdata = HBaseServiceImpl.this.getRowData(row);
				if (rowdata != null) {
					result.add(rowdata);
				}

			}
		}, maxnum);
		return result;
	}

	public Row getRowByHex(String tableName, String hexid) {
		try {
			byte[] e = Hex.decodeHex(hexid.toCharArray());
			return this.getRowById(tableName, e);
		} catch (Exception arg3) {
			throw new IllegalArgumentException(arg3);
		}
	}

	public Row getRowByStrId(String tablename, String strId) {
		return this.getRowById(tablename, Bytes.toBytes(strId));
	}

	public Row getRowById(String tablename, final byte[] rowid) {
		return (Row) this.execute(tablename, new TableCallback() {
			public Row doWithTable(Table htable) throws Exception {
				Get get = new Get(rowid);
				get.addFamily(HBaseServiceImpl.columnFamily);
				Result row = htable.get(get);
				return HBaseServiceImpl.this.getRowData(row);
			}
		});
	}

	public Map<Long, Map<String, String>> getMultiVersionRow(String tableName, final byte[] rowid,
			final int maxVersion) {
		final TreeMap rowMap = new TreeMap();
		this.execute(tableName, new TableCallback() {
			public Object doWithTable(Table htable) throws Exception {
				Get get = new Get(rowid);
				get.addFamily(HBaseServiceImpl.columnFamily);
				get.setMaxVersions(maxVersion);
				Result row = htable.get(get);
				rowMap.putAll(HBaseServiceImpl.this.getMultiVerRowData(row));
				return null;
			}
		});
		return rowMap;
	}

	public List<Row> getRowListByHexids(String tablename, List<String> hexidList) {
		ArrayList rowidList = new ArrayList(hexidList.size());
		Iterator arg3 = hexidList.iterator();

		while (arg3.hasNext()) {
			String hexid = (String) arg3.next();

			try {
				rowidList.add(Hex.decodeHex(hexid.toCharArray()));
			} catch (DecoderException arg6) {
				;
			}
		}

		return this.getRowListByIdList(tablename, rowidList);
	}

	public List<Row> getRowListByIdList(String tablename, final List<byte[]> rowidList) {
		final LinkedList rowList = new LinkedList();
		this.execute(tablename, new TableCallback() {
			public Object doWithTable(Table htable) throws Exception {
				try {
					ArrayList gets = new ArrayList(rowidList.size());
					Iterator rows = rowidList.iterator();

					while (rows.hasNext()) {
						byte[] rowid = (byte[]) rows.next();
						Get get = new Get(rowid);
						get.addFamily(HBaseServiceImpl.columnFamily);
						gets.add(get);
					}

					Result[] arg11 = htable.get(gets);
					Result[] arg12 = arg11;
					int arg13 = arg11.length;

					for (int arg5 = 0; arg5 < arg13; ++arg5) {
						Result row = arg12[arg5];
						Row rowdata = HBaseServiceImpl.this.getRowData(row);
						if (rowdata != null) {
							rowList.add(rowdata);
						}
					}

					arg12 = null;
					return arg12;
				} finally {
					htable.close();
				}
			}
		});
		return rowList;
	}

	public void saveRow(String tablename, String hexid, Map<String, String> rowdata) {
		rowdata.remove("rowid");

		try {
			this.saveRow(tablename, Hex.decodeHex(hexid.toCharArray()), rowdata);
		} catch (DecoderException arg4) {
			this.dbLogger.warn(arg4, 20);
		}

		rowdata.put("rowid", hexid);
	}

	public boolean isAvaliable() {
		try {
			return !this.getConnection().isClosed();
		} catch (Exception arg1) {
			return false;
		}
	}

	public void afterPropertiesSet() throws Exception {
		(new Thread(new Runnable() {
			public void run() {
				HBaseServiceImpl.this.setupHbase();
			}
		})).start();
	}

	public void saveRowListByHex(String tableName, String hexidName, List<Map<String, String>> rowList) {
		ArrayList puts = new ArrayList(rowList.size());
		Iterator arg4 = rowList.iterator();

		while (arg4.hasNext()) {
			Map row = (Map) arg4.next();
			Object rowid = null;
			byte[] rowid1;
			if (row.containsKey(hexidName)) {
				try {
					rowid1 = Hex.decodeHex(((String) row.remove(hexidName)).toCharArray());
				} catch (DecoderException arg10) {
					throw new IllegalArgumentException("RowidError", arg10);
				}
			} else {
				rowid1 = ObjectId.get().toByteArray();
			}

			Put put = new Put(rowid1);
			Iterator arg8 = row.keySet().iterator();

			while (arg8.hasNext()) {
				String key = (String) arg8.next();
				if (StringUtils.isNotBlank((String) row.get(key))) {
					put.addColumn(columnFamily, Bytes.toBytes(key), Bytes.toBytes((String) row.get(key)));
				}
			}

			puts.add(put);
		}

		this.savePuts(tableName, puts);
	}

	private void savePuts(String tableName, final List<Put> puts) {
		this.execute(tableName, new TableCallback() {
			public Object doWithTable(Table htable) throws Exception {
				Object arg1;
				try {
					htable.put(puts);
					arg1 = null;
				} finally {
					htable.close();
				}

				return arg1;
			}
		});
	}

	public void saveRowList(String tablename, List<Row> rowList) {
		ArrayList puts = new ArrayList();
		Iterator arg3 = rowList.iterator();

		while (true) {
			Put put;
			Map data;
			do {
				if (!arg3.hasNext()) {
					this.savePuts(tablename, puts);
					return;
				}

				Row row = (Row) arg3.next();
				put = new Put(row.getRowid());
				data = row.getData();
			} while (data == null);

			Iterator arg7 = data.keySet().iterator();

			while (arg7.hasNext()) {
				String key = (String) arg7.next();
				if (StringUtils.isNotBlank((String) data.get(key))) {
					put.addColumn(columnFamily, Bytes.toBytes(key), Bytes.toBytes((String) data.get(key)));
				}
			}

			puts.add(put);
		}
	}

	public void saveRowListByStrId(String tableName, String idName, List<Map<String, String>> rowList) {
		ArrayList puts = new ArrayList();
		Iterator arg4 = rowList.iterator();

		while (arg4.hasNext()) {
			Map row = (Map) arg4.next();
			Object rowid = null;
			byte[] rowid1;
			if (row.containsKey(idName)) {
				try {
					rowid1 = ((String) row.remove(idName)).getBytes("utf-8");
				} catch (UnsupportedEncodingException arg10) {
					throw new IllegalArgumentException("RowidError", arg10);
				}
			} else {
				rowid1 = ObjectId.get().toByteArray();
			}

			Put put = new Put(rowid1);
			Iterator arg8 = row.keySet().iterator();

			while (arg8.hasNext()) {
				String key = (String) arg8.next();
				if (StringUtils.isNotBlank((String) row.get(key))) {
					put.addColumn(columnFamily, Bytes.toBytes(key), Bytes.toBytes((String) row.get(key)));
				}
			}

			puts.add(put);
		}

		this.savePuts(tableName, puts);
	}

	public void removeRowListByHex(String tablename, String[] hexidList) {
		ArrayList rowidList = new ArrayList();
		String[] arg3 = hexidList;
		int arg4 = hexidList.length;

		for (int arg5 = 0; arg5 < arg4; ++arg5) {
			String hexid = arg3[arg5];

			try {
				rowidList.add(Hex.decodeHex(hexid.toCharArray()));
			} catch (Exception arg8) {
				;
			}
		}

		this.removeRowList(tablename, rowidList);
	}

	public void removeRowListByHex(String tablename, List<String> hexidList) {
		ArrayList rowidList = new ArrayList();
		Iterator arg3 = hexidList.iterator();

		while (arg3.hasNext()) {
			String hexid = (String) arg3.next();

			try {
				rowidList.add(Hex.decodeHex(hexid.toCharArray()));
			} catch (Exception arg6) {
				;
			}
		}

		this.removeRowList(tablename, rowidList);
	}

	public void removeRowList(String tablename, final List<byte[]> rowidList) {
		this.execute(tablename, new TableCallback() {
			public Object doWithTable(Table htable) throws Exception {
				try {
					ArrayList deletes = new ArrayList(rowidList.size());
					Iterator arg2 = rowidList.iterator();

					while (arg2.hasNext()) {
						byte[] rowid = (byte[]) arg2.next();
						deletes.add(new Delete(rowid));
					}

					htable.delete(deletes);
					arg2 = null;
					return arg2;
				} finally {
					htable.close();
				}
			}
		});
	}

	public static void main(String[] args) {
		HBaseServiceImpl hbaseService = new HBaseServiceImpl("192.168.2.254,192.168.2.253,192.168.2.252");
		byte[] startRowId = hbaseService.getStartRowId(Long.valueOf((new Date()).getTime()));
		System.out.println(startRowId);
		System.out.println(startRowId.length);
		System.out.println(Bytes.toHex(startRowId));
		System.out.println("^^");
		System.out.println(Hex.encodeHexString(startRowId));
		System.out.println(Bytes.toString(startRowId));
		byte[] endRowId = hbaseService.getEndRowId(Long.valueOf((new Date()).getTime()));
		System.out.println(endRowId);
		byte[] objectId = ObjectId.get().toByteArray();
		System.out.println("^^");
		System.out.println(Hex.encodeHexString(objectId));
		System.out.println(Bytes.toString(objectId));
	}

	public boolean createTable(String tableName, int maxVersions) {
		ValidateUtil.isVariable(tableName, 5, 50);
		Admin admin = this.getHBaseAdmin();

		try {
			if (!admin.isTableAvailable(TableName.valueOf(tableName))) {
				HTableDescriptor e = new HTableDescriptor(TableName.valueOf(tableName));
				HColumnDescriptor coldef = new HColumnDescriptor(Bytes.toBytes("DF"));
				coldef.setCompressionType(Algorithm.SNAPPY);
				if (maxVersions > 0) {
					coldef.setMaxVersions(maxVersions);
				}

				e.addFamily(coldef);
				admin.createTable(e);
			}

			return true;
		} catch (Exception arg5) {
			this.dbLogger.warn(arg5, 200);
			return false;
		}
	}

	public class DefaultTableCallback implements TableCallback {
		private Scan scan;
		private RowCallback action;
		private int maxnum;
		private int processRows = 0;

		public int getProcessRows() {
			return this.processRows;
		}

		public DefaultTableCallback(Scan scan, RowCallback action, int maxnum) {
			this.scan = scan;
			this.action = action;
			this.maxnum = maxnum;
			if (scan.getCaching() <= 1) {
				if (maxnum <= 0) {
					scan.setCaching(500);
				} else {
					scan.setCaching(Math.min(500, maxnum));
				}
			}

		}

		public Object doWithTable(Table hTable) {
			ResultScanner scanner = null;

			try {
				scanner = hTable.getScanner(this.scan);
				Iterator e = scanner.iterator();
				Result row = null;

				while (e.hasNext() && (this.maxnum < 0 || this.processRows < this.maxnum)) {
					row = (Result) e.next();
					this.action.doInRow(row);
					++this.processRows;
					if (this.processRows % 5000 == 0) {
						HBaseServiceImpl.this.dbLogger.warn("processRowNum:" + this.processRows + ",t="
								+ HBaseServiceImpl.this.getTimestr(row.getRow()));
					}
				}
			} catch (Exception arg11) {
				throw new RuntimeException(arg11);
			} finally {
				if (scanner != null) {
					try {
						scanner.close();
					} catch (Exception arg10) {
						HBaseServiceImpl.this.dbLogger.warn(arg10, 30);
					}
				}

			}

			return null;
		}
	}
}