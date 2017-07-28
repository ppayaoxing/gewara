/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mongo;

import com.gewara.json.mongo.MaintainInfo;
import java.util.List;
import java.util.Map;

public interface MongoAdminService {
	List<Map> getSlowestQuery(String arg0, Integer arg1);

	Map<String, Integer> getSlowestQueryForJob(Integer arg0, Integer arg1, Integer arg2);

	Map getCollectionStat(String arg0);

	List<MaintainInfo> addNewCollections();

	List<MaintainInfo> getMaintainInfoList(String arg0);

	MaintainInfo getMaintainInfoByName(String arg0);

	void updateMaintainInfo(MaintainInfo arg0);
}