package com.gewara.support;

public class StaleLocalObjectException extends RuntimeException{
	public StaleLocalObjectException(){
		super("local cached object cannot be saved!!");
	}
	private static final long serialVersionUID = 3545743639343281548L;

}
