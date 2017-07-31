package com.gewara.hbase;
import org.apache.hadoop.hbase.client.HTable;

/**
 * Defines methods to get HTable and close HTable. Modeled after DataSource interface in JDBC.
 *
 * @author Vaibhav Puranik
 * @version $Id: HBaseCallback.java 3429 2009-07-21 02:10:28Z vaibhav $
 */
public interface HBaseCallback {

    /**
     * Gets called by HbaseTemplate.execute with an active HTable for the given tablename.
     * @param htable htable instance for the given tablename.
     * @return a result object, or null if none
     * @throws Exception
     */
    Object doInHbase(HTable htable) throws Exception;
}
