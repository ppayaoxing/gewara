/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.json.ourplay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class CompensateLogVo extends BaseVo {
	private static final long serialVersionUID = 2195904002958496947L;
	private String compensateLogId;
	private Long memberid;
	private String nickname;
	private Long commentid;
	private Long playMovieId;
	private String kind;
	private Integer generalmark;
	private Integer isCompensated;
	private Timestamp createtime;
	private Timestamp updatetime;

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getCommentid() {
		return this.commentid;
	}

	public void setCommentid(Long commentid) {
		this.commentid = commentid;
	}

	public Long getPlayMovieId() {
		return this.playMovieId;
	}

	public void setPlayMovieId(Long playMovieId) {
		this.playMovieId = playMovieId;
	}

	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Integer getIsCompensated() {
		return this.isCompensated;
	}

	public void setIsCompensated(Integer isCompensated) {
		this.isCompensated = isCompensated;
	}

	public Integer getGeneralmark() {
		return this.generalmark;
	}

	public void setGeneralmark(Integer generalmark) {
		this.generalmark = generalmark;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Serializable realId() {
		return this.commentid;
	}

	public String getCompensateLogId() {
		return this.compensateLogId;
	}

	public void setCompensateLogId(String compensateLogId) {
		this.compensateLogId = compensateLogId;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}