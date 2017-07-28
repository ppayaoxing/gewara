/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.vo.comment;

import com.gewara.api.sns.vo.comment.CommentBaseVo;
import java.sql.Timestamp;

public class CommentHistVo extends CommentBaseVo {
	private static final long serialVersionUID = 1L;

	public CommentHistVo() {
	}

	public CommentHistVo(Long memberid) {
		this.memberid = memberid;
		this.transfercount = Integer.valueOf(0);
		this.replycount = Integer.valueOf(0);
		this.flowernum = Integer.valueOf(0);
		this.status = "Y_NEW";
		this.address = "web";
		this.addtime = new Timestamp(System.currentTimeMillis());
	}

	public CommentHistVo(Long memberid, String tag, Long relatedId, String body) {
		this(memberid);
		this.tag = tag;
		this.relatedid = relatedId;
		this.body = body;
	}

	public CommentHistVo(Long memberid, String tag, Long relatedId, String body, String picturename, String link) {
		this(memberid);
		this.tag = tag;
		this.relatedid = relatedId;
		this.body = body;
		this.picturename = picturename;
		this.link = link;
	}
}