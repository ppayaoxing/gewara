package com.gewara.api.pay.request.abc;

import java.util.Map;

public class MoneyAndPointPayRequest extends AbcRequest {

	private static final long serialVersionUID = 7814516839886229493L;

	private String cardno;// 锟斤拷锟阶匡拷锟斤拷
	private String cardexp;// 锟斤拷锟斤拷效锟斤拷
	private String adddata;// CVD2
	private Integer amount;// 锟斤拷锟阶斤拷锟�
	private Integer point;// 锟斤拷锟斤拷
	private Integer totalAmount;//锟斤拷锟斤拷锟杰斤拷锟�
	private String checkcode;// 锟斤拷证锟斤拷
	private String pointflag;// 锟斤拷锟街憋拷识  0: 锟斤拷使锟矫伙拷锟斤拷 1:使锟矫伙拷锟斤拷

	public MoneyAndPointPayRequest() {
	}

	public MoneyAndPointPayRequest(String orderid, String cardno, String cardexp, String adddata, Integer amount, Integer point, Integer totalAmount, String checkcode,
			String pointflag) {
		super(orderid);
		this.cardno = cardno;
		this.cardexp = cardexp;
		this.adddata = adddata;
		this.amount = amount;
		this.point = point;
		this.totalAmount = totalAmount;
		this.checkcode = checkcode;
		this.pointflag = pointflag;
	}

	@Override
	public Map<String, String> getTextParams() {
		Map<String, String> params = super.getTextParams();
		params.put("cardno", cardno);
		params.put("cardexp", cardexp);
		params.put("adddata", adddata);
		params.put("amount", String.valueOf(amount));
		params.put("point", String.valueOf(point));
		params.put("totalamount", String.valueOf(totalAmount));
		params.put("checkcode", checkcode);
		params.put("pointflag", pointflag);
		return params;
	}

	@Override
	public boolean checkParams() {
		if (!super.checkParams()) {
            return false;
        }

		if (cardno == null || cardno.length() >= 20) {
            return false;
        }
		if (cardexp == null || cardno.length() == 4) {
            return false;
        }
		if (adddata == null || adddata.length() != 3) {
            return false;
        }
		if (checkcode == null || checkcode.length() != 6) {
            return false;
        }
		if (totalAmount == null || totalAmount <= 0) {
            return false;
        }
		if (pointflag == null) {
			return false;
		} else {// 0: 锟斤拷使锟矫伙拷锟斤拷 1:使锟矫伙拷锟斤拷
			if ("1".equals(pointflag)) {
				if (point == null || point <= 0) {
					return false;
				}
			} else {
				if (amount == null || amount <= 0) {
					return false;
				}
			}
		}
		return true;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCardexp() {
		return cardexp;
	}

	public void setCardexp(String cardexp) {
		this.cardexp = cardexp;
	}

	public String getAdddata() {
		return adddata;
	}

	public void setAdddata(String adddata) {
		this.adddata = adddata;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	public String getPointflag() {
		return pointflag;
	}

	public void setPointflag(String pointflag) {
		this.pointflag = pointflag;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

}
