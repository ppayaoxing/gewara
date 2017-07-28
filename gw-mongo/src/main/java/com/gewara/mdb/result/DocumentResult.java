/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.result;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;
import org.bson.Document;

public class DocumentResult {
	private Document doc = null;

	public DocumentResult(Document doc) {
		this.doc = doc;
	}

	public String toJson() {
		return this.doc.toJson();
	}

	public Map<String, Object> toMap() {
		HashMap map = new HashMap();
		map.putAll(this.doc);
		return map;
	}

	public <T> T toBean(Class<T> pojoClass) {
		try {
			Object e = pojoClass.newInstance();
			PropertyUtils.copyProperties(e, this.doc);
			return e;
		} catch (InvocationTargetException | NoSuchMethodException | InstantiationException
				| IllegalAccessException arg2) {
			arg2.printStackTrace();
			return null;
		}
	}
}