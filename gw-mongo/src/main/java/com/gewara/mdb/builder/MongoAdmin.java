/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.builder;

import com.gewara.mdb.HostInfo;
import com.gewara.mdb.builder.SystemProfileBuilder;
import com.mongodb.client.MongoDatabase;
import java.util.Collection;

public class MongoAdmin {
	private Collection<HostInfo> hosts = null;
	private Collection<MongoDatabase> dbs = null;

	public MongoAdmin(Collection<MongoDatabase> dbs, Collection<HostInfo> hosts) {
		this.hosts = hosts;
		this.dbs = dbs;
	}

	public SystemProfileBuilder prepareSystemProfile() {
		return new SystemProfileBuilder(this.dbs, this.hosts);
	}
}