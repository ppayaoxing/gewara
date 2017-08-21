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
    private int allowIpNum = 2;    //允许IP变更的次数

    public void setAllowIpNum(int allowIpNum) {
        this.allowIpNum = allowIpNum;
    }

    /**
     * 根据用户名和密码登录
     *
     * @param request
     * @param response
     * @param username
     * @param password
     * @return
     */
    @Override
    public ErrorCode<Map> autoLogin(HttpServletRequest request, HttpServletResponse response, String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) return ErrorCode.getFailure("用户名密码必填！");
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
     * 根据认证信息登录
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
                } else jsonMap.put("isMobile", false);
                return ErrorCode.getSuccessReturn(jsonMap);
            } else {
                errorMap.put("j_username", "用户名或密码错误！");
            }
        } catch (DisabledException e) {
            errorMap.put("j_username", "你的用户被禁用，请联系客服！");
        } catch (AuthenticationServiceException e) {//用户不存在.
            errorMap.put("j_username", "你的账号不存在！");
        } catch (BadCredentialsException e) {//密码错误
            errorMap.put("j_password", "密码错误！");
        } catch (Exception e) {
            dbLogger.warn("", e, 15);
            errorMap.put("j_username", "用户名或密码错误！");
        }

        return ErrorCode.getFailureReturn(errorMap);
    }

    /**
     * 通过id和sessid获取user
     *
     * @param ip
     * @param sessid
     * @return
     */
    @Override
    public GewaraUser getLogonGewaraUserBySessid(String ip, String sessid) {
        Authentication auth = loadAuthentication(ip, sessid);
        if (auth != null) return (GewaraUser) auth.getPrincipal();
        return null;
    }

    /**
     * 加载并刷新更新时间
     *
     * @param ip
     * @param sessid
     * @return
     */
    @Override
    public Authentication loadAuthentication(String ip, String sessid) {
        if (!LoginUtils.isValidSessid(sessid)) return null;
        String ukey = LoginUtils.getCacheUkey(sessid);
        CachedAuthentication ca = (CachedAuthentication) cacheService.get(CacheService.REGION_LOGINAUTH, ukey);
        if (ca != null) {
            if (!StringUtils.contains(ca.getIp(), ip)) {//IP变更
                Map entry = Maps.newHashMap();
                entry.put("oldip", ca.getIp());
                entry.put("newip", ip);
                entry.put("errortype", LoginUtils.ERROR_IPCHANGE);
                entry.put("username", ca.getAuthentication().getName());
                entry.put("usertype", ca.getAuthentication().getPrincipal().getClass().getName());
                Long memberid = ((GewaraUser) ca.getAuthentication().getPrincipal()).getId();
                // 保存到前台用户行为,
                monitorService.saveMemberLogMap(memberid, "login", entry, ip);

                dbLogger.warn("登录IP不匹配，" + ca.getAuthentication().getName() + ":" + ca.getIp() + "---->" + ip);
                //
                if (cannotChangeIp(ca.getAuthentication().getPrincipal(), ip)) {
                    return null;//不能更换ID
                }
                //TODO:同网段的IP不算更改计数
                if (StringUtils.split(ca.getIp(), ",").length >= allowIpNum) {//超过3个IP，直接forbidden，移出登录信息
                    cacheService.remove(CacheService.REGION_LOGINAUTH, ukey);
                    return null;
                }
                ca.setIp(ca.getIp() + "," + ip);
                cacheService.set(CacheService.REGION_LOGINAUTH, ukey, ca);
            }
            if (ca.getTimeout() != null && ca.getTimeout() < System.currentTimeMillis() + DateUtil.m_minute * 20) {//20分钟即将超时，重新设置
                // 重置登录时间,刷新登录信息
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
     * 加载并刷新更新时间
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
