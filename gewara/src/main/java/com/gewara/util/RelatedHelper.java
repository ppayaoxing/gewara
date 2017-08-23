package com.gewara.util;

import com.gewara.support.ServiceHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RelatedHelper {
    public RelatedHelper() {

    }

    private Map<String/*group*/, Map<String/*relatedid*/, Object>> relatedGroupMap = Maps.newHashMap();

    public void addRelated(int idx, String group, Serializable relatedid, Object object) {
        String key = idx + "G" + relatedid;
        Map<String, Object> relatedMap = relatedGroupMap.get(group);
        if (relatedMap == null) {
            relatedMap = Maps.newHashMap();
            relatedGroupMap.put(group, relatedMap);
        }
        relatedMap.put(key, object);
    }

    public List<Long> getRelatedMemberIdList(String group) {
        List<Long> memberIdList = Lists.newArrayList();
        Map<String, Object> relatedMap = relatedGroupMap.get(group);
        if (relatedMap != null) {
            memberIdList.addAll(ServiceHelper.getMemberIdListFromBeanList(relatedMap.values()));
        }
        return memberIdList;
    }

    public void addRelated1(String group, Serializable relatedid, Object object) {
        addRelated(1, group, relatedid, object);
    }

    public void addRelated2(String group, Serializable relatedid, Object object) {
        addRelated(2, group, relatedid, object);
    }

    public void addRelated3(String group, Serializable relatedid, Object object) {
        addRelated(3, group, relatedid, object);
    }

    public Object getR1(String group, Serializable rid) {
        Map<String, Object> relatedMap = relatedGroupMap.get(group);
        return relatedMap == null ? null : relatedMap.get(1 + "G" + rid);
    }

    public Object getR2(String group, Serializable rid) {
        Map<String, Object> relatedMap = relatedGroupMap.get(group);
        return relatedMap == null ? null : relatedMap.get(2 + "G" + rid);
    }

    public Object getR3(String group, Serializable rid) {
        Map<String, Object> relatedMap = relatedGroupMap.get(group);
        return relatedMap == null ? null : relatedMap.get(3 + "G" + rid);
    }

    public Map<String, Object> getGroupMap(String group) {
        Map<String, Object> relatedMap = relatedGroupMap.get(group);
        return relatedMap;
    }

    public List getGroupIndexList(String group, int idx) {
        Map<String, Object> relatedMap = relatedGroupMap.get(group);
        List<Object> result = Lists.newArrayList();
        String pre = idx + "G";
        if (relatedMap == null) return result;
        for (String key : relatedMap.keySet()) {
            if (StringUtils.startsWith(key, pre)) {
                result.add(relatedMap.get(key));
            }
        }
        return result;
    }
}
