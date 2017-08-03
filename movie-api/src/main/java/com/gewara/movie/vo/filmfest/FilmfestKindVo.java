package com.gewara.movie.vo.filmfest;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class FilmfestKindVo extends BaseVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6810449133584792962L;
	private Long id;
	private String kindName;
	private Integer orderNumber;
	private Integer isDel;
	private Long parentId;
	private String picturePc;
	private String pictureH5;
	private String description;
	private String kindCode;
	private Long belongToId;
	private String icon;
	private String iconName; //小图标名称
	private String kindType; //片单类型，G：格瓦片单，U：用户片单，只针对片单模块有效
	private Long memberid; //当是用户片单时，用户ID
	@Override
	public Serializable realId() {
		return id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getKindCode() {
		return kindCode;
	}
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	public String getPicturePc() {
		return picturePc;
	}
	public void setPicturePc(String picturePc) {
		this.picturePc = picturePc;
	}
	public String getPictureH5() {
		return pictureH5;
	}
	public void setPictureH5(String pictureH5) {
		this.pictureH5 = pictureH5;
	}
	public Long getBelongToId() {
		return belongToId;
	}
	public void setBelongToId(Long belongToId) {
		this.belongToId = belongToId;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	public String getKindType() {
		return kindType;
	}
	public void setKindType(String kindType) {
		this.kindType = kindType;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	
	

}
