/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.model.acl;

import com.gewara.model.BaseObject;
import com.gewara.web.support.SecurityModule;
import java.io.Serializable;
import org.apache.commons.lang.StringUtils;

public class WebModule extends BaseObject implements SecurityModule {
	public static final String TAG_GEWA = "G";
	public static final String TAG_PARTNER = "GP";
	public static final String TAG_API = "A";
	private static final long serialVersionUID = -7871445315999186011L;
	private Long id;
	private String moduleurl;
	private Integer matchorder;
	private String menucode;
	private String menutitle;
	private String target;
	private String display;
	private String tag;
	private String rolenames;
	private boolean top;

	public Integer getMatchorder() {
		return this.matchorder;
	}

	public void setMatchorder(Integer matchorder) {
		this.matchorder = matchorder;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getModuleurl() {
		return this.moduleurl;
	}

	public void setModuleurl(String moduleurl) {
		this.moduleurl = moduleurl;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenucode() {
		return this.menucode;
	}

	public void setMenucode(String menucode) {
		this.menucode = menucode;
	}

	public String getMenutitle() {
		return this.menutitle;
	}

	public void setMenutitle(String menutitle) {
		this.menutitle = menutitle;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getDisplay() {
		return this.display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public boolean isTop() {
		return this.top ? this.top : StringUtils.length(this.menucode) == 2;
	}

	public String getParentcode() {
		return StringUtils.substring(this.menucode, 0, 2);
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTopMenucode() {
		return StringUtils.isNotBlank(this.menucode) && this.menucode.length() == 4 ? this.menucode.substring(0, 2)
				: null;
	}

	public String getRolenames() {
		return this.rolenames;
	}

	public void setRolenames(String rolenames) {
		this.rolenames = rolenames;
	}

	public void setTop(boolean top) {
		this.top = top;
	}
}