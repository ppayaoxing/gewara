package com.gewara.weixin.friendcard;

import java.io.Serializable;
import java.util.List;

public class CashAdvancedInfo implements Serializable{
	private static final long serialVersionUID = 8502018749523012364L;
	//private Integer consume_share_self_num;			//核销后送券的数量，可设置核销后送本卡券的数量，限制传入1张，与consume_share_card_list字段互斥 
    private Boolean share_friends;					//是否支持分享给朋友使用，填写true优惠券才可被共享 
    private UseCondition use_condition;	//可用范围
    private AdvancedAbstact abstract1;		
    private List<Img2Text> text_image_list;
    public CashAdvancedInfo(){
    	
    }
    public CashAdvancedInfo(UseCondition use_condition, AdvancedAbstact abstract1, List<Img2Text> text_image_list){
    	//this.consume_share_self_num = 1;
    	this.share_friends = true;
    	this.use_condition = use_condition;
    	this.abstract1 = abstract1;
    	this.text_image_list = text_image_list;
    }
	
	public Boolean getShare_friends() {
		return share_friends;
	}
	public void setShare_friends(Boolean share_friends) {
		this.share_friends = share_friends;
	}
	public AdvancedAbstact getAbstract1() {
		return abstract1;
	}
	public void setAbstract1(AdvancedAbstact abstract1) {
		this.abstract1 = abstract1;
	}
	public List<Img2Text> getText_image_list() {
		return text_image_list;
	}
	public void setText_image_list(List<Img2Text> text_image_list) {
		this.text_image_list = text_image_list;
	}
	public UseCondition getUse_condition() {
		return use_condition;
	}
	public void setUse_condition(UseCondition use_condition) {
		this.use_condition = use_condition;
	}
}
