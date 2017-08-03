package com.gewara.api.sns.vo.recommend;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

/**
 * 推荐的详细内容
 * @author zxl
 *
 */
public class RecommendBatchDetailVo extends BaseVo {

	private static final long serialVersionUID = -7002538981573566217L;
	private Long id; // 主键
	private Long batchId; // 批次id
	private String tag;// TAG_STAR、TAG_MOVIE、TAG_BIGLABEL、TAG_COMMENT_TYPE
	private Long relatedid;// 关联对象id
	private String status;// Y_NEW、N_DELETE
	private Integer sortNum;// 排序
	private Timestamp addtime;
	private Long memberid;
	private String nickname;

	public RecommendBatchDetailVo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public Serializable realId() {
		return id;
	}

}
