/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.result;

import com.mongodb.client.result.DeleteResult;

public class DeleteRes {
	private DeleteResult result;
	private boolean d1;

	public DeleteRes(DeleteResult result, boolean done) {
		this.result = result;
		this.d1 = done;
	}

	public boolean success() {
		return this.d1 ? this.result.getDeletedCount() == 1L
				: this.result.getDeletedCount() > 0L && this.result.wasAcknowledged();
	}

	public int deleteCount() {
		return (int) this.result.getDeletedCount();
	}
}