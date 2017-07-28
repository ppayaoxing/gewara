/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.guess;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class UserBettingVo extends BaseVo {
	private static final long serialVersionUID = 6888798581179944197L;
	private Long memberid;
	private Long stepid;
	private Long optionid;
	private Integer num;
	private Integer point;
	private Timestamp addtime;
	private Timestamp rewardtime;
	private Integer reward;

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getRewardtime() {
		return this.rewardtime;
	}

	public void setRewardtime(Timestamp rewardtime) {
		this.rewardtime = rewardtime;
	}

	public Integer getReward() {
		return this.reward;
	}

	public void setReward(Integer reward) {
		this.reward = reward;
	}

	public Long getStepid() {
		return this.stepid;
	}

	public void setStepid(Long stepid) {
		this.stepid = stepid;
	}

	public Long getOptionid() {
		return this.optionid;
	}

	public void setOptionid(Long optionid) {
		this.optionid = optionid;
	}

	public Serializable realId() {
		return this.memberid + "" + this.stepid + "" + this.optionid;
	}
}