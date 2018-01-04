package com.gewara.ucenter.vo.member;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

@Deprecated
public class DuiBaOrderInfoVo extends BaseVo{
	private static final long serialVersionUID = 5077150442927561935L;
	private String id;
	private String memberId;
	private String credits;		//本次兑换用户所消耗的积分数
	private String description;	//本次积分消耗的描述
	private String orderNum;	//兑吧订单号(请记录到数据库中)
	private String type;		//兑换类型:Alipay(支付宝),QB(Q币),Coupon(优惠券),Object(实物),Phonebill(话费),PhoneFlow(流量),Virtual(虚拟商品),Turntable(大转盘),SingleLottery(单品抽奖) 所有类型不区分大小写
	private String facePrice;	//兑换商品的市场价值，单位是分
	private String actualPrice;	//此次兑换实际扣除开发者账户费用，单位为分
	private String ip;			//用户ip
	private String waitAudit;	//是否需要审核
	private String params;		//额外参数，不同的类型，返回不同的内容，中间用英文冒号分隔。(支付宝类型带中文，请用utf-8进行解码)实物商品：返回收货信息(姓名:手机号:省份:城市:区域:详细地址)支付宝：返回账号信息(支付宝账号:实名)话费：返回手机号QB：返回QQ号
	private String pointId;
	private String result;		//此次兑换是否成功：fail：失败；success：成功；processing：处理中；
	private Integer notifyCount;//通知次数
	private Timestamp addtime;	//添加时间
	@Override
	public Serializable realId() {		
		return id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFacePrice() {
		return facePrice;
	}
	public void setFacePrice(String facePrice) {
		this.facePrice = facePrice;
	}
	public String getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(String actualPrice) {
		this.actualPrice = actualPrice;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getWaitAudit() {
		return waitAudit;
	}
	public void setWaitAudit(String waitAudit) {
		this.waitAudit = waitAudit;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getPointId() {
		return pointId;
	}
	public void setPointId(String pointId) {
		this.pointId = pointId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getNotifyCount() {
		return notifyCount;
	}
	public void setNotifyCount(Integer notifyCount) {
		this.notifyCount = notifyCount;
	}
	public Timestamp getAddtime() {
		return addtime;
	}
	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

}
