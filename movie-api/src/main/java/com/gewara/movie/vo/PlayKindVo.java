package com.gewara.movie.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class PlayKindVo extends BaseVo {
	private static final long serialVersionUID = -5154633937499593360L;
	private Long id; //唯一标示
	private String kindName; //放映类别名称
	private Integer orderNumber; //排序序号
	private Timestamp addtime; //添加时间
	private Timestamp updatetime;	//修改时间 
	private Integer status; //是否删除 1=删除 0=未删除
	private String isCur; //是否是当期 y=是  n=否
	private String belongToKind;//属于哪个类别 新商业or新经典 现在的值有 newBusiness newClassics;
	private String belongToKindPattern;//属于新经典什么模式,例如 单片模式(singular)，展映模式()
	private String isRecommend;//是否推荐y=是  n=否
	public String getIsRecommend() {
		return isRecommend;
	}
	public void setIsRecommend(String isRecommend) {
		this.isRecommend = isRecommend;
	}
	public PlayKindVo(){}
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIsCur() {
		return isCur;
	}

	public void setIsCur(String isCur) {
		this.isCur = isCur;
	}

	@Override
	public Serializable realId() {
		return id;
	}
	public String getBelongToKind() {
		return belongToKind;
	}
	public void setBelongToKind(String belongToKind) {
		this.belongToKind = belongToKind;
	}
	public String getBelongToKindPattern() {
		return belongToKindPattern;
	}
	public void setBelongToKindPattern(String belongToKindPattern) {
		this.belongToKindPattern = belongToKindPattern;
	}
	

}
