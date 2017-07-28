/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class MovieVideoVo extends BaseVo {
	private static final long serialVersionUID = -4368832012742703607L;
	private Long movieid;
	private String videoid;
	private String img;
	private Timestamp addtime;

	public MovieVideoVo() {
	}

	public MovieVideoVo(Long movieid, String videoid) {
		this.movieid = movieid;
		this.videoid = videoid;
		this.addtime = new Timestamp(System.currentTimeMillis());
	}

	public Serializable realId() {
		return this.movieid;
	}

	public Long getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public String getVideoid() {
		return this.videoid;
	}

	public void setVideoid(String videoid) {
		this.videoid = videoid;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}