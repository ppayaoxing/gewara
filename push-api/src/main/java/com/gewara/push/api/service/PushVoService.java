package com.gewara.push.api.service;
import com.gewara.api.vo.ResultCode;
import com.gewara.push.api.req.vo.PushNotifyNewVo;
/**
 * (推送服务接口)
 * @author chunhui.wang
 */
public interface PushVoService {
	
	/**
	 * (单设备-消息推送)
	 * @param pushNotifyVo	推送对象
	 * @return
	 */
	ResultCode<String> sendPushNotify(PushNotifyNewVo pushNotifyVo);
	
	/**
	 * 推送消息取消
	 * @param msgkey
	 * @return
	 */
	ResultCode<String> cancelPushNotify(String msgkey);
}