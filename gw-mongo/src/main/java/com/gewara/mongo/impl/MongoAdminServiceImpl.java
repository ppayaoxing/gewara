/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mongo.impl;

import com.gewara.json.mongo.MaintainInfo;
import com.gewara.mdb.operation.Expression;
import com.gewara.mongo.MongoAdminService;
import com.gewara.mongo.MongoService3;
import com.gewara.util.DateUtil;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;

public class MongoAdminServiceImpl implements MongoAdminService {
	private static final int minScan = 5000;
	private MongoService3 mongoService3;

	public void setMongoService3(MongoService3 mongoService) {
		this.mongoService3 = mongoService;
	}

	public List<Map> getSlowestQuery(String op, Integer mills) {
		if (mills == null) {
			mills = Integer.valueOf(150);
		}

		Expression qry = (new Expression()).gt("millis", mills);
		if (StringUtils.isNotBlank(op)) {
			qry.eq("op", "query");
		}

		List result = this.mongoService3.find("system.profile", qry);
		return result;
	}

	public Map<String, Integer> getSlowestQueryForJob(Integer ms, Integer multiple, Integer min) {
		if (ms == null) {
			ms = Integer.valueOf(200);
		}

		if (multiple == null) {
			multiple = Integer.valueOf(10);
		}

		Date opTime = DateUtil.addMinute(new Date(), -min.intValue());
		Expression query = new Expression();
		query.gt("ts", opTime).gt("millis", ms).eq("op", "query");
		List queryResult = this.mongoService3.find("system.profile", query);
		HashMap result = new HashMap();
		Iterator arg7 = queryResult.iterator();

		while (arg7.hasNext()) {
			Map map = (Map) arg7.next();
			String ns = String.valueOf(map.get("ns"));
			ns = StringUtils.substring(ns, StringUtils.indexOf(ns, '.') + 1);
			if (map.get("nreturned") == null || map.get("keysExamined") == null && map.get("docsExamined") == null) {
				return result;
			}

			int nreturned = map.get("nreturned") == null ? 0 : Integer.parseInt("" + map.get("nreturned"));
			int keysExamined = map.get("keysExamined") == null ? 0 : Integer.parseInt("" + map.get("keysExamined"));
			int docsExamined = map.get("docsExamined") == null ? 0 : Integer.parseInt("" + map.get("docsExamined"));
			keysExamined = Math.max(keysExamined, docsExamined);
			if (keysExamined > 5000) {
				++nreturned;
				++keysExamined;
				boolean multi = keysExamined / nreturned > multiple.intValue();
				if (multi) {
					MaintainInfo mi = this.getMaintainInfoByName(ns);
					if (mi == null || mi.getRowcount() == null
							|| mi.getRowcount().longValue() / (long) keysExamined < 4L) {
						this.resultHelper(result, ns);
					}
				}
			}
		}

		return result;
	}

	private void resultHelper(Map<String, Integer> result, String ns) {
		if (result.containsKey(ns)) {
			result.put(ns, Integer.valueOf(((Integer) result.get(ns)).intValue() + 1));
		} else {
			result.put(ns, Integer.valueOf(1));
		}

	}

	public Map getCollectionStat(String collectionName) {
		Map result = this.mongoService3.getCollectionStat(collectionName);
		return result;
	}

	public List<MaintainInfo> addNewCollections() {
		Set collectionNames = this.mongoService3.getCollections();
		ArrayList newTables = new ArrayList();
		Iterator allMaintainedCollections = collectionNames.iterator();

		MaintainInfo name;
		while (allMaintainedCollections.hasNext()) {
			String allMaintainedCollectionNames = (String) allMaintainedCollections.next();
			if (!allMaintainedCollectionNames.startsWith("system.")) {
				MaintainInfo findOne = (MaintainInfo) this.mongoService3.getObjectById(MaintainInfo.class, "name",
						allMaintainedCollectionNames);
				if (findOne == null) {
					name = new MaintainInfo(allMaintainedCollectionNames);
					this.mongoService3.addObject(name, "name");
					newTables.add(name);
				}
			}
		}

		List allMaintainedCollections1 = this.mongoService3.getObjectList(MaintainInfo.class);
		HashSet allMaintainedCollectionNames1 = new HashSet();
		Iterator findOne1 = allMaintainedCollections1.iterator();

		while (findOne1.hasNext()) {
			name = (MaintainInfo) findOne1.next();
			allMaintainedCollectionNames1.add(name.getName());
		}

		allMaintainedCollectionNames1.removeAll(collectionNames);
		findOne1 = allMaintainedCollectionNames1.iterator();

		while (findOne1.hasNext()) {
			String name1 = (String) findOne1.next();
			this.mongoService3.removeObjectById(MaintainInfo.class, "name", name1);
		}

		return newTables;
	}

	public List<MaintainInfo> getMaintainInfoList(String system) {
		Expression query = new Expression();
		if (StringUtils.isNotBlank(system)) {
			query.eq("system", system);
		}

		List result = this.mongoService3.getObjectList(MaintainInfo.class, query, "name", true, 0, 10000);
		return result;
	}

	public void updateMaintainInfo(MaintainInfo info) {
		if (info.getCreatetime() == null) {
			info.setCreatetime(new Timestamp(System.currentTimeMillis()));
		}

		if (info.getUpdatetime() == null || info.getUpdatetime().before(DateUtil.getCurDate())) {
			info.setUpdatetime(new Date());
		}

		if (!info.getName().startsWith("system.")) {
			Map stats = this.mongoService3.getCollectionStat(info.getName());
			if (stats != null) {
				info.setRowcount(Long.valueOf("" + stats.get("count")));
				info.setIndexcount(Integer.valueOf(stats.get("nindexes") + ""));
				if (stats.get("avgObjSize") != null) {
					info.setAvgObjSize(Long.valueOf(Double.valueOf("" + stats.get("avgObjSize")).longValue()));
				} else {
					info.setAvgObjSize(Long.valueOf(0L));
				}

				if (stats.get("storageSize") != null) {
					info.setStorageSize(Long.valueOf(Double.valueOf("" + stats.get("storageSize")).longValue()));
				}
			}
		}

		this.mongoService3.saveOrUpdateObject(info, "name");
	}

	public MaintainInfo getMaintainInfoByName(String name) {
		return (MaintainInfo) this.mongoService3.getObjectById(MaintainInfo.class, "name", name);
	}
}