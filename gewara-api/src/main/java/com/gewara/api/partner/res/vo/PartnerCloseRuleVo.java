package com.gewara.api.partner.res.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.BeanUtil;

/**
 * 锟教伙拷锟截闭癸拷锟斤拷
 */
public class PartnerCloseRuleVo extends BaseVo{

	private static final long serialVersionUID = -376659304790226970L;
	public static final String RULETYPE_OPI = "opi";			//锟斤拷锟斤拷
	public static final String RULETYPE_MOVIE = "movie";		//影院
	public static final String RULETYPE_CINEMA = "cinema";	//影片
	public static final String MATCH_INCLUDE = "include";		//锟斤拷锟斤拷
	public static final String MATCH_EXCLUDE = "exclude";		//锟脚筹拷
	private Long id;
	private String ruletype;			//锟斤拷锟斤拷锟斤拷锟酵ｏ拷只锟斤拷影片锟斤拷只锟斤拷影院锟斤拷锟斤拷锟斤拷锟斤拷片
	private String partnerids;			//锟教硷拷ID			
	private String pmatch;				//partner match model 锟斤拷锟斤拷锟斤拷锟斤拷锟脚筹拷锟教硷拷 
	private Timestamp opentime1;		//锟斤拷锟斤拷时锟斤拷1
	private Timestamp opentime2;		//锟斤拷锟斤拷时锟斤拷2
	private String time1;				//锟斤拷锟斤拷时锟斤拷1
	private String time2;				//锟斤拷锟斤拷时锟斤拷2
	private String movieids;			//影片ID锟斤拷锟斤拷锟斤拷锟斤拷
	private String cinemaids;			//影院ID锟斤拷锟斤拷锟斤拷锟斤拷
	private String cmatch;				//cinema match model 锟斤拷锟斤拷锟斤拷锟斤拷锟脚筹拷影院
	private String mpids;				//锟斤拷锟斤拷ID锟斤拷锟斤拷锟斤拷锟脚筹拷锟斤拷
	private Integer price1;				//锟桔革拷围1锟斤拷小锟节此价革拷牟锟斤拷锟斤拷锟�
	private Integer price2;				//锟桔革拷围2锟斤拷锟斤拷锟节此价革拷牟锟斤拷锟斤拷锟�
	private Integer pricegap;			//锟斤拷锟斤拷pricegap锟侥诧拷锟斤拷锟斤拷
	private String weektype;			//锟杰硷拷锟侥诧拷锟斤拷锟斤拷
	private String description;			//锟斤拷锟斤拷锟斤拷锟斤拷
	private Timestamp updatetime;		//锟斤拷锟斤拷时锟斤拷
	@Override
	public Serializable realId() {
		return id;
	}
	public String getPartnerids() {
		return partnerids;
	}
	public void setPartnerids(String partnerids) {
		this.partnerids = partnerids;
	}
	public Timestamp getOpentime1() {
		return opentime1;
	}
	public void setOpentime1(Timestamp opentime1) {
		this.opentime1 = opentime1;
	}
	public Timestamp getOpentime2() {
		return opentime2;
	}
	public void setOpentime2(Timestamp opentime2) {
		this.opentime2 = opentime2;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public String getMovieids() {
		return movieids;
	}
	public void setMovieids(String movieids) {
		this.movieids = movieids;
	}
	public String getCinemaids() {
		return cinemaids;
	}
	public void setCinemaids(String cinemaids) {
		this.cinemaids = cinemaids;
	}
	public String getMpids() {
		return mpids;
	}
	public void setMpids(String mpids) {
		this.mpids = mpids;
	}
	public Integer getPrice1() {
		return price1;
	}
	public void setPrice1(Integer price1) {
		this.price1 = price1;
	}
	public Integer getPrice2() {
		return price2;
	}
	public void setPrice2(Integer price2) {
		this.price2 = price2;
	}
	public Integer getPricegap() {
		return pricegap;
	}
	public void setPricegap(Integer pricegap) {
		this.pricegap = pricegap;
	}
	public String getWeektype() {
		return weektype;
	}
	public void setWeektype(String weektype) {
		this.weektype = weektype;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRuletype() {
		return ruletype;
	}
	public void setRuletype(String ruletype) {
		this.ruletype = ruletype;
	}
	public String getPmatch() {
		return pmatch;
	}
	public void setPmatch(String pmatch) {
		this.pmatch = pmatch;
	}
	public String getCmatch() {
		return cmatch;
	}
	public void setCmatch(String cmatch) {
		this.cmatch = cmatch;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public boolean matchPartner(Long partnerid) {
		boolean matchPartner = StringUtils.equals(partnerids, "000000");
		if(!matchPartner){
			List<Long> pidList = BeanUtil.getIdList(partnerids, ",");
			matchPartner = pidList.contains(partnerid);
		}
		return StringUtils.equals(pmatch, MATCH_EXCLUDE)?!matchPartner:matchPartner;
	}
	public boolean matchCinema(Long cinemaid) {
		if(StringUtils.isBlank(cinemaids)) {
            return true;
        }
		List<Long> cinemaidList = BeanUtil.getIdList(cinemaids, ",");
		boolean match = cinemaidList.contains(cinemaid);
		return StringUtils.equals(cmatch, MATCH_EXCLUDE)?!match:match;
	}
	public boolean matchMovie(Long movieid) {
		if(StringUtils.isBlank(movieids)) {
            return true;
        }
		List<Long> movieidList = BeanUtil.getIdList(movieids, ",");
		return movieidList.contains(movieid);
	}
}
