/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.result;

import com.gewara.mdb.helper.DocumentConverter;
import com.gewara.mdb.helper.ResultUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.bson.Document;

public class FindRes<T> {
	private Class<T> mapping;
	private List<Document> result;

	public FindRes(Iterator<Document> docs, Class<T> mappingClass) {
		this(docs);
		this.mapping = mappingClass;
	}

	public FindRes(Iterator<Document> docs) {
		this.mapping = null;
		this.result = null;
		if (docs != null && docs.hasNext()) {
			this.result = new ArrayList();

			while (docs.hasNext()) {
				this.result.add(docs.next());
			}
		} else {
			this.result = new ArrayList(0);
		}

	}

	public FindRes<T> addPropertyClassType(Class propertyClass) {
		BeanUtilsBean pub = BeanUtilsBean.getInstance();
		pub.getConvertUtils().register(new DocumentConverter(propertyClass), propertyClass);
		return this;
	}

	public int size() {
		return this.result != null ? this.result.size() : 0;
	}

	public String toJsonStr() {
		if (this.result.size() == 1) {
			return ((Document) this.result.get(0)).toJson();
		} else {
			StringBuilder sb = new StringBuilder("[");
			Iterator arg1 = this.result.iterator();

			while (arg1.hasNext()) {
				Document doc = (Document) arg1.next();
				sb.append(doc.toJson()).append(",");
			}

			sb.deleteCharAt(sb.length() - 1);
			sb.append("]");
			return sb.toString();
		}
	}

	public Map<String, Object> toMap() {
		return this.result.isEmpty() ? null : ResultUtil.toMap((Document) this.result.get(0));
	}

	public List<Map> toMapList() {
		ArrayList resultList = new ArrayList();
		Iterator arg1 = this.result.iterator();

		while (arg1.hasNext()) {
			Document doc = (Document) arg1.next();
			Map b = ResultUtil.toMap(doc);
			if (b != null) {
				resultList.add(b);
			}
		}

		return resultList;
	}

	public T toBean() {
		return this.result != null && !this.result.isEmpty()
				? ResultUtil.toBean(this.mapping, (Document) this.result.get(0)) : null;
	}

	public List<T> toBeans() {
		return ResultUtil.toBeans(this.mapping, this.result);
	}
}