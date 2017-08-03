package com.gewara.movie.vo.json.ourplay;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class CompensateLogVo extends BaseVo{
	private static final long serialVersionUID = 2195904002958496947L;
	private String compensateLogId;//CompensateLog的主键 =memberid+"_"+playMovieId
	private Long memberid;//用户ID
	private String nickname;//用户别名
	private Long commentid;//哇啦ID
	private Long playMovieId;//PlayMovie的主键ID
	private String kind;//打赏(reward)/补偿(compensate)
	private Integer generalmark;//评分
	private Integer isCompensated;//是否补偿过
	private Timestamp createtime;//添加时间
	private Timestamp updatetime;//修改时间
	public Long getMemberid() {
		return memberid;
	}
	
	public CompensateLogVo() {
		super();
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public Long getCommentid() {
		return commentid;
	}
	public void setCommentid(Long commentid) {
		this.commentid = commentid;
	}
	public Long getPlayMovieId() {
		return playMovieId;
	}

	public void setPlayMovieId(Long playMovieId) {
		this.playMovieId = playMovieId;
	}

	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Integer getIsCompensated() {
		return isCompensated;
	}
	public void setIsCompensated(Integer isCompensated) {
		this.isCompensated = isCompensated;
	}
	public Integer getGeneralmark() {
		return generalmark;
	}
	public void setGeneralmark(Integer generalmark) {
		this.generalmark = generalmark;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	
	@Override
	public Serializable realId() {
		return commentid;
	}

	public String getCompensateLogId() {
		return compensateLogId;
	}

	public void setCompensateLogId(String compensateLogId) {
		this.compensateLogId = compensateLogId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



}
