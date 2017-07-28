/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo.star;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class CastProfileVo extends BaseVo {
	private static final long serialVersionUID = -9102933891913403605L;
	private Long id;
	private String mtimeid;
	private String chinesename;
	private String engname;
	private Long volk;
	private String headPicUrl;
	private String birthday;
	private String birthplace;
	private String dateOfDeath;
	private Integer height;
	private Integer weight;
	private Long sign;
	private Long hometown;
	private String intro;
	private String bloodtype;
	private String education;
	private String imdbid;
	private String isshow;
	private Timestamp addtime;
	private Timestamp updatetime;
	private String familyMember;
	private String weiboAccount;
	private String weiboUrl;
	private String hlogo;
	private Long collectimes;
	private String role;

	public Long getCollectimes() {
		return this.collectimes;
	}

	public void setCollectimes(Long collectimes) {
		this.collectimes = collectimes;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getHlogo() {
		return this.hlogo;
	}

	public void setHlogo(String hlogo) {
		this.hlogo = hlogo;
	}

	public String getFamilyMember() {
		return this.familyMember;
	}

	public void setFamilyMember(String familyMember) {
		this.familyMember = familyMember;
	}

	public String getWeiboAccount() {
		return this.weiboAccount;
	}

	public void setWeiboAccount(String weiboAccount) {
		this.weiboAccount = weiboAccount;
	}

	public String getWeiboUrl() {
		return this.weiboUrl;
	}

	public void setWeiboUrl(String weiboUrl) {
		this.weiboUrl = weiboUrl;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMtimeid() {
		return this.mtimeid;
	}

	public void setMtimeid(String mtimeid) {
		this.mtimeid = mtimeid;
	}

	public String getChinesename() {
		return this.chinesename;
	}

	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}

	public String getEngname() {
		return this.engname;
	}

	public void setEngname(String engname) {
		this.engname = engname;
	}

	public Long getVolk() {
		return this.volk;
	}

	public void setVolk(Long volk) {
		this.volk = volk;
	}

	public String getHeadPicUrl() {
		return this.headPicUrl;
	}

	public void setHeadPicUrl(String headPicUrl) {
		this.headPicUrl = headPicUrl;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getHeight() {
		return this.height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Long getSign() {
		return this.sign;
	}

	public void setSign(Long sign) {
		this.sign = sign;
	}

	public Long getHometown() {
		return this.hometown;
	}

	public void setHometown(Long hometown) {
		this.hometown = hometown;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getBloodtype() {
		return this.bloodtype;
	}

	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
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

	public String getImdbid() {
		return this.imdbid;
	}

	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}

	public String getIsshow() {
		return this.isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	public String getBirthplace() {
		return this.birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getDateOfDeath() {
		return this.dateOfDeath;
	}

	public void setDateOfDeath(String dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public Serializable realId() {
		return this.id;
	}
}