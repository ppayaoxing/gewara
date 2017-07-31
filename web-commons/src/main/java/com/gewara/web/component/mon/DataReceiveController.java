package com.gewara.web.component.mon;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gewara.untrans.DataReceiveCallback;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;

@Controller
public class DataReceiveController {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	
	@Autowired(required=false)
	private DataReceiveCallback dataReceiveCallback;
	
	@RequestMapping("/data/receive.xhtml")
	@ResponseBody
	public String dataReceive(String dataBody, HttpServletRequest request){
		String ip = BaseWebUtils.getRemoteIp(request);
		if(!GewaIpConfig.isGewaInnerIp(ip) || !GewaIpConfig.isLocalIp(ip)){
			String msg = "error:invalid ip=>" + ip;
			dbLogger.error(msg);
			return msg;
		}
		dataReceiveCallback.receiveData(dataBody);
		return "ok";
	}
}
