package com.gewara.hbase;
import org.apache.hadoop.hbase.client.Result;

/**
 * Defines methods to get a Result from the given scan. Modeled after DataSource interface in JDBC.
 *
 * @author Vaibhav Puranik
 * @version $Id: HBaseCallback.java 5623 2010-05-27 21:27:39Z ken $
 */
public interface RowCallback {

    /**
     * Gets called by HbaseTemplate.executeInRow with an active Scanner for the given scan.
     * @param result Result instance for the given scan.
     * @return a result object, or null if none
     * @throws Exception
     */
    void doInRow(Result result) throws Exception;
}
