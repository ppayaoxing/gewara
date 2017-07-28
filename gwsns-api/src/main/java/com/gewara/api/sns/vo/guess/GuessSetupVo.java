/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.guess;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class GuessSetupVo extends BaseVo {
	private static final long serialVersionUID = -6238251192248125698L;
	private Long id;
	private Integer consumepoint;
	private Integer multiple;
	private Timestamp starttime;
	private Timestamp endtime;
	private Timestamp addtime;
	private String status;
	private Long winid;
	private String winPic;
	private String bgPic;
	private Long memberid;
	private String title;
	private String body;
	private Long movieid;
	private String cover;
	private String process;
	private String shareTitle;
	private String shareBody;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getConsumepoint() {
		return this.consumepoint;
	}

	public void setConsumepoint(Integer consumepoint) {
		this.consumepoint = consumepoint;
	}

	public Integer getMultiple() {
		return this.multiple;
	}

	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getWinid() {
		return this.winid;
	}

	public void setWinid(Long winid) {
		this.winid = winid;
	}

	public String getWinPic() {
		return this.winPic;
	}

	public void setWinPic(String winPic) {
		this.winPic = winPic;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getProcess() {
		return this.process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public String getBgPic() {
		return this.bgPic;
	}

	public void setBgPic(String bgPic) {
		this.bgPic = bgPic;
	}

	public String getShareTitle() {
		return this.shareTitle;
	}

	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}

	public String getShareBody() {
		return this.shareBody;
	}

	public void setShareBody(String shareBody) {
		this.shareBody = shareBody;
	}
}