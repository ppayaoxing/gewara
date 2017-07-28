/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.gpticket.vo.command;

import com.gewara.api.vo.BaseVo;
import java.io.Serializable;

public class ReserveVo extends BaseVo {
	private static final long serialVersionUID = 8107672671980762797L;
	private Long id;
	private String dramaid;
	private String barcode;

	public ReserveVo(String dramaid, String barcode) {
		this.dramaid = dramaid;
		this.barcode = barcode;
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDramaid() {
		return this.dramaid;
	}

	public String getBarcode() {
		return this.barcode;
	}
}