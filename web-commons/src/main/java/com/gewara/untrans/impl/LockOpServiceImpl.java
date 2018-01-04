package com.gewara.untrans.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gewara.untrans.CacheService;
import com.gewara.untrans.LockOpService;

@Service("lockOpService")
public class LockOpServiceImpl implements LockOpService	{
	@Autowired(required=false)
	@Qualifier("cacheService")
	private CacheService cacheService;

	@Override
	public Long updateOperation(String opkey, int allowIntervalSecond) {
		Long value = (Long) cacheService.get(CacheService.REGION_ONEHOUR, opkey);
		if(value!=null && value>System.currentTimeMillis()){
			return null;
		}
		Long v = System.currentTimeMillis() + allowIntervalSecond * 1000;
		cacheService.set(CacheService.REGION_ONEHOUR, opkey, v);
		//重新获取，是否被其他覆盖
		value = (Long) cacheService.get(CacheService.REGION_ONEHOUR, opkey);
		return v.equals(value)?v:null;
	}
	@Override
	public Long updateFlagOperation(String opkey, int allowIntervalSecond, String flag) {
		String pair = (String) cacheService.get(CacheService.REGION_ONEHOUR, opkey);
		if(pair==null){
			Long v1 = System.currentTimeMillis() + allowIntervalSecond * 1000;	//他人
			Long v2 = System.currentTimeMillis() + allowIntervalSecond * 1000;	//自己
			pair = v1+"," + v2 + "," + flag; 
			cacheService.set(CacheService.REGION_ONEHOUR, opkey, pair);
			return v2;
		}
		String[] values = StringUtils.split(pair, ",");
		Long value1 = Long.valueOf(values[0]);
		Long value2 = Long.valueOf(values[1]);
		if(value1!=null && value1> System.currentTimeMillis()){
			if(StringUtils.equals(values[2], flag)){
				if(value2!=null && value2> System.currentTimeMillis()){
					return null;
				}else{
					return value2;
				}
			}
			return null;
		}
		return value2;
	}
	@Override
	public void resetFlagOperation(String opkey, String flag){
		String pair = (String) cacheService.get(CacheService.REGION_ONEHOUR, opkey);
		if(pair!=null){
			String[] values = StringUtils.split(pair, ",");
			if(StringUtils.equals(values[2], flag)){
				String pair2 = values[0] + ",0," + flag;
				cacheService.set(CacheService.REGION_ONEHOUR, opkey, pair2);
			}
		}
	}
	@Override
	public void resetOperation(String opkey, Long locknum) {
		if(locknum!=null){
			Long value = (Long) cacheService.get(CacheService.REGION_ONEHOUR, opkey);
			if(value!=null && value.equals(locknum)){//值无变更才移除
				cacheService.remove(CacheService.REGION_ONEHOUR, opkey);
			}
		}
	}
}
