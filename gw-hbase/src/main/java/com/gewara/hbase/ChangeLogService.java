package com.gewara.hbase;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface ChangeLogService {
	void addChangeLog(String systemId, String tag, Serializable relatedid, Map<String, String> changeMap);
	Map</*modifytime*/Long, Map<String, String>> getChangeLogList(String systemId, String tag, Serializable relatedid);
	List<Row> getDelLogList(String systemId, String tag, String adddate, int maxnum);
}
