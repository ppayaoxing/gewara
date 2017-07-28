/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.bbs;

import com.gewara.api.sns.constant.AddressConstant;
import com.gewara.api.vo.BaseVo;
import com.gewara.model.BaseObject;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class CustomerQuestionVo extends BaseVo {
	public static final String CustomerPermission = "customer";
	public static final String TAG_EVALUATE = "evaluate";
	public static final String TAG_ADVISE = "advise";
	public static final String TAG_ADVISE_DRAMA = "adviseDrama";
	public static final String TAG_MOBILE = "mobile";
	public static final String TAG_OTHER = "other";
	public static final List<String> TAG_LIST = Arrays
			.asList(new String[] { "evaluate", "advise", "mobile", "other", "adviseDrama" });
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
	private String feedbackType;
	private static final long serialVersionUID = 1365933982357637583L;

	public CustomerQuestionVo() {
	}

	public CustomerQuestionVo(String email) {
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.updatetime = this.addtime;
		this.status = "Y_NEW";
		this.email = email;
		this.type = "web";
		this.feedbackType = "other";
	}

	public Serializable realId() {
		return this.id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getMembername() {
		return this.membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public BaseObject getMember() {
		return this.member;
	}

	public void setMember(BaseObject member) {
		this.member = member;
	}

	public String getStatusText() {
		return StringUtils.equals(this.status, "Y_NEW") ? "待回复"
				: (StringUtils.equals(this.status, "Y_TREAT") ? "已回复"
						: (StringUtils.equals(this.status, "Y_STOP") ? "已关闭" : "待回复"));
	}

	public String getFromFlag() {
		String stype = StringUtils.lowerCase(this.type);
		return (String) AddressConstant.addressMap.get(stype);
	}

	public boolean getPic() {
		return StringUtils.contains(this.body, "<img");
	}

	public String getFeedbackType() {
		return this.feedbackType;
	}

	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}
}