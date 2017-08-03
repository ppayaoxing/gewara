package com.gewara.drama.vo.cmd.order;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class ParamsVo implements Serializable{

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
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public Timestamp getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(Timestamp currentTime) {
		this.currentTime = currentTime;
	}
	public OrderParamsVo getOrderParamsVo() {
		return orderParamsVo;
	}
	public void setOrderParamsVo(OrderParamsVo orderParamsVo) {
		this.orderParamsVo = orderParamsVo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getCountycode() {
		return countycode;
	}
	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}
	public String getIndexareacode() {
		return indexareacode;
	}
	public void setIndexareacode(String indexareacode) {
		this.indexareacode = indexareacode;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(int maxnum) {
		this.maxnum = maxnum;
	}
	public Long getActivityid() {
		return activityid;
	}
	public void setActivityid(Long activityid) {
		this.activityid = activityid;
	}
	public List<Long> getPrizeids() {
		return prizeids;
	}
	public void setPrizeids(List<Long> prizeids) {
		this.prizeids = prizeids;
	}
	public Long getPrizeid() {
		return prizeid;
	}
	public void setPrizeid(Long prizeid) {
		this.prizeid = prizeid;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getInvitetype() {
		return invitetype;
	}
	public void setInvitetype(String invitetype) {
		this.invitetype = invitetype;
	}
	public Boolean getValidMobile() {
		return validMobile;
	}
	public void setValidMobile(Boolean validMobile) {
		this.validMobile = validMobile;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTradeno() {
		return tradeno;
	}
	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public Integer getDepartment() {
		return department;
	}
	public void setDepartment(Integer department) {
		this.department = department;
	}
	public boolean isNotExists() {
		return notExists;
	}
	public void setNotExists(boolean notExists) {
		this.notExists = notExists;
	}
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getRefundOrigin() {
		return refundOrigin;
	}
	public void setRefundOrigin(String refundOrigin) {
		this.refundOrigin = refundOrigin;
	}
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
}
