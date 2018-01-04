package com.gewara.api.sns.vo.guess;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

/**
 * 
 * 猜票房用户投注(MongoDB)  
 *
 */
public class UserBettingVo extends BaseVo{
	private static final long serialVersionUID = 6888798581179944197L;
	private Long memberid; //用户ID
	private Long stepid; //设置ID
	private Long optionid; //投注选项ID
	private Integer num;//投注份数
	private Integer point;//投注总积分
	private Timestamp addtime;//投注时间
	private Timestamp rewardtime;//发放奖励时间
	private Integer reward; //总奖励积分

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getRewardtime() {
		return rewardtime;
	}

	public void setRewardtime(Timestamp rewardtime) {
		this.rewardtime = rewardtime;
	}

	public Integer getReward() {
		return reward;
	}

	public void setReward(Integer reward) {
		this.reward = reward;
	}

	public Long getStepid() {
		return stepid;
	}

	public void setStepid(Long stepid) {
		this.stepid = stepid;
	}

	public Long getOptionid() {
		return optionid;
	}

	public void setOptionid(Long optionid) {
		this.optionid = optionid;
	}

	@Override
	public Serializable realId() {
		return memberid+""+stepid+""+optionid;
	}
}
