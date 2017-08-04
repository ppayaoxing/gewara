package com.gewara.json.mobile;

import java.io.Serializable;

import com.gewara.mongo.support.MGObject;

/**
 * 手机客户端抢票场次关联
 * 
 * @author taiqichao
 * 
 */
public class MobileGrabTicketMpi extends MGObject implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String gtid;// 抢票活动id
	private Long mpid;// 场次id

	public MobileGrabTicketMpi() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGtid() {
		return gtid;
	}

	public void setGtid(String gtid) {
		this.gtid = gtid;
	}

	public Long getMpid() {
		return mpid;
	}

	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}

}
