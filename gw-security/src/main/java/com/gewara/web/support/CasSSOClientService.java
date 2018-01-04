package com.gewara.web.support;

import com.gewara.Config;
import com.gewara.constant.UserType;
import com.gewara.model.acl.GewaraUser;
import com.gewara.model.acl.User;
import com.gewara.service.DaoService;
import com.gewara.sso.client.cas.GewaraSsoClient;
import com.gewara.support.ErrorCode;
import com.gewara.util.BeanUtil;
import com.gewara.util.StringUtil;
import lombok.extern.log4j.Log4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class CasSSOClientService extends AbstractSSOClientService implements InitializingBean {
    private GewaraSsoClient ssoClient;
    @Autowired
    @Qualifier("daoService")
    private DaoService daoService;

    public void setDaoService(DaoService daoService) {
        this.daoService = daoService;
    }

    @Override
    public void afterPropertiesSet() {
        Assert.notNull(aclService, "蹇呴』鎻愪緵aclService瀹炵幇锛�");
        String validateUrl = config.getString("ssoValidateUrl");
        ssoClient = new GewaraSsoClient(config.getString("ssoLoginUrl"), getPath(), validateUrl);
    }

    @Override
    public String getLoginUrl(HttpServletRequest request) {
        String url = config.getString("ssoLoginUrl") + "?";
        url += "service=" + getPath() + config.getBasePath() + "casLogon.xhtml?";
        String callback = "system=" + Config.SYSTEMID + "&returnUrl=";
        String returnUrl = request.getParameter(targetUrlParameter);
        if (StringUtils.isBlank(returnUrl)) {
            String contextPath = request.getContextPath();
            returnUrl = request.getRequestURI().substring(contextPath.length());//鍘婚櫎ContextPath
            String qstr = request.getQueryString();
            if (StringUtils.isNotBlank(qstr)) {
                try {
                    returnUrl += "?" + URLDecoder.decode(qstr, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    log.error("", e);
                }
            }
            try {
                callback += Base64.encodeBase64URLSafeString(returnUrl.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e) {
                log.error("", e);
            }
        } else {
        }
        try {
            callback = URLDecoder.decode(callback, "utf-8");
            callback = URLEncoder.encode(callback, "utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error("",e);
        }
        url += callback;
        return url;
    }

    @Override
    public ErrorCode<GewaraUser> getGewaraUser(HttpServletRequest request, HttpServletResponse response, String sessid) {
        Assertion assertion = null;
        try {
            assertion = ssoClient.validationSso(request, response, getPath(), config.getBasePath());
            List<String> roles = ssoClient.loadUserAttributes(assertion);
            GewaraUser user = createCasUser(assertion);
            if (user == null) {
                return ErrorCode.getFailure("鐢ㄦ埛淇℃伅鏈悓姝ワ紝璇峰悓姝ョ敤鎴蜂俊鎭紒锛�");
            }
            if (aclService.isCopyAuthorities()) {
                StringBuffer rolenames = new StringBuffer();
                List<GrantedAuthority> tmpAuth = new ArrayList();
                for (Object key : roles) {
                    String role = key.toString().trim();
                    if (StringUtils.isBlank(role)) {
                        continue;
                    }
                    rolenames.append(role + ",");
                    tmpAuth.add(new SimpleGrantedAuthority(role));
                }
                BeanUtil.set(user, "rolenames", rolenames.toString());
                //鍋氫竴娆″垵濮嬪寲
                user.getAuthorities();
            }
            BeanUtil.set(user, "usertype", UserType.USER_TYPE_SSO);
            return ErrorCode.getSuccessReturn(user);
        } catch (Exception e) {
            dbLogger.warn(e, 10);
            return ErrorCode.getFailure("鍗曠偣鐧诲綍澶辫触,璇峰崟鐐圭櫥褰曢厤缃紒锛�");
        }
    }

    private String getPath() {
        String path = config.getString("houtaiPath");
        if (StringUtils.isBlank(path)) {
            path = config.getAbsPath();
        }
        return path;
    }

    private GewaraUser createCasUser(Assertion assertion) {
        User user = daoService.getObjectByUkey(User.class, "username", assertion.getPrincipal().getName());
        Long userid = Long.parseLong(GewaraSsoClient.loadUserAttributes(assertion, "id"));
        boolean update = false;//缁熶竴displayName銆乵ail銆乵obile
        if (user == null) {
            user = daoService.getObject(User.class, userid);
            update = true;
        }
        // 濡傛灉娌℃湁鍚屾锛岀畝鍗曚繚瀛樹竴涓�
        if (user == null) {
            user = new User();
            user.setUsername(assertion.getPrincipal().getName());
            user.setPassword(StringUtil.getRandomString(10));
            user.setId(userid);
            user.setAccountEnabled("Y");
            update = true;
        }
        if (update) {
            user.setNickname(GewaraSsoClient.loadUserAttributes(assertion, "displayName"));
            user.setEmail(GewaraSsoClient.loadUserAttributes(assertion, "mail"));
            user.setMobile(GewaraSsoClient.loadUserAttributes(assertion, "mobile"));
            user.setUsertype(UserType.USER_TYPE_SSO);
            user = daoService.saveObject(user);
        }
        return user;
    }

}
