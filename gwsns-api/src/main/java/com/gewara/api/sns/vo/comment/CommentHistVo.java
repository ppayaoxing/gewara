package com.gewara.api.sns.vo.comment;

import java.sql.Timestamp;

import com.gewara.api.sns.constant.AddressConstant;
import com.gewara.api.sns.constant.Status;

/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28下午02:05:17
 */
public class CommentHistVo extends CommentBaseVo{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommentHistVo() {}
	
	public CommentHistVo(Long memberid){
		this.memberid =memberid;
		this.transfercount = 0;
		this.replycount = 0;
		this.flowernum = 0;
		this.status = Status.Y_NEW;
		this.address=AddressConstant.ADDRESS_WEB;
		//this.nickname = member.getNickname();
		this.addtime=new Timestamp(System.currentTimeMillis());
	}
	public CommentHistVo(Long memberid, String tag, Long relatedId, String body){
		this(memberid);
		this.tag = tag;
		this.relatedid = relatedId;
		this.body = body;
	}
	
	public CommentHistVo(Long memberid, String tag, Long relatedId, String body, String picturename, String link){
		this(memberid);
		this.tag = tag;
		this.relatedid = relatedId;
		this.body = body;
		this.picturename= picturename;
		this.link = link;
	}
}
