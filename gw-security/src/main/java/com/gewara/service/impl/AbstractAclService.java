package com.gewara.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gewara.dao.Dao;
import com.gewara.model.acl.GewaraUser;
import com.gewara.model.acl.User;

/**
 * @author acerge(acerge@163.com)
 * @since 1:59:19 PM Aug 11, 2009
 */

public abstract class AbstractAclService implements UserDetailsService {
	@Autowired@Qualifier("baseDao")
	protected Dao baseDao;
	public void setBaseDao(Dao baseDao) {
		this.baseDao = baseDao;
	}
	
	protected ThreadLocal<String> LOGON_TYPE = new ThreadLocal<String>();
	public void setLogonType(String logonType){
		this.LOGON_TYPE.set(logonType);
	}
	protected boolean copyAuthorities = false;
	public void setCopyAuthorities(boolean copyAuthorities) {
		this.copyAuthorities = copyAuthorities;
	}
	@Override
	public GewaraUser loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGON_TYPE.set(null);
		GewaraUser user = baseDao.getObjectByUkey(User.class, "username", username);
		return user;
	}

	public boolean isCopyAuthorities() {
		return copyAuthorities;
	}
}
