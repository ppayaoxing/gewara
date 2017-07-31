package com.gewara.web.component.mon;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gewara.Config;
import com.gewara.ext.jdbc.validation.GWMysqlConnValidation;
import com.gewara.ext.jdbc.validation.GWOracleConnValidation;
import com.gewara.ext.jdbc.validation.GWPostgresConnValidation;
import com.gewara.service.ReadOnlyDaoService;
import com.gewara.untrans.monitor.ConfigCenter;
import com.gewara.untrans.monitor.ConfigTrigger;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.DateUtil;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.JsonUtils;

@Controller("_dbpool")
public class DbPoolController implements InitializingBean{
	private static final String TAG_POOL_CHECK = "poolCheck";
	private static final String TAG_READONLY_SWITCH = "readOnlyDaoSwitch";
	@Autowired(required=false)
	private ConfigCenter configCenter;
	@Autowired(required=false)
	private ReadOnlyDaoService readOnlyDaoService;
	
	/**
	 * @param seconds（时长）
	 * @return
	 */
	@RequestMapping("/sysmgr/dbpool/enableCheck.xhtml")
	@ResponseBody
	public String enableConnectionCheck(HttpServletRequest request, Integer seconds){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if(seconds==null){
			seconds = 1200;
		}
		long endtime = System.currentTimeMillis() + seconds * 1000;
		GWOracleConnValidation.enableValidate(endtime);
		GWPostgresConnValidation.enableValidate(endtime);
		try{
			GWMysqlConnValidation.enableValidate(endtime);
		}catch(Throwable e){//程序未升级
		}
		return "ok";
	}
	@RequestMapping("/sysmgr/dbpool/disableCheck.xhtml")
	@ResponseBody
	public String disableConnectionCheck(HttpServletRequest request){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		GWOracleConnValidation.disableValidate();
		GWPostgresConnValidation.disableValidate();
		return "ok";
	}
	@RequestMapping("/sysmgr/dbpool/enableAllCheck.xhtml")
	@ResponseBody
	public String enableAllCheck(HttpServletRequest request, Integer seconds){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if(seconds==null){
			seconds = 1200;
		}
		long endtime = System.currentTimeMillis() + seconds * 1000;
		configCenter.refresh(Config.SYSTEMID, TAG_POOL_CHECK, ""+endtime);
		return "ok:" + new Timestamp(endtime);
	}
	@RequestMapping("/sysmgr/dbpool/getStats.xhtml")
	@ResponseBody
	public String getStats(HttpServletRequest request, String dbtype){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		Map<String, String> stats = new LinkedHashMap<String, String>();
		stats.put("host", Config.getHostname());
		stats.put("dbtype", ""+dbtype);
		if(StringUtils.equals("oracle", dbtype)){
			stats.put("endtime", ""+new Timestamp(GWOracleConnValidation.getEndtime()));
			stats.put("invalidTimes", ""+GWOracleConnValidation.getInvalidTimes());
			stats.put("validateTimes", ""+GWOracleConnValidation.getValidateTimes());
		}else if(StringUtils.equals("postgres", dbtype)){
			stats.put("endtime", "" + new Timestamp(GWPostgresConnValidation.getEndtime()));
			stats.put("invalidTimes", "" + GWPostgresConnValidation.getInvalidTimes());
			stats.put("validateTimes", "" + GWPostgresConnValidation.getValidateTimes());
		}else if(StringUtils.equals("mysql", dbtype)){
			stats.put("endtime", "" + new Timestamp(GWPostgresConnValidation.getEndtime()));
			stats.put("invalidTimes", "" + GWMysqlConnValidation.getInvalidTimes());
			stats.put("validateTimes", "" + GWMysqlConnValidation.getValidateTimes());
		}
		return JsonUtils.writeMapToJson(stats);
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		if(configCenter!=null){
			configCenter.register(Config.SYSTEMID, TAG_POOL_CHECK, new ConfigTrigger(){
				@Override
				public void refreshCurrent(String newConfig) {
					if(StringUtils.isNotBlank(newConfig)){
						Long time = Long.parseLong(newConfig);
						if(time>System.currentTimeMillis()){
							GWOracleConnValidation.enableValidate(time);
							GWPostgresConnValidation.enableValidate(time);
						}
					}
				}
			});
			configCenter.register(Config.SYSTEMID, TAG_READONLY_SWITCH, new ConfigTrigger(){
				@Override
				public void refreshCurrent(String newConfig) {
					if(readOnlyDaoService!=null){
						if(StringUtils.isNotBlank(newConfig)){
							boolean disable = StringUtils.startsWith(newConfig, "disable");
							if(disable){
								readOnlyDaoService.setReadonly(false);
							}else{
								readOnlyDaoService.setReadonly(true);
							}
						}
					}
				}
			});
		}
	}
	@RequestMapping("/sysmgr/dbpool/switchAllReadonly.xhtml")
	@ResponseBody
	public String switchAllReadonly(HttpServletRequest request, String readonly){
		configCenter.refresh(Config.SYSTEMID, TAG_READONLY_SWITCH, readonly + ":" + DateUtil.getCurFullTimestampStr());
		return "all:" + readonly;
	}
	@RequestMapping("/sysmgr/dbpool/switchReadonly.xhtml")
	@ResponseBody
	public String switchReadonly(HttpServletRequest request, String readonly){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if(readOnlyDaoService!=null){
			boolean ro = StringUtils.isBlank(readonly) || StringUtils.equals("Y", readonly);
			readOnlyDaoService.setReadonly(ro);
			return "readonly:" + ro + ":" + Config.getHostname();
		}else{
			return "no readonly!" + ":" + Config.getHostname();
		}
	}

}
