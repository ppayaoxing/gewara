/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.service.impl;

import com.gewara.dao.Dao;
import com.gewara.model.acl.Role;
import com.gewara.model.acl.User;
import com.gewara.model.acl.WebModule;
import com.gewara.service.AclManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AclManagerImpl implements AclManager {
	@Autowired
	@Qualifier("baseDao")
	private Dao baseDao;

	public void setBaseDao(Dao baseDao) {
		this.baseDao = baseDao;
	}

	public Role getRole(String rolename) {
		List roles = this.baseDao.findByHql("from Role where name=?", new Object[] { rolename });
		return roles.isEmpty() ? null : (Role) roles.get(0);
	}

	public void removeRole(String rolename) {
		Role role = this.getRole(rolename);
		if (role != null) {
			this.baseDao.removeObject(role);
		}

	}

	public Role addRole(String rolename, String description, String tag) {
		Role role = new Role(rolename);
		role.setDescription(description);
		role.setTag(tag);
		this.baseDao.saveObject(role);
		return role;
	}

	public List<WebModule> getMainMenuList(String tag, boolean showAll) {
		String query = "from WebModule w where w.menucode is not null and w.tag = ? and length(w.menucode)=2 "
				+ (showAll ? "" : "and w.display=\'Y\'") + "order by menucode";
		List result = this.baseDao.findByHql(query, new Object[] { tag });
		return result;
	}

	public List<WebModule> getSubMenuList(String tag, String mainmenucode, boolean showAll) {
		String query = "from WebModule w where w.menucode is not null " + (showAll ? "" : "and w.display=\'Y\' ")
				+ "and w.tag = ? and length(w.menucode)=4 and w.menucode like ? and w.menucode!=?  order by menucode";
		List result = this.baseDao.findByHql(query, new Object[] { tag, mainmenucode + "%", mainmenucode });
		return result;
	}

	public String getMainMenuNextSubCode(String mainmenucode) {
		DetachedCriteria query = DetachedCriteria.forClass(WebModule.class);
		query.add(Restrictions.ne("menucode", mainmenucode));
		query.add(Restrictions.like("menucode", mainmenucode, MatchMode.START));
		query.setProjection(Projections.property("menucode"));
		List codeList = this.baseDao.findByCriteria(query);
		if (codeList.isEmpty()) {
			return mainmenucode + "01";
		} else {
			ArrayList codenumList = new ArrayList();
			Iterator num = codeList.iterator();

			while (num.hasNext()) {
				Object strnum = num.next();
				codenumList.add(Integer.valueOf(((String) strnum).substring(2, 4)));
			}

			Collections.sort(codenumList);
			Integer num1 = (Integer) codenumList.get(codenumList.size() - 1);
			num1 = Integer.valueOf(num1.intValue() + 1);
			String strnum1 = mainmenucode + num1;
			if (num1.intValue() < 10) {
				strnum1 = mainmenucode + "0" + num1;
			}

			return String.valueOf(strnum1);
		}
	}

	public String getMainMenuNextCode(String tag) {
		String query = "select w.menucode from WebModule w where w.menucode is not null and w.tag = ? and length(w.menucode)=2 order by menucode";
		List codeList = this.baseDao.findByHql(query, new Object[] { tag });
		if (codeList.isEmpty()) {
			return "01";
		} else {
			ArrayList codenumList = new ArrayList();
			Iterator num = codeList.iterator();

			while (num.hasNext()) {
				Object strnum = num.next();
				codenumList.add(Integer.valueOf((String) strnum));
			}

			Collections.sort(codenumList);
			Integer num1 = (Integer) codenumList.get(codenumList.size() - 1);
			num1 = Integer.valueOf(num1.intValue() + 1);
			String strnum1 = "" + num1;
			if (num1.intValue() < 10) {
				strnum1 = "0" + num1;
			}

			return String.valueOf(strnum1);
		}
	}

	public List<Role> getRoleListByTag(String tag) {
		String sql = "from Role where tag=? order by name";
		List result = this.baseDao.findByHql(sql, new Object[] { tag });
		return result;
	}

	public List<User> getRelatedUsersByRole(Long roleId) {
		String query = "from User where id in (select userid from User2Role where role.id = ?)";
		List unrelatedUsers = this.baseDao.findByHql(query, new Object[] { roleId });
		return unrelatedUsers;
	}

	public List<User> getUnrelatedUsersByRole(Long roleId) {
		String query = "from User where id not in (select userid from User2Role where role.id = ?)";
		List unrelatedUsers = this.baseDao.findByHql(query, new Object[] { roleId });
		return unrelatedUsers;
	}

	public List<Long> getRelatedModulesByRole(Long roleId) {
		String roleModuleQuery = "select module.id from Module2Role where role.id = ? ";
		List roleModules = this.baseDao.findByHql(roleModuleQuery, new Object[] { roleId });
		return roleModules;
	}
}