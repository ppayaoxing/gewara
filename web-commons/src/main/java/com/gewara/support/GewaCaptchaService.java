package com.gewara.support;

import com.gewara.untrans.CacheService;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.util.GewaLogger;
import com.gewara.util.StringUtil;
import com.gewara.util.WebLogger;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.patchca.CaptchaUtil;
import org.patchca.PatchcaUtils;
import org.patchca.service.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class GewaCaptchaService {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(getClass());
	private static final String KEY_CAPTCHA = "CAP_";
	private static final String KEY_CAPTCHA_COUNT = "CAPCOUNT_";
	private static final String LOGON_CAPTCHAPRE = "zt2reXy";
	private int checkCount = 0;
	private CaptchaUtil captchaUtil;
	@Autowired@Qualifier("monitorService")
	private MonitorService monitorService;
	public GewaCaptchaService(){
		captchaUtil = new PatchcaUtils(80, 40, 4, 4);
	}
	public GewaCaptchaService(String capstr){
		captchaUtil = new PatchcaUtils(80, 40, 4, 4, capstr);
	}
	public void setCaptchaUtil(CaptchaUtil captchaUtil) {
		this.captchaUtil = captchaUtil;
	}

	protected CacheService cacheService;
	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}
	/**
	 * 需要登录的验证码
	 * @param captchaId
	 * @param ip
	 * @param memberid
	 * @return
	 */
	public BufferedImage getLogonCaptchaImage(String captchaId, String ip, Long memberid) {
		captchaId = StringUtil.md5(LOGON_CAPTCHAPRE + memberid, 16) + captchaId;
		return getCaptchaImage(captchaId);
	}
	public BufferedImage getCaptchaImage(String captchaId) {
		Captcha captcha = captchaUtil.createCaptcha();
		BufferedImage challenge = captcha.getImage();
		cacheService.set(CacheService.REGION_TENMIN, KEY_CAPTCHA + captchaId, captcha.getChallenge());
		return challenge;
	}
	
	public ErrorCode<Map<String, String>> validateLogonResponse(String captchaId, String response, String ip, Long memberid) {
		captchaId = StringUtil.md5(LOGON_CAPTCHAPRE + memberid, 16) + captchaId;
		return validateResponseForID(captchaId, response, ip);
	}
	public String getCaptchaValue(String captchaId){
		return (String) cacheService.get(CacheService.REGION_TENMIN, KEY_CAPTCHA + captchaId);
	}

	/** 根据 验证码id,ip和验证码验证.
	 * @param captchaId
	 * @param captcha
	 * @param ip
	 * @return
	 */
	public ErrorCode<Map<String, String>> validateResponseForID(String captchaId, String captcha, String ip) {
		checkCount ++;
		if(checkCount % 1000==0){
			checkCount = 0;
			dbLogger.warn("验证码1000次计数：" + checkCount);
		}
		if(captcha==null) {
			Map<String, String> entry = Maps.newHashMap();
			entry.put("errtype", "captcha");
			entry.put("captchaId", captchaId);
			entry.put("response", captcha);
			entry.put("msg", "未输入验证码");
			return ErrorCode.getFailureReturn(entry);
		}
		captcha = StringUtils.replace(captcha, " ", "");
		String captchaText = (String) cacheService.get(CacheService.REGION_TENMIN, KEY_CAPTCHA + captchaId);
		if(captchaText != null){
			int count = cacheService.incr(CacheService.REGION_ONEHOUR, KEY_CAPTCHA_COUNT + captchaId, 1, 1);
			if(count > 20){//同一验证码验证不能超过20次
				dbLogger.warn("验证码错误,次数超出：" + captchaId  + "：" + captchaText + "--->" + captcha + ", " + ip);
				return ErrorCode.getFailureReturn(getLogEntry(captchaId, captchaText, captcha, "验证码次数超出"));
			}
			cacheService.remove(CacheService.REGION_TENMIN, KEY_CAPTCHA + captchaId);
			boolean result = captchaText.equalsIgnoreCase(captcha);
			if(!result) {
				dbLogger.warn("验证码错误：" + captchaId  + "：" + captchaText + "--->" + captcha + ", " + ip);
				return ErrorCode.getFailureReturn(getLogEntry(captchaId, captchaText, captcha, "验证码错误"));
			}
			return ErrorCode.SUCCESS;
		}else{
			Map<String, String> entry = Maps.newHashMap();
			entry.put("errtype", "captcha");
			entry.put("captchaId", captchaId);
			entry.put("response", captcha);
			entry.put("msg", "验证码不存在！");
			return ErrorCode.getFailureReturn(entry);
		}
		
	}
	private Map<String, String> getLogEntry(String captchaId, String captchaText, String response, String msg){
		Map<String, String> entry = Maps.newHashMap();
		entry.put("errtype", "captcha");
		entry.put("captchaId", captchaId);
		entry.put("captchaText", captchaText);
		entry.put("response", response);
		entry.put("msg", msg);
		return entry;
	}
	
	public static final String upper = "ABCDEFGHJKLMNPRSTUVWXYZabcdefghkmnrstuvwxz2345678";// I,O,Q,i,j,l,o,p,q,y,1,9,0去掉

	/**
	 * @param length
	 *            生成的字符串长度，<100
	 * @return
	 */
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(upper.charAt(RandomUtils.nextInt(upper.length())));
		}
		return sb.toString();
	}
	
}
