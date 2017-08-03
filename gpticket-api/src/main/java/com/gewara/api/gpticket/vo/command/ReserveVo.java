package com.gewara.api.gpticket.vo.command;

import java.io.Serializable;

import com.gewara.api.vo.BaseVo;

public class ReserveVo extends BaseVo {

	private static final long serialVersionUID = 8107672671980762797L;

	private Long id;
	private String dramaid;
	private String barcode;
	
	public ReserveVo(String dramaid, String barcode){
		this.dramaid = dramaid;
		this.barcode = barcode;
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

	public String getDramaid() {
		return dramaid;
	}

	public String getBarcode() {
		return barcode;
	}

}
