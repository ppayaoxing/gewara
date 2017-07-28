/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.service.impl;

import com.gewara.dao.Dao;
import com.gewara.model.acl.GewaraUser;
import com.gewara.model.acl.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public abstract class AbstractAclService implements UserDetailsService {
	@Autowired
	@Qualifier("baseDao")
	protected Dao baseDao;
	protected ThreadLocal<String> LOGON_TYPE = new ThreadLocal();
	protected boolean copyAuthorities = false;

	public void setBaseDao(Dao baseDao) {
		this.baseDao = baseDao;
	}

	public void setLogonType(String logonType) {
		this.LOGON_TYPE.set(logonType);
	}

	public void setCopyAuthorities(boolean copyAuthorities) {
		this.copyAuthorities = copyAuthorities;
	}

	public GewaraUser loadUserByUsername(String username) throws UsernameNotFoundException {
		this.LOGON_TYPE.set((Object) null);
		GewaraUser user = (GewaraUser) this.baseDao.getObjectByUkey(User.class, "username", username);
		return user;
	}

	public boolean isCopyAuthorities() {
		return this.copyAuthorities;
	}
}