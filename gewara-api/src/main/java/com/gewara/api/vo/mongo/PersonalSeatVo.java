package com.gewara.api.vo.mongo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class PersonalSeatVo extends BaseVo{

	private static final long serialVersionUID = 2369105876039440228L;
	private String id;	
	private String relatedidList;//关联电影id
	private String relatedType;  //关联电影类型  1.电影id 2.场次id
    private String title;
    private String addtime;
    private Timestamp starttime;
	private Timestamp stoptime;	
	
	@Override
	public Serializable realId() {
		return id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRelatedidList() {
		return relatedidList;
	}

	public void setRelatedidList(String relatedidList) {
		this.relatedidList = relatedidList;
	}

	public String getRelatedType() {
		return relatedType;
	}

	public void setRelatedType(String relatedType) {
		this.relatedType = relatedType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getStoptime() {
		return stoptime;
	}

	public void setStoptime(Timestamp stoptime) {
		this.stoptime = stoptime;
	}


}
