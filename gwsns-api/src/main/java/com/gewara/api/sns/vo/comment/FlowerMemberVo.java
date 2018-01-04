package com.gewara.api.sns.vo.comment;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class FlowerMemberVo extends BaseVo {

	private static final long serialVersionUID = 1L;
	private String ckey;			//memberid+type+relatedid
	private Long memberid;
	private String type;			//类型  comment or moderatortag
	private Long relatedid;			//关联id
	private Timestamp addtime;		//添加时间
	private String source;			//来源web,wap
	private Long parentid;			//父标签id
	private String parenttype;		//父标签类型

	@Override
	public Serializable realId() {
		return ckey;
	}

	public String getCkey() {
		return ckey;
	}

	public void setCkey(String ckey) {
		this.ckey = ckey;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public String getParenttype() {
		return parenttype;
	}

	public void setParenttype(String parenttype) {
		this.parenttype = parenttype;
	}
	

}
