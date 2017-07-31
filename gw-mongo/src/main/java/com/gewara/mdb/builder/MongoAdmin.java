package com.gewara.mdb.builder;

import java.util.Collection;

import com.gewara.mdb.HostInfo;
import com.mongodb.client.MongoDatabase;

public class MongoAdmin {	
	private Collection<HostInfo> hosts=null;
	private Collection<MongoDatabase> dbs=null;
	
	public MongoAdmin(Collection<MongoDatabase> dbs,Collection<HostInfo> hosts){
		this.hosts=hosts;
		this.dbs=dbs;
	}
	
	public  SystemProfileBuilder prepareSystemProfile(){
		return new SystemProfileBuilder(dbs,hosts);
	}
}
