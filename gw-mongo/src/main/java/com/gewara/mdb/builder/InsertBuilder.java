/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.builder;

import com.gewara.util.BeanUtil;
import com.mongodb.client.model.InsertManyOptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import org.bson.conversions.Bson;

public class InsertBuilder<T> {
	private Class<T> sourceType = null;
	private List<Document> sources = new ArrayList();
	private Bson id = null;
	private InsertManyOptions insertManyOptions = new InsertManyOptions();
	private boolean autoCreateID = true;
	private String collectionName = null;

	public InsertBuilder(String collectionName) {
		this.collectionName = collectionName;
	}

	public InsertBuilder(Class<T> mapping) {
		this.collectionName = mapping.getCanonicalName();
		this.sourceType = mapping;
	}

	public InsertBuilder<T> setInsertModel(boolean alone) {
		if (alone) {
			this.insertManyOptions = (new InsertManyOptions()).ordered(false);
		}

		return this;
	}

	private void addDataSource(T data) {
		assert data != null;

		Map map = null;
		if (data instanceof Map) {
			map = (Map) data;
		} else {
			map = BeanUtil.getBeanMap(data);
		}

		if (map != null && !map.isEmpty()) {
			Document doc = new Document();
			doc.putAll(map);
			this.sources.add(doc);
		}

	}

	public InsertBuilder<T> addData4Bean(T... datas) {
		Object[] arg1 = datas;
		int arg2 = datas.length;

		for (int arg3 = 0; arg3 < arg2; ++arg3) {
			Object data = arg1[arg3];
			this.addDataSource(data);
		}

		return this;
	}

	public InsertBuilder<T> setData4Bean(Collection<T> datas) {
		this.sources = new ArrayList();
		Iterator arg1 = datas.iterator();

		while (arg1.hasNext()) {
			Object data = arg1.next();
			this.addDataSource(data);
		}

		return this;
	}

	public Class<T> getSourceType() {
		return this.sourceType;
	}

	public List<Document> getSources() {
		return this.sources;
	}

	public Document getTop() {
		return (Document) this.sources.get(0);
	}

	public Bson getId() {
		return this.id;
	}

	public InsertManyOptions getInsertManyOptions() {
		return this.insertManyOptions;
	}

	public boolean isAutoCreateID() {
		return this.autoCreateID;
	}

	public String getCollectionName() {
		return this.collectionName;
	}
}