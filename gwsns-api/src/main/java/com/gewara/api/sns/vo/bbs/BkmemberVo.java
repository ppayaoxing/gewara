/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.bbs;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class BkmemberVo extends BaseVo {
	public static final int ROLE_USER = 1;
	public static final int ROLE_BANZHU = 2;
	public static final int ROLE_MANAGER = 4;
	public static final int ROLE_OWNER = 8;
	private static final long serialVersionUID = 4476980910614491968L;
	private Long id;
	private Long memberid;
	private String tag;
	private String remark;
	private Long relatedid;
	private Timestamp addtime;
	private Integer applyrole;
	private Integer role;

	public BkmemberVo() {
	}

	public BkmemberVo(String tag) {
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.role = Integer.valueOf(1);
		this.applyrole = Integer.valueOf(1);
		this.tag = tag;
	}

	public BkmemberVo(Long memberid, String tag, Long relatedId) {
		this(tag);
		this.memberid = memberid;
		this.relatedid = relatedId;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Serializable realId() {
		return this.id;
	}

	public Integer getApplyrole() {
		return this.applyrole;
	}

	public void setApplyrole(Integer applyrole) {
		this.applyrole = applyrole;
	}

	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public boolean hasManagerRights(String stag, Long srelatedid) {
		return this.role.intValue() < 4 ? false
				: ((!StringUtils.isBlank(stag) || !StringUtils.isBlank(this.tag))
						&& !StringUtils.defaultString(this.tag).equals(StringUtils.defaultString(stag))
								? (StringUtils.isNotBlank(stag) && stag.contains(StringUtils.defaultString(this.tag))
										? this.relatedid == null : false)
								: (this.relatedid == null ? true : this.relatedid.equals(srelatedid)));
	}

	public boolean hasRights(String stag, Long srelatedid) {
		return this.role.intValue() < 2 ? false
				: ((!StringUtils.isBlank(stag) || !StringUtils.isBlank(this.tag))
						&& !StringUtils.defaultString(this.tag).equals(StringUtils.defaultString(stag))
								? (StringUtils.isNotBlank(stag) && stag.contains(StringUtils.defaultString(this.tag))
										? this.relatedid == null : false)
								: (this.relatedid == null ? true : this.relatedid.equals(srelatedid)));
	}

	public boolean isBkmember(String stag, Long srelatedid) {
		return !StringUtils.defaultString(this.tag).equals(StringUtils.defaultString(stag)) ? false
				: (this.relatedid == null && srelatedid != null || this.relatedid != null && srelatedid == null ? false
						: this.relatedid == null || srelatedid == null || this.relatedid.equals(srelatedid));
	}

	public String getRolename() {
		return this.role == null ? "未知"
				: (this.role.intValue() == 1 ? "普通成员"
						: (this.role.intValue() == 2 ? "版主" : (this.role.intValue() == 4 ? "管理员" : "未知")));
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
}