/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.helper;

import com.gewara.mdb.helper.ClassMetaInfo;
import com.gewara.mongo.MongoDataException;
import com.gewara.mongo.impl.MongoService3Impl;
import com.gewara.util.BeanUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.bson.Document;

public class ResultUtil {
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(MongoService3Impl.class);

	public static <T> T toBean(Class<T> beanClass, Document doc) {
		if (beanClass == null) {
			throw new MongoDataException("please set the mapping bean type");
		} else {
			Map listProperties = ClassMetaInfo.getWritableListPropertyInfo(beanClass);
			return toBean(beanClass, listProperties, doc);
		}
	}

	public static Map<String, Object> toMap(Document doc) {
		LinkedHashMap map = new LinkedHashMap();
		map.putAll(doc);
		return map;
	}

	public static <T> List<T> toBeans(Class<T> beanClass, List<Document> result) {
		if (beanClass == null) {
			throw new MongoDataException("please set the mapping bean type");
		} else {
			ArrayList list = new ArrayList(result.size());
			Map listProperties = ClassMetaInfo.getWritableListPropertyInfo(beanClass);
			Iterator arg3 = result.iterator();

			while (arg3.hasNext()) {
				Document doc = (Document) arg3.next();
				Object b = toBean(beanClass, listProperties, doc);
				if (b != null) {
					list.add(b);
				}
			}

			return list;
		}
	}

	public static <T> T toBean(Class<T> beanClass, Map<String, Class> listProperties, Document doc) {
		if (beanClass == null) {
			throw new MongoDataException("please set the mapping bean type");
		} else if (beanClass.equals(Map.class)) {
			return toMap(doc);
		} else {
			Object dest = BeanUtil.getInstance(beanClass);
			BeanUtil.copyProperties(dest, doc);
			Iterator arg3 = listProperties.entrySet().iterator();

			while (arg3.hasNext()) {
				Entry entry = (Entry) arg3.next();

				try {
					Object e = doc.get(entry.getKey());
					if (e instanceof List) {
						List docs = (List) e;
						ArrayList list = new ArrayList(0);
						Iterator arg8 = docs.iterator();

						while (arg8.hasNext()) {
							Document item = (Document) arg8.next();
							if (entry.getValue() == Map.class) {
								list.add(toMap(item));
							} else {
								Object bean = BeanUtil.getInstance((Class) entry.getValue());
								BeanUtil.copyProperties(bean, item);
								list.add(bean);
							}
						}

						BeanUtil.set(dest, (String) entry.getKey(), list);
					}
				} catch (Exception arg11) {
					dbLogger.warn(arg11, 20);
				}
			}

			return dest;
		}
	}
}