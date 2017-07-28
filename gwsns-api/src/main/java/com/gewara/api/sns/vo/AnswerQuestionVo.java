/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class AnswerQuestionVo extends BaseVo {
	private Long id;
	private String quesion;
	private String title;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String realAnswer;
	private String relatedid;
	private Integer rightNum;
	private Integer total;
	private String updateTime;
	private Integer answer1Num;
	private Integer answer2Num;
	private Integer answer3Num;
	private Integer answer4Num;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuesion() {
		return this.quesion;
	}

	public void setQuesion(String quesion) {
		this.quesion = quesion;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAnswer1() {
		return this.answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return this.answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return this.answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return this.answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getRealAnswer() {
		return this.realAnswer;
	}

	public void setRealAnswer(String realAnswer) {
		this.realAnswer = realAnswer;
	}

	public String getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(String relatedid) {
		this.relatedid = relatedid;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Serializable realId() {
		return this.id;
	}

	public Integer getRightNum() {
		return this.rightNum;
	}

	public void setRightNum(Integer rightNum) {
		this.rightNum = rightNum;
	}

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getAnswer1Num() {
		return this.answer1Num;
	}

	public void setAnswer1Num(Integer answer1Num) {
		this.answer1Num = answer1Num;
	}

	public Integer getAnswer2Num() {
		return this.answer2Num;
	}

	public void setAnswer2Num(Integer answer2Num) {
		this.answer2Num = answer2Num;
	}

	public Integer getAnswer3Num() {
		return this.answer3Num;
	}

	public void setAnswer3Num(Integer answer3Num) {
		this.answer3Num = answer3Num;
	}

	public Integer getAnswer4Num() {
		return this.answer4Num;
	}

	public void setAnswer4Num(Integer answer4Num) {
		this.answer4Num = answer4Num;
	}
}