/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.service.impl;

import com.gewara.model.acl.GewaraUser;
import com.gewara.model.acl.Role;
import com.gewara.model.acl.User;
import com.gewara.model.acl.WebModule;
import com.gewara.service.impl.AbstractAclService;
import com.gewara.web.support.AclService;
import java.util.List;

public class AclServiceImpl extends AbstractAclService implements AclService<WebModule> {
	public GewaraUser getGewaraUser(Long userid, String logonType) {
		return (GewaraUser) this.baseDao.getObject(User.class, userid);
	}

	public List<WebModule> getMenuList(String tag) {
		String query = "from WebModule where display=\'Y\' and tag = ? order by menucode";
		List result = this.baseDao.findByHql(query, new Object[] { tag });
		return result;
	}

	public List<WebModule> getSecurityModuleList() {
		String query = "from WebModule where moduleurl is not null and tag like ? order by matchorder";
		List result = this.baseDao.findByHql(query, new Object[] { "G%" });
		return result;
	}

	public List<String> getRolenameList() {
		List result = this.baseDao.getObjectPropertyList(Role.class, "name");
		return result;
	}
}