package com.gewara.untrans.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gewara.Config;
import com.gewara.support.lifecycle.BeforeUpdateService;
import com.gewara.untrans.OpenApiRegService;
import com.gewara.untrans.monitor.ZookeeperService;
import com.gewara.util.GewaLogger;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.TimerHelper;
import com.gewara.util.WebLogger;

/**
 * @author ge.biao
 * TODO:锟斤拷锟较低筹拷锟斤拷锟斤拷锟斤拷锟斤拷远锟斤拷锟斤拷锟�
 */
public class OpenApiRegServiceImpl implements OpenApiRegService, BeforeUpdateService {
	private GewaLogger logger = WebLogger.getLogger(getClass());
	@Autowired@Qualifier("keeperService")
	private ZookeeperService keeperService;
	
	private Map<String, Set<String>> regData = new HashMap<String, Set<String>>();

	private String checkUri;
	public void setCheckUri(String checkUri) {
		this.checkUri = checkUri;
	}
	
	/**
	 * OPENAPI锟斤拷锟斤拷注锟结处锟斤拷
	 */
	@Override
	public void registerOpenApi(final String path, final String data){
		TimerHelper.TIMER.schedule(new Runnable() {
			@Override
			public void run() {
				registerOpenApiInternal(path, data);
			}
		}, 5000);
				
	}
	private void registerOpenApiInternal(String path, String data){
		try{
			boolean openapiOk = checkUrl();
			if(openapiOk){
				if(!keeperService.exist(path)){
					keeperService.addPresistentNode(path, System.currentTimeMillis()+"");
				}
				logger.warn("zookeeper锟斤拷锟斤拷锟绞憋拷诘锟� 锟斤拷 " + path + " 锟节碉拷锟斤拷锟斤拷为锟斤拷" + data);
				keeperService.registerNode(path + "/s", data);
				Set<String> dataList = regData.get(path);
				if(dataList==null){
					dataList = new HashSet<>();
					regData.put(path, dataList);
				}
				dataList.add(data);
			}
		}catch(Exception ex){
			logger.error("", ex);
		}
	}
	@Override
	public void unregisterOpenApi(){
		//注锟斤拷OPENAPI
		logger.warn("unregister to openapi~~");
		for(Map.Entry<String, Set<String>> reg: regData.entrySet()){
			for(String data: reg.getValue()){
				keeperService.unRegisterEphemeralNode(reg.getKey(), data);
			}
		}
	}
	
	@Override
	public void beforeUpdate() {
		unregisterOpenApi();
	}
	private boolean checkUrl(){
		String checkUrl = "http://" + Config.getServerIp() + ":2000" + checkUri;

		for(int i=0;i<10;i++){
			HttpResult result = HttpUtils.getUrlAsString(checkUrl);
			if(result.isSuccess()){
				return true;
			}else{
				try {
					logger.warn("testOpenapi2000 failure!!");
					Thread.sleep(3000L);
				} catch (InterruptedException e) {
				}
			}
		}
		return false;
	}
	
}
