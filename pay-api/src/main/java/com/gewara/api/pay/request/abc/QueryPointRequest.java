package com.gewara.api.pay.request.abc;

import java.util.Map;

public class QueryPointRequest extends AbcRequest{

	private static final long serialVersionUID = 556251408350901842L;

	/**
	 * ����
	 */
	private String cardno;
	
	/**
	 * ����Ч��
	 */
	private String cardexp;
	
	/**
	 * У����
	 */
	private String adddata;

	public QueryPointRequest(){}
	
	public QueryPointRequest(String orderid, String cardno, String cardexp, String adddata){
		super(orderid);
		this.cardno = cardno;
		this.cardexp = cardexp;
		this.adddata = adddata;
	}
	
	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = super.getTextParams();
		params.put("cardno", cardno);
		params.put("cardexp", cardexp);
		params.put("adddata", adddata);
		return params;
	}

	@Override
	public boolean checkParams() {
		if(!super.checkParams()) {
            return false;
        }
		
		if(cardno==null || cardno.length()>=20) {
            return false;
        }
		if(cardexp==null || cardexp.length()!=4) {
            return false;
        }
		if(adddata==null || adddata.length()!=3) {
            return false;
        }
		return true;
	}

}
