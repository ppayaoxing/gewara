package com.gewara.web.component.mon;

import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gewara.Config;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.Debugger;
import com.gewara.util.GewaIpConfig;
import com.gewara.web.support.ViewContextDebugger;
import com.gewara.web.util.ParamCollectUtils;

@Controller("_sysDebugController_")
public class SysDebugController {
	/**
	 * @param seconds
	 * @return
	 */
	@RequestMapping("/sysmgr/debugger/enableParamsCollect.xhtml")
	@ResponseBody
	public String enableParamsCollect(HttpServletRequest request, int seconds){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		ParamCollectUtils.enableCollect(seconds);
		return "enableParamsCollect: "+ seconds;
	}
	@RequestMapping("/sysmgr/debugger/getParamsData.xhtml")
	public void getParamsData(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		List<String> stats = ParamCollectUtils.getStats();
		response.setContentType("text/plain");
		response.addHeader("Content-Disposition", "attachment;filename=paramsData" + Config.SYSTEMID + ".txt");
		Writer writer = response.getWriter();
		for(String row: stats){
			writer.write(row);
			writer.write("\n");
		}
		response.flushBuffer();
	}
	@RequestMapping("/sysmgr/debugger/setIgnoreField.xhtml")
	@ResponseBody
	public String setIgnoreField(String f, HttpServletRequest request, ModelMap model){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if(StringUtils.isNotBlank(f)){
			model.put("f", f);//≤‚ ‘
			ViewContextDebugger.ignoreField = Arrays.asList(StringUtils.split(f, ","));
		}
		return GewaIpConfig.getHostname() +":" + ViewContextDebugger.isDebugEnabled() + ":" + f;
	}
	@RequestMapping("/sysmgr/debugger/setVelocityDebug.xhtml")
	@ResponseBody
	public String toggleVelocityDebug(String enable, HttpServletRequest request){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		ViewContextDebugger.setDebugEnabled(StringUtils.equals(enable, "true"));
		//velocityEngine.
		return GewaIpConfig.getHostname() +":" + ViewContextDebugger.isDebugEnabled();
	}
	@RequestMapping("/sysmgr/debugger/addVelocityDebugIgnoreUri.xhtml")
	@ResponseBody
	public String modifyDebugUri(String uri, HttpServletRequest request){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if(StringUtils.isNotBlank(uri) && StringUtils.startsWith(uri, "/")){
			ViewContextDebugger.addIgnoreUri(uri);
		}
		//velocityEngine.
		return GewaIpConfig.getHostname() +":" + ViewContextDebugger.isDebugEnabled() + ", ignore:" + ViewContextDebugger.getIgnoreUris();
	}
	@RequestMapping("/sysmgr/debugger/enableClazz.xhtml")
	@ResponseBody
	public String enableClazz(String clazz, HttpServletRequest request){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if(StringUtils.isNotBlank(clazz)){
			Debugger.enableClazz(clazz);
		}
		return Config.getHostname() + ":" + Debugger.getDebugInfo();
	}
	@RequestMapping("/sysmgr/debugger/toggleDebugger.xhtml")
	@ResponseBody
	public String toggleDebugger(HttpServletRequest request){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		Debugger.setDebugEnabled(!Debugger.isDebugEnabled());
		return Config.getHostname() + ":"+Debugger.isDebugEnabled();
	}

	@RequestMapping("/sysmgr/debugger/disableClazz.xhtml")
	@ResponseBody
	public String disableClazz(String clazz, HttpServletRequest request){
		String ip = BaseWebUtils.getRemoteIp(request);
		GewaIpConfig.filterOfficeIp(ip);
		if(StringUtils.isNotBlank(clazz)){
			Debugger.disableClazz(clazz);
		}
		return Config.getHostname() + ":" + Debugger.getDebugInfo();
	}

}
