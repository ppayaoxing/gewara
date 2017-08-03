package com.gewara.gmessage.external.constant;

public enum MCategory{
	/**系统*/
	SYS(1),
	
	/**互动*/
	INTERACT(2),
	
	/**即时*/
	INSTANT(3),
	
	/**推荐*/
	RECOMMEND(4),
	
	/**评论*/
	COMMENT(5);
	
	private int value=0;
	private MCategory(int value){
		this.value=value;
	}
	
	public int value(){
		return this.value;
	}
	
	public static MCategory valueOf(int value){
		switch(value){
			case 1:return SYS;
			case 2:return INTERACT;
			case 3:return INSTANT;
			case 4:return RECOMMEND;
			case 5:return COMMENT;
		}
		return null;
	}
}
