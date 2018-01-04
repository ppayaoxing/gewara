package com.gewara.model;

import java.io.Serializable;
import java.util.List;
/**
 * 用户观影信息
 * 
 * @author jeremylei
 * @date 2016/04/15
 */
public class MemberViewInfo  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3363180767294549933L;
	private Long movieid; // 电影id
	private Long cinemaid; // 影院id
	private Long playtime; // 放映时间
	private Integer viewcounts; // 该电影观影次数
	private List<Long> othermembers; // 同场次观影用户id列表

	public Long getMovieid() {
		return movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public Long getCinemaid() {
		return cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public Long getPlaytime() {
		return playtime;
	}

	public void setPlaytime(Long playtime) {
		this.playtime = playtime;
	}

	public Integer getViewcounts() {
		return viewcounts;
	}

	public void setViewcounts(Integer viewcounts) {
		this.viewcounts = viewcounts;
	}

	public List<Long> getOthermembers() {
		return othermembers;
	}

	public void setOthermembers(List<Long> othermembers) {
		this.othermembers = othermembers;
	}
}
