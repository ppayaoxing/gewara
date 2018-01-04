package com.gewara.api.activity.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.gewara.api.activity.ApiObject;

public class ApplyJoinVo extends ApiObject{

	public static final String O = "O";//δ��¼ʤ����ϵ�ıȷ�
	public static final String MARK_WIN = "win";//Լսʤ
	public static final String MARK_LOSE = "lose";//Լս��
	public static final String MARK_TIE = "tie";//Լսƽ
	private static final long serialVersionUID = -4502423276846683786L;
	private Long id;
	private Long relatedid;		//�id
	private Timestamp addtime;	//����ʱ��
	private Integer joinnum;	//�μ�����
	private String contactway;	//��ϵ��ʽ
	private Integer admin;		//1�������Ƿ����ˣ�memberid�ͻ��memberid��ͬ��0����ͨ������
	private Long memberid;		//�μ�
	private String realname;	//��ʵ����
	private String sex; 		//�Ա�
	private Integer needpay;	//��Ҫ֧������
	private Date joindate;		//�μӻ����
	private Integer score;		//Լս��
	private String mark;		//Լս��
	private String status;		//ֻ��Լս���õ� N��δ��д�ȷּ�¼��O��������д�ȷּ�¼��Y˫������д�˱ȷּ�¼
	private String headpicUrl;  //�û�ͷ���ַ
	private String nickName;	//�û��ǳ�
	private String address;		//��ַ
	private String otherinfo;	
	private String birthday;    //��������
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadpicUrl() {
		return headpicUrl;
	}
	public void setHeadpicUrl(String headpicUrl) {
		this.headpicUrl = headpicUrl;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	public ApplyJoinVo() {}
	
	public ApplyJoinVo(Long memberid){
		this.joinnum = 1;
		this.admin = 0;
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.memberid = memberid;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRelatedid() {
		return relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getJoinnum() {
		return joinnum;
	}

	public void setJoinnum(Integer joinnum) {
		this.joinnum = joinnum;
	}

	public String getContactway() {
		return contactway;
	}

	public void setContactway(String contactway) {
		this.contactway = contactway;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	public Integer getNeedpay() {
		if(needpay == null) {
            needpay = 0;
        }
		return needpay;
	}
	public void setNeedpay(Integer needpay) {
		this.needpay = needpay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
