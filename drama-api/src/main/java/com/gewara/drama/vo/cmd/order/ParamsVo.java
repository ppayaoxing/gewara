/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.vo.cmd.order;

import com.gewara.drama.vo.cmd.order.OrderParamsVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class ParamsVo implements Serializable {
	private static final long serialVersionUID = -7331816234374417793L;
	private OrderParamsVo orderParamsVo;
	private String citycode;
	private Timestamp currentTime;
	private String itemName;
	private String placeName;
	private String countycode;
	private String indexareacode;
	private String order;
	private String classType;
	private int from;
	private int maxnum;
	private Long activityid;
	private List<Long> prizeids;
	private Long prizeid;
	private String tag;
	private String nickname;
	private String invitetype;
	private Boolean validMobile;
	private String mobile;
	private String tradeno;
	private Long memberId;
	private String paymethod;
	private Integer department;
	private boolean notExists;
	protected String merchantNo;
	private String refundOrigin;
	private String merchantCode;

	public String getClassType() {
		return this.classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Timestamp getCurrentTime() {
		return this.currentTime;
	}

	public void setCurrentTime(Timestamp currentTime) {
		this.currentTime = currentTime;
	}

	public OrderParamsVo getOrderParamsVo() {
		return this.orderParamsVo;
	}

	public void setOrderParamsVo(OrderParamsVo orderParamsVo) {
		this.orderParamsVo = orderParamsVo;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPlaceName() {
		return this.placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getCountycode() {
		return this.countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public String getIndexareacode() {
		return this.indexareacode;
	}

	public void setIndexareacode(String indexareacode) {
		this.indexareacode = indexareacode;
	}

	public String getOrder() {
		return this.order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getFrom() {
		return this.from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getMaxnum() {
		return this.maxnum;
	}

	public void setMaxnum(int maxnum) {
		this.maxnum = maxnum;
	}

	public Long getActivityid() {
		return this.activityid;
	}

	public void setActivityid(Long activityid) {
		this.activityid = activityid;
	}

	public List<Long> getPrizeids() {
		return this.prizeids;
	}

	public void setPrizeids(List<Long> prizeids) {
		this.prizeids = prizeids;
	}

	public Long getPrizeid() {
		return this.prizeid;
	}

	public void setPrizeid(Long prizeid) {
		this.prizeid = prizeid;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getInvitetype() {
		return this.invitetype;
	}

	public void setInvitetype(String invitetype) {
		this.invitetype = invitetype;
	}

	public Boolean getValidMobile() {
		return this.validMobile;
	}

	public void setValidMobile(Boolean validMobile) {
		this.validMobile = validMobile;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTradeno() {
		return this.tradeno;
	}

	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}

	public Long getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getPaymethod() {
		return this.paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public Integer getDepartment() {
		return this.department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public boolean isNotExists() {
		return this.notExists;
	}

	public void setNotExists(boolean notExists) {
		this.notExists = notExists;
	}

	public String getMerchantNo() {
		return this.merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getRefundOrigin() {
		return this.refundOrigin;
	}

	public void setRefundOrigin(String refundOrigin) {
		this.refundOrigin = refundOrigin;
	}

	public String getMerchantCode() {
		return this.merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
}