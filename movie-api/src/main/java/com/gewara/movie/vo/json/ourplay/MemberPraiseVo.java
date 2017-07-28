/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.json.ourplay;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class MemberPraiseVo extends BaseVo {
	private static final long serialVersionUID = 7680984355389224217L;
	private String me_movieid;
	private Long memberid;
	private Long movieid;
	private Long walaid;
	private Timestamp ordertime;
	private Integer packetstatus;
	private Long playMovieId;
	private Timestamp createtime;
	private Timestamp updatetime;

	public MemberPraiseVo() {
	}

	public MemberPraiseVo(Long memberid, Long movieid, Long walaid) {
		this.memberid = memberid;
		this.movieid = movieid;
		this.walaid = walaid;
		this.me_movieid = spliceMeMovieid(memberid, movieid);
		this.packetstatus = Integer.valueOf(0);
		this.createtime = new Timestamp(System.currentTimeMillis());
		this.updatetime = new Timestamp(System.currentTimeMillis());
	}

	public Serializable realId() {
		return this.memberid + "_" + this.movieid;
	}

	public String getMe_movieid() {
		return this.me_movieid;
	}

	public void setMe_movieid(String me_movieid) {
		this.me_movieid = me_movieid;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public Long getWalaid() {
		return this.walaid;
	}

	public void setWalaid(Long walaid) {
		this.walaid = walaid;
	}

	public Integer getPacketstatus() {
		return this.packetstatus;
	}

	public void setPacketstatus(Integer packetstatus) {
		this.packetstatus = packetstatus;
	}

	public Timestamp getOrdertime() {
		return this.ordertime;
	}

	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
	}

	public static String spliceMeMovieid(Long memberid, Long movieid) {
		return memberid + "_" + movieid;
	}

	public Long getPlayMovieId() {
		return this.playMovieId;
	}

	public void setPlayMovieId(Long playMovieId) {
		this.playMovieId = playMovieId;
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
}