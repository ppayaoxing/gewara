package com.gewara.api.vo.movie;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

/**
 * @author sunder
 *
 */
public class MoviePlayItemVo extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1045685597517847050L;
	private String openStatus;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpenStatus() {
		return openStatus;
	}

	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}

	@Override
	public Serializable realId() {
		return null;
	}
}
