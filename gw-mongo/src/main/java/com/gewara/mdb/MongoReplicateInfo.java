/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb;

import com.gewara.mdb.GWMongoAccount;
import com.gewara.mdb.HostInfo;
import com.gewara.mdb.config.GwMongoClientOptions;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class MongoReplicateInfo {
	private Logger logger = LoggerFactory.getLogger(MongoReplicateInfo.class);
	private MongoClient _mongoClient;
	private List<String> _dblist = null;
	private Map<String, MongoDatabase> _mdatabases = new LinkedHashMap();
	private List<HostInfo> hosts = new ArrayList(0);

	protected void initMongoClient(List<String> hosts1, List<GWMongoAccount> accounts, GwMongoClientOptions options,
			String mechanism) {
		ArrayList hostList = new ArrayList(hosts1.size());
		Iterator arg5 = hosts1.iterator();

		while (arg5.hasNext()) {
			String host = (String) arg5.next();
			hostList.add(new HostInfo(host));
		}

		this.initMongoClient((GwMongoClientOptions) options, (String) mechanism, (List) hostList, (List) accounts);
	}

	protected synchronized void initMongoClient(GwMongoClientOptions options, String mechanism, List<HostInfo> hosts1,
			List<GWMongoAccount> accounts) {
		if (this._mongoClient != null) {
			this.logger.warn("MongoClient已经被初始化，请不要重复！(本次初始化要求已被忽略)");
		} else {
			if (mechanism == null) {
				mechanism = "default";
			}

			this.hosts = Collections.unmodifiableList(hosts1);
			ArrayList hostList = new ArrayList(hosts1.size());
			Iterator mcs = hosts1.iterator();

			while (mcs.hasNext()) {
				HostInfo mcOptions = (HostInfo) mcs.next();
				hostList.add(new ServerAddress(mcOptions.getIp(), mcOptions.getPort().intValue()));
			}

			this._dblist = new ArrayList(accounts.size());
			ArrayList mcs1 = new ArrayList(accounts.size());

			MongoCredential dbName;
			for (Iterator mcOptions1 = accounts.iterator(); mcOptions1.hasNext(); mcs1.add(dbName)) {
				GWMongoAccount account = (GWMongoAccount) mcOptions1.next();
				this._dblist.add(account.getDatabase());
				dbName = null;
				byte arg10 = -1;
				switch (mechanism.hashCode()) {
				case 3183:
					if (mechanism.equals("cr")) {
						arg10 = 0;
					}
					break;
				case 3528965:
					if (mechanism.equals("sha1")) {
						arg10 = 2;
					}
					break;
				case 106748362:
					if (mechanism.equals("plain")) {
						arg10 = 1;
					}
				}

				switch (arg10) {
				case 0:
					dbName = MongoCredential.createMongoCRCredential(account.getUser(), account.getDatabase(),
							account.getPassword().toCharArray());
					break;
				case 1:
					dbName = MongoCredential.createPlainCredential(account.getUser(), account.getDatabase(),
							account.getPassword().toCharArray());
					break;
				case 2:
					dbName = MongoCredential.createScramSha1Credential(account.getUser(), account.getDatabase(),
							account.getPassword().toCharArray());
					break;
				default:
					dbName = MongoCredential.createCredential(account.getUser(), account.getDatabase(),
							account.getPassword().toCharArray());
				}
			}

			if (options == null) {
				options = new GwMongoClientOptions();
			}

			MongoClientOptions mcOptions2 = options.toMongoClientOptions();
			this._mongoClient = new MongoClient(hostList, mcs1, mcOptions2);
			Iterator account1 = this._dblist.iterator();

			while (account1.hasNext()) {
				String dbName1 = (String) account1.next();
				MongoDatabase mdb = this._mongoClient.getDatabase(dbName1);
				this._mdatabases.put(dbName1, mdb);
			}

		}
	}

	protected Collection<HostInfo> getHosts() {
		return this.hosts;
	}

	protected MongoDatabase getMongoDatabase(String databaseName) {
		return (MongoDatabase) this._mdatabases.get(databaseName);
	}

	protected Collection<MongoDatabase> getMongoDatabases() {
		return this._mdatabases.values();
	}

	protected MongoDatabase getDefaultMongoDatabase() {
		return (MongoDatabase) this._mdatabases.get(this._dblist.get(0));
	}

	@Deprecated
	protected DB getMongoDB(String databaseName) {
		return this._mongoClient.getDB(databaseName);
	}

	protected void destory() {
	}
}