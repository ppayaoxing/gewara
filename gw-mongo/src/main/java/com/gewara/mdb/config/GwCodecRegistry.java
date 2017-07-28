/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.config;

import com.gewara.mdb.config.SqlDateCodec;
import com.gewara.mdb.config.SqlTimeCodec;
import com.gewara.mdb.config.SqlTimestampCodec;
import java.util.HashMap;
import java.util.Map;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistry;

public class GwCodecRegistry implements CodecRegistry {
	private CodecRegistry sysCodecRegistry = null;
	private Map<Class, Codec> gwCodec = new HashMap();

	public GwCodecRegistry(CodecRegistry codecRegistry) {
		this.sysCodecRegistry = codecRegistry;
		this.registryCodec(new SqlTimestampCodec());
		this.registryCodec(new SqlTimeCodec());
		this.registryCodec(new SqlDateCodec());
	}

	public <T> Codec<T> get(Class<T> clazz) {
		Codec codec = (Codec) this.gwCodec.get(clazz);
		System.out.println(clazz.getName() + "==" + (codec == null));
		return codec == null ? this.sysCodecRegistry.get(clazz) : codec;
	}

	public <T> void registryCodec(Codec<T> codec) {
		this.gwCodec.put(codec.getClass(), codec);
	}
}