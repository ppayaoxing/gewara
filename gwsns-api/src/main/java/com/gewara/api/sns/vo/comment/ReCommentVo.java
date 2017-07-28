/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.comment;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.JsonUtils;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

public class ReCommentVo extends BaseVo {
	private static final long serialVersionUID = 6937601037315369836L;
	public static final String ADDRESS_WEB = "web";
	public static final String ADDRESS_WAP = "wap";
	public static final String TAG_COMMENT = "comment";
	public static final String TAG_RECOMMENT = "recomment";
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
	private Integer isread;
	private Integer toRead;
	private Integer toTop;
	private String imgPath;
	private Integer flowernum;
	private Long mtid;
	private String atmemberjson;
	private String replyids;

	public String getReplyids() {
		return this.replyids;
	}

	public void setReplyids(String replyids) {
		this.replyids = replyids;
	}

	public String getAtmemberjson() {
		return this.atmemberjson;
	}

	public void setAtmemberjson(String atmemberjson) {
		this.atmemberjson = atmemberjson;
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

	public Integer getIsread() {
		return this.isread;
	}

	public void setIsread(Integer isread) {
		this.isread = isread;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ReCommentVo() {
	}

	public ReCommentVo(Long memberid) {
		this.memberid = memberid;
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.status = "Y_NEW";
		this.address = "web";
		this.isread = Integer.valueOf(0);
		this.toRead = Integer.valueOf(0);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTomemberid() {
		return this.tomemberid;
	}

	public void setTomemberid(Long tomemberid) {
		this.tomemberid = tomemberid;
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

	public Integer getToRead() {
		return this.toRead;
	}

	public void setToRead(Integer toRead) {
		this.toRead = toRead;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public Serializable realId() {
		return this.id;
	}

	public Integer getToTop() {
		return this.toTop;
	}

	public void setToTop(Integer toTop) {
		this.toTop = toTop;
	}

	public Long getMtid() {
		return this.mtid;
	}

	public void setMtid(Long mtid) {
		this.mtid = mtid;
	}

	public Map<String, String> atMemberMap() {
		return JsonUtils.readJsonToMap(this.atmemberjson);
	}
}