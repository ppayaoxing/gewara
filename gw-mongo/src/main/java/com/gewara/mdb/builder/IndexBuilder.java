/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.builder;

import com.mongodb.client.model.IndexOptions;
import org.bson.Document;

public class IndexBuilder {
	private IndexOptions indexOptions = new IndexOptions();
	private String collectionName = null;
	private Document index = null;

	public IndexBuilder(String collectionName) {
		this.collectionName = collectionName;
		this.index = new Document();
	}

	public IndexBuilder setIndexName(String indexName) {
		this.indexOptions.name(indexName);
		return this;
	}

	public IndexBuilder addIndexField(String... fields) {
		String[] arg1 = fields;
		int arg2 = fields.length;

		for (int arg3 = 0; arg3 < arg2; ++arg3) {
			String field = arg1[arg3];
			this.index.append(field, Integer.valueOf(1));
		}

		return this;
	}

	public IndexBuilder addIndexField(String field, boolean asc) {
		this.index.append(field, Integer.valueOf(asc ? 1 : -1));
		return this;
	}

	public IndexBuilder setUnique(boolean unique) {
		this.indexOptions.unique(unique);
		return this;
	}

	public IndexBuilder setBackground(boolean br) {
		this.indexOptions.background(br);
		return this;
	}

	public IndexOptions getIndexOptions() {
		return this.indexOptions;
	}

	public String getCollectionName() {
		return this.collectionName;
	}

	public Document getIndex() {
		return this.index;
	}
}