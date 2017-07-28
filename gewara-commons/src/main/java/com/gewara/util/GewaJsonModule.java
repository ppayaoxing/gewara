/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.gewara.util.GewaDateSerializer;
import com.gewara.util.GewaDateSerializers;
import java.sql.Timestamp;
import java.util.Date;

public class GewaJsonModule extends SimpleModule {
	private static final long serialVersionUID = 4093223126017721944L;
	public static GewaJsonModule GEWA_MODULE = new GewaJsonModule();

	private GewaJsonModule() {
		this.addDeserializer(Timestamp.class, GewaDateSerializers.timestampDeserializer);
		this.addDeserializer(Date.class, GewaDateSerializers.dateDeserializer);
		this.addDeserializer(java.sql.Date.class, GewaDateSerializers.sqlDateDeserializer);
		this.addSerializer(Timestamp.class, new GewaDateSerializer());
		this.addSerializer(Date.class, new GewaDateSerializer());
		this.addSerializer(java.sql.Date.class, new GewaDateSerializer());
	}

	public static class UpperCasePropertyNamingStrategy extends PropertyNamingStrategyBase {
		private static final long serialVersionUID = -6510034237130928673L;

		public String translate(String propertyName) {
			if ("objectName".equals(propertyName)) {
				return propertyName;
			} else {
				String name = propertyName.replaceAll("^\\w", propertyName.toUpperCase().substring(0, 1));
				return name;
			}
		}
	}
}