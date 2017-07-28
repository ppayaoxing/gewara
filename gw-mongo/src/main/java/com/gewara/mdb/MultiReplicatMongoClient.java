/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb;

import com.gewara.mdb.NameGWMongoClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiReplicatMongoClient {
	private final List<NameGWMongoClient> replicates = new ArrayList();

	public MultiReplicatMongoClient(List<NameGWMongoClient> multiMongo) {
		this.replicates.addAll(multiMongo);
	}

	public NameGWMongoClient useReplicat(String replicatName) {
		for (int i = 0; i < this.replicates.size(); ++i) {
			if (((NameGWMongoClient) this.replicates.get(i)).replicateName().equals(replicatName)) {
				return (NameGWMongoClient) this.replicates.get(i);
			}
		}

		return null;
	}

	public List<NameGWMongoClient> listReplicate() {
		return Collections.unmodifiableList(this.replicates);
	}
}