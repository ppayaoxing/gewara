/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mongo.support;

import com.mongodb.MongoCredential;
import org.springframework.beans.factory.config.AbstractFactoryBean;

public class MongoAuthBean extends AbstractFactoryBean<MongoCredential> {
	public String userName;
	public String password;
	public String database;

	public Class<?> getObjectType() {
		return MongoCredential.class;
	}

	protected MongoCredential createInstance() throws Exception {
		return MongoCredential.createCredential(this.userName, this.database, this.password.toCharArray());
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
}