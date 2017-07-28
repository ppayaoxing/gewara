/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.sns;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class MovieGeneralmarkDetailVo extends BaseVo {
	private static final long serialVersionUID = -5015270045343038649L;
	private String name;
	private int value;
	private long percent;
	private int pointY;
	private int pointN;
	private long percenY;
	private long percenN;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public long getPercent() {
		return this.percent;
	}

	public void setPercent(long percent) {
		this.percent = percent;
	}

	public int getPointY() {
		return this.pointY;
	}

	public void setPointY(int pointY) {
		this.pointY = pointY;
	}

	public int getPointN() {
		return this.pointN;
	}

	public void setPointN(int pointN) {
		this.pointN = pointN;
	}

	public long getPercenY() {
		return this.percenY;
	}

	public void setPercenY(long percenY) {
		this.percenY = percenY;
	}

	public long getPercenN() {
		return this.percenN;
	}

	public void setPercenN(long percenN) {
		this.percenN = percenN;
	}

	public static long getSerialversionuid() {
		return -5015270045343038649L;
	}

	public Serializable realId() {
		return this.name;
	}
}