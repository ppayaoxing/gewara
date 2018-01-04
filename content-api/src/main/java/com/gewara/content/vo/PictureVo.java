package com.gewara.content.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-10-9上午08:57:47
 */
public class PictureVo extends BaseVo{
	private static final long serialVersionUID = 4914995483381697551L;
	private Long id;
	private String tag;			//类型标签
	private Long relatedid;		//相关Id
	private String picturename;	//图片名称
	private String description;	//描述
	private String category;		
	private Long categoryid;	
	private String name;
	private Timestamp posttime;//发布时间
	private Long memberid;//专区用户名
	private String memberType;
	private Integer clickedtimes;

	private Integer picwidth;
	private Integer picheight;
	private String pictureUrl;
	
	@Override
	public Serializable realId() {
		return id;
	}
	public Integer getClickedtimes() {
		return clickedtimes;
	}
	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}
	public Long getMemberid() {
	return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public PictureVo() {}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getPicturename() {
		return picturename;
	}

	public void setPicturename(String picturename) {
		this.picturename = picturename;
	}
	public Long getRelatedid() {
		return relatedid;
	}
	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}
	public String getLogo(){
		return this.picturename;
	}
	public String getLimg() {
		return picturename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getPosttime() {
		return posttime;
	}
	public void setPosttime(Timestamp posttime) {
		this.posttime = posttime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	
	public boolean hasMemberType(String type){
		return StringUtils.equals(this.memberType, type);
	}
	public Integer getPicwidth() {
		return picwidth;
	}
	public void setPicwidth(Integer picwidth) {
		this.picwidth = picwidth;
	}
	public Integer getPicheight() {
		return picheight;
	}
	public void setPicheight(Integer picheight) {
		this.picheight = picheight;
	}
	public Long getPictureid(){
		return id;
	}
	public Integer getPicw(){
		return picwidth;
	}
	public Integer getPich(){
		return picheight;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
}
