package com.gewara.movie.vo.json.ourplay;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;


public class NiuRenRankingVo extends BaseVo {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7497905842878021840L;
	private Long memberid;
	private Integer ranking;//牛人总榜排名
	private Timestamp addtime;
	private  Integer point;//牛人分数
	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return memberid;
	}
}
