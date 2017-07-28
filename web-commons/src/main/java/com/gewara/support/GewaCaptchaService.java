/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import com.gewara.support.ErrorCode;
import com.gewara.untrans.CacheService;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.util.GewaLogger;
import com.gewara.util.StringUtil;
import com.gewara.util.WebLogger;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.patchca.CaptchaUtil;
import org.patchca.PatchcaUtils;
import org.patchca.service.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class GewaCaptchaService {
	protected final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());
	private static final String KEY_CAPTCHA = "CAP_";
	private static final String KEY_CAPTCHA_COUNT = "CAPCOUNT_";
	private static final String LOGON_CAPTCHAPRE = "zt2reXy";
	private int checkCount = 0;
	private CaptchaUtil captchaUtil;
	@Autowired
	@Qualifier("monitorService")
	private MonitorService monitorService;
	protected CacheService cacheService;
	public static final String upper = "ABCDEFGHJKLMNPRSTUVWXYZabcdefghkmnrstuvwxz2345678";

	public GewaCaptchaService() {
		this.captchaUtil = new PatchcaUtils(80, 40, 4, 4);
	}

	public GewaCaptchaService(String capstr) {
		this.captchaUtil = new PatchcaUtils(80, 40, 4, 4, capstr);
	}

	public void setCaptchaUtil(CaptchaUtil captchaUtil) {
		this.captchaUtil = captchaUtil;
	}

	public void setCacheService(CacheService cacheService) {
		this.cacheService = cacheService;
	}

	public BufferedImage getLogonCaptchaImage(String captchaId, String ip, Long memberid) {
		captchaId = StringUtil.md5("zt2reXy" + memberid, 16) + captchaId;
		return this.getCaptchaImage(captchaId);
	}

	public BufferedImage getCaptchaImage(String captchaId) {
		Captcha captcha = this.captchaUtil.createCaptcha();
		BufferedImage challenge = captcha.getImage();
		this.cacheService.set("tenMin", "CAP_" + captchaId, captcha.getChallenge());
		return challenge;
	}

	public ErrorCode<Map<String, String>> validateLogonResponse(String captchaId, String response, String ip,
			Long memberid) {
		captchaId = StringUtil.md5("zt2reXy" + memberid, 16) + captchaId;
		return this.validateResponseForID(captchaId, response, ip);
	}

	public String getCaptchaValue(String captchaId) {
		return (String) this.cacheService.get("tenMin", "CAP_" + captchaId);
	}

	public ErrorCode<Map<String, String>> validateResponseForID(String captchaId, String response, String ip) {
		++this.checkCount;
		if (this.checkCount % 1000 == 0) {
			this.checkCount = 0;
			this.dbLogger.warn("验证码1000次计数：" + this.checkCount);
		}

		if (response == null) {
			HashMap arg6 = new HashMap();
			arg6.put("errtype", "captcha");
			arg6.put("captchaId", captchaId);
			arg6.put("response", response);
			arg6.put("msg", "未输入验证码");
			return ErrorCode.getFailureReturn(arg6);
		} else {
			response = StringUtils.replace(response, " ", "");
			String captchaText = (String) this.cacheService.get("tenMin", "CAP_" + captchaId);
			if (captchaText != null) {
				int arg7 = this.cacheService.incr("oneHour", "CAPCOUNT_" + captchaId, 1, 1);
				if (arg7 > 20) {
					this.dbLogger.warn("验证码错误,次数超出：" + captchaId + "：" + captchaText + "--->" + response + ", " + ip);
					return ErrorCode.getFailureReturn(this.getLogEntry(captchaId, captchaText, response, "验证码次数超出"));
				} else {
					this.cacheService.remove("tenMin", "CAP_" + captchaId);
					boolean result = captchaText.equalsIgnoreCase(response);
					if (!result) {
						this.dbLogger.warn("验证码错误：" + captchaId + "：" + captchaText + "--->" + response + ", " + ip);
						return ErrorCode.getFailureReturn(this.getLogEntry(captchaId, captchaText, response, "验证码错误"));
					} else {
						return ErrorCode.SUCCESS;
					}
				}
			} else {
				HashMap entry = new HashMap();
				entry.put("errtype", "captcha");
				entry.put("captchaId", captchaId);
				entry.put("response", response);
				entry.put("msg", "验证码不存在！");
				return ErrorCode.getFailureReturn(entry);
			}
		}
	}

	private Map<String, String> getLogEntry(String captchaId, String captchaText, String response, String msg) {
		HashMap entry = new HashMap();
		entry.put("errtype", "captcha");
		entry.put("captchaId", captchaId);
		entry.put("captchaText", captchaText);
		entry.put("response", response);
		entry.put("msg", msg);
		return entry;
	}

	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; ++i) {
			sb.append("ABCDEFGHJKLMNPRSTUVWXYZabcdefghkmnrstuvwxz2345678"
					.charAt(RandomUtils.nextInt("ABCDEFGHJKLMNPRSTUVWXYZabcdefghkmnrstuvwxz2345678".length())));
		}

		return sb.toString();
	}
}