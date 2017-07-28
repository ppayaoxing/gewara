/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.entity;

import com.gewara.gmessage.external.constant.MCategory;
import com.gewara.gmessage.external.constant.MType;
import java.io.Serializable;

public abstract class MessageBaseInfo implements Serializable {
	private static final long serialVersionUID = -8305456371926741367L;
	private String title;
	private String content;
	private String releaseURL;
	private String releaseID;
	private String releaseIDType;
	private String releaseExt;
	private String tag;
	private MCategory category;
	private MType type;
	private String optType;

	public MessageBaseInfo() {
		this.title = null;
		this.content = null;
		this.releaseURL = null;
		this.releaseID = null;
		this.releaseIDType = null;
		this.releaseExt = null;

		this.tag = null;
		this.category = null;
		this.type = null;
		this.optType = null;
	}

	public String getTitle() {
		return this.title;
	}

	public String getContent() {
		return this.content;
	}

	public String getReleaseURL() {
		return this.releaseURL;
	}

	public String getReleaseID() {
		return this.releaseID;
	}

	public String getReleaseIDType() {
		return this.releaseIDType;
	}

	public String getTag() {
		return this.tag;
	}

	public MCategory getCategory() {
		return this.category;
	}

	public MType getType() {
		return this.type;
	}

	public String getOptType() {
		return this.optType;
	}

	public String getReleaseExt() {
		return this.releaseExt;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setReleaseURL(String releaseURL) {
		this.releaseURL = releaseURL;
	}

	public void setReleaseID(String releaseID, String releaseIDType) {
		this.releaseID = releaseID;
		this.releaseIDType = releaseIDType;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setCategory(MCategory category, MType type) {
		this.category = category;
		this.type = type;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	public void setReleaseExt(String releaseExt) {
		this.releaseExt = releaseExt;
	}

	public void copyValue(MessageBaseInfo mbi) {
		this.title = mbi.getTitle();
		this.content = mbi.getContent();
		this.releaseURL = mbi.getReleaseURL();
		this.releaseID = mbi.getReleaseID();
		this.releaseIDType = mbi.getReleaseIDType();
		this.releaseExt = mbi.getReleaseExt();

		this.tag = mbi.getTag();
		this.category = mbi.getCategory();
		this.type = mbi.getType();
		this.optType = mbi.getOptType();
	}
}