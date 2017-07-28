/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.mongo;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import com.gewara.util.ObjectId;
import java.io.Serializable;

public class FriendCardCfgVo extends BaseVo {
	private String _id;
	private String title;
	private Integer amount;
	private String description;
	private Long sdid;
	private String centerTitle;
	private String centerSubtitle;
	private String abstractText;
	private String icon;
	private String img;
	private String imgText;
	private String addtime;
	private String cardId;

	public FriendCardCfgVo() {
		this.set_id(ObjectId.uuid());
		this.addtime = DateUtil.getCurFullTimestampStr();
	}

	public Serializable realId() {
		return this._id;
	}

	public String get_id() {
		return this._id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSdid() {
		return this.sdid;
	}

	public void setSdid(Long sdid) {
		this.sdid = sdid;
	}

	public String getCenterTitle() {
		return this.centerTitle;
	}

	public void setCenterTitle(String centerTitle) {
		this.centerTitle = centerTitle;
	}

	public String getCenterSubtitle() {
		return this.centerSubtitle;
	}

	public void setCenterSubtitle(String centerSubtitle) {
		this.centerSubtitle = centerSubtitle;
	}

	public String getAbstractText() {
		return this.abstractText;
	}

	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImgText() {
		return this.imgText;
	}

	public void setImgText(String imgText) {
		this.imgText = imgText;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
}