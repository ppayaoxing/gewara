package com.gewara.gmessage.external.constant;

public enum MType {
	CINEMA(11),
	DRAMA(12),
	SPORT(13),
	OTHER(99);
	
	private int value=0;
	
	private MType(int v){
		this.value=v;
	}
	
	public static MType valueOf(int value){
		switch(value){
		case 1:return CINEMA;
		case 2:return DRAMA;
		case 3:return SPORT;
		case 99:return OTHER;
		}
		return null;
	}
	
	public int value(){
		return this.value;
	}
	
}
