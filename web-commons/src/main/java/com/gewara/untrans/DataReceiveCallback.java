package com.gewara.untrans;

import com.gewara.web.component.mon.DataReceiveController;

/**
 * 数据接收callback服务，由各个系统自己实现服务逻辑<br>
 * 服务地址入口:<br>http://ip:{port}/data/receive.xhtml<br>
 * <p>
 * 代码见：<p>{@link DataReceiveController#dataReceive(String, javax.servlet.http.HttpServletRequest)})}
 * @author quzhuping
 *
 */
public interface DataReceiveCallback {
	/**
	 * 接收数据
	 * <p>各系统接收到数据后需要通过异步处理后续逻辑
	 * @param jsonData
	 */
	void receiveData(String jsonData);
}
