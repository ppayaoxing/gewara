package com.gewara.untrans.impl;

import com.gewara.Config;
import com.gewara.support.TraceErrorException;
import com.gewara.untrans.CacheConfigure;
import com.gewara.untrans.CacheService;
import com.gewara.util.Assert;
import com.gewara.util.GewaLogger;
import com.gewara.util.StringUtil;
import com.gewara.util.WebLogger;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;

import java.util.Map;

public abstract class AbstractCacheService implements CacheService, InitializingBean {
    protected final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
    protected Map<String, String> regionVersion = Maps.newHashMap();
    protected CacheConfigure cacheConfigure;
    protected Map<String, Integer> regionTimeMap = Maps.newHashMap();

    public void setRegionTimeMap(Map<String, Integer> regionTimeMap) {
        this.regionTimeMap = regionTimeMap;
    }

    public void setCacheConfigure(CacheConfigure cacheConfigure) {
        this.cacheConfigure = cacheConfigure;
    }

    protected String getRealKey(String regionName, String key) {
        String result = getKeyPre(regionName) + key;
        if (result.length() > 50) {
            if (result.length() > 128) {
                dbLogger.warn("keyTooLong2Md5:" + result);
            }
            result = Config.SYSTEMID + "md5" + StringUtil.md5(result);
        }
        return result;
    }

    protected String getKeyPre(String regionName) {
        return regionName + StringUtils.defaultIfBlank(regionVersion.get(regionName), ":") + "@" + Config.SYSTEMID;
    }

    protected Integer getRegionTime(String regionName) {
        Integer time = getCacheTime(regionName);
        if (time == null) throw new TraceErrorException("region error!");
        return time;
    }

    @Override
    public void updateValue(String regionName, String key, String newvalue) {
        Object value = get(regionName, key);
        if (value == null) return;
        set(regionName, key, newvalue);
    }

    @Override
    public void refreshVersion() {
        regionVersion = cacheConfigure.getRegionVersion();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(cacheConfigure);
        refreshVersion();
        Assert.notNull(regionTimeMap);
        if (!regionTimeMap.containsKey(REGION_LOGINAUTH)) {
            regionTimeMap.put(REGION_LOGINAUTH, 60 * 60 * 2);//2hour
        }
        regionTimeMap.put(REGION_TENMIN, 60 * 10);
        regionTimeMap.put(REGION_ONEHOUR, 60 * 60);
        regionTimeMap.put(REGION_SERVICE, 60 * 60 * 12); //12 hour
        regionTimeMap.put(REGION_FIVEDAY, 60 * 60 * 24 * 5); //5day
    }

    @Override
    public Integer getCacheTime(String regionName) {
        return regionTimeMap.get(regionName);
    }

    @Override
    public int incr(String regionName, String key, int by, int defvalue) {
        if (StringUtils.isNotBlank(key)) {
            Integer result = (Integer) get(regionName, key);
            if (result == null) {
                result = defvalue;
            } else {
                result = result + by;
            }
            set(regionName, key, result);
            return result;
        }
        return 0;
    }

}
