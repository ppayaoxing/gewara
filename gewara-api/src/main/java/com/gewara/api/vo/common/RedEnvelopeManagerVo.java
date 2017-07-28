/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.common;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class RedEnvelopeManagerVo extends BaseVo {
	private static final long serialVersionUID = 5486510291048700966L;
	private String starttime;
	private String endtime;
	private String logo;
	private String title;
	private String url;
	private String valid;
	private String shareTitle;
	private String shareContent;
	private String sharePic;
	private String dialogTitle;
	private String dialogContent;

	public Serializable realId() {
		return this.url;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getShareTitle() {
		return this.shareTitle;
	}

	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}

	public String getShareContent() {
		return this.shareContent;
	}

	public void setShareContent(String shareContent) {
		this.shareContent = shareContent;
	}

	public String getSharePic() {
		return this.sharePic;
	}

	public void setSharePic(String sharePic) {
		this.sharePic = sharePic;
	}

	public String getDialogTitle() {
		return this.dialogTitle;
	}

	public void setDialogTitle(String dialogTitle) {
		this.dialogTitle = dialogTitle;
	}

	public String getDialogContent() {
		return this.dialogContent;
	}

	public void setDialogContent(String dialogContent) {
		this.dialogContent = dialogContent;
	}
}