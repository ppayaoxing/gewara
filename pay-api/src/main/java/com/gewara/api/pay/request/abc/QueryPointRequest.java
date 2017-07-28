/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.pay.request.abc;

import com.gewara.api.pay.request.abc.AbcRequest;
import java.util.Map;

public class QueryPointRequest extends AbcRequest {
	private static final long serialVersionUID = 556251408350901842L;
	private String cardno;
	private String cardexp;
	private String adddata;

	public QueryPointRequest() {
	}

	public QueryPointRequest(String orderid, String cardno, String cardexp, String adddata) {
		super(orderid);
		this.cardno = cardno;
		this.cardexp = cardexp;
		this.adddata = adddata;
	}

	public Map<String, String> getTextParams() {
		Map params = super.getTextParams();
		params.put("cardno", this.cardno);
		params.put("cardexp", this.cardexp);
		params.put("adddata", this.adddata);
		return params;
	}

	public boolean checkParams() {
		return !super.checkParams() ? false
				: (this.cardno != null && this.cardno.length() < 20
						? (this.cardexp != null && this.cardexp.length() == 4
								? this.adddata != null && this.adddata.length() == 3 : false)
						: false);
	}
}