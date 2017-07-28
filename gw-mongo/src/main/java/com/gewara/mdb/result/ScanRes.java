/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.result;

import com.gewara.mdb.helper.RowDataProcess;
import com.gewara.mongo.MongoDataException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;
import org.bson.Document;

public class ScanRes<T> {
	private Class<T> mapping = null;
	private String mappingIDName = null;
	private Iterator<Document> docs = null;
	private RowDataProcess<T> processApp = null;

	public ScanRes(Iterator<Document> docs, Class<T> mappingClass) {
		this.docs = docs;
		this.mapping = mappingClass;
	}

	public ScanRes<T> setMappingIDName(String beanMappingIDName) {
		this.mappingIDName = beanMappingIDName;
		return this;
	}

	public ScanRes<T> setDataProcessApp(RowDataProcess<T> rowdataProcess, Class<T> paramClass) {
		this.mapping = paramClass;
		this.processApp = rowdataProcess;
		return this;
	}

	private T toBean(Document doc) {
		if (this.mapping == null) {
			throw new MongoDataException("please set the mapping bean type");
		} else if (this.mapping.equals(Map.class)) {
			return doc;
		} else {
			try {
				Object e = this.mapping.newInstance();
				PropertyUtils.copyProperties(e, doc);
				if (this.mappingIDName != null) {
					PropertyUtils.setProperty(e, this.mappingIDName, doc.get("_id"));
				}

				return e;
			} catch (InvocationTargetException | NoSuchMethodException | InstantiationException
					| IllegalAccessException arg2) {
				arg2.printStackTrace();
				return null;
			}
		}
	}

	public void startSyncProcess() {
		while (this.docs.hasNext()) {
			this.processApp.process(this.toBean((Document) this.docs.next()));
		}

	}

	public void startAsyncProcess() {
		(new Thread(new Runnable() {
			public void run() {
				ScanRes.this.startSyncProcess();
			}
		})).start();
	}
}