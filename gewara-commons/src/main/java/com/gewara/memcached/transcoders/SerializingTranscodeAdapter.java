/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.memcached.transcoders;

import com.gewara.serialize.ObjectInput;
import com.gewara.serialize.ObjectOutput;
import com.gewara.serialize.Serialization;
import com.gewara.support.TraceErrorException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import net.spy.memcached.transcoders.SerializingTranscoder;

public class SerializingTranscodeAdapter extends SerializingTranscoder {
	private Serialization serialization;

	public Serialization getSerialization() {
		return this.serialization;
	}

	public void setSerialization(Serialization serialization) {
		this.serialization = serialization;
	}

	protected byte[] serialize(Object o) {
		if (o != null && this.serialization != null && this.serialization instanceof Serialization) {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			try {
				ObjectOutput e = this.serialization.serialize(byteArrayOutputStream);
				e.writeObject(o);
				e.flushBuffer();
			} catch (IOException arg3) {
				this.getLogger().warn("Non-serializable object", arg3);
				throw new TraceErrorException("Non-serializable object", arg3);
			}

			return byteArrayOutputStream.toByteArray();
		} else {
			return super.serialize(o);
		}
	}

	protected Object deserialize(byte[] in) {
		if (in != null && this.serialization != null && this.serialization instanceof Serialization) {
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(in);

			try {
				ObjectInput e = this.serialization.deserialize(byteArrayInputStream);
				return e.readObject();
			} catch (ClassNotFoundException arg3) {
				this.getLogger().warn("Caught CNFE decoding %d bytes of data",
						new Object[] { Integer.valueOf(in == null ? 0 : in.length), arg3 });
			} catch (IOException arg4) {
				this.getLogger().warn("Caught IOException decoding %d bytes of data",
						new Object[] { Integer.valueOf(in == null ? 0 : in.length), arg4 });
			}

			return null;
		} else {
			return super.deserialize(in);
		}
	}
}