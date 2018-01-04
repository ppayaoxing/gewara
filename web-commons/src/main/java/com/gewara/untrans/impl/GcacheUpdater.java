package com.gewara.untrans.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gewara.untrans.CacheObjectService;
import com.gewara.util.BeanUtil;
import com.gewara.util.CacheMeta;
import com.gewara.util.GcacheManager;

public class GcacheUpdater extends AbstractGcacheUpdater  {
	@Autowired@Qualifier("cacheObjectService")
	protected CacheObjectService cacheObjectService;
	public void setCacheObjectService(CacheObjectService cacheObjectService) {
		this.cacheObjectService = cacheObjectService;
	}

	private void cleanDataByIds(CacheMeta meta, String ids){
		Class type = cacheObjectService.getEntityIdType(meta.gclass);
		if(type!=null){
			//只支持String和Long
			if(type==String.class){
				String[] idList = StringUtils.split(ids, ",");
				for (final String id : idList) {
					try{
						meta.gcache.invalidate(id);
						if(meta.eager){
							cacheObjectService.getObject(meta.gclass, id);
						}
						refreshOther(meta.gclass, id);
					}catch(Exception e){
						dbLogger.warn(e, 20);
					}
				}
				
			}else{//
				List<Long> idList = BeanUtil.getIdList(ids, ",");
				for (final Long id : idList) {
					try{
						meta.gcache.invalidate(id);
						if(meta.eager){
							cacheObjectService.getObject(meta.gclass, id);
						}
						refreshOther(meta.gclass, id);
					}catch(Exception e){
						dbLogger.warn(e, 20);
					}
				}
			}
		}
	}
	protected void refreshOther(Class clazz, Serializable id){
		//其他业务逻辑
	}
	@Override
	public final List<String> getListenerTags() {
		List<String> channelList = GcacheManager.getAllTags();
		if(channelList.isEmpty()){
			throw new IllegalArgumentException("GcacheManger.getAllTags() is Empty!");
		}
		return channelList;
	}
	@Override
	protected final void refreshCache(CacheMeta meta, String ids, String op) {
		if(StringUtils.equals(op, "C")){//
			if(StringUtils.isNotBlank(ids)){
				cleanDataByIds(meta, ids);
				dbLogger.warn("CacheObjectService,CleanByID:" + meta.gclass + ",IDs:" + ids);
			}else{
				meta.gcache.invalidateAll();
				dbLogger.warn("CacheObjectService,CleanAll:" + meta.gclass);
			}
		}else{
			if(StringUtils.isBlank(ids)){
				dbLogger.warn("CacheObjectService:NoIDs");
				return;
			}
			cleanDataByIds(meta, ids);
		}
	}
}
