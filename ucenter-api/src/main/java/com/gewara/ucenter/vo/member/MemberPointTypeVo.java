package com.gewara.ucenter.vo.member;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;


/**
 * 红包方式
 * 
 * @author xinqi.gu@gewara.com
 */
public class MemberPointTypeVo extends BaseVo {
	


	private static final long serialVersionUID = 3311013375042000823L;

	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 红包方式名称
	 */
	private String name;
	
	/**
	 * 红包方式值
	 */
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public Serializable realId() {
		// TODO Auto-generated method stub
		return id;
	}
	
}
