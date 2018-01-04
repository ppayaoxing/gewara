package com.gewara.api.sns.vo.comment;

import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.sns.constant.AddressConstant;
import com.gewara.api.sns.constant.Status;

/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28锟斤拷锟斤拷02:05:17
 */
public class CommentVo extends CommentBaseVo {
	private static final long serialVersionUID = 1L;

	

	public static final String RECOMMEND_TAG_D = "D";//锟筋毒锟斤拷
	public static final String RECOMMEND_TAG_N = "N";//锟斤拷锟斤拷锟斤拷
	public static final String RECOMMEND_TAG_Z = "Z";//锟斤拷锟斤拷锟斤拷
	public static final String RECOMMEND_TAG_H = "H";//锟斤拷锟节猴拷
	public static final String RECOMMEND_TAG_X = "X";//锟斤拷犀锟斤拷
	public static final String RECOMMEND_TAG_W = "W";//围锟斤拷
	public static final String RECOMMEND_TAG_Y = "Y";//锟矫帮拷锟斤拷
	public static final String RECOMMEND_TAG_R = "R";//wenner
	public static final String OHTERINFO_RECOMMEND_TAG = "recommendTag";//围锟斤拷
	
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
		if(StringUtils.equals(str, "锟街伙拷锟斤拷锟斤拷")) {
            return "锟街伙拷";
        }
		return str;
	}

}
