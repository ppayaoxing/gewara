
package com.gewara.gmessage.external.entity;

import java.io.Serializable;
/**
 * 未读消息统计
 *
 */
public class UnReadCountResult implements Serializable {

	private static final long serialVersionUID = -1345047719020144850L;
	private String userID=null; 
	
	private long system=0;
	private long interaction=0;
	private long instant=0;
	private long recommend=0;
	private long comment=0;
	
	private ReceiverMessage systemReceiverMessage;
	private ReceiverMessage interactionReceiverMessage;
	private ReceiverMessage instantReceiverMessage;
	private ReceiverMessage recommendReceiverMessage;
	private ReceiverMessage commentReceiverMessage;
	
	public UnReadCountResult(String userID){
		this.userID=userID;
	}
	
	public UnReadCountResult(){}
	
	public UnReadCountResult(String userID,long system,long interaction,long instant){
		this.userID=userID;
		this.system=system;
		this.interaction=interaction;
		this.instant=instant;
		
		if(this.system<0) this.system=0;
		if(this.interaction<0) this.interaction=0;
		if(this.instant<0) this.instant=0;
		if(this.recommend<0) this.recommend=0;
		if(this.comment<0) this.comment=0;
	}
	
	public long getComment() {
		return comment;
	}

	public void setComment(long comment) {
		this.comment = comment;
	}

	public ReceiverMessage getSystemReceiverMessage() {
		return systemReceiverMessage;
	}

	public void setSystemReceiverMessage(ReceiverMessage systemReceiverMessage) {
		this.systemReceiverMessage = systemReceiverMessage;
	}

	public ReceiverMessage getCommentReceiverMessage() {
		return commentReceiverMessage;
	}

	public void setCommentReceiverMessage(ReceiverMessage commentReceiverMessage) {
		this.commentReceiverMessage = commentReceiverMessage;
	}

	public ReceiverMessage getInteractionReceiverMessage() {
		return interactionReceiverMessage;
	}

	public void setInteractionReceiverMessage(ReceiverMessage interactionReceiverMessage) {
		this.interactionReceiverMessage = interactionReceiverMessage;
	}

	public ReceiverMessage getInstantReceiverMessage() {
		return instantReceiverMessage;
	}

	public void setInstantReceiverMessage(ReceiverMessage instantReceiverMessage) {
		this.instantReceiverMessage = instantReceiverMessage;
	}

	public ReceiverMessage getRecommendReceiverMessage() {
		return recommendReceiverMessage;
	}

	public void setRecommendReceiverMessage(ReceiverMessage recommendReceiverMessage) {
		this.recommendReceiverMessage = recommendReceiverMessage;
	}

	public long getSystem() {
		return system;
	}
	public void setSystem(long system) {
		this.system = system;
	}
	
	/**互动消息*/
	public long getInteraction() {
		return interaction;
	}
	
	public void setInteraction(long interaction) {
		this.interaction = interaction;
	}
	
	/**即时消息*/
	public long getInstant() {
		return instant;
	}
	public void setInstant(long instant) {
		this.instant = instant;
	}
	
	/**用户ID*/
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public long getRecommend() {
		return recommend;
	}

	public void setRecommend(long recommend) {
		this.recommend = recommend;
	}
}
