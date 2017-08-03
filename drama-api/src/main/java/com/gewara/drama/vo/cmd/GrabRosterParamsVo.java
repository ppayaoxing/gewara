package com.gewara.drama.vo.cmd;

import com.gewara.drama.vo.partner.req.PartnerBaseReqVo;


public class GrabRosterParamsVo extends PartnerBaseReqVo {
	private static final long serialVersionUID = -1665911655807876167L;
	private Long memberid;
	private String membername;
	private String membermobile;
	private String mobile;
	private Integer quantity;
	private Long priceid;
	private String origin;
	private String email;
	private String realName;
	private String IDCard;
	private String memberencode;

	public GrabRosterParamsVo() {
	}

	/**
	 * 抢票生成订单，出票（web端）
	 * 
	 * @param memberid
	 * @param mobile
	 * @param quantity
	 * @param priceid
	 * @param origin
	 * @param remoteIp
	 * @param email
	 *           邮箱地址 可选字段
	 * @param realName
	 *           真实姓名 可选字段
	 * @param IDCard
	 *           身份证号码 可选字段
	 */
	public GrabRosterParamsVo(Long memberid, String mobile, Integer quantity, Long priceid, String origin, String remoteIp) {
		this.memberid = memberid;
		this.mobile = mobile;
		this.quantity = quantity;
		this.priceid = priceid;
		this.origin = origin;
		this.remoteIp = remoteIp;

	}

	/**
	 * 
	 * 抢票生成订单，出票（wap端）
	 * @param appkey
	 * @param memberid
	 * @param mobile
	 * @param quantity
	 * @param priceid
	 * @param origin
	 * @param remoteIp
	 * @param email
	 *           邮箱地址 可选字段
	 * @param realName
	 *           真实姓名 可选字段
	 * @param IDCard
	 *           身份证号码 可选字段
	 */
	public GrabRosterParamsVo(String appkey, Long memberid, String mobile, Integer quantity, Long priceid, String origin, String remoteIp) {
		this(memberid, mobile, quantity, priceid, origin, remoteIp);
		this.appkey = appkey;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getPriceid() {
		return priceid;
	}

	public void setPriceid(Long priceid) {
		this.priceid = priceid;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public String getMembermobile() {
		return membermobile;
	}

	public void setMembermobile(String membermobile) {
		this.membermobile = membermobile;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberencode() {
		return memberencode;
	}

	public void setMemberencode(String memberencode) {
		this.memberencode = memberencode;
	}

}
