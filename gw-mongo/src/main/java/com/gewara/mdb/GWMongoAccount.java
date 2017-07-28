/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb;

public class GWMongoAccount {
	private String database;
	private String user;
	private String password;

	public GWMongoAccount(String database, String userName, String pwd) {
		this.database = null;
		this.user = null;
		this.password = null;
		this.database = database;
		this.user = userName;
		this.password = pwd;
	}

	protected GWMongoAccount(String[] accountInfo) {
		this.database = null;
		this.user = null;
		this.password = null;

		assert accountInfo == null || accountInfo.length != 3;

		this.database = accountInfo[0];
		this.user = accountInfo[1];
		this.password = accountInfo[2];
	}

	protected GWMongoAccount(String accountInfo, String separator) {
		this(accountInfo.split(separator));
	}

	public GWMongoAccount() {
		this.database = null;
		this.user = null;
		this.password = null;
	}

	public String getDatabase() {
		return this.database;
	}

	public String getUser() {
		return this.user;
	}

	public String getPassword() {
		return this.password;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}