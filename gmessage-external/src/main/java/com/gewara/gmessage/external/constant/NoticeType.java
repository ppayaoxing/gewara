package com.gewara.gmessage.external.constant;

public enum NoticeType {
	/**站内信*/
	WEBSITE(1),
	
	/**短信*/
	SMS(2),
	
	/**push*/
	PUSH(3);
	
	private int value=0;
	private NoticeType(int value){
		this.value=value;
	}
	
	public int value(){
		return this.value;
	}
}
