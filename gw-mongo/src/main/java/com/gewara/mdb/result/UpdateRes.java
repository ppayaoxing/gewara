/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.result;

import com.mongodb.client.result.UpdateResult;

public class UpdateRes {
	private UpdateResult result = null;

	public UpdateRes(UpdateResult result) {
		this.result = result;
	}

	public long updateCount() {
		return this.result.getModifiedCount();
	}

	public long matchCount() {
		return this.result.getMatchedCount();
	}
}