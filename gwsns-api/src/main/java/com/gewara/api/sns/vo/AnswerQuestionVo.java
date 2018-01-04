package com.gewara.api.sns.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class AnswerQuestionVo extends BaseVo{
	private Long id;
	private String quesion; //问题
	private String title;   //头图
	private String answer1; //选项1
	private String answer2; //选项2
	private String answer3; //选项3
	private String answer4; //选项4
	private String realAnswer; //正确选项
	private String relatedid;  //关联主题
	private Integer rightNum;  //总答对人数
	private Integer total;     //总答题人数  
	private String updateTime; //时间
	private Integer answer1Num; //选项1答题人数
	private Integer answer2Num; //选项2答题人数
	private Integer answer3Num; //选项3答题人数
	private Integer answer4Num; //选项4答题人数
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuesion() {
		return quesion;
	}
	public void setQuesion(String quesion) {
		this.quesion = quesion;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	public String getRealAnswer() {
		return realAnswer;
	}
	public void setRealAnswer(String realAnswer) {
		this.realAnswer = realAnswer;
	}
	public String getRelatedid() {
		return relatedid;
	}
	public void setRelatedid(String relatedid) {
		this.relatedid = relatedid;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public Integer getRightNum() {
		return rightNum;
	}
	public void setRightNum(Integer rightNum) {
		this.rightNum = rightNum;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getAnswer1Num() {
		return answer1Num;
	}
	public void setAnswer1Num(Integer answer1Num) {
		this.answer1Num = answer1Num;
	}
	public Integer getAnswer2Num() {
		return answer2Num;
	}
	public void setAnswer2Num(Integer answer2Num) {
		this.answer2Num = answer2Num;
	}
	public Integer getAnswer3Num() {
		return answer3Num;
	}
	public void setAnswer3Num(Integer answer3Num) {
		this.answer3Num = answer3Num;
	}
	public Integer getAnswer4Num() {
		return answer4Num;
	}
	public void setAnswer4Num(Integer answer4Num) {
		this.answer4Num = answer4Num;
	}
}
