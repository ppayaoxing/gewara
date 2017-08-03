package com.gewara.movie.vo.star;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class CastPictureVo extends BaseVo {
	private static final long serialVersionUID = -100677988174265653L;
	private Long id;
	private Long castid; // 人物ID
	private String picname; // 图片名
	private String picurl; // 图片路径
	private String piccategory; // 图片分类
	private Timestamp addtime; // 新增时间
	private Timestamp updatetime; // 更新时间
	private Integer picwidth;
	private Integer picheight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCastid() {
		return castid;
	}

	public void setCastid(Long castid) {
		this.castid = castid;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public String getPiccategory() {
		return piccategory;
	}

	public void setPiccategory(String piccategory) {
		this.piccategory = piccategory;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	@Override
	public Serializable realId() {
		return id;
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


}
