package com.gewara.api.service.weixin;


import java.util.Map;

import com.gewara.api.vo.ResultCode;

public interface WeixinAccessVoService {
  
	ResultCode<Map<String, Object>> getAccessTokenByCode(String code, String appid, String appsecret);
	
	ResultCode<Map<String, String>> getAccessToken(String appid, String appsecret);
}
