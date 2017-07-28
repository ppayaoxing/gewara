/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.SqlDateDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.TimestampDeserializer;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GewaDateSerializers {
	public static final GewaDateSerializers.GewaDateDeserializer dateDeserializer = new GewaDateSerializers.GewaDateDeserializer();
	public static final GewaDateSerializers.GewaTimestampDeserializer timestampDeserializer = new GewaDateSerializers.GewaTimestampDeserializer();
	public static final GewaDateSerializers.GewaSqlDateDeserializer sqlDateDeserializer = new GewaDateSerializers.GewaSqlDateDeserializer();

	public static class GewaSqlDateDeserializer extends SqlDateDeserializer {
		private static final long serialVersionUID = -8049402816880830231L;

		protected Date _parseDate(JsonParser jp, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			JsonToken t = jp.getCurrentToken();

			try {
				if (t == JsonToken.VALUE_NUMBER_INT) {
					return new Date(jp.getLongValue());
				} else if (t == JsonToken.VALUE_STRING) {
					String iae = jp.getText().trim();
					if (iae.length() == 0) {
						return null;
					} else {
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						return new Date(formatter.parse(iae).getTime());
					}
				} else {
					throw ctxt.mappingException(this._valueClass);
				}
			} catch (ParseException arg5) {
				throw ctxt.mappingException(this._valueClass);
			} catch (IllegalArgumentException arg6) {
				throw ctxt.weirdStringException((String) null, this._valueClass,
						"not a valid representation (error: " + arg6.getMessage() + ")");
			}
		}
	}

	public static class GewaTimestampDeserializer extends TimestampDeserializer {
		private static final long serialVersionUID = -8049402816880830231L;

		protected java.util.Date _parseDate(JsonParser jp, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			JsonToken t = jp.getCurrentToken();

			try {
				if (t == JsonToken.VALUE_NUMBER_INT) {
					return new java.util.Date(jp.getLongValue());
				} else if (t == JsonToken.VALUE_STRING) {
					String iae = jp.getText().trim();
					if (iae.length() == 0) {
						return null;
					} else {
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						return formatter.parse(iae);
					}
				} else {
					throw ctxt.mappingException(this._valueClass);
				}
			} catch (ParseException arg5) {
				throw ctxt.mappingException(this._valueClass);
			} catch (IllegalArgumentException arg6) {
				throw ctxt.weirdStringException((String) null, this._valueClass,
						"not a valid representation (error: " + arg6.getMessage() + ")");
			}
		}
	}

	public static class GewaDateDeserializer extends DateDeserializer {
		private static final long serialVersionUID = -8049402816880830231L;

		protected java.util.Date _parseDate(JsonParser jp, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			JsonToken t = jp.getCurrentToken();

			try {
				if (t == JsonToken.VALUE_NUMBER_INT) {
					return new java.util.Date(jp.getLongValue());
				} else if (t == JsonToken.VALUE_STRING) {
					String iae = jp.getText().trim();
					if (iae.length() == 0) {
						return null;
					} else {
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
						return formatter.parse(iae);
					}
				} else {
					throw ctxt.mappingException(this._valueClass);
				}
			} catch (ParseException arg5) {
				throw ctxt.mappingException(this._valueClass);
			} catch (IllegalArgumentException arg6) {
				throw ctxt.weirdStringException((String) null, this._valueClass,
						"not a valid representation (error: " + arg6.getMessage() + ")");
			}
		}
	}
}