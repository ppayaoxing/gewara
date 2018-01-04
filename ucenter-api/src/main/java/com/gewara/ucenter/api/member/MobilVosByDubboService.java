package com.gewara.ucenter.api.member;
import com.gewara.support.ErrorCode;
/*
 * 根据手机号、tag校验验证码用dubbo实现定义的接口
 * 彭迪
 * 2014年10月28日
 */
public interface MobilVosByDubboService {
	public ErrorCode<String> validateMobileCheckByTag(String mobile, String tag, String checkpass);
	public ErrorCode<String> sendMobileCheckByTag(String mobile, String tag,String ip);
  
}
