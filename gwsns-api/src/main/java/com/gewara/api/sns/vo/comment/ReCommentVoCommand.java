/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.comment;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;
import java.sql.Timestamp;

public class ReCommentVoCommand extends BaseVo {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long memberid;
	private Long relatedid;
	private String body;
	private Timestamp addtime;
	private Long tomemberid;
	private String status;
	private String address;
	private String tag;
	private Long transferid;
	private String imgPath;
	private Integer flowernum;
	private Long mtid;
	private String ip;
	private String atmemberids;
	private Long replyid;

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Long getRelatedid() {
		return this.relatedid;
	}

	public void setRelatedid(Long relatedid) {
		this.relatedid = relatedid;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Long getTomemberid() {
		return this.tomemberid;
	}

	public void setTomemberid(Long tomemberid) {
		this.tomemberid = tomemberid;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getTransferid() {
		return this.transferid;
	}

	public void setTransferid(Long transferid) {
		this.transferid = transferid;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getFlowernum() {
		return this.flowernum;
	}

	public void setFlowernum(Integer flowernum) {
		this.flowernum = flowernum;
	}

	public Long getMtid() {
		return this.mtid;
	}

	public void setMtid(Long mtid) {
		this.mtid = mtid;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAtmemberids() {
		return this.atmemberids;
	}

	public void setAtmemberids(String atmemberids) {
		this.atmemberids = atmemberids;
	}

	public Long getReplyid() {
		return this.replyid;
	}

	public void setReplyid(Long replyid) {
		this.replyid = replyid;
	}
}