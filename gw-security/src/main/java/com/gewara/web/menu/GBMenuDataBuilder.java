/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.web.menu;

import com.gewara.util.BeanUtil;
import com.gewara.web.menu.MenuRepository;
import com.gewara.web.support.SecurityModule;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang.StringUtils;

public class GBMenuDataBuilder<T extends SecurityModule> {
	public static final String MENU_DATA_KEY = "com.gewara.web.menu.MENU_DATA_KEY";
	private String basePath = "";
	private Set<String> roles;
	private MenuRepository<T> repository;

	public GBMenuDataBuilder(String basePath, String[] roles, MenuRepository<T> repository) {
		this.basePath = basePath;
		this.roles = new TreeSet(Arrays.asList(roles));
		this.repository = repository;
	}

	public String getBasePath() {
		return this.basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public StringBuilder getMenuData() {
		StringBuilder sb = new StringBuilder();
		this.buildMenuRepository(sb);
		return sb;
	}

	public List getMenuTop() {
		ArrayList lst = new ArrayList();
		Iterator arg1 = this.repository.topMenuList.iterator();

		while (true) {
			SecurityModule menu;
			do {
				if (!arg1.hasNext()) {
					return lst;
				}

				menu = (SecurityModule) arg1.next();
			} while (!"1".equals(menu.getDisplay()) && !"Y".equals(menu.getDisplay()));

			if (this.isAllowed(menu)) {
				lst.add(menu);
			}
		}
	}

	private void buildMenuRepository(StringBuilder sb) {
		sb.append("{");
		sb.append("\'id\':\'0\',");
		sb.append("\'text\':\'Ö÷²Ëµ¥\',");
		sb.append("\'iconCls\':\'icon-pkg\',");
		sb.append("\'cls\':\'package\',");
		sb.append("\'singleClickExpand\':true,");
		sb.append("\'children\':[");
		Iterator arg1 = this.repository.topMenuList.iterator();

		while (true) {
			SecurityModule menu;
			do {
				if (!arg1.hasNext()) {
					sb.deleteCharAt(sb.length() - 1);
					sb.append("]");
					sb.append("}");
					return;
				}

				menu = (SecurityModule) arg1.next();
			} while (!this.isAllowed(menu));

			sb.append("{");
			sb.append("\'id\':\'" + menu.getMenucode() + "\',");
			sb.append("\'text\':\'" + menu.getMenutitle() + "\',");
			List subList = (List) this.repository.menuMap.get(menu.getMenucode());
			if (subList != null && subList.size() > 0) {
				sb.append("\'iconCls\':\'icon-pkg\',");
				sb.append("\'cls\':\'package\',");
				sb.append("\'singleClickExpand\':true,");
				sb.append("\'children\':[");
				boolean href1 = false;

				SecurityModule subMenu;
				for (Iterator arg5 = subList.iterator(); arg5.hasNext(); this.buildMenuData(subMenu, sb)) {
					subMenu = (SecurityModule) arg5.next();
					if (this.isAllowed(subMenu)) {
						href1 = true;
					}
				}

				if (href1) {
					sb.deleteCharAt(sb.length() - 1);
				}

				sb.append("]");
			} else {
				String href = "";
				if (StringUtils.startsWith(menu.getModuleurl(), "http://")) {
					href = menu.getModuleurl();
				} else {
					href = this.basePath + menu.getModuleurl();
				}

				sb.append("\'href\':\'" + href + "\',");
				if (StringUtils.isNotBlank(menu.getTarget())) {
					sb.append("\'target\':\'" + menu.getTarget() + "\',");
				}

				sb.append("\'isClass\':true,\'iconCls\':\'icon-cls\',\'cls\':\'cls\',\'leaf\':true");
			}

			sb.append("},");
		}
	}

	public List<T> getAllSubModule() {
		ArrayList subModuleList = new ArrayList();
		Iterator arg1 = this.repository.topMenuList.iterator();

		while (true) {
			List subList;
			do {
				do {
					if (!arg1.hasNext()) {
						return subModuleList;
					}

					SecurityModule menu = (SecurityModule) arg1.next();
					subList = (List) this.repository.menuMap.get(menu.getMenucode());
				} while (subList == null);
			} while (subList.size() <= 0);

			Iterator arg4 = subList.iterator();

			while (arg4.hasNext()) {
				SecurityModule subMenu = (SecurityModule) arg4.next();
				if (this.isAllowed(subMenu)) {
					subModuleList.add(subMenu);
				}
			}
		}
	}

	private void buildMenuData(T menu, StringBuilder sb) {
		if (this.isAllowed(menu)) {
			sb.append("{");
			sb.append("\'id\':\'" + menu.getMenucode() + "\',");
			sb.append("\'text\':\'" + menu.getMenutitle() + "\',");
			String href = "";
			if (StringUtils.isNotBlank(menu.getModuleurl())) {
				if (menu.getModuleurl().startsWith("http://")) {
					href = menu.getModuleurl();
				} else {
					href = this.basePath + menu.getModuleurl().substring(1);
				}

				sb.append("\'href\':\'" + href + "\',");
			}

			if (StringUtils.isNotBlank(menu.getTarget())) {
				sb.append("\'target\':\'" + menu.getTarget() + "\',");
			}

			sb.append("\'isClass\':true,\'iconCls\':\'icon-cls\',\'cls\':\'cls\',\'leaf\':true");
			sb.append("},");
		}
	}

	private boolean isAllowed(T menu) {
		String menuRoles = menu.getRolenames();
		if (StringUtils.isBlank(menuRoles)) {
			return false;
		} else {
			String[] mroles = StringUtils.split(menuRoles, ",");

			for (int i = 0; i < mroles.length; ++i) {
				if (this.roles.contains(mroles[i])) {
					return true;
				}
			}

			return false;
		}
	}

	public Map<Map, List<Map>> getMenuTree() {
		LinkedHashMap menuMap = new LinkedHashMap();
		Iterator arg1 = this.repository.topMenuList.iterator();

		while (true) {
			SecurityModule menu;
			do {
				if (!arg1.hasNext()) {
					return menuMap;
				}

				menu = (SecurityModule) arg1.next();
			} while (!this.isAllowed(menu));

			List tmp = (List) this.repository.menuMap.get(menu.getMenucode());
			ArrayList subList = new ArrayList();
			if (tmp != null && tmp.size() > 0) {
				Iterator arg5 = tmp.iterator();

				while (arg5.hasNext()) {
					SecurityModule subMenu = (SecurityModule) arg5.next();
					if (this.isAllowed(subMenu)) {
						Map tmpMap = BeanUtil.getBeanMapWithKey(subMenu,
								new String[] { "menutitle", "target", "display" });
						String href = "";
						if (subMenu.getModuleurl().startsWith("http://")) {
							href = subMenu.getModuleurl();
						} else if (StringUtils.isNotBlank(subMenu.getModuleurl())) {
							href = this.basePath + subMenu.getModuleurl().substring(1);
						}

						tmpMap.put("href", href);
						subList.add(tmpMap);
					}
				}
			}

			menuMap.put(BeanUtil.getBeanMapWithKey(menu, new String[] { "menutitle", "target", "display" }), subList);
		}
	}

	public MenuRepository<T> getRepository() {
		return this.repository;
	}

	public void setRepository(MenuRepository repository) {
		this.repository = repository;
	}
}