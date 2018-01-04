package com.gewara.api.sns.vo.bbs;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;

/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28锟斤拷锟斤拷02:05:17
 */
public class BkmemberVo extends BaseVo{
	public static final int ROLE_USER = 1; //锟斤拷通锟矫伙拷
	public static final int ROLE_BANZHU = 2; //锟斤拷锟斤拷
	public static final int ROLE_MANAGER = 4; //锟斤拷锟斤拷员
	public static final int ROLE_OWNER = 8; //拥锟斤拷锟斤拷
	private static final long serialVersionUID = 4476980910614491968L;
	private Long id;
	private Long memberid;
	private String tag;
	private String remark; //锟斤拷锟界，锟斤拷锟斤拷锟斤拷锟缴碉拷
	private Long relatedid;
	private Timestamp addtime;
	private Integer applyrole;//锟斤拷锟诫当锟斤拷锟斤拷
	private Integer role;
	public BkmemberVo(){}
	
	public BkmemberVo(String tag){
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.role = 1;
		this.applyrole = 1;
		this.tag = tag;
	}
	public BkmemberVo(Long memberid, String tag, Long relatedId){
		this(tag);
		this.memberid = memberid;
		this.relatedid = relatedId;
	}
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getRelatedid() {
		return relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public Integer getApplyrole() {
		return applyrole;
	}
	public void setApplyrole(Integer applyrole) {
		this.applyrole = applyrole;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public boolean hasManagerRights(String stag, Long srelatedid) {
		if(this.role < ROLE_MANAGER) {
            return false;
        }
		if(StringUtils.isBlank(stag) && StringUtils.isBlank(this.tag) || 
				StringUtils.defaultString(this.tag).equals(StringUtils.defaultString(stag))){//锟斤拷锟�
			if(this.relatedid == null) {
                return true;
            }
			return this.relatedid.equals(srelatedid);
		}
		if(StringUtils.isNotBlank(stag) && stag.contains(StringUtils.defaultString(this.tag))){//锟斤拷锟斤拷
			if(this.relatedid != null) {
                return false;
            }
			return true; 
		}
		return false;
	}
	public boolean hasRights(String stag, Long srelatedid){
		if(this.role < ROLE_BANZHU) {
            return false;//锟斤拷权锟斤拷
        }
		if(StringUtils.isBlank(stag) && StringUtils.isBlank(this.tag) || 
				StringUtils.defaultString(this.tag).equals(StringUtils.defaultString(stag))){//锟斤拷锟�
			if(this.relatedid == null) {
                return true;
            }
			return this.relatedid.equals(srelatedid);
		}
		if(StringUtils.isNotBlank(stag) && stag.contains(StringUtils.defaultString(this.tag))){//锟斤拷锟斤拷
			if(this.relatedid != null) {
                return false;
            }
			return true; 
		}
		return false;
	}
	public boolean isBkmember(String stag, Long srelatedid) {
		if(!StringUtils.defaultString(this.tag).equals(StringUtils.defaultString(stag))) {
            return false;
        }
		if(this.relatedid == null && srelatedid !=null || this.relatedid != null && srelatedid == null) {
            return false;
        }
		if(this.relatedid !=null && srelatedid !=null && !this.relatedid.equals(srelatedid)) {
            return false;
        }
		return true;
	}
	public String getRolename(){
		if(this.role == null) {
            return "未知";
        }
		if(this.role == 1) {
            return "锟斤拷通锟斤拷员";
        }
		if(this.role == 2) {
            return "锟斤拷锟斤拷";
        }
		if(this.role == 4) {
            return "锟斤拷锟斤拷员";
        }
		return "未知";
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
}
