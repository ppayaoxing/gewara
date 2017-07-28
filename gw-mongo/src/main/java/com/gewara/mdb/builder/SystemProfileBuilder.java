/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.builder;

import com.gewara.mdb.HostInfo;
import com.gewara.mdb.helper.RowDataProcess;
import com.gewara.mdb.operation.Expression;
import com.gewara.mdb.result.ScanRes;
import com.mongodb.ReadPreference;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.bson.Document;
import org.bson.conversions.Bson;

public class SystemProfileBuilder {
	private Collection<MongoCollection<Document>> profileCollections = null;
	private Collection<HostInfo> hosts = null;
	private Bson condition = null;

	public SystemProfileBuilder(Collection<MongoDatabase> databases, Collection<HostInfo> hosts) {
		this.profileCollections = new ArrayList(databases.size());
		Iterator arg2 = databases.iterator();

		while (arg2.hasNext()) {
			MongoDatabase db = (MongoDatabase) arg2.next();
			this.profileCollections.add(db.getCollection("system.profile"));
		}

		this.hosts = hosts;
	}

	public SystemProfileBuilder setMinCreateTime(Date ts) {
		Expression expre = (new Expression()).gt("ts", ts);
		if (this.condition != null) {
			expre.bson(new Bson[] { this.condition });
		}

		this.condition = expre.toBson();
		return this;
	}

	public SystemProfileBuilder setType(String op) {
		Expression expre = (new Expression()).gt("op", op);
		if (this.condition != null) {
			expre.bson(new Bson[] { this.condition });
		}

		this.condition = expre.toBson();
		return this;
	}

	public void find(final RowDataProcess<Map> rowdataProcess) {
		Iterator arg1 = this.profileCollections.iterator();

		while (arg1.hasNext()) {
			MongoCollection profileCollection = (MongoCollection) arg1.next();
			Iterator arg3 = this.hosts.iterator();

			while (arg3.hasNext()) {
				final HostInfo host = (HostInfo) arg3.next();
				MongoCollection collection = profileCollection
						.withReadPreference(ReadPreference.nearest(host.getTagSet()));
				FindIterable fi = this.condition == null ? collection.find() : collection.find(this.condition);
				ScanRes sr = new ScanRes(fi.iterator(), Map.class);
				sr.setDataProcessApp(new RowDataProcess() {
					public void process(Map rowData) {
						rowData.put("hostIP", host.getIp());
						rowData.put("hostTag", host.getTagValue());
						rowdataProcess.process(rowData);
					}
				}, Map.class);
				sr.startSyncProcess();
			}
		}

	}
}