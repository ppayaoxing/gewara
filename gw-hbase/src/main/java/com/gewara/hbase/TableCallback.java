package com.gewara.hbase;

import org.apache.hadoop.hbase.client.Table;

/**
 * Defines methods to get HTable and close HTable. Modeled after DataSource
 * interface in JDBC.
 * 
 * @author Vaibhav Puranik
 * @version $Id: TableCallback.java 11124 2012-01-27 23:05:57Z vaibhav $
 */
public interface TableCallback<T> {

	/**
	 * Gets called by HbaseTemplate.execute with an active HTable for the given
	 * tablename.
	 * 
	 * @param htable
	 * @return a result object, or null if none
	 * @throws Exception
	 */
	T doWithTable(Table htable) throws Exception;
}
