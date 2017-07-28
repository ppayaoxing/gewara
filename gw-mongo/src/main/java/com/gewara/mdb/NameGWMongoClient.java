/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb;

import com.gewara.mdb.GWMongoAccount;
import com.gewara.mdb.GWMongoClient;
import com.gewara.mdb.HostInfo;
import com.gewara.mdb.config.GwMongoClientOptions;
import java.util.List;

public class NameGWMongoClient extends GWMongoClient {
	private String replicateName = null;

	public NameGWMongoClient(List<HostInfo> hosts, List<GWMongoAccount> accounts, GwMongoClientOptions options,
			String mechanism, String replicateName) {
		super(options, mechanism, hosts, accounts);
		this.replicateName = replicateName;
	}

	public NameGWMongoClient(List<HostInfo> hosts, List<GWMongoAccount> accounts, GwMongoClientOptions options,
			String replicateName) {
		super(options, "default", hosts, accounts);
		this.replicateName = replicateName;
	}

	public NameGWMongoClient(List<HostInfo> hosts, List<GWMongoAccount> accounts, String replicateName) {
		super(GwMongoClientOptions.getDefaultInstance(), "default", hosts, accounts);
		this.replicateName = replicateName;
	}

	public String replicateName() {
		return this.replicateName;
	}
}