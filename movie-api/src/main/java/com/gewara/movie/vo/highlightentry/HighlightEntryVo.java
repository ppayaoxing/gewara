package com.gewara.movie.vo.highlightentry;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

/**
 * 亮点入口
 * @author weihua.wang
 *
 */
public class HighlightEntryVo extends BaseVo{
	
	private static final long serialVersionUID = -3249617513980619848L;
	
	private Long id;
	private String tag;//标签
	private String title;//标题
	private String type;//亮点入口类型
	private String url;//URL
	private String citycode;//城市编码
	private Timestamp addtime;//添加时间
	private Timestamp updatetime;//更新时间
	private Timestamp starttime;//开始时间
	private Timestamp endtime;//结束时间
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
	
	@Override
	public Serializable realId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}
}
