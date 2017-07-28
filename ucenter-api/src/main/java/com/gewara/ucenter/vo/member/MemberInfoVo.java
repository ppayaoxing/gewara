/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.member;

import com.gewara.api.vo.BaseVo;
import com.gewara.ucenter.constant.MemberConstant;
import com.gewara.util.JsonUtils;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class MemberInfoVo extends BaseVo {
	private static final long serialVersionUID = -3838425704891306595L;
	private Long id;
	private String nickname;
	private String sex;
	private String tag;
	private String fromcity;
	private String realname;
	private String invitetype;
	private String source;
	private String regfrom;
	private String headpic;
	private Timestamp addtime;
	private Timestamp updatetime;
	private Integer expvalue;
	private String newtask;
	private String otherinfo;
	private Integer pointvalue;
	private Long inviteid;
	private String ip;

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadpic() {
		return this.headpic;
	}

	public void setHeadpic(String headpic) {
		this.headpic = headpic;
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

	public String getHeadpicUrl() {
		return StringUtils.isNotBlank(this.headpic) ? this.headpic : "img/default_head.png";
	}

	public String getLogo() {
		return this.getHeadpicUrl();
	}

	public Long getInviteid() {
		return this.inviteid;
	}

	public void setInviteid(Long inviteid) {
		this.inviteid = inviteid;
	}

	public String getInvitetype() {
		return this.invitetype;
	}

	public void setInvitetype(String invitetype) {
		this.invitetype = invitetype;
	}

	public String getRegfrom() {
		return this.regfrom;
	}

	public void setRegfrom(String regfrom) {
		this.regfrom = regfrom;
	}

	public String getNewtask() {
		return this.newtask;
	}

	public void setNewtask(String newtask) {
		this.newtask = newtask;
	}

	public Integer getExpvalue() {
		return this.expvalue;
	}

	public void setExpvalue(Integer expvalue) {
		this.expvalue = expvalue;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Serializable realId() {
		return this.id;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getFromcity() {
		return this.fromcity;
	}

	public void setFromcity(String fromcity) {
		this.fromcity = fromcity;
	}

	public List<String> getFinishedTaskList() {
		return (List) (StringUtils.isBlank(this.newtask) ? new ArrayList() : Arrays.asList(this.newtask.split(",")));
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public Integer getPointvalue() {
		return this.pointvalue;
	}

	public void setPointvalue(Integer pointvalue) {
		this.pointvalue = pointvalue;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<String> getNewTaskList() {
		return (List) (StringUtils.isBlank(this.newtask) ? new ArrayList()
				: Arrays.asList(StringUtils.split(this.newtask, ",")));
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public boolean isRegisterSource(String rsource) {
		return StringUtils.isBlank(rsource) ? false : StringUtils.equals(this.source, rsource);
	}

	public boolean isBindSuccess() {
		String value = JsonUtils.getJsonValueByKey(this.otherinfo, "bindstatus");
		return StringUtils.isBlank(value) ? true : StringUtils.equals(value, "success");
	}

	public int getBuyticket() {
		ArrayList taskList = new ArrayList();
		if (StringUtils.isNotBlank(this.getNewtask())) {
			taskList = new ArrayList(Arrays.asList(StringUtils.split(this.getNewtask(), ",")));
		}

		return taskList.contains("buyticket") ? 1 : 0;
	}

	public boolean isFinishedTask(String task) {
		return !StringUtils.isNotBlank(this.getNewtask()) ? false
				: !MemberConstant.TASK_LIST.contains(task) || this.getNewtask().contains(task);
	}
}