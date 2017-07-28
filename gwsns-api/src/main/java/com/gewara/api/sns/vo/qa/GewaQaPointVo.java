/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.qa;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class GewaQaPointVo extends BaseVo {
	private static final long serialVersionUID = 8512385224617282034L;
	public static String TAG_SENDQUESTION = "sendquestion";
	public static String TAG_BESTANSWER = "bestanswer";
	public static String TAG_REPLYQUESTION = "replyquestion";
	private Long id;
	private Long questionid;
	private Long answerid;
	private Long memberid;
	private Integer point;
	private Timestamp addtime;
	private String tag;

	public GewaQaPointVo() {
	}

	public GewaQaPointVo(Long questionid, Long answerid, Long memberid, Integer point, String tag) {
		this.questionid = questionid;
		this.answerid = answerid;
		this.memberid = memberid;
		this.point = point;
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.tag = tag;
	}

	public GewaQaPointVo(Long questionid, Long memberid, Integer point, String tag) {
		this.questionid = questionid;
		this.memberid = memberid;
		this.point = point;
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.tag = tag;
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

	public Long getAnswerid() {
		return this.answerid;
	}

	public void setAnswerid(Long answerid) {
		this.answerid = answerid;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
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

	public Long getQuestionid() {
		return this.questionid;
	}

	public void setQuestionid(Long questionid) {
		this.questionid = questionid;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}