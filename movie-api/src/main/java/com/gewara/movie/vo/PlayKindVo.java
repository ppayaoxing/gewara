/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class PlayKindVo extends BaseVo {
	private static final long serialVersionUID = -5154633937499593360L;
	private Long id;
	private String kindName;
	private Integer orderNumber;
	private Timestamp addtime;
	private Timestamp updatetime;
	private Integer status;
	private String isCur;
	private String belongToKind;
	private String belongToKindPattern;
	private String isRecommend;

	public String getIsRecommend() {
		return this.isRecommend;
	}

	public void setIsRecommend(String isRecommend) {
		this.isRecommend = isRecommend;
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

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIsCur() {
		return this.isCur;
	}

	public void setIsCur(String isCur) {
		this.isCur = isCur;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getBelongToKind() {
		return this.belongToKind;
	}

	public void setBelongToKind(String belongToKind) {
		this.belongToKind = belongToKind;
	}

	public String getBelongToKindPattern() {
		return this.belongToKindPattern;
	}

	public void setBelongToKindPattern(String belongToKindPattern) {
		this.belongToKindPattern = belongToKindPattern;
	}
}