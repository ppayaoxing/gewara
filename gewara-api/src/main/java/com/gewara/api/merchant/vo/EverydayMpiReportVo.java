/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.merchant.vo;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class EverydayMpiReportVo extends BaseVo {
	private static final long serialVersionUID = -4481307586398663355L;
	private Date playDate;
	private int cinemaCount;
	private int mpiCinemaCount;
	private int mpiCount;
	private List<Map<String, Long>> movieMpiCount;
	private List<Map<String, Long>> goleMovieMpiCount;

	public EverydayMpiReportVo() {
	}

	public EverydayMpiReportVo(Date playDate, int cinemaCount, int mpiCinemaCount, int mpiCount,
			List<Map<String, Long>> movieMpiCount, List<Map<String, Long>> goleMovieMpiCount) {
		this.playDate = playDate;
		this.cinemaCount = cinemaCount;
		this.mpiCinemaCount = mpiCinemaCount;
		this.mpiCount = mpiCount;
		this.movieMpiCount = movieMpiCount;
		this.goleMovieMpiCount = goleMovieMpiCount;
	}

	public Date getPlayDate() {
		return this.playDate;
	}

	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}

	public int getCinemaCount() {
		return this.cinemaCount;
	}

	public void setCinemaCount(int cinemaCount) {
		this.cinemaCount = cinemaCount;
	}

	public int getMpiCinemaCount() {
		return this.mpiCinemaCount;
	}

	public void setMpiCinemaCount(int mpiCinemaCount) {
		this.mpiCinemaCount = mpiCinemaCount;
	}

	public int getMpiCount() {
		return this.mpiCount;
	}

	public void setMpiCount(int mpiCount) {
		this.mpiCount = mpiCount;
	}

	public List<Map<String, Long>> getMovieMpiCount() {
		return this.movieMpiCount;
	}

	public void setMovieMpiCount(List<Map<String, Long>> movieMpiCount) {
		this.movieMpiCount = movieMpiCount;
	}

	public List<Map<String, Long>> getGoleMovieMpiCount() {
		return this.goleMovieMpiCount;
	}

	public void setGoleMovieMpiCount(List<Map<String, Long>> goleMovieMpiCount) {
		this.goleMovieMpiCount = goleMovieMpiCount;
	}

	public Serializable realId() {
		return this.playDate;
	}
}