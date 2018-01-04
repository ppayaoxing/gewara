package com.gewara.ucenter.vo.sns;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class MovieGeneralmarkDetailVo extends BaseVo{
	private static final long serialVersionUID = -5015270045343038649L;
	private String name; //等级描述   如 9-10分
	private int value; //等级评分总数  例如 9-10分100个用户评 ，这里100就是value的值
	private long percent; //占比   例如：9-10分 所在的比例  20  就表示20%
	private int pointY; // 购票用户评分数  例如：9-10分里面购票的人数
	private int pointN; // 非购票用户评分总数 例如：9-10分里面非购票人数
	private long percenY; //购票用户评分占比
	private long percenN; //非购票用户评分占比
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public long getPercent() {
		return percent;
	}

	public void setPercent(long percent) {
		this.percent = percent;
	}

	public int getPointY() {
		return pointY;
	}

	public void setPointY(int pointY) {
		this.pointY = pointY;
	}

	public int getPointN() {
		return pointN;
	}

	public void setPointN(int pointN) {
		this.pointN = pointN;
	}

	public long getPercenY() {
		return percenY;
	}

	public void setPercenY(long percenY) {
		this.percenY = percenY;
	}

	public long getPercenN() {
		return percenN;
	}

	public void setPercenN(long percenN) {
		this.percenN = percenN;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public Serializable realId() {
		return name;
	}

}
