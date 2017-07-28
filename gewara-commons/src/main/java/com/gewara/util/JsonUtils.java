/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.gewara.util.GewaJsonModule;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import com.gewara.util.GewaJsonModule.UpperCasePropertyNamingStrategy;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class JsonUtils {
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(JsonUtils.class);
	public static UpperCasePropertyNamingStrategy UPPER_CASE_PROPERTY_NAMING_STRATEGY = new UpperCasePropertyNamingStrategy();

	public static <T> T readJsonToObject(Class<T> clazz, String json) {
		if (StringUtils.isBlank(json)) {
			return null;
		} else {
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			mapper.registerModule(GewaJsonModule.GEWA_MODULE);

			try {
				Object e = mapper.readValue(json, clazz);
				return e;
			} catch (Exception arg3) {
				dbLogger.error(StringUtils.substring(json, 0, 500), arg3, 15);
				return null;
			}
		}
	}

	public static <T> T readJsonToObject(TypeReference<T> type, String json) {
		if (StringUtils.isBlank(json)) {
			return null;
		} else {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.registerModule(GewaJsonModule.GEWA_MODULE);

			try {
				Object e = mapper.readValue(json, type);
				return e;
			} catch (Exception arg3) {
				dbLogger.error(
						"json:" + StringUtils.substring(json, 0, 500) + "\n" + LoggerUtils.getExceptionTrace(arg3, 15));
				return null;
			}
		}
	}

	public static <T> List<T> readJsonToObjectList(Class<T> clazz, String json) {
		if (StringUtils.isBlank(json)) {
			return null;
		} else {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.registerModule(GewaJsonModule.GEWA_MODULE);

			try {
				CollectionType e = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
				List result = (List) mapper.readValue(json, e);
				return result;
			} catch (Exception arg4) {
				dbLogger.error(
						"json:" + StringUtils.substring(json, 0, 500) + "\n" + LoggerUtils.getExceptionTrace(arg4, 15));
				return null;
			}
		}
	}

	public static Map readJsonToMap(String json) {
		if (StringUtils.isBlank(json)) {
			return new HashMap();
		} else {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(GewaJsonModule.GEWA_MODULE);

			try {
				Object e = (Map) mapper.readValue(json, Map.class);
				if (e == null) {
					e = new HashMap();
				}

				return (Map) e;
			} catch (Exception arg2) {
				dbLogger.error(
						"json:" + StringUtils.substring(json, 0, 500) + "\n" + LoggerUtils.getExceptionTrace(arg2, 15));
				return new HashMap();
			}
		}
	}

	public static <T> T readJsonToObject(Class<T> clazz, String json, PropertyNamingStrategy pns) {
		if (StringUtils.isBlank(json)) {
			return null;
		} else {
			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			mapper.registerModule(GewaJsonModule.GEWA_MODULE);
			if (pns != null) {
				mapper.setPropertyNamingStrategy(pns);
			}

			try {
				Object e = mapper.readValue(json, clazz);
				return e;
			} catch (Exception arg4) {
				dbLogger.error(StringUtils.substring(json, 0, 500), arg4, 15);
				return null;
			}
		}
	}

	public static <T> T readJsonToObject(TypeReference<T> type, String json, PropertyNamingStrategy pns) {
		if (StringUtils.isBlank(json)) {
			return null;
		} else {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.registerModule(GewaJsonModule.GEWA_MODULE);
			if (pns != null) {
				mapper.setPropertyNamingStrategy(pns);
			}

			try {
				Object e = mapper.readValue(json, type);
				return e;
			} catch (Exception arg4) {
				dbLogger.error(
						"json:" + StringUtils.substring(json, 0, 500) + "\n" + LoggerUtils.getExceptionTrace(arg4, 15));
				return null;
			}
		}
	}

	public static <T> List<T> readJsonToObjectList(Class<T> clazz, String json, PropertyNamingStrategy pns) {
		if (StringUtils.isBlank(json)) {
			return null;
		} else {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.registerModule(GewaJsonModule.GEWA_MODULE);
			if (pns != null) {
				mapper.setPropertyNamingStrategy(pns);
			}

			try {
				CollectionType e = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
				List result = (List) mapper.readValue(json, e);
				return result;
			} catch (Exception arg5) {
				dbLogger.error(
						"json:" + StringUtils.substring(json, 0, 500) + "\n" + LoggerUtils.getExceptionTrace(arg5, 15));
				return null;
			}
		}
	}

	public static Map readJsonToMap(String json, PropertyNamingStrategy pns) {
		if (StringUtils.isBlank(json)) {
			return new HashMap();
		} else {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(GewaJsonModule.GEWA_MODULE);
			if (pns != null) {
				mapper.setPropertyNamingStrategy(pns);
			}

			try {
				Object e = (Map) mapper.readValue(json, Map.class);
				if (e == null) {
					e = new HashMap();
				}

				return (Map) e;
			} catch (Exception arg3) {
				dbLogger.error(
						"json:" + StringUtils.substring(json, 0, 500) + "\n" + LoggerUtils.getExceptionTrace(arg3, 15));
				return new HashMap();
			}
		}
	}

	public static String writeObjectToJson(Object object) {
		return writeObjectToJson(object, false);
	}

	public static void writeObjectToStream(OutputStream os, Object object, boolean excludeNull) {
		writeObject(object, os, (Writer) null, excludeNull);
	}

	public static void writeObjectToWriter(Writer writer, Object object, boolean excludeNull) {
		writeObject(object, (OutputStream) null, writer, excludeNull);
	}

	public static String writeObjectToJson(Object object, boolean excludeNull) {
		return writeObject(object, (OutputStream) null, (Writer) null, excludeNull);
	}

	private static String writeObject(Object object, OutputStream os, Writer writer, boolean excludeNull) {
		if (object == null) {
			return null;
		} else {
			if (object instanceof Map) {
				try {
					((Map) object).remove((Object) null);
				} catch (Exception arg6) {
					;
				}
			}

			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(SerializationFeature.WRITE_NULL_MAP_VALUES);
			mapper.getFactory().disable(Feature.AUTO_CLOSE_TARGET);
			if (excludeNull) {
				mapper.setSerializationInclusion(Include.NON_NULL);
			}

			try {
				mapper.registerModule(GewaJsonModule.GEWA_MODULE);
				if (os != null) {
					mapper.writeValue(os, object);
				} else {
					if (writer == null) {
						String e = mapper.writeValueAsString(object);
						return e;
					}

					mapper.writeValue(writer, object);
				}
			} catch (Exception arg5) {
				dbLogger.error("object:" + object + "\n" + LoggerUtils.getExceptionTrace(arg5, 15));
			}

			return null;
		}
	}

	public static String writeMapToJson(Map<String, String> dataMap) {
		if (dataMap == null) {
			return null;
		} else {
			if (dataMap instanceof HashMap) {
				try {
					dataMap.remove((Object) null);
				} catch (Exception arg3) {
					;
				}
			}

			ObjectMapper mapper = new ObjectMapper();
			mapper.disable(SerializationFeature.WRITE_NULL_MAP_VALUES);

			try {
				String e = mapper.writeValueAsString(dataMap);
				return e;
			} catch (Exception arg2) {
				dbLogger.error("", arg2);
				return null;
			}
		}
	}

	public static String addJsonKeyValue(String json, String key, String value) {
		Map info = readJsonToMap(json);
		info.put(key, value);
		return writeMapToJson(info);
	}

	public static String removeJsonKeyValue(String json, String key) {
		Map info = readJsonToMap(json);
		info.remove(key);
		return writeMapToJson(info);
	}

	public static String getJsonValueByKey(String json, String key) {
		Map info = readJsonToMap(json);
		return (String) info.get(key);
	}
}