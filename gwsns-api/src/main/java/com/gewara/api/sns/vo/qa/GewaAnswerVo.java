/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.qa;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class GewaAnswerVo extends BaseVo {
	private static final long serialVersionUID = 5578727148166770087L;
	public static final Integer SEND_QUESTION_POINT = Integer.valueOf(10);
	public static final String AS_STATUS_N = "N";
	public static final String AS_STATUS_Y = "Y";
	private Long id;
	private Long questionid;
	private Long memberid;
	private String content;
	private Integer hotvalue;
	private String answerstatus;
	private String status;
	private Timestamp addtime;
	private String ip;

	public GewaAnswerVo() {
	}

	public GewaAnswerVo(String content) {
		this.content = content;
		this.hotvalue = Integer.valueOf(0);
		this.answerstatus = "N";
		this.status = "Y_NEW";
		this.addtime = new Timestamp(System.currentTimeMillis());
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuestionid() {
		return this.questionid;
	}

	public void setQuestionid(Long questionid) {
		this.questionid = questionid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getHotvalue() {
		return this.hotvalue;
	}

	public void setHotvalue(Integer hotvalue) {
		this.hotvalue = hotvalue;
	}

	public String getAnswerstatus() {
		return this.answerstatus;
	}

	public void setAnswerstatus(String answerstatus) {
		this.answerstatus = answerstatus;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}