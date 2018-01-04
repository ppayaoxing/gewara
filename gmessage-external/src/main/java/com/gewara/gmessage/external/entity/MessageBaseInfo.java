package com.gewara.gmessage.external.entity;

import java.io.Serializable;

import com.gewara.gmessage.external.constant.MCategory;
import com.gewara.gmessage.external.constant.MType;

public abstract class MessageBaseInfo implements Serializable{
	private static final long serialVersionUID = -8305456371926741367L;
	private String title=null;
	private String content=null;
	private String releaseURL=null;
	private String releaseID=null;
	private String releaseIDType=null;
	private String releaseExt=null;
	
	private String tag=null; 
	private MCategory category=null;
	private MType type=null;
	private String optType=null;
	
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getReleaseURL() {
		return releaseURL;
	}
	public String getReleaseID() {
		return releaseID;
	}
	public String getReleaseIDType() {
		return releaseIDType;
	}
	public String getTag() {
		return tag;
	}
	
	public MCategory getCategory() {
		return category;
	}
	
	public MType getType() {
		return type;
	}
	
	public String getOptType() {
		return optType;
	}
	public String getReleaseExt() {
		return releaseExt;
	}
	
	/**
	 * 消息标题，非必须
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 消息内容，必须
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 消息相关的URL, 非必须
	 * @param releaseURL
	 */
	public void setReleaseURL(String releaseURL) {
		this.releaseURL = releaseURL;
	}
	
	/**
	 * 和消息相关的目标ID,配合releaseIDType使用，二者必须同时填写，非必填字段
	 * @param releaseID
	 */
	public void setReleaseID(String releaseID,String releaseIDType) {
		this.releaseID = releaseID;
		this.releaseIDType = releaseIDType;
	}
	
	/**
	 * 消息标签，主要是留给业务系统实现自己的业务使用。 非必须
	 * 针对tag设置了 [GM.WALA.MERGE]的消息，如果其realeaseID，type相同的话，进行合并处理
	 * （仅仅保留最早一条记录，但发送人信息添加至其中。仅仅合并两次查询之间的）（开始是只合并哇啦，目前已经泛指了）。
	 * 
	 * 
	 * @param tag
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * 消息种类以及消息类型。必须
	 * @param category
	 */
	public void setCategory(MCategory category,MType type) {
		this.category = category;
		this.type=type;
	}
	
	/**
	 * 这个字段用来表明，该消息是由什么行为触发的，必须填写
	 * @return
	 */
	public void setOptType(String optType) {
		this.optType=optType;
	}
	
	/**
	 * 这个字段用来记录和该消息相关的扩展信息。 非必须
	 * 如需发送特定信息只push系统，则改字段的格式必须如下
	 * {push:{}}或者{push:[]}。 json格式，必须有push这个字段，其值和格式根据业务要求自定义。
	 * @param releaseExt
	 */
	public void setReleaseExt(String releaseExt) {
		this.releaseExt = releaseExt;
	}
	
	public void copyValue(MessageBaseInfo mbi){
		  this.title=mbi.getTitle();
		  this.content=mbi.getContent();
		  this.releaseURL=mbi.getReleaseURL();
		  this.releaseID=mbi.getReleaseID();
		  this.releaseIDType=mbi.getReleaseIDType();
		  this.releaseExt=mbi.getReleaseExt();
		
		  this.tag=mbi.getTag(); 
		  this.category=mbi.getCategory();
		  this.type=mbi.getType();
		  this.optType=mbi.getOptType();
	}
}
