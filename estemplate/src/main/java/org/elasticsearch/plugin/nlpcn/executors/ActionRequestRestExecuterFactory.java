package org.elasticsearch.plugin.nlpcn.executors;

/**
 * Created by Eliran on 26/12/2015.
 */
public class ActionRequestRestExecuterFactory {
    public static RestExecutor createExecutor(String format) {
        if(format == null || "".equals(format)){
            return new ElasticDefaultRestExecutor();
        }
        if("csv".equalsIgnoreCase(format)){
            return new CSVResultRestExecutor();
        }
        return null;
    }
}
