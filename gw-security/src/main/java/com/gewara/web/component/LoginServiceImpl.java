package com.gewara.web.component;

import com.gewara.Config;
import com.gewara.model.acl.GewaraUser;
import com.gewara.model.acl.User;
import com.gewara.support.ErrorCode;
import com.gewara.untrans.CacheService;
import com.gewara.untrans.monitor.MonitorService;
import com.gewara.util.*;
import com.gewara.web.support.CachedAuthentication;
import com.gewara.web.support.GewaAuthenticationSuccessHandler;
import com.gewara.web.support.SSOAuthenticationToken;
import com.gewara.web.support.SSOClientService;
import com.gewara.web.util.LoginUtils;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginServiceImpl implements LoginService {
    private final transient GewaLogger dbLogger = LoggerUtils.getLogger(getClass());
    @Autowired
    @Qualifier("authenticationManager")
    protected ProviderManager authenticationManager;
    @Autowired
    @Qualifier("successHandler")
    protected GewaAuthenticationSuccessHandler successHandler;

    protected CacheService cacheService;

    public void setCacheService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    protected SSOClientService ssoClientService;

    public void setSsoClientService(SSOClientService ssoClientService) {
        this.ssoClientService = ssoClientService;
    }

    @Autowired
    @Qualifier("monitorService")
    protected MonitorService monitorService;
    private int allowIpNum = 2;    //鍏佽IP鍙樻洿鐨勬鏁�

    public void setAllowIpNum(int allowIpNum) {
        this.allowIpNum = allowIpNum;
    }

    /**
     * 鏍规嵁鐢ㄦ埛鍚嶅拰瀵嗙爜鐧诲綍
     *
     * @param request
     * @param response
     * @param username
     * @param password
     * @return
     */
    @Override
    public ErrorCode<Map> autoLogin(HttpServletRequest request, HttpServletResponse response, String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return ErrorCode.getFailure("鐢ㄦ埛鍚嶅瘑鐮佸繀濉紒");
        }
        Authentication auth = new UsernamePasswordAuthenticationToken(username, password);
        return autoLogin(request, response, auth);
    }

    @Override
    public ErrorCode<Map> ssoAutoLogin(HttpServletRequest request, HttpServletResponse response, String sessid) {
        ErrorCode<GewaraUser> result = ssoClientService.getGewaraUser(request, response, sessid);
        Map<String, String> loginResult = new HashMap<String, String>();
        if (result.isSuccess()) {
            Authentication auth = new SSOAuthenticationToken(result.getRetval(), Config.SYSTEMID, result.getRetval().getAuthorities());
            return autoLogin(request, response, auth);
        } else {
            loginResult.put("msg", result.getMsg());
        }
        return ErrorCode.getFailureReturn(loginResult);
    }

    /**
     * 鏍规嵁璁よ瘉淇℃伅鐧诲綍
     *
     * @param request
     * @param response
     * @param auth
     * @return
     */
    protected ErrorCode<Map> autoLogin(HttpServletRequest request, HttpServletResponse response, Authentication auth) {
        Map errorMap = Maps.newHashMap();
        try {
            auth = authenticationManager.authenticate(auth);
            if (auth.isAuthenticated()) {
                successHandler.processSuccess(request, response, auth);
                Map jsonMap = BeanUtil.getBeanMapWithKey(auth.getPrincipal(), "realname", "id", "mobile");
                if (StringUtils.isNotBlank((String) jsonMap.get("mobile"))) {
                    jsonMap.put("isMobile", true);
                } else {
                    jsonMap.put("isMobile", false);
                }
                return ErrorCode.getSuccessReturn(jsonMap);
            } else {
                errorMap.put("j_username", "鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒锛�");
            }
        } catch (DisabledException e) {
            errorMap.put("j_username", "浣犵殑鐢ㄦ埛琚鐢紝璇疯仈绯诲鏈嶏紒");
        } catch (AuthenticationServiceException e) {//鐢ㄦ埛涓嶅瓨鍦�.
            errorMap.put("j_username", "浣犵殑璐﹀彿涓嶅瓨鍦紒");
        } catch (BadCredentialsException e) {//瀵嗙爜閿欒
            errorMap.put("j_password", "瀵嗙爜閿欒锛�");
        } catch (Exception e) {
            dbLogger.warn("", e, 15);
            errorMap.put("j_username", "鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒锛�");
        }

        return ErrorCode.getFailureReturn(errorMap);
    }

    /**
     * 閫氳繃id鍜宻essid鑾峰彇user
     *
     * @param ip
     * @param sessid
     * @return
     */
    @Override
    public GewaraUser getLogonGewaraUserBySessid(String ip, String sessid) {
        Authentication auth = loadAuthentication(ip, sessid);
        if (auth != null) {
            return (GewaraUser) auth.getPrincipal();
        }
        return null;
    }

    /**
     * 鍔犺浇骞跺埛鏂版洿鏂版椂闂�
     *
     * @param ip
     * @param sessid
     * @return
     */
    @Override
    public Authentication loadAuthentication(String ip, String sessid) {
        if (!LoginUtils.isValidSessid(sessid)) {
            return null;
        }
        String ukey = LoginUtils.getCacheUkey(sessid);
        CachedAuthentication ca = (CachedAuthentication) cacheService.get(CacheService.REGION_LOGINAUTH, ukey);
        if (ca != null) {
            if (!StringUtils.contains(ca.getIp(), ip)) {//IP鍙樻洿
                Map entry = Maps.newHashMap();
                entry.put("oldip", ca.getIp());
                entry.put("newip", ip);
                entry.put("errortype", LoginUtils.ERROR_IPCHANGE);
                entry.put("username", ca.getAuthentication().getName());
                entry.put("usertype", ca.getAuthentication().getPrincipal().getClass().getName());
                Long memberid = ((GewaraUser) ca.getAuthentication().getPrincipal()).getId();
                // 淇濆瓨鍒板墠鍙扮敤鎴疯涓�,
                monitorService.saveMemberLogMap(memberid, "login", entry, ip);

                dbLogger.warn("鐧诲綍IP涓嶅尮閰嶏紝" + ca.getAuthentication().getName() + ":" + ca.getIp() + "---->" + ip);
                //
                if (cannotChangeIp(ca.getAuthentication().getPrincipal(), ip)) {
                    return null;//涓嶈兘鏇存崲ID
                }
                //TODO:鍚岀綉娈电殑IP涓嶇畻鏇存敼璁℃暟
                if (StringUtils.split(ca.getIp(), ",").length >= allowIpNum) {//瓒呰繃3涓狪P锛岀洿鎺orbidden锛岀Щ鍑虹櫥褰曚俊鎭�
                    cacheService.remove(CacheService.REGION_LOGINAUTH, ukey);
                    return null;
                }
                ca.setIp(ca.getIp() + "," + ip);
                cacheService.set(CacheService.REGION_LOGINAUTH, ukey, ca);
            }
            if (ca.getTimeout() != null && ca.getTimeout() < System.currentTimeMillis() + DateUtil.m_minute * 20) {//20鍒嗛挓鍗冲皢瓒呮椂锛岄噸鏂拌缃�
                // 閲嶇疆鐧诲綍鏃堕棿,鍒锋柊鐧诲綍淇℃伅
                cacheService.set(CacheService.REGION_LOGINAUTH, ukey, ca);
            }
            return ca.getAuthentication();
        }
        return null;
    }

    protected boolean cannotChangeIp(Object principal, String ip) {
        return principal != null && principal instanceof User && !GewaIpConfig.isOfficeIp(ip);
    }

    /**
     * 鍔犺浇骞跺埛鏂版洿鏂版椂闂�
     *
     * @param
     * @param sessid
     * @return
     */
    @Override
    public boolean isGewaraUserLogon(HttpServletRequest request, String sessid) {
        CachedAuthentication ca = (CachedAuthentication) cacheService.get(CacheService.REGION_LOGINAUTH, LoginUtils.getCacheUkey(sessid));
        return ca != null;
    }

    @Override
    public void removeInvalidSessid(String sessid) {
        cacheService.remove(CacheService.REGION_LOGINAUTH, LoginUtils.getCacheUkey(sessid));
    }
}
