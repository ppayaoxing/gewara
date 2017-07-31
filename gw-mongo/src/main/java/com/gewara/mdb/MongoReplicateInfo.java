package com.gewara.mdb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gewara.mdb.config.GwMongoClientOptions;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

final class MongoReplicateInfo {
	private  Logger logger = LoggerFactory.getLogger(MongoReplicateInfo.class);
	private  MongoClient _mongoClient;
	private  List<String> _dblist=null;
	private  Map<String,MongoDatabase> _mdatabases=new LinkedHashMap<>();
	private  List<HostInfo> hosts = new ArrayList<>(0);//集群中每台机器
	
	/**
	 * 初始化mongoClient。
	 * 这里初始化的都是静态变量。
	 * @param hosts1
	 * @param accounts
	 * @param options
	 * @param mechanism
	 */
	protected  void initMongoClient(List<String> hosts1, List<GWMongoAccount> accounts, GwMongoClientOptions options,String mechanism){
		List<HostInfo> hostList=new ArrayList<HostInfo>(hosts1.size());
		for (String host : hosts1) {
			hostList.add(new HostInfo(host));
		}
		initMongoClient(options,mechanism,hostList,accounts);
	}
	
	
	/**
	 * 初始化mongoClient。
	 * 这里初始化的都是静态变量。
	 * @param hosts1
	 * @param accounts
	 * @param options
	 * @param mechanism
	 */
	protected synchronized  void initMongoClient(GwMongoClientOptions options,String mechanism, List<HostInfo> hosts1, List<GWMongoAccount> accounts){
		if(_mongoClient!=null){
			logger.warn("MongoClient已经被初始化，请不要重复！(本次初始化要求已被忽略)");
			return;
		}
		
		if(mechanism==null) mechanism="default";
		
		this.hosts=Collections.unmodifiableList(hosts1);
		
		List<ServerAddress> hostList = new ArrayList<ServerAddress>(hosts1.size());
		for (HostInfo host : hosts1) {
			hostList.add(new ServerAddress(host.getIp(),host.getPort()));
		}
		
		_dblist=new ArrayList<String>(accounts.size());
		List<MongoCredential> mcs = new ArrayList<MongoCredential>(accounts.size());
		for(GWMongoAccount account:accounts){
			_dblist.add(account.getDatabase());
			MongoCredential mc=null;
			switch(mechanism){
				case "cr":mc=MongoCredential.createMongoCRCredential(account.getUser(),account.getDatabase(), account.getPassword().toCharArray());break;
				case "plain":mc=MongoCredential.createPlainCredential(account.getUser(),account.getDatabase(), account.getPassword().toCharArray());break;
				case "sha1":mc=MongoCredential.createScramSha1Credential(account.getUser(),account.getDatabase(), account.getPassword().toCharArray());break;
				default:
					mc=MongoCredential.createCredential(account.getUser(),account.getDatabase(), account.getPassword().toCharArray());
			}
			mcs.add(mc);
		}
		if(options==null) options=new GwMongoClientOptions();
		MongoClientOptions mcOptions=options.toMongoClientOptions();
		_mongoClient=new  MongoClient(hostList, mcs, mcOptions);
		for(String dbName:_dblist){
			MongoDatabase mdb=_mongoClient.getDatabase(dbName);
			_mdatabases.put(dbName,mdb);
		}
	}
	
	/**
	 * 返回某个集群的所有机器信息
	 * @param replicate
	 * @return
	 */
	protected Collection<HostInfo> getHosts(){
		return this.hosts;
	}
	
	protected  MongoDatabase getMongoDatabase(String databaseName){
		return _mdatabases.get(databaseName);
	}
	
	protected  Collection<MongoDatabase> getMongoDatabases(){
		return _mdatabases.values();
	}
	
	protected  MongoDatabase getDefaultMongoDatabase(){
		return _mdatabases.get(_dblist.get(0));
	}
	
	@Deprecated
	protected  DB getMongoDB(String databaseName){
		return _mongoClient.getDB(databaseName);
	}
	
	protected  void destory(){
		//TODO;
	}
}
