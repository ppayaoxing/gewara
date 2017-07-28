/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.comment;

import com.gewara.api.sns.constant.AddressConstant;
import com.gewara.api.sns.vo.comment.CommentBaseVo;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class CommentVo extends CommentBaseVo {
	private static final long serialVersionUID = 1L;
	public static final String RECOMMEND_TAG_D = "D";
	public static final String RECOMMEND_TAG_N = "N";
	public static final String RECOMMEND_TAG_Z = "Z";
	public static final String RECOMMEND_TAG_H = "H";
	public static final String RECOMMEND_TAG_X = "X";
	public static final String RECOMMEND_TAG_W = "W";
	public static final String RECOMMEND_TAG_Y = "Y";
	public static final String RECOMMEND_TAG_R = "R";
	public static final String OHTERINFO_RECOMMEND_TAG = "recommendTag";

	public CommentVo() {
	}

	public CommentVo(Long memberId) {
		this.memberid = memberId;
		this.transfercount = Integer.valueOf(0);
		this.replycount = Integer.valueOf(0);
		this.flowernum = Integer.valueOf(0);
		this.status = "Y_NEW";
		this.address = "web";
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

	public String getFromFlag2() {
		String str = (String) AddressConstant.addressMap.get(this.address);
		return StringUtils.equals(str, "手机短信") ? "手机" : str;
	}
}