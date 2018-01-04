package com.gewara.api.sns.vo.bbs;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.sns.constant.AddressConstant;
import com.gewara.api.sns.constant.Status;
import com.gewara.api.vo.BaseVo;
import com.gewara.model.BaseObject;

/**
 *  @function 锟矫伙拷锟斤拷锟斤拷,锟斤拷锟斤拷,bug
 * 	@author bob.hu
 *	@date	2011-03-11 11:00:46
 */
public class CustomerQuestionVo extends BaseVo {
	/***
	 * 权锟斤拷
	 */
	public static final String CustomerPermission = "customer";

	/**
	 *	锟矫伙拷锟斤拷锟绞碉拷锟斤拷锟斤拷 锟斤拷锟斤拷锟斤拷锟斤拷/锟侥斤拷锟斤拷锟斤拷/锟斤拷锟斤拷
	 * 
	 */
	public static final String TAG_EVALUATE = "evaluate"; //锟斤拷锟斤拷锟斤拷锟斤拷
	public static final String TAG_ADVISE = "advise"; //锟侥斤拷锟斤拷锟斤拷
	public static final String TAG_ADVISE_DRAMA = "adviseDrama"; //锟捷筹拷锟斤拷锟斤拷
	public static final String TAG_MOBILE = "mobile";	//锟街伙拷锟酵伙拷锟斤拷
	public static final String TAG_OTHER = "other"; //锟斤拷锟斤拷
	public static final List<String> TAG_LIST = Arrays.asList(new String[]{ "evaluate", "advise", "mobile", "other","adviseDrama"});
	
	/**
	 *  锟斤拷锟斤拷状态 锟斤拷锟斤拷锟�/ 锟窖回革拷/ 锟窖关憋拷
	 * */
	public static final String Y_NEW = "Y_NEW";
	public static final String Y_TREAT = "Y_TREAT";	
	public static final String Y_STOP = "Y_STOP";
	
	public static final String N_DELETE = "N_DELETE";
	public static final String N_FILTER = "N_FILTER";
	
	private Long id;
	private Long memberid;
	private String membername;
	private String email;
	private String body;
	private Timestamp addtime;
	private String tag;
	private String status;
	private String type;
	private Timestamp updatetime;
	private String citycode;
	private BaseObject member;
	private String feedbackType;//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
	
	private static final long serialVersionUID = 1365933982357637583L;

	public CustomerQuestionVo(){}
	
	public CustomerQuestionVo(String email) {
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.updatetime = addtime;
		this.status = Status.Y_NEW;
		this.email = email;
		this.type = AddressConstant.ADDRESS_WEB;
		this.feedbackType="other";
	}
	@Override
	public Serializable realId() {
		return id;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public BaseObject getMember() {
		return member;
	}

	public void setMember(BaseObject member) {
		this.member = member;
	}
	
	public String getStatusText(){
		if(StringUtils.equals(status, Y_NEW)) {
            return "锟斤拷锟截革拷";
        }
		if(StringUtils.equals(status, Y_TREAT)) {
            return "锟窖回革拷";
        }
		if(StringUtils.equals(status, Y_STOP)) {
            return "锟窖关憋拷";
        }
		return "锟斤拷锟截革拷";
	}
	
	public String getFromFlag(){
		String stype = StringUtils.lowerCase(this.type);
		return AddressConstant.addressMap.get(stype);
	}
	
	public boolean getPic() {// 锟斤拷锟斤拷图片
		return StringUtils.contains(this.body, "<img");
	}
	public String getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}
}
