package com.gewara.drama.vo.cmd;

import java.io.Serializable;
import java.sql.Timestamp;


import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;

/**
 */
public class DramaOpusVo extends BaseVo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5940746594893299685L;
	private Long id;
	private Long dramaid;			//项目ID
	private String title;			//标题
	private String entitle;			//英文标题
	private String logo;				//图片链接
	private String description;	//描述
	private String videourl;		//语音链接
	private Integer sortnum;		//排序字段
	private Timestamp addtime;
	private Timestamp updatetime;
	
	public DramaOpusVo(){}
	
	public DramaOpusVo(Long dramaid){
		this.dramaid = dramaid;
		this.sortnum = 1;
		this.addtime = DateUtil.getCurFullTimestamp();
		this.updatetime = this.addtime;
	}
	
	
	@Override
	public Serializable realId() {
		return id;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getDramaid() {
		return dramaid;
	}


	public void setDramaid(Long dramaid) {
		this.dramaid = dramaid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLimg(){
		return this.logo;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getVideourl() {
		return videourl;
	}


	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}


	public Integer getSortnum() {
		return sortnum;
	}


	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}


	public Timestamp getAddtime() {
		return addtime;
	}


	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}


	public Timestamp getUpdatetime() {
		return updatetime;
	}


	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getEntitle() {
		return entitle;
	}

	public void setEntitle(String entitle) {
		this.entitle = entitle;
	}
}
