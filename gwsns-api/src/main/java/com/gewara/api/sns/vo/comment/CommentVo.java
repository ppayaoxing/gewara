package com.gewara.api.sns.vo.comment;

import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.sns.constant.AddressConstant;
import com.gewara.api.sns.constant.Status;

/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28下午02:05:17
 */
public class CommentVo extends CommentBaseVo {
	private static final long serialVersionUID = 1L;

	

	public static final String RECOMMEND_TAG_D = "D";//最毒舌
	public static final String RECOMMEND_TAG_N = "N";//最逆天
	public static final String RECOMMEND_TAG_Z = "Z";//最争议
	public static final String RECOMMEND_TAG_H = "H";//最内涵
	public static final String RECOMMEND_TAG_X = "X";//最犀利
	public static final String RECOMMEND_TAG_W = "W";//围观
	public static final String RECOMMEND_TAG_Y = "Y";//好榜样
	public static final String RECOMMEND_TAG_R = "R";//wenner
	public static final String OHTERINFO_RECOMMEND_TAG = "recommendTag";//围观
	
	public CommentVo() {
	}

	public CommentVo(Long memberId) {
		this.memberid = memberId;
		this.transfercount = 0;
		this.replycount = 0;
		this.flowernum = 0;
		this.status = Status.Y_NEW;
		this.address = AddressConstant.ADDRESS_WEB;
		// this.nickname = member.getNickname();
		this.addtime = new Timestamp(System.currentTimeMillis());
	}

	public CommentVo(Long memberId, String tag, Long relatedId, String body) {
		this(memberId);
		this.tag = tag;
		this.relatedid = relatedId;
		this.body = body;
	}

	public CommentVo(Long memberId, String nickname, String tag, Long relatedId, String body) {
		this(memberId);
		this.nickname = nickname;
		this.tag = tag;
		this.relatedid = relatedId;
		this.body = body;
	}

	public CommentVo(Long memberId, String nickname, String tag, Long relatedId, String body, String picturename,
			String link) {
		this(memberId);
		this.nickname = nickname;
		this.tag = tag;
		this.relatedid = relatedId;
		this.body = body;
		this.picturename = picturename;
		this.link = link;
	}

	public CommentVo(Long memberId, String tag, Long relatedId, String body, String picturename, String link) {
		this(memberId);
		this.tag = tag;
		this.relatedid = relatedId;
		this.body = body;
		this.picturename = picturename;
		this.link = link;
	}
	
	
	
	public String getFromFlag2(){
		String str = AddressConstant.addressMap.get(this.address);
		if(StringUtils.equals(str, "手机短信")) return "手机";
		return str;
	}

}
