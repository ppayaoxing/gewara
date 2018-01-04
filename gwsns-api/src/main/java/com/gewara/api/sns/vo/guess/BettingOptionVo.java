package com.gewara.api.sns.vo.guess;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;
/**
 * 猜票房投注选项  
 *
 */
public class BettingOptionVo extends BaseVo{
	private static final long serialVersionUID = -3353254174148150236L;
	private Long id;//主键
	private String body; //内容
	private String status;// 状态Y_NEW --新建     N_DELETE --删除
	private Long relatedid; //设置id
	private Integer orderNum;//排序序号
	private Timestamp addtime; //添加时间

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	@Override
	public Serializable realId() {
		return id;
	}

}
