package com.gewara.movie.vo;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.DateUtil;

/**
 * 电影英文字段            
 * @author john
 *
 */

public class MovieExtraVo extends BaseVo implements Serializable {
	private static final long serialVersionUID = 4965993143973574947L;
	
	private Long id;
	private String language;		//语言
	private String state;			//地区
	private String director;		//导演
	private String actors;			//主演
	private String content;			//剧情
	private String addtime;
	private String updatetime;
	
	public MovieExtraVo(){}
	
	public MovieExtraVo(Long id){
		this.id = id;
		this.addtime = DateUtil.getCurFullTimestampStr();
		this.updatetime = this.addtime;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	
}
