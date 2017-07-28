/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.common;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class BaseEntityVo extends BaseVo implements Serializable {
	public static final int HOTVALUE_HOT = 30000;
	public static final int HOTVALUE_RECOMMEND = 50000;
	public static final int HOTVALUE_SEARCH = 70000;
	private static final long serialVersionUID = 6326252378179481450L;
	protected Long id;
	protected String name;
	protected String englishname;
	protected String pinyin;
	protected String content;
	protected String logo;
	protected String fullLogo;
	protected String firstpic;
	protected Integer generalmark;
	protected Integer generalmarkedtimes;
	protected Integer avggeneral;
	protected Integer collectedtimes;
	protected Integer clickedtimes;
	protected String briefname;
	protected Timestamp addtime;
	protected Timestamp updatetime;
	protected String seotitle;
	protected String seodescription;
	protected Integer hotvalue = Integer.valueOf(0);
	protected Integer quguo;
	protected Integer xiangqu;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getClickedtimes() {
		return this.clickedtimes;
	}

	public void setClickedtimes(Integer clickedtimes) {
		this.clickedtimes = clickedtimes;
	}

	public String getEnglishname() {
		return this.englishname;
	}

	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}

	public String getPinyin() {
		return this.pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLimg() {
		return StringUtils.isBlank(this.logo) ? "img/default_logo.png" : this.logo;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getFirstpic() {
		return this.firstpic;
	}

	public void setFirstpic(String firstpic) {
		this.firstpic = firstpic;
	}

	public Integer getGeneralmark() {
		return this.generalmark;
	}

	public void setGeneralmark(Integer generalmark) {
		this.generalmark = generalmark;
	}

	public Integer getGeneralmarkedtimes() {
		return this.generalmarkedtimes;
	}

	public void setGeneralmarkedtimes(Integer generalmarkedtimes) {
		this.generalmarkedtimes = generalmarkedtimes;
	}

	public Integer getAvggeneral() {
		return this.avggeneral;
	}

	public void setAvggeneral(Integer avggeneral) {
		this.avggeneral = avggeneral;
	}

	public Integer getCollectedtimes() {
		return this.collectedtimes;
	}

	public void setCollectedtimes(Integer collectedtimes) {
		this.collectedtimes = collectedtimes;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getRealBriefname() {
		return StringUtils.isNotBlank(this.briefname) ? this.briefname : this.getName();
	}

	public String getBriefname() {
		return this.briefname;
	}

	public void setBriefname(String briefname) {
		this.briefname = briefname;
	}

	public String getFullLogo() {
		return this.fullLogo;
	}

	public void setFullLogo(String fullLogo) {
		this.fullLogo = fullLogo;
	}

	public String getSeotitle() {
		return this.seotitle;
	}

	public void setSeotitle(String seotitle) {
		this.seotitle = seotitle;
	}

	public String getSeodescription() {
		return this.seodescription;
	}

	public void setSeodescription(String seodescription) {
		this.seodescription = seodescription;
	}

	public Integer getHotvalue() {
		return this.hotvalue;
	}

	public void setHotvalue(Integer hotvalue) {
		this.hotvalue = hotvalue;
	}

	public Integer getQuguo() {
		return this.quguo;
	}

	public void setQuguo(Integer quguo) {
		this.quguo = quguo;
	}

	public Integer getXiangqu() {
		return this.xiangqu;
	}

	public void setXiangqu(Integer xiangqu) {
		this.xiangqu = xiangqu;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
}