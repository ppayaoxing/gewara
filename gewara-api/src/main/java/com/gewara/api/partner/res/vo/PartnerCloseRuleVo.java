package com.gewara.api.partner.res.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.BeanUtil;

/**
 * �̻��رչ���
 */
public class PartnerCloseRuleVo extends BaseVo{

	private static final long serialVersionUID = -376659304790226970L;
	public static final String RULETYPE_OPI = "opi";			//����
	public static final String RULETYPE_MOVIE = "movie";		//ӰԺ
	public static final String RULETYPE_CINEMA = "cinema";	//ӰƬ
	public static final String MATCH_INCLUDE = "include";		//����
	public static final String MATCH_EXCLUDE = "exclude";		//�ų�
	private Long id;
	private String ruletype;			//�������ͣ�ֻ��ӰƬ��ֻ��ӰԺ��������Ƭ
	private String partnerids;			//�̼�ID			
	private String pmatch;				//partner match model ���������ų��̼� 
	private Timestamp opentime1;		//����ʱ��1
	private Timestamp opentime2;		//����ʱ��2
	private String time1;				//����ʱ��1
	private String time2;				//����ʱ��2
	private String movieids;			//ӰƬID��������
	private String cinemaids;			//ӰԺID��������
	private String cmatch;				//cinema match model ���������ų�ӰԺ
	private String mpids;				//����ID�������ų���
	private Integer price1;				//�۸�Χ1��С�ڴ˼۸�Ĳ�����
	private Integer price2;				//�۸�Χ2�����ڴ˼۸�Ĳ�����
	private Integer pricegap;			//����pricegap�Ĳ�����
	private String weektype;			//�ܼ��Ĳ�����
	private String description;			//��������
	private Timestamp updatetime;		//����ʱ��
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
