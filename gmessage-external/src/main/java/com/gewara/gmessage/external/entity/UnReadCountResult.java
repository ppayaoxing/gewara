/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.gmessage.external.entity;

import java.io.Serializable;

public class UnReadCountResult implements Serializable {
	private static final long serialVersionUID = -1345047719020144850L;
	private String userID = null;

	private long system = 0L;
	private long interaction = 0L;
	private long instant = 0L;
	private long recommend = 0L;
	private long comment = 0L;
	private ReceiverMessage systemReceiverMessage;
	private ReceiverMessage interactionReceiverMessage;
	private ReceiverMessage instantReceiverMessage;
	private ReceiverMessage recommendReceiverMessage;
	private ReceiverMessage commentReceiverMessage;

	public UnReadCountResult(String userID) {
		this.userID = userID;
	}

	public UnReadCountResult() {
	}

	public UnReadCountResult(String userID, long system, long interaction, long instant) {
		this.userID = userID;
		this.system = system;
		this.interaction = interaction;
		this.instant = instant;

		if (this.system < 0L)
			this.system = 0L;
		if (this.interaction < 0L)
			this.interaction = 0L;
		if (this.instant < 0L)
			this.instant = 0L;
		if (this.recommend < 0L)
			this.recommend = 0L;
		if (this.comment >= 0L)
			return;
		this.comment = 0L;
	}

	public long getComment() {
		return this.comment;
	}

	public void setComment(long comment) {
		this.comment = comment;
	}

	public ReceiverMessage getSystemReceiverMessage() {
		return this.systemReceiverMessage;
	}

	public void setSystemReceiverMessage(ReceiverMessage systemReceiverMessage) {
		this.systemReceiverMessage = systemReceiverMessage;
	}

	public ReceiverMessage getCommentReceiverMessage() {
		return this.commentReceiverMessage;
	}

	public void setCommentReceiverMessage(ReceiverMessage commentReceiverMessage) {
		this.commentReceiverMessage = commentReceiverMessage;
	}

	public ReceiverMessage getInteractionReceiverMessage() {
		return this.interactionReceiverMessage;
	}

	public void setInteractionReceiverMessage(ReceiverMessage interactionReceiverMessage) {
		this.interactionReceiverMessage = interactionReceiverMessage;
	}

	public ReceiverMessage getInstantReceiverMessage() {
		return this.instantReceiverMessage;
	}

	public void setInstantReceiverMessage(ReceiverMessage instantReceiverMessage) {
		this.instantReceiverMessage = instantReceiverMessage;
	}

	public ReceiverMessage getRecommendReceiverMessage() {
		return this.recommendReceiverMessage;
	}

	public void setRecommendReceiverMessage(ReceiverMessage recommendReceiverMessage) {
		this.recommendReceiverMessage = recommendReceiverMessage;
	}

	public long getSystem() {
		return this.system;
	}

	public void setSystem(long system) {
		this.system = system;
	}

	public long getInteraction() {
		return this.interaction;
	}

	public void setInteraction(long interaction) {
		this.interaction = interaction;
	}

	public long getInstant() {
		return this.instant;
	}

	public void setInstant(long instant) {
		this.instant = instant;
	}

	public String getUserID() {
		return this.userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public long getRecommend() {
		return this.recommend;
	}

	public void setRecommend(long recommend) {
		this.recommend = recommend;
	}
}