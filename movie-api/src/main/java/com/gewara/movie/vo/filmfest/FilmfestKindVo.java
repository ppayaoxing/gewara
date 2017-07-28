/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.filmfest;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class FilmfestKindVo extends BaseVo {
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
	private String iconName;
	private String kindType;
	private Long memberid;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKindName() {
		return this.kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public Integer getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getIsDel() {
		return this.isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKindCode() {
		return this.kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public String getPicturePc() {
		return this.picturePc;
	}

	public void setPicturePc(String picturePc) {
		this.picturePc = picturePc;
	}

	public String getPictureH5() {
		return this.pictureH5;
	}

	public void setPictureH5(String pictureH5) {
		this.pictureH5 = pictureH5;
	}

	public Long getBelongToId() {
		return this.belongToId;
	}

	public void setBelongToId(Long belongToId) {
		this.belongToId = belongToId;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconName() {
		return this.iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public String getKindType() {
		return this.kindType;
	}

	public void setKindType(String kindType) {
		this.kindType = kindType;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
}