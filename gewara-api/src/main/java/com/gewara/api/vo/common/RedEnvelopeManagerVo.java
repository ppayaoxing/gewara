package com.gewara.api.vo.common;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;


public class RedEnvelopeManagerVo extends BaseVo {
	
	private static final long serialVersionUID = 5486510291048700966L;

	@Override
	public Serializable realId() {
		return url;
	}
	//红包开始时间
	private String starttime;
	//红包结束时间
	private String endtime;
	//红包图片
	private String logo;
	//红包标题
	private String title;
	//红包url
	private String url;
	//是否能生成红包 Y:可以生成红包 N:表示不能生成红包 
	private String valid;
	//分享标题
	private String shareTitle;
	//分享内容
	private String shareContent;
	//分享图片
	private String sharePic;
	//弹窗标题
	private String dialogTitle;
	//弹窗内容
	private String dialogContent;
	
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public String getShareTitle() {
		return shareTitle;
	}
	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}
	public String getShareContent() {
		return shareContent;
	}
	public void setShareContent(String shareContent) {
		this.shareContent = shareContent;
	}
	public String getSharePic() {
		return sharePic;
	}
	
	public void setSharePic(String sharePic) {
		this.sharePic = sharePic;
	}
	
	public String getDialogTitle() {
		return dialogTitle;
	}
	
	public void setDialogTitle(String dialogTitle) {
		this.dialogTitle = dialogTitle;
	}
	
	public String getDialogContent() {
		return dialogContent;
	}
	
	public void setDialogContent(String dialogContent) {
		this.dialogContent = dialogContent;
	}
	
}
