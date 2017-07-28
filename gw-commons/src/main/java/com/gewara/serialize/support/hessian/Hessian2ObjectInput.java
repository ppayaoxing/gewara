/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.serialize.support.hessian;

import com.caucho.hessian.io.Hessian2Input;
import com.gewara.serialize.ObjectInput;
import com.gewara.serialize.support.hessian.Hessian2SerializerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public class Hessian2ObjectInput implements ObjectInput {
	private final Hessian2Input mH2i;

	public Hessian2ObjectInput(InputStream is) {
		this.mH2i = new Hessian2Input(is);
		this.mH2i.setSerializerFactory(Hessian2SerializerFactory.SERIALIZER_FACTORY);
	}

	public boolean readBool() throws IOException {
		return this.mH2i.readBoolean();
	}

	public byte readByte() throws IOException {
		return (byte) this.mH2i.readInt();
	}

	public short readShort() throws IOException {
		return (short) this.mH2i.readInt();
	}

	public int readInt() throws IOException {
		return this.mH2i.readInt();
	}

	public long readLong() throws IOException {
		return this.mH2i.readLong();
	}

	public float readFloat() throws IOException {
		return (float) this.mH2i.readDouble();
	}

	public double readDouble() throws IOException {
		return this.mH2i.readDouble();
	}

	public byte[] readBytes() throws IOException {
		return this.mH2i.readBytes();
	}

	public String readUTF() throws IOException {
		return this.mH2i.readString();
	}

	public Object readObject() throws IOException {
		return this.mH2i.readObject();
	}

	public <T> T readObject(Class<T> cls) throws IOException, ClassNotFoundException {
		return this.mH2i.readObject(cls);
	}

	public <T> T readObject(Class<T> cls, Type type) throws IOException, ClassNotFoundException {
		return this.readObject(cls);
	}
}