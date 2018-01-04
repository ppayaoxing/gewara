package com.gewara.hbase.impl;

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
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;
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

/**
 * Helper class that simplifies Hbase data access code. This class will call
 * HTablePool's getTable and closeHtable methods before and after your action.
 * 
 * @author Vaibhav Puranik
 * @version $Id: HBaseTemplate.java 8964 2011-05-23 20:57:05Z vaibhav $
 */
public class HBaseServiceImpl implements HBaseService, InitializingBean {
	private final transient GewaLogger dbLogger = LoggerUtils.getLogger(HBaseServiceImpl.class);

	// private static final String VALIDATE_TABLE_NAME = "monitor"; [johnson]no
	// need
	private static final byte[] columnFamily = "DF".getBytes();// DEFAUTFAMILY

	private String zookeeperQuorum;
	private Connection connection = null;

	public void setZookeeperQuorum(String zookeeperQuorum) {
		this.zookeeperQuorum = zookeeperQuorum;
	}

	/**
	 * AggregationClient锟斤拷锟斤拷hbase锟斤拷实锟街简单聚合硷拷锟斤拷,锟斤拷锟斤拷{@link Configuration}锟斤拷锟斤拷
	 */
	private AggregationClient aggregationClient;
	/**
	 * hbase 锟斤拷锟矫碉拷锟节达拷峁癸拷锟绞�
	 */
	private Configuration cfg;

	public HBaseServiceImpl() {
	}

	public HBaseServiceImpl(String zookeeperQuorum) {
		this.zookeeperQuorum = zookeeperQuorum;
	}

	public void setupHbase() {
		cfg = HBaseConfiguration.create();
		cfg.clear();
		cfg.set("hbase.zookeeper.quorum", zookeeperQuorum);
		cfg.set("hbase.zookeeper.property.clientPort", "2181");
		// cfg.set("hbase.client.connection.impl",
		// HConnectionManager.HConnectionImplementation.class.getName());//默锟较伙拷取锟斤拷实锟斤拷锟斤拷,锟斤拷锟斤拷锟斤拷锟斤拷
		//XXX no-block the spring container startup!!!
		new Thread(new Runnable(){
			@Override
			public void run() {
				dbLogger.warn("try setup HBase.....");
				try{
					aggregationClient = new AggregationClient(cfg);
				}catch(Exception e){
					dbLogger.warn("setup HBase aggregationClient failure:", e);
				}

				/*
				 * getHConnection锟角革拷锟斤拷锟斤拷锟斤拷锟斤拷,只要锟斤拷锟斤拷值锟斤拷锟斤拷,锟酵达拷锟斤拷锟斤拷锟窖撅拷锟斤拷锟斤拷锟斤拷锟�,锟斤拷锟斤拷使锟矫客伙拷锟剿等达拷一锟斤拷锟斤拷时锟斤拷
				 */
				if (/*isAvaliable()*/getConnection() != null) {
					dbLogger.warn("setup HBase success!!!!");
				} else {
					dbLogger.warn("setup HBase failure!!!!");
				}
			}
		}).start();
	}

	/**
	 * getHConnection锟角革拷锟斤拷锟斤拷锟斤拷锟斤拷,只要锟斤拷锟斤拷值锟斤拷锟斤拷,锟酵达拷锟斤拷锟斤拷锟窖撅拷锟斤拷锟斤拷锟斤拷锟�,锟斤拷锟斤拷使锟矫客伙拷锟剿等达拷一锟斤拷锟斤拷时锟斤拷
	 */
	private Connection getConnection() {
		if(connection==null || connection.isClosed()){
			synchronized (this) {
				if(connection==null || connection.isClosed()){
					try {
						connection = ConnectionFactory.createConnection(cfg);
					} catch (Exception e) {
						dbLogger.warn(e, 30);
						throw new IllegalStateException("can NOT get the connection from the Hbase", e.getCause());
					}
				}
			}
		}
		return connection;
	}

	private Admin getHBaseAdmin() {
		Admin hbaseAdmin = null;
		try {
			hbaseAdmin = getConnection().getAdmin();
		} catch (Exception e) {
			dbLogger.warn(e, 30);
			throw new IllegalStateException("can NOT get the connection from the Hbase", e.getCause());
		}
		return hbaseAdmin;
	}

	protected <T> T execute(String tablename, TableCallback<T> action) {
		Table hTable = null;
		try {
			hTable = getConnection().getTable(TableName.valueOf(tablename));
			T result = action.doWithTable(hTable);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (hTable != null) {
                try {
                    hTable.close();
                } catch (Exception e) {
                    dbLogger.warn(e, 30);
                }
            }
		}
	}

	protected int executeWithScan(String tableName, final Scan scan, final RowCallback action, final int maxnum) {
		DefaultTableCallback callback = new DefaultTableCallback(scan, action, maxnum);
		this.execute(tableName, callback);
		return callback.getProcessRows();
	}

	/**
	 * 锟斤拷#Result锟斤拷锟斤拷锟斤拷锟捷碉拷一锟斤拷(一锟斤拷 map 锟斤拷平锟斤拷锟斤拷锟叫碉拷锟斤拷锟斤拷锟街讹拷)
	 * 
	 * @param row
	 * @return
	 */
	protected Row getRowData(Result row) {
		if (row.isEmpty()){
			return null;
		}
		Map<String, String> rowdata = new LinkedHashMap<String, String>();
		NavigableMap<byte[], NavigableMap<byte[], byte[]>> map = row.getNoVersionMap();
		// XXX 锟斤拷锟斤拷锟斤拷锟斤拷注指锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�, gewara 使锟矫碉拷锟斤拷锟斤拷为 DF
		NavigableMap<byte[], byte[]> data = map.get(columnFamily);
		for (Entry<byte[], byte[]> entry : data.entrySet()) {
			rowdata.put(Bytes.toString(entry.getKey()), Bytes.toString(entry.getValue()));
		}
		rowdata.put("rowid", Hex.encodeHexString(row.getRow()));
		return new Row(row.getRow(), rowdata);
	}

	protected Map<Long, Map<String, String>> getMultiVerRowData(Result row) {
		Map<Long/* modifyTime */, Map<String, String>> rowMap = new TreeMap<Long, Map<String, String>>();
		if (row.isEmpty()){
			return rowMap;
		}
		NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> multiData = row.getMap();
		NavigableMap<byte[], NavigableMap<Long, byte[]>> data = multiData.get(columnFamily);

		for (Entry<byte[]/* key */, NavigableMap<Long, byte[]>> entry : data.entrySet()) {
			NavigableMap<Long, byte[]> coldata = entry.getValue();
			for (Long timestamp : coldata.keySet()) {
				Map<String, String> rowdata = rowMap.get(timestamp);
				if (rowdata == null) {
					rowdata = new LinkedHashMap<String, String>();
					rowMap.put(timestamp, rowdata);
				}
				rowdata.put("rowid", Hex.encodeHexString(row.getRow()));
				rowdata.put(Bytes.toString(entry.getKey()), Bytes.toString(coldata.get(timestamp)));
			}
		}
		return rowMap;
	}

	public class DefaultTableCallback implements TableCallback {
		private Scan scan;
		private RowCallback action;
		private int maxnum;
		private int processRows = 0;

		public int getProcessRows() {
			return processRows;
		}

		public DefaultTableCallback(Scan scan, RowCallback action, int maxnum) {
			this.scan = scan;
			this.action = action;
			this.maxnum = maxnum;
			if (scan.getCaching() <= 1) {// not set cache
				if (maxnum <= 0) {
                    scan.setCaching(CACHE_SIZE);
                } else {
                    scan.setCaching(Math.min(CACHE_SIZE, maxnum));
                }
			}
		}

		@Override
		public Object doWithTable(Table hTable) {
			ResultScanner scanner = null;
			try {
				scanner = hTable.getScanner(scan);
				Iterator<Result> it = scanner.iterator();
				Result row = null;
				while (it.hasNext() && (maxnum < 0 || processRows < maxnum)) {
					row = it.next();
					action.doInRow(row);
					processRows++;
					if (processRows % 5000 == 0) {
						dbLogger.warn("processRowNum:" + processRows + ",t=" + getTimestr(row.getRow()));
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				if (scanner != null) {
					try {
						scanner.close();
					} catch (Exception e) {
						dbLogger.warn(e, 30);
					}
				}
			}
			return null;
		}
	}
	private String getTimestr(byte[] rowid){
		String timestr = "";
		if(rowid.length >=4){
			long time = Bytes.toInt(Arrays.copyOfRange(rowid, 0, 4)) * 1000L;
			timestr = DateUtil.formatTimestamp(time);
		}
		return timestr;
	}

	@Override
	public void saveRow(String tablename, Map<String, String> rowdata) {
		if (rowdata.isEmpty()){
			return;
		}
		byte[] rowid = ObjectId.get().toByteArray();
		saveRow(tablename, rowid, rowdata);
	}

	@Override
	public void removeRowByHex(String tablename, final String hexid) {
		try {
			byte[] rowid = Hex.decodeHex(hexid.toCharArray());
			removeRowById(tablename, rowid);
		} catch (DecoderException e) {
			dbLogger.warn(e, 50);
		}
	}
	@Override
	public void removeRowById(String tablename, final byte[] rowid){
		execute(tablename, new TableCallback() {
			@Override
			public Object doWithTable(Table htable) throws Exception {
				Delete delete = new Delete(rowid);
				htable.delete(delete);
				return null;
			}
		});

	}

	@Override
	public void saveRow(final String tablename, final byte[] rowid, final Map<String, String> rowdata) {
		if (rowdata.isEmpty()) {
            return;
        }
		execute(tablename, new TableCallback() {
			@Override
			public Object doWithTable(Table htable) throws Exception {
				Map<String, String> data = BeanUtil.toSimpleStringMap(rowdata);
				Put put = new Put(rowid);
				for (String key : data.keySet()) {
					if (StringUtils.isNotBlank(data.get(key))) {
						put.addColumn(columnFamily, Bytes.toBytes(key), Bytes.toBytes(data.get(key)));
					}
				}
				htable.put(put);
				return null;
			}
		});
	}

	@Override
	public List<Row> getRowListByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime, final RowFilter filter, int maxnum) {
		final List<Row> result = new ArrayList<>();
		Scan scan = getScanBuilder(tableName, fb, starttime, endtime).buildScan();
		executeWithScan(tableName, scan, new RowCallback() {
			@Override
			public void doInRow(Result row) throws Exception {
				Row rowdata = getRowData(row);
				if(rowdata!=null){
					if(filter == null || filter.accept(rowdata)){
						result.add(rowdata);
					}
				}
			}
		}, maxnum);
		return result;
	}
	@Override
	public List<Row> getRowListByRange(String tableName, Map fb, Long starttime, Long endtime, RowFilter filter,
			int maxnum) {
		// TODO 锟斤拷锟斤拷
		return null;
	}

	@Override
	public List<Row> getRowListByIdRange(String tableName, Map fb, byte[] startRowId, byte[] endRowId, RowFilter filter,
			int maxnum) {
		// TODO 锟斤拷锟斤拷
		return null;
	}

	@Override
	public List<byte[]> getRowidListByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime, int maxnum) {
		return getRowidListByRange(tableName, fb, starttime, endtime, maxnum, null);
	}

	@Override
	public List<byte[]> getRowidListByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime, int maxnum, String column) {
		final List<byte[]> result = new ArrayList<byte[]>();
		ScanBuilder scanBuilder = getScanBuilder(tableName, fb, starttime, endtime);
		Scan scan = scanBuilder.buildScan();
		if (StringUtils.isNotBlank(column) && scanBuilder.isEmptyCondition() && HbaseData.supportTimeRange(tableName)) {
			scan.addColumn(columnFamily, column.getBytes());// not exists锟斤拷锟斤拷要锟斤拷锟斤拷锟斤拷锟斤拷
		}

		executeWithScan(tableName, scan, new RowCallback() {
			@Override
			public void doInRow(Result row) throws Exception {
				result.add(row.getRow());
			}
		}, maxnum);
		return result;
	}

	@Override
	public int removeByRange(final String tableName, FilterBuilder fb, Long starttime, Long endtime, String column) {
		final List<byte[]> rowidList = new ArrayList<byte[]>();
		ScanBuilder scanBuilder = getScanBuilder(tableName, fb, starttime, endtime);
		Scan scan = scanBuilder.buildScan();
		if (StringUtils.isNotBlank(column) && scanBuilder.isEmptyCondition() && HbaseData.supportTimeRange(tableName)) {
			scan.addColumn(columnFamily, column.getBytes());// not exists锟斤拷锟斤拷要锟斤拷锟斤拷锟斤拷锟斤拷
		}
		final AtomicInteger count = new AtomicInteger(0);
		executeWithScan(tableName, scan, new RowCallback() {
			@Override
			public void doInRow(Result row) throws Exception {
				rowidList.add(row.getRow());
				if (rowidList.size() >= 5000) {
					removeRowList(tableName, rowidList);
					count.addAndGet(5000);
					rowidList.clear();
				}
			}
		}, 200000000);
		// 锟斤拷锟揭伙拷锟�
		if (rowidList.size() > 0) {
			removeRowList(tableName, rowidList);
			count.addAndGet(rowidList.size());
		}
		return count.get();
	}

	@Override
	public List<Row> getRowListByIdRange(String tableName, FilterBuilder fb, byte[] startRowId, byte[] endRowId, final RowFilter filter, int maxnum) {
		final List<Row> result = new ArrayList<>();
		Scan scan = getScan(fb, startRowId, endRowId);
		executeWithScan(tableName, scan, new RowCallback() {
			@Override
			public void doInRow(Result row) throws Exception {
				Row rowdata = getRowData(row);
				if(rowdata!=null){
					if(filter == null || filter.accept(rowdata)){
						result.add(rowdata);
					}
				}
			}
		}, maxnum);
		return result;
	}
	@Override
	public List<Map<Long/*modifytime*/, Map<String, String>>> getMultiRowListByIdRange(String tableName, int maxVersions, FilterBuilder fb, byte[] startRowId, byte[] endRowId, int maxnum){
		final List<Map<Long, Map<String, String>>> result = new ArrayList<Map<Long, Map<String, String>>>();
		Scan scan = getScan(fb, startRowId, endRowId);
		scan.setMaxVersions(maxVersions);
		executeWithScan(tableName, scan, new RowCallback() {
			@Override
			public void doInRow(Result row) throws Exception {
				Map<Long, Map<String, String>> rowdata = getMultiVerRowData(row);
				result.add(rowdata);
			}
		}, maxnum);
		return result;
	}

	@Override
	public long getRowCountByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime) {
		Scan scan = getScanBuilder(tableName, fb, starttime, endtime).buildScan();
		scan.addFamily(columnFamily);
		LongColumnInterpreter columnInterpreter = new LongColumnInterpreter();
		long result = -1;
		try {
			result = aggregationClient.rowCount(TableName.valueOf(tableName), /* null */columnInterpreter, scan);
		} catch (Throwable e) {
			dbLogger.warn(e, 30);
		}
		return result;
	}

	@Override
	public void processRowListByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime, final RowDataCallback callback, final RowFilter filter) {
		Scan scan =  getScanBuilder(tableName, fb, starttime, endtime).buildScan();
		executeWithScan(tableName, scan, new RowCallback() {
			@Override
			public void doInRow(Result row) throws Exception {
				Row rowdata = getRowData(row);
				if(rowdata!=null){
					if(filter==null || filter.accept(rowdata)){
						callback.processRow(rowdata);
					}
				}
			}
		}, -1);
	}

	@Override
	public void processRowListByRowIdRange(String tableName, FilterBuilder fb, byte[] startRowId, byte[] endRowId, final RowDataCallback callback, final RowFilter filter) {
		Scan scan = getScan(fb, startRowId, endRowId);
		executeWithScan(tableName, scan, new RowCallback() {
			@Override
			public void doInRow(Result row) throws Exception {
				Row rowdata = getRowData(row);
				if(rowdata!=null){
					if(filter==null || filter.accept(rowdata)){
						callback.processRow(rowdata);
					}
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

	/**
	 * 锟斤拷锟斤拷一锟斤拷锟斤拷锟杰比斤拷锟斤拷锟斤拷锟斤拷锟阶筹拷锟斤拷锟斤拷锟� API, 锟绞讹拷使锟斤拷时,锟斤拷锟阶⒆拷锟�.
	 * 
	 * for query: 默锟斤拷锟斤拷锟斤拷锟斤拷缺冉锟�,锟斤拷锟給perator锟斤拷锟斤拷值,锟斤拷值为'<>',锟斤拷锟斤拷锟斤拷锟斤拷缺冉锟� for
	 * likeQuery:只锟斤拷锟斤拷缺冉锟�,锟斤拷operator锟斤拷锟斤拷值锟睫癸拷
	 * 
	 * 锟斤拷锟斤拷Range,锟斤拷锟斤拷锟斤拷锟斤拷牟锟斤拷锟斤拷锟�'[...)',前锟秸猴拷
	 * 
	 * @param tablename
	 * @param query
	 * @param likeQuery
	 * @param operator
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	protected ScanBuilder getScanBuilder(String tablename, FilterBuilder fb, Long starttime, Long endtime) {
		if(fb == null){
			fb = new FilterBuilder();
		}
		if (HbaseData.supportTimeRange(tablename)) {
			if (starttime != null){
				fb.setStartRow(getStartRowId(starttime));
			}
			if (endtime != null){
				fb.setStopRow(getEndRowId(endtime));
			}
		} else {
			fb.gte(COLUMN_ADDTIME,DateUtil.formatTimestamp(starttime));
			fb.lte(COLUMN_ADDTIME,DateUtil.formatTimestamp(endtime));
		}
		ScanBuilder sb = new ScanBuilder(fb);
		return sb;
	}

	/**
	 * TODO 锟斤拷锟斤拷 null 值锟侥达拷锟斤拷
	 * 
	 * @param timestamp
	 * @return
	 */
	private byte[] getStartRowId(Long timestamp) {
		byte[] b = new byte[12];
		ByteBuffer bb = ByteBuffer.wrap(b);
		bb.putInt((int) (timestamp / 1000L));
		bb.putInt(0);
		bb.putInt(0);
		return b;
	}

	/**
	 * TODO 锟斤拷锟斤拷 null 值锟侥达拷锟斤拷
	 * 
	 * @param timestamp
	 * @return
	 */
	private byte[] getEndRowId(Long timestamp) {
		byte[] b = new byte[12];
		ByteBuffer bb = ByteBuffer.wrap(b);
		bb.putInt((int) (timestamp / 1000L));
		bb.putInt(Integer.MAX_VALUE);
		bb.putInt(Integer.MAX_VALUE);
		return b;
	}

	@Override
	public AggregateData getGroupData(String tablename, GroupFields gf, FilterBuilder fb, Long starttime, Long endtime, int maxRowScan, final RowFilter filter) {
		Scan scan = getScanBuilder(tablename, fb, starttime, endtime).buildScan();
		final AggregateData result = new AggregateData(gf);
		executeWithScan(tablename, scan, new RowCallback() {
			@Override
			public void doInRow(Result row) throws Exception {
				Row data = getRowData(row);
				if(data!=null){
					if(filter== null || filter.accept(data)){
						result.processRow(data.getData());
					}
				}
			}
		}, maxRowScan);
		return result;
	}
	
	@Override
	public List<Row> getRowList(String tableName, FilterBuilder fb, int maxnum) {
		Scan scan = getScan(fb);
		final List<Row> result = new ArrayList<Row>();
		executeWithScan(tableName, scan, new RowCallback() {
			@Override
			public void doInRow(Result row) throws Exception {
				Row rowdata = getRowData(row);
				if(rowdata!=null){
					result.add(rowdata);
				}
			}
		}, maxnum);
		return result;
	}

	@Override
	public Row getRowByHex(String tableName, String hexid) {
		try {
			byte[] rowid = Hex.decodeHex(hexid.toCharArray());
			return getRowById(tableName, rowid);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	@Override
	public Row getRowByStrId(String tablename, String strId) {
		return getRowById(tablename, Bytes.toBytes(strId));
	}
	@Override
	public Row getRowById(String tablename, final byte[] rowid) {
		return execute(tablename, new TableCallback<Row>() {
			@Override
			public Row doWithTable(Table htable) throws Exception {
				Get get = new Get(rowid);
				get.addFamily(columnFamily);
				Result row = htable.get(get);
				return getRowData(row);
			}
		});
	}

	@Override
	public Map</* modifytime */Long, Map<String, String>> getMultiVersionRow(String tableName, final byte[] rowid, final int maxVersion) {
		final Map</* modifytime */Long, Map<String, String>> rowMap = new TreeMap<Long, Map<String, String>>();
		execute(tableName, new TableCallback() {
			@Override
			public Object doWithTable(Table htable) throws Exception {
				Get get = new Get(rowid);
				get.addFamily(columnFamily);
				get.setMaxVersions(maxVersion);
				Result row = htable.get(get);
				rowMap.putAll(getMultiVerRowData(row));
				return null;
			}
		});
		return rowMap;
	}
	@Override
	public List<Row> getRowListByHexids(String tablename, final List<String> hexidList) {
		List<byte[]> rowidList = new ArrayList<>(hexidList.size());
		for(String hexid: hexidList){
			try {
				rowidList.add(Hex.decodeHex(hexid.toCharArray()));
			} catch (DecoderException e) {
			}
		}
		return getRowListByIdList(tablename, rowidList);
	}

	@Override
	public List<Row> getRowListByIdList(String tablename, final List<byte[]> rowidList) {
		final List<Row> rowList = new LinkedList<>();

		execute(tablename, new TableCallback() {
			@Override
			public Object doWithTable(Table htable) throws Exception {
				try{
					List<Get> gets = new ArrayList<Get>(rowidList.size());
					for (byte[] rowid : rowidList) {
						Get get = new Get(rowid);
						get.addFamily(columnFamily);
						gets.add(get);
					}
					Result[] rows = htable.get(gets);
					for (Result row : rows) {
						Row rowdata = getRowData(row);
						if(rowdata!=null){
							rowList.add(rowdata);
						}
					}
					return null;
				} finally {
					htable.close();
				}
			}
		});
		
		return rowList;
	}
	
	@Override
	public void saveRow(String tablename, String hexid, Map<String, String> rowdata) {
		rowdata.remove("rowid");
		try {
			saveRow(tablename, Hex.decodeHex(hexid.toCharArray()), rowdata);
		} catch (DecoderException e) {
			dbLogger.warn(e, 20);
		}
		rowdata.put("rowid", hexid);
	}

	@Override
	public boolean isAvaliable() {
		try {
			return !getConnection().isClosed();
			// new HTable(TableName.valueOf(VALIDATE_TABLE_NAME),
			// getHConnection()).isAutoFlush();
			// return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		new Thread(new Runnable() {
			@Override
			public void run() {
				setupHbase();
			}
		}).start();
	}

	@Override
	public void saveRowListByHex(String tableName, final String hexidName, final List<Map<String, String>> rowList) {
		final List<Put> puts = new ArrayList<Put>(rowList.size());
		for (Map<String, String> row : rowList) {
			byte[] rowid = null;
			if (row.containsKey(hexidName)) {
				try {
					rowid = Hex.decodeHex(row.remove(hexidName).toCharArray());
				} catch (DecoderException e) {
					throw new IllegalArgumentException("RowidError", e);
				}
			} else {
				rowid = ObjectId.get().toByteArray();
			}
			Put put = new Put(rowid);
			for (String key : row.keySet()) {
				if (StringUtils.isNotBlank(row.get(key))) {
					put.addColumn(columnFamily, Bytes.toBytes(key), Bytes.toBytes(row.get(key)));
				}
			}
			puts.add(put);
		}
		savePuts(tableName, puts);
	}

	private void savePuts(String tableName, final List<Put> puts) {
		execute(tableName, new TableCallback() {
			@Override
			public Object doWithTable(Table htable) throws Exception {
				try{
					htable.put(puts);
					return null;
				}finally{
					htable.close();
				}
			}
		});
	}

	@Override
	public void saveRowList(String tablename, List<Row> rowList) {
		List<Put> puts = new ArrayList<Put>();
		for (Row row : rowList) {
			Put put = new Put(row.getRowid());
			Map<String, String> data = row.getData();
			if(data!=null){
				for (String key : data.keySet()) {
					if (StringUtils.isNotBlank(data.get(key))) {
						put.addColumn(columnFamily, Bytes.toBytes(key), Bytes.toBytes(data.get(key)));
					}
				}
				puts.add(put);
			}
		}
		savePuts(tablename, puts);
	}

	@Override
	public void saveRowListByStrId(String tableName, final String idName, final List<Map<String, String>> rowList) {
		List<Put> puts = new ArrayList<Put>();
		for (Map<String, String> row : rowList) {
			byte[] rowid = null;
			if (row.containsKey(idName)) {
				try {
					rowid = row.remove(idName).getBytes("utf-8");
				} catch (UnsupportedEncodingException e) {
					throw new IllegalArgumentException("RowidError", e);
				}
			} else {
				rowid = ObjectId.get().toByteArray();
			}
			Put put = new Put(rowid);
			for (String key : row.keySet()) {
				if (StringUtils.isNotBlank(row.get(key))) {
					put.addColumn(columnFamily, Bytes.toBytes(key), Bytes.toBytes(row.get(key)));
				}
			}
			puts.add(put);
		}
		savePuts(tableName, puts);
	}

	@Override
	public void removeRowListByHex(String tablename, String[] hexidList) {
		List<byte[]> rowidList = new ArrayList<byte[]>();
		for (String hexid : hexidList) {
			try {
				rowidList.add(Hex.decodeHex(hexid.toCharArray()));
			} catch (Exception e) {
			}
		}
		removeRowList(tablename, rowidList);
	}
	@Override
	public void removeRowListByHex(String tablename, List<String> hexidList) {
		List<byte[]> rowidList = new ArrayList<byte[]>();
		for (String hexid : hexidList) {
			try {
				rowidList.add(Hex.decodeHex(hexid.toCharArray()));
			} catch (Exception e) {
			}
		}
		removeRowList(tablename, rowidList);
	}

	@Override
	public void removeRowList(String tablename, final List<byte[]> rowidList) {
		execute(tablename, new TableCallback() {
			@Override
			public Object doWithTable(Table htable) throws Exception {
				try{
					List<Delete> deletes = new ArrayList<Delete>(rowidList.size());
					for (byte[] rowid : rowidList) {
						deletes.add(new Delete(rowid));
					}
					htable.delete(deletes);
					return null;
				}finally{
					htable.close();
				}
			}
		});
	}

	public static void main(String[] args) {
		HBaseServiceImpl hbaseService = new HBaseServiceImpl("192.168.2.254,192.168.2.253,192.168.2.252");// hadoop2+
																																			// 192.168.8.24
		// hbaseService = new HBaseServiceImpl("192.168.8.24");//hadoop2+
		// 192.168.8.24

		byte[] startRowId = hbaseService.getStartRowId(new Date().getTime());
		System.out.println(startRowId);
		System.out.println(startRowId.length);
		System.out.println(Bytes.toHex(startRowId));
		System.out.println("^^");
		System.out.println(Hex.encodeHexString(startRowId));
		System.out.println(Bytes.toString(startRowId));

		byte[] endRowId = hbaseService.getEndRowId(new Date().getTime());
		System.out.println(endRowId);

		byte[] objectId = ObjectId.get().toByteArray();
		System.out.println("^^");
		System.out.println(Hex.encodeHexString(objectId));
		System.out.println(Bytes.toString(objectId));

	}

	@Override
	public boolean createTable(String tableName, int maxVersions)  {
		ValidateUtil.isVariable(tableName, 5, 50);
		Admin admin = getHBaseAdmin();
		try {
			if(!admin.isTableAvailable(TableName.valueOf(tableName))){
				HTableDescriptor desc = new HTableDescriptor(TableName.valueOf(tableName));
				HColumnDescriptor coldef = new HColumnDescriptor(Bytes.toBytes("DF"));
				coldef.setCompressionType(Algorithm.SNAPPY);
				if(maxVersions>0){
					coldef.setMaxVersions(maxVersions);
				}
				desc.addFamily(coldef);
				admin.createTable(desc);
			}
		} catch (Exception e) {
			dbLogger.warn(e, 200);
			return false;
		}
		return true;
	}

	@Override
	public <K, V> List<Map<K, V>> getRowList(String tablename, List fb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K, V> List<Map<K, V>> getRowListByRange(String tableAppsource, Map<K, V> query, long time, long time2,
			int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K, V> List<Map<K, V>> getRowListByRange(String tableAppsource, Map<K, V> query, Map<K, V> map, long time,
			long time2, int i) {
		// TODO Auto-generated method stub
		return null;
	}



}
