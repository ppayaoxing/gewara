package com.gewara.movie.vo.star;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

/**
 * 人物详细信息表
 */
public class CastProfileVo extends BaseVo {

	private static final long serialVersionUID = -9102933891913403605L;
	
	private Long id;
	private String mtimeid;				//时光网用户ID
	private String chinesename;			//中文名
	private String engname;				//英文名
	private Long volk;					//民族
	private String headPicUrl;			//头像图片路径
	private String birthday;			//生日
	private String birthplace;			//出生地
	private String dateOfDeath;			//去世日期
	private Integer height;				//身高
	private Integer weight;				//体重
	private Long sign;					//星座
	private Long hometown;				//出生地
	private String intro;				//个人简介
	private String bloodtype;			//血型
	private String education;			//教育背景
	private String imdbid;				//第三方超链接
	private String isshow;				//是否在前台显示详细资料
	private Timestamp addtime;			//新增时间
	private Timestamp updatetime;		//更新时间
    private String familyMember;		//家庭成员
    private String weiboAccount;		//微博账号
    private String weiboUrl;			//微博地址
    private String hlogo;				//横版海报
    
    private Long collectimes;//点赞数
    public Long getCollectimes() {
		return collectimes;
	}

	public void setCollectimes(Long collectimes) {
		this.collectimes = collectimes;
	}

	private String role;	
    
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getHlogo() {
		return hlogo;
	}

	public void setHlogo(String hlogo) {
		this.hlogo = hlogo;
	}

	public String getFamilyMember() {
		return familyMember;
	}

	public void setFamilyMember(String familyMember) {
		this.familyMember = familyMember;
	}

	public String getWeiboAccount() {
		return weiboAccount;
	}

	public void setWeiboAccount(String weiboAccount) {
		this.weiboAccount = weiboAccount;
	}

	public String getWeiboUrl() {
		return weiboUrl;
	}

	public void setWeiboUrl(String weiboUrl) {
		this.weiboUrl = weiboUrl;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMtimeid() {
		return mtimeid;
	}

	public void setMtimeid(String mtimeid) {
		this.mtimeid = mtimeid;
	}

	public String getChinesename() {
		return chinesename;
	}

	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}

	public String getEngname() {
		return engname;
	}

	public void setEngname(String engname) {
		this.engname = engname;
	}

	public Long getVolk() {
		return volk;
	}

	public void setVolk(Long volk) {
		this.volk = volk;
	}

	public String getHeadPicUrl() {
		return headPicUrl;
	}

	public void setHeadPicUrl(String headPicUrl) {
		this.headPicUrl = headPicUrl;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Long getSign() {
		return sign;
	}

	public void setSign(Long sign) {
		this.sign = sign;
	}

	public Long getHometown() {
		return hometown;
	}

	public void setHometown(Long hometown) {
		this.hometown = hometown;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getBloodtype() {
		return bloodtype;
	}

	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getImdbid() {
		return imdbid;
	}

	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}

	public String getIsshow() {
		return isshow;
	}

	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(String dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	@Override
	public Serializable realId() {
		return id;
	}

}
