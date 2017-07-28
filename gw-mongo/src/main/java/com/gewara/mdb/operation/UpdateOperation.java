/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.operation;

import org.bson.Document;

public class UpdateOperation {
	protected Document doc = new Document();

	public <Num extends Number> UpdateOperation inc(String field, Num value) {
		return this;
	}

	public <Num extends Number> UpdateOperation mul(String field, Num value) {
		return this;
	}

	public UpdateOperation renameFiled(String field, String newFieldName) {
		return this;
	}

	public UpdateOperation delField(String... field) {
		return this;
	}

	public <TItem> UpdateOperation setOnInsert(String field, TItem value) {
		return this;
	}

	public <TItem> UpdateOperation data(String field, TItem value) {
		return this;
	}

	public <TItem> UpdateOperation min(String field, TItem value) {
		return this;
	}

	public <TItem> UpdateOperation max(String field, TItem value) {
		return this;
	}

	public UpdateOperation currentDate(String Field) {
		return this;
	}
}