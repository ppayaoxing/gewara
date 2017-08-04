package com.gewara.hbase;

import java.util.List;
import java.util.Map;

import com.gewara.hbase.util.FilterBuilder;
import com.gewara.hbase.util.GroupFields;

/**
 * @author gebiao 本程序是调用HBase的接口，有些局限性： 1）不考虑修改记录 2）数据格式要规范，key必须为正常的key
 */
public interface HBaseService {

	///////////////////// 接口常量/////////////////////
	String COUNT_FLAG_HOUR = "hour";
	String COUNT_FLAG_MIN = "min";
	String COUNT_FLAG_DAY = "day";
	String COLUMN_ADDTIME = "addtime"; // 客户化保留字段，用于存储记录的产生时间,范围查询时做时间比较
	int CACHE_SIZE = 500; // SCAN 缓存条数

	///////////////////// 添加单条记录 API/////////////////////
	/**
	 * 保存记录，自动产生rowid,rowid 的规则是基于时间 timestamp[32bit]
	 * 
	 * @param tablename
	 * @param rowdata
	 */
	void saveRow(String tablename, Map<String, String> rowdata);

	/**
	 * 保存记录，使用自定义的 rowid格式,二进制数据
	 * 
	 * @param tablename
	 * @param rowid
	 * @param rowdata
	 */
	void saveRow(String tablename, byte[] rowid, Map<String, String> rowdata);

	/**
	 * 保存记录，使用自定义的 rowid格式,hexid为byte[]的hex编码,16进制编码
	 * 
	 * @param tablename
	 * @param hexid
	 * @param row
	 */
	void saveRow(String tablename, String hexid, Map<String, String> row);

	///////////////////// 添加多条记录 API/////////////////////
	void saveRowListByStrId(String tablename, String idName, List<Map<String, String>> rowList);

	void saveRowListByHex(String tablename, String hexidName, List<Map<String, String>> rowList);

	void saveRowList(String tablename, List<Row> rowList);

	///////////////////// 删除 API/////////////////////
	void removeRowById(String tablename, byte[] rowid);

	void removeRowByHex(String tablename, String hexid);

	void removeRowList(String tablename, List<byte[]> rowidList);

	void removeRowListByHex(String tablename, String[] hexidList);

	void removeRowListByHex(String tablename, List<String> hexidList);

	int removeByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime, String column);

	///////////////////// 查询 API/////////////////////
	boolean isAvaliable();

	Row getRowByHex(String tablename, String hexid);

	Row getRowByStrId(String tablename, String strId);

	Row getRowById(String tablename, byte[] rowid);

	/**
	 * 获取多次修改的记录
	 * 
	 * @param tablename
	 * @param rowid
	 * @param maxVersion
	 * @return
	 */
	Map<Long/* modifytime */, Map<String, String>> getMultiVersionRow(String tablename, byte[] rowid, int maxVersion);

	List<Map<Long/* modifytime */, Map<String, String>>> getMultiRowListByIdRange(String tableName, int maxVersions,
			FilterBuilder fb, byte[] startRowId, byte[] endRowId, int maxnum);

	List<Row> getRowList(String tablename, FilterBuilder fb, int maxnum);
	<K, V> List<Map<K, V>> getRowList(String tablename, List fb);

	List<Row> getRowListByHexids(String tablename, List<String> hexidList);

	List<Row> getRowListByIdList(String tablename, List<byte[]> rowidList);

	List<Row> getRowListByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime, RowFilter filter,
			int maxnum);

	List<Row> getRowListByRange(String tableName, Map fb, Long starttime, Long endtime, RowFilter filter, int maxnum);

	<K, V> List<Map<K, V>> getRowListByRange(String tableAppsource, Map<K, V> query, long time, long time2, int i);
	<K, V> List<Map<K, V>> getRowListByRange(String tableAppsource, Map<K, V> query,Map<K, V>map ,long time, long time2, int i);

	List<Row> getRowListByIdRange(String tableName, FilterBuilder fb, byte[] startRowId, byte[] endRowId,
			RowFilter filter, int maxnum);

	List<Row> getRowListByIdRange(String tableName, Map fb, byte[] startRowId, byte[] endRowId, RowFilter filter,
			int maxnum);

	AggregateData getGroupData(String tableName, GroupFields gf, FilterBuilder fb, Long starttime, Long endtime,
			int maxRowScan, RowFilter filter);

	/**
	 * @param tableName
	 * @param fb
	 * @param starttime
	 * @param endtime
	 * @param maxnum
	 * @return
	 */
	List<byte[]> getRowidListByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime, int maxnum);

	/**
	 * @param tableName
	 * @param query
	 * @param likeQuery
	 * @param starttime
	 * @param endtime
	 * @param maxnum
	 * @param column
	 *            只返回指定列值，以减少数据传输
	 * @return
	 */
	List<byte[]> getRowidListByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime, int maxnum,
			String column);

	///////////////////// 范围处理 API/////////////////////
	/**
	 * 按时间段范围处理
	 * 
	 * @param tableName
	 * @param query
	 * @param likeQuery
	 * @param starttime
	 * @param endtime
	 * @param callback
	 */
	void processRowListByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime,
			RowDataCallback callback, RowFilter filter);

	/**
	 * 按rowid范围处理
	 * 
	 * @param tableName
	 * @param query
	 * @param likeQuery
	 * @param startRowId
	 * @param endRowId
	 * @param callback
	 */
	void processRowListByRowIdRange(String tableName, FilterBuilder fb, byte[] startRowId, byte[] endRowId,
			RowDataCallback callback, RowFilter filter);

	///////////////////// 聚集查询 API/////////////////////
	/**
	 * @param tableName
	 * @param fb
	 * @param starttime
	 * @param endtime
	 * @return
	 */
	long getRowCountByRange(String tableName, FilterBuilder fb, Long starttime, Long endtime);

	/**
	 * 新建一张表（如果已经存在就不建），columnFamily是默认的DF，默认压缩 create 'table',{NAME => 'DF',
	 * VERSIONS => 1, COMPRESSION => 'SNAPPY'}
	 * 
	 * @param tableName
	 * @param maxVersions
	 *            > 0 时设置
	 * @return
	 */
	boolean createTable(String tableName, int maxVersions);

}
