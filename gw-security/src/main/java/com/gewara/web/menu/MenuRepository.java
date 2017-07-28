/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.menu;

import com.gewara.web.support.SecurityModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.support.PropertyComparator;

public class MenuRepository<T extends SecurityModule> implements Serializable {
	private static final long serialVersionUID = -7404705716824736582L;
	public static final String GEWA_MENU_REPOSITORY_KEY = "com.gewara.web.menu.GEWA_MENU_REPOSITORY";
	public static final String PARTNER_MENU_REPOSITORY_KEY = "com.gewara.web.menu.PARTNER_MENU_REPOSITORY";
	Map<String, List<T>> menuMap = null;
	List<T> topMenuList = null;

	public MenuRepository(List<T> moduleList) {
		this.menuMap = new LinkedHashMap();
		this.topMenuList = new ArrayList();
		this.menuMap.put("0", this.topMenuList);
		Object tmp = null;
		Iterator arg2 = moduleList.iterator();

		while (arg2.hasNext()) {
			SecurityModule code = (SecurityModule) arg2.next();
			if (code.isTop()) {
				this.topMenuList.add(code);
			} else {
				tmp = (List) this.menuMap.get(code.getParentcode());
				if (tmp == null) {
					tmp = new ArrayList();
					this.menuMap.put(code.getParentcode(), tmp);
				}

				((List) tmp).add(code);
			}
		}

		Collections.sort(this.topMenuList, new PropertyComparator("matchorder", false, true));
		arg2 = this.menuMap.keySet().iterator();

		while (arg2.hasNext()) {
			String code1 = (String) arg2.next();
			Collections.sort((List) this.menuMap.get(code1), new PropertyComparator("matchorder", false, true));
		}

	}

	public Map<String, List<T>> getMenuMap() {
		return this.menuMap;
	}

	public void setMenuMap(Map<String, List<T>> menuMap) {
		this.menuMap = menuMap;
	}

	public List<T> getTopMenu() {
		return (List) this.menuMap.get("0");
	}
}