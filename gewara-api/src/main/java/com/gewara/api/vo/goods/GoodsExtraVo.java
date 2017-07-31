package com.gewara.api.vo.goods;

import java.io.Serializable;
import java.sql.Timestamp;

import com.gewara.api.vo.BaseVo;

public class GoodsExtraVo extends BaseVo {

	private static final long serialVersionUID = 8621222313371273059L;

	private Long goodsid;
	private String msgbefore;				//活动开始前短信提醒内容
	private String msgpro;					//拼团活动升级短信提醒内容
	private String msgafter;				//拼团活动满团短信提醒内容
	private String msgover;					//拼团活动结束短信提醒内容
	private String restriction;			//活动限制
	private String timeexp;					//时间说明
	private String rule;						//活动规则
	private String otherexp;				//其它说明
	private String department;				//需求部门
	private String appPresaleName;		//APP按钮的名称
	private String subsidyUnit;			//补贴单位：order, quantity
	private Integer subsidyMoney;			//补贴金额
	private String preType;					//扩展类型，T演出团销
	private Integer hintnum;				//实际预约提醒短信数量
	private Integer defnum;					//虚拟已售出数量 --->wantedBuyNum
	private Integer defSalesnum;			//虚拟已售初始值inventedHaveSalesInitNum
	private Integer defTotalnum;			//虚拟总数量--->inventedTotalNum
	private String otherinfo;		
	
	private Timestamp addtime;
	private Timestamp updatetime;
	
	public GoodsExtraVo(){
		
	}
	
	@Override
	public Serializable realId() {
		return goodsid;
	}

	public Long getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public String getMsgbefore() {
		return msgbefore;
	}

	public void setMsgbefore(String msgbefore) {
		this.msgbefore = msgbefore;
	}

	public String getRestriction() {
		return restriction;
	}

	public String getAppPresaleName() {
		return appPresaleName;
	}

	public void setAppPresaleName(String appPresaleName) {
		this.appPresaleName = appPresaleName;
	}

	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}

	public String getTimeexp() {
		return timeexp;
	}

	public void setTimeexp(String timeexp) {
		this.timeexp = timeexp;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getOtherexp() {
		return otherexp;
	}

	public void setOtherexp(String otherexp) {
		this.otherexp = otherexp;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSubsidyUnit() {
		return subsidyUnit;
	}

	public void setSubsidyUnit(String subsidyUnit) {
		this.subsidyUnit = subsidyUnit;
	}

	public Integer getSubsidyMoney() {
		return subsidyMoney;
	}

	public void setSubsidyMoney(Integer subsidyMoney) {
		this.subsidyMoney = subsidyMoney;
	}

	public Integer getHintnum() {
		return hintnum;
	}

	public void setHintnum(Integer hintnum) {
		this.hintnum = hintnum;
	}

	public Integer getDefnum() {
		return defnum;
	}

	public void setDefnum(Integer defnum) {
		this.defnum = defnum;
	}

	public Integer getDefSalesnum() {
		return defSalesnum;
	}

	public void setDefSalesnum(Integer defSalesnum) {
		this.defSalesnum = defSalesnum;
	}

	public Integer getDefTotalnum() {
		return defTotalnum;
	}

	public void setDefTotalnum(Integer defTotalnum) {
		this.defTotalnum = defTotalnum;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getOtherinfo() {
		return otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getPreType() {
		return preType;
	}

	public void setPreType(String preType) {
		this.preType = preType;
	}

	public String getMsgpro() {
		return msgpro;
	}

	public void setMsgpro(String msgpro) {
		this.msgpro = msgpro;
	}

	public String getMsgafter() {
		return msgafter;
	}

	public void setMsgafter(String msgafter) {
		this.msgafter = msgafter;
	}

	public String getMsgover() {
		return msgover;
	}

	public void setMsgover(String msgover) {
		this.msgover = msgover;
	}

}
