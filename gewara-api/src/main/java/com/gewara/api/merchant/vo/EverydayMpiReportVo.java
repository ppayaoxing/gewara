package com.gewara.api.merchant.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.BaseVo;
/**
 * 按天统计的场次
 * @author gang.liu
 *
 */
public class EverydayMpiReportVo extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4481307586398663355L;

	private Date playDate; //日期
	
	private int cinemaCount;//统计影院数： 格瓦拉 格瓦拉 系统直连计到的影院 总数，含不排片影院 
	
	private int mpiCinemaCount;// 排片影院数
	
	private int mpiCount; //总场次数
	
	private List<Map<String,Long>> movieMpiCount ;// 每部影片 每天的场次数 Map的key值 对应含义：movieId 电影id mpiCount：对应电影某天的排片数
	
	private List<Map<String,Long>> goleMovieMpiCount ;// 黄金时段每部影片 每天的场次数 Map的key值 对应含义：movieId 电影id mpiCount：对应电影某天的排片数
	
	public EverydayMpiReportVo(){}
	
	public EverydayMpiReportVo(Date playDate,int cinemaCount,int mpiCinemaCount,int mpiCount,
			List<Map<String,Long>> movieMpiCount,List<Map<String,Long>> goleMovieMpiCount){
		this.playDate = playDate;
		this.cinemaCount = cinemaCount;
		this.mpiCinemaCount = mpiCinemaCount;
		this.mpiCount = mpiCount;
		this.movieMpiCount = movieMpiCount;
		this.goleMovieMpiCount = goleMovieMpiCount;
	}
	
	public Date getPlayDate() {
		return playDate;
	}

	public void setPlayDate(Date playDate) {
		this.playDate = playDate;
	}

	public int getCinemaCount() {
		return cinemaCount;
	}

	public void setCinemaCount(int cinemaCount) {
		this.cinemaCount = cinemaCount;
	}

	public int getMpiCinemaCount() {
		return mpiCinemaCount;
	}

	public void setMpiCinemaCount(int mpiCinemaCount) {
		this.mpiCinemaCount = mpiCinemaCount;
	}

	public int getMpiCount() {
		return mpiCount;
	}

	public void setMpiCount(int mpiCount) {
		this.mpiCount = mpiCount;
	}

	public List<Map<String, Long>> getMovieMpiCount() {
		return movieMpiCount;
	}

	public void setMovieMpiCount(List<Map<String, Long>> movieMpiCount) {
		this.movieMpiCount = movieMpiCount;
	}

	public List<Map<String, Long>> getGoleMovieMpiCount() {
		return goleMovieMpiCount;
	}

	public void setGoleMovieMpiCount(List<Map<String, Long>> goleMovieMpiCount) {
		this.goleMovieMpiCount = goleMovieMpiCount;
	}

	@Override
	public Serializable realId() {
		return playDate;
	}

}
