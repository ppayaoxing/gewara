/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.PropertyUtils;

public class DocumentConverter implements Converter {
	private Class outputDataType = null;

	public DocumentConverter(Class outputDataType) {
		this.outputDataType = outputDataType;
	}

	public Class getOutputDataType() {
		return this.outputDataType;
	}

	public void setOutputDataType(Class outputDataType) {
		this.outputDataType = outputDataType;
	}

	public Object convert(Class type, Object value) {
		try {
			if (this.outputDataType.isEnum()) {
				Method e = this.outputDataType.getMethod("valueOf", new Class[] { String.class });
				return e.invoke((Object) null, new Object[] { (String) value });
			} else {
				Object o = this.outputDataType.newInstance();
				PropertyUtils.copyProperties(o, value);
				return o;
			}
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException
				| InstantiationException arg4) {
			arg4.printStackTrace();
			return value;
		}
	}
}