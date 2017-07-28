/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.component.mon;

import com.gewara.untrans.DataReceiveCallback;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataReceiveController {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	@Autowired(required = false)
	private DataReceiveCallback dataReceiveCallback;

	@RequestMapping({"/data/receive.xhtml"})
	@ResponseBody
	public String dataReceive(String dataBody, HttpServletRequest request) {
		String ip = BaseWebUtils.getRemoteIp(request);
		if (GewaIpConfig.isGewaInnerIp(ip) && GewaIpConfig.isLocalIp(ip)) {
			this.dataReceiveCallback.receiveData(dataBody);
			return "ok";
		} else {
			String msg = "error:invalid ip=>" + ip;
			this.dbLogger.error(msg);
			return msg;
		}
	}
}