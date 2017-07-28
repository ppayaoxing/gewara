/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb;

import com.gewara.mdb.GWMongoAccount;
import com.gewara.mdb.HostInfo;
import com.gewara.mdb.MongoReplicateInfo;
import com.gewara.mdb.builder.MongoAdmin;
import com.gewara.mdb.config.GwMongoClientOptions;
import com.mongodb.DB;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GWMongoClient {
	private final MongoReplicateInfo _mongo;
	private MongoDatabase currentDB;

	public GWMongoClient(List<String> hosts, List<GWMongoAccount> accounts, GwMongoClientOptions options,
			String mechanism) {
		this._mongo = new MongoReplicateInfo();
		this.currentDB = null;
		this._mongo.initMongoClient(hosts, accounts, options, mechanism);
		this.currentDB = this._mongo.getDefaultMongoDatabase();
	}

	public GWMongoClient(GwMongoClientOptions options, String mechanism, List<HostInfo> hosts,
			List<GWMongoAccount> accounts) {
		this._mongo = new MongoReplicateInfo();
		this.currentDB = null;
		this._mongo.initMongoClient(options, mechanism, hosts, accounts);
		this.currentDB = this._mongo.getDefaultMongoDatabase();
	}

	public GWMongoClient(List<String> hosts, List<String> accounts, GwMongoClientOptions options) {
		this._mongo = new MongoReplicateInfo();
		this.currentDB = null;
		ArrayList accountList = new ArrayList(accounts.size());
		Iterator arg4 = accounts.iterator();

		while (arg4.hasNext()) {
			String account = (String) arg4.next();
			accountList.add(new GWMongoAccount(account, ":"));
		}

		this._mongo.initMongoClient(hosts, accountList, options, (String) null);
		this.currentDB = this._mongo.getDefaultMongoDatabase();
	}

	public GWMongoClient(List<String> hosts, List<String> accounts) {
		this(hosts, accounts, (GwMongoClientOptions) null);
	}

	public MongoDatabase prepareDatabase() {
		return this.currentDB;
	}

	public MongoAdmin admin() {
		return new MongoAdmin(this._mongo.getMongoDatabases(), this._mongo.getHosts());
	}

	public MongoDatabase prepareDatabase(String databaseName) {
		return this._mongo.getMongoDatabase(databaseName);
	}

	@Deprecated
	public DB prepareDB() {
		return this._mongo.getMongoDB(this.currentDB.getName());
	}
}