package com.gewara.mongo;

import java.util.List;
import java.util.Map;

import com.gewara.json.mongo.MaintainInfo;


public interface MongoAdminService {
	//Map<String, Object> serverStatusMap();
	List<Map> getSlowestQuery(String op, Integer mills);
	/**
	 * 获取几分钟内的慢查询
	 * @param ms
	 * @param multiple 倍数比值：scan/return
	 * @param min
	 * @return
	 */
	Map<String, Integer> getSlowestQueryForJob(Integer ms, Integer multiple, Integer min);
	Map getCollectionStat(String collectionName);
	/**
	 * for job used
	 */
	List<MaintainInfo> addNewCollections();
	List<MaintainInfo> getMaintainInfoList(String system);
	MaintainInfo getMaintainInfoByName(String name);
	void updateMaintainInfo(MaintainInfo info);

}
