package com.gewara.hbase;

/**
 * @author gebiao(ge.biao@gewara.com)
 * @since Sep 14, 2012 8:35:58 PM
 */
public interface RowDataCallback {
    void processRow(Row row) throws Exception;
}
