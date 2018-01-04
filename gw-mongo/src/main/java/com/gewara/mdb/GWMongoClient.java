package com.gewara.mdb;

import java.util.ArrayList;
import java.util.List;

import com.gewara.mdb.builder.MongoAdmin;
import com.gewara.mdb.config.GwMongoClientOptions;
import com.mongodb.DB;
import com.mongodb.client.MongoDatabase;

/**
 * 封装了MongoClient。
 * GWMongoClient支持多数据库操作。 
 * 切换数据库用请使用GWMongoClient的useDatabase方法来获取一个GWMongoClient的新的实例。
 * 
 * @author 董明
 * @createDate 2015年9月6日
 */
public class GWMongoClient {
	private final MongoReplicateInfo _mongo=new MongoReplicateInfo();
	/*只有当前数据库和具体实例相关*/
	private MongoDatabase currentDB=null;

	/**
	 * 构建mongo client
	 * @param hosts mongo服务器IP列表。格式为ip:port
	 * @param accounts mongo服务的数据库账户。
	 * @param options  mongo客户端属性设置
	 * @param mechanism mongo的权限验证策略。其值只支持： cr,plain,sha1三种方式。不设置，使用服务器默认配置。
	 */
	public GWMongoClient(List<String> hosts, List<GWMongoAccount> accounts, GwMongoClientOptions options,String mechanism){
		_mongo.initMongoClient(hosts,accounts,options,mechanism);
		this.currentDB=_mongo.getDefaultMongoDatabase();
	}
	
	public GWMongoClient(GwMongoClientOptions options,String mechanism,List<HostInfo> hosts, List<GWMongoAccount> accounts){
		_mongo.initMongoClient(options,mechanism,hosts,accounts);
		this.currentDB=_mongo.getDefaultMongoDatabase();
	}
	
	/**使用默认的认证配置登录
	 * @param hosts
	 * @param accounts 格式为： db:user:pwd
	 * @param options
	 */
	public GWMongoClient(List<String> hosts, List<String> accounts, GwMongoClientOptions options){
		List<GWMongoAccount> accountList=new ArrayList<>(accounts.size());
		for(String account:accounts){
			accountList.add(new GWMongoAccount(account,":"));
		}
		_mongo.initMongoClient(hosts,accountList,options,null);//静态信息。
		this.currentDB=_mongo.getDefaultMongoDatabase();
	}
	
	/**
	 * 使用默认配置，默认认证方式初始化mongoClient
	 * @param hosts
	 * @param accounts
	 */
	public GWMongoClient(List<String> hosts,List<String> accounts){
		this(hosts,accounts,null);
	}
	
	/**
	 * 返回GWMongoClient实例的当前操作的数据库
	 * @return
	 */
	public MongoDatabase prepareDatabase(){
		return this.currentDB;
	}
	
	public MongoAdmin admin(){
		return new MongoAdmin(_mongo.getMongoDatabases(),_mongo.getHosts());
	}
	
	/**
	 * 返回GWMongoClient实例中指定的数据库
	 * @param databaseName
	 * @return 指定的数据库如果不存在，则返回null。 只支持在配置文件中注册的数据库。
	 */
	public MongoDatabase prepareDatabase(String databaseName){
		return _mongo.getMongoDatabase(databaseName);
	}

	@Deprecated
	public DB prepareDB(){
		return _mongo.getMongoDB(this.currentDB.getName());
	}


}
