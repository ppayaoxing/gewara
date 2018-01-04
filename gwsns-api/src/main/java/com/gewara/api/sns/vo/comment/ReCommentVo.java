package com.gewara.api.sns.vo.comment;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

import com.gewara.api.sns.constant.Status;
import com.gewara.api.vo.BaseVo;
import com.gewara.util.JsonUtils;

public class ReCommentVo extends BaseVo {
	private static final long serialVersionUID = 6937601037315369836L;
	public static final String ADDRESS_WEB="web";
	public static final String ADDRESS_WAP="wap";
	public static final String TAG_COMMENT = "comment"; //回复哇啦
	public static final String TAG_RECOMMENT = "recomment"; //回复回复
	private Long id;
	private Long memberid;
	private Long relatedid;
	private String body;
	private Timestamp addtime;
	private Long tomemberid;
	private String status;
	private String address;//发表来源
	private String tag;
	private Long transferid;
	private Integer isread;//针对哇啦是否已看,0:未读、1：已读
	private Integer toRead;//针对回复是否已看,0:未读、1：已读
	private Integer toTop; // 回复置顶 1
	
	private String imgPath;//存放图片
	private Integer flowernum; //鲜花数
	private Long mtid;	//标签id
	
	private String atmemberjson;	//{'用户昵称':用户id}
	private String replyids;		//回复回复的id  用","拼接
	
	public String getReplyids() {
		return replyids;
	}
	public void setReplyids(String replyids) {
		this.replyids = replyids;
	}
	public String getAtmemberjson() {
		return atmemberjson;
	}
	public void setAtmemberjson(String atmemberjson) {
		this.atmemberjson = atmemberjson;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Integer getFlowernum() {
		return flowernum;
	}
	public void setFlowernum(Integer flowernum) {
		this.flowernum = flowernum;
	}
	public Integer getIsread() {
		return isread;
	}
	public void setIsread(Integer isread) {
		this.isread = isread;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ReCommentVo(){}
	public ReCommentVo(Long memberid) {
		this.memberid = memberid;
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.status = Status.Y_NEW;
		this.address = ADDRESS_WEB;
		this.isread = 0;
		this.toRead = 0;
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public Long getTomemberid() {
		return tomemberid;
	}
	public void setTomemberid(Long tomemberid) {
		this.tomemberid = tomemberid;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Long getTransferid() {
		return transferid;
	}
	public void setTransferid(Long transferid) {
		this.transferid = transferid;
	}
	public Integer getToRead() {
		return toRead;
	}
	public void setToRead(Integer toRead) {
		this.toRead = toRead;
	}
	public Long getMemberid() {
		return memberid;
	}
	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}
	@Override
	public Serializable realId() {
		return this.id;
	}
	public Integer getToTop() {
		return toTop;
	}
	public void setToTop(Integer toTop) {
		this.toTop = toTop;
	}
	public Long getMtid() {
		return mtid;
	}
	public void setMtid(Long mtid) {
		this.mtid = mtid;
	}
	public Map<String, String> atMemberMap(){
		return JsonUtils.readJsonToMap(this.atmemberjson);
	}
}
