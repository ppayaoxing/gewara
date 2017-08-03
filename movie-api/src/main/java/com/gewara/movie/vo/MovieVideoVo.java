package com.gewara.movie.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class MovieVideoVo extends BaseVo {
	private static final long serialVersionUID = -4368832012742703607L;
	private Long movieid;
	private String videoid;
	private String img;
	private Timestamp addtime;
	
	public MovieVideoVo() {}
	
	public MovieVideoVo(Long movieid, String videoid){
		this.movieid = movieid;
		this.videoid = videoid;
		this.addtime = new Timestamp(System.currentTimeMillis());
	}

	@Override
	public Serializable realId() {
		return movieid;
	}
	
	public Long getMovieid() {
		return movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public String getVideoid() {
		return videoid;
	}

	public void setVideoid(String videoid) {
		this.videoid = videoid;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
