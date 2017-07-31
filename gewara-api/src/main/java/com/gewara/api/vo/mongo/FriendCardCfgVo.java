package com.gewara.api.vo.mongo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;
import com.gewara.util.ObjectId;

public class FriendCardCfgVo extends BaseVo{

	private String _id;
	private String title;				//券名称
	private Integer amount;				//优惠金额
	private String description;			//描述（使用范围）
	private Long sdid;					//特价活动id
	private String centerTitle;			//按钮文字
	private String centerSubtitle;		//按钮下面的文字
	private String abstractText;		//代金券详情下面的文字
	private String icon;				//代金券详情下面的文字下面的图片
	private String img;					//详情页面下的（图文介绍)
	private String imgText;				//详情页面（图片文字介绍）
	private String addtime;				//添加时间
	
	private String cardId;				//微信接口返回的card_id
	public FriendCardCfgVo(){
		set_id(ObjectId.uuid());
		this.addtime = DateUtil.getCurFullTimestampStr();
	}

	@Override
	public Serializable realId() {
		return _id;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSdid() {
		return sdid;
	}

	public void setSdid(Long sdid) {
		this.sdid = sdid;
	}

	public String getCenterTitle() {
		return centerTitle;
	}

	public void setCenterTitle(String centerTitle) {
		this.centerTitle = centerTitle;
	}

	public String getCenterSubtitle() {
		return centerSubtitle;
	}

	public void setCenterSubtitle(String centerSubtitle) {
		this.centerSubtitle = centerSubtitle;
	}

	public String getAbstractText() {
		return abstractText;
	}

	public void setAbstractText(String abstractText) {
		this.abstractText = abstractText;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImgText() {
		return imgText;
	}

	public void setImgText(String imgText) {
		this.imgText = imgText;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

}
