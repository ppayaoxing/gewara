package com.gewara.api.test;

import java.io.Serializable;

public class TestObject implements Serializable {
	private static final long serialVersionUID = 6572240613657862880L;
	private String body;
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
}
