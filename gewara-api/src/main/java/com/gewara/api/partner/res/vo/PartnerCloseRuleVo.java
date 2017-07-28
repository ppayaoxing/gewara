/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.res.vo;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.BeanUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class PartnerCloseRuleVo extends BaseVo {
	private static final long serialVersionUID = -376659304790226970L;
	public static final String RULETYPE_OPI = "opi";
	public static final String RULETYPE_MOVIE = "movie";
	public static final String RULETYPE_CINEMA = "cinema";
	public static final String MATCH_INCLUDE = "include";
	public static final String MATCH_EXCLUDE = "exclude";
	private Long id;
	private String ruletype;
	private String partnerids;
	private String pmatch;
	private Timestamp opentime1;
	private Timestamp opentime2;
	private String time1;
	private String time2;
	private String movieids;
	private String cinemaids;
	private String cmatch;
	private String mpids;
	private Integer price1;
	private Integer price2;
	private Integer pricegap;
	private String weektype;
	private String description;
	private Timestamp updatetime;

	public Serializable realId() {
		return this.id;
	}

	public String getPartnerids() {
		return this.partnerids;
	}

	public void setPartnerids(String partnerids) {
		this.partnerids = partnerids;
	}

	public Timestamp getOpentime1() {
		return this.opentime1;
	}

	public void setOpentime1(Timestamp opentime1) {
		this.opentime1 = opentime1;
	}

	public Timestamp getOpentime2() {
		return this.opentime2;
	}

	public void setOpentime2(Timestamp opentime2) {
		this.opentime2 = opentime2;
	}

	public String getTime1() {
		return this.time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return this.time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getMovieids() {
		return this.movieids;
	}

	public void setMovieids(String movieids) {
		this.movieids = movieids;
	}

	public String getCinemaids() {
		return this.cinemaids;
	}

	public void setCinemaids(String cinemaids) {
		this.cinemaids = cinemaids;
	}

	public String getMpids() {
		return this.mpids;
	}

	public void setMpids(String mpids) {
		this.mpids = mpids;
	}

	public Integer getPrice1() {
		return this.price1;
	}

	public void setPrice1(Integer price1) {
		this.price1 = price1;
	}

	public Integer getPrice2() {
		return this.price2;
	}

	public void setPrice2(Integer price2) {
		this.price2 = price2;
	}

	public Integer getPricegap() {
		return this.pricegap;
	}

	public void setPricegap(Integer pricegap) {
		this.pricegap = pricegap;
	}

	public String getWeektype() {
		return this.weektype;
	}

	public void setWeektype(String weektype) {
		this.weektype = weektype;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRuletype() {
		return this.ruletype;
	}

	public void setRuletype(String ruletype) {
		this.ruletype = ruletype;
	}

	public String getPmatch() {
		return this.pmatch;
	}

	public void setPmatch(String pmatch) {
		this.pmatch = pmatch;
	}

	public String getCmatch() {
		return this.cmatch;
	}

	public void setCmatch(String cmatch) {
		this.cmatch = cmatch;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public boolean matchPartner(Long partnerid) {
		boolean matchPartner = StringUtils.equals(this.partnerids, "000000");
		if (!matchPartner) {
			List pidList = BeanUtil.getIdList(this.partnerids, ",");
			matchPartner = pidList.contains(partnerid);
		}

		return StringUtils.equals(this.pmatch, "exclude") ? !matchPartner : matchPartner;
	}

	public boolean matchCinema(Long cinemaid) {
		if (StringUtils.isBlank(this.cinemaids)) {
			return true;
		} else {
			List cinemaidList = BeanUtil.getIdList(this.cinemaids, ",");
			boolean match = cinemaidList.contains(cinemaid);
			return StringUtils.equals(this.cmatch, "exclude") ? !match : match;
		}
	}

	public boolean matchMovie(Long movieid) {
		if (StringUtils.isBlank(this.movieids)) {
			return true;
		} else {
			List movieidList = BeanUtil.getIdList(this.movieids, ",");
			return movieidList.contains(movieid);
		}
	}
}