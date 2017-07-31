package com.gewara.mdb;

public class GWMongoAccount {
	private String database = null;
	private String user = null;
	private String password = null;
	
	public GWMongoAccount(String database,String userName,String pwd){
		this.database=database;
		this.user=userName;
		this.password=pwd;
	}
	
	/**
	 * 该构造方式主要是为了字符串方式构造使用。
	 * 
	 * @param accountInfo  必须长度为3，并且其信息依次为 database,username,password.
	 */
	protected GWMongoAccount(String[] accountInfo){
		assert(accountInfo==null||accountInfo.length!=3);
		this.database=accountInfo[0];
		this.user=accountInfo[1];
		this.password=accountInfo[2];
	}
	
	/**
	 * 该构造方式主要是为了字符串方式构造使用。
	 * 
	 * @param accountInfo  必须长度为3，并且其信息依次为 database,username,password.
	 */
	protected GWMongoAccount(String accountInfo,String separator){
		this(accountInfo.split(separator));
	}
	
	public GWMongoAccount(){}

	public String getDatabase() {
		return database;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
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
