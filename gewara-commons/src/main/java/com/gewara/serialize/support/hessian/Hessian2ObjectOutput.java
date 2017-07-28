/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.serialize.support.hessian;

import com.caucho.hessian.io.Hessian2Output;
import com.gewara.serialize.ObjectOutput;
import com.gewara.serialize.support.hessian.Hessian2SerializerFactory;
import java.io.IOException;
import java.io.OutputStream;

public class Hessian2ObjectOutput implements ObjectOutput {
	private final Hessian2Output mH2o;

	public Hessian2ObjectOutput(OutputStream os) {
		this.mH2o = new Hessian2Output(os);
		this.mH2o.setSerializerFactory(Hessian2SerializerFactory.SERIALIZER_FACTORY);
	}

	public void writeBool(boolean v) throws IOException {
		this.mH2o.writeBoolean(v);
	}

	public void writeByte(byte v) throws IOException {
		this.mH2o.writeInt(v);
	}

	public void writeShort(short v) throws IOException {
		this.mH2o.writeInt(v);
	}

	public void writeInt(int v) throws IOException {
		this.mH2o.writeInt(v);
	}

	public void writeLong(long v) throws IOException {
		this.mH2o.writeLong(v);
	}

	public void writeFloat(float v) throws IOException {
		this.mH2o.writeDouble((double) v);
	}

	public void writeDouble(double v) throws IOException {
		this.mH2o.writeDouble(v);
	}

	public void writeBytes(byte[] b) throws IOException {
		this.mH2o.writeBytes(b);
	}

	public void writeBytes(byte[] b, int off, int len) throws IOException {
		this.mH2o.writeBytes(b, off, len);
	}

	public void writeUTF(String v) throws IOException {
		this.mH2o.writeString(v);
	}

	public void writeObject(Object obj) throws IOException {
		this.mH2o.writeObject(obj);
	}

	public void flushBuffer() throws IOException {
		this.mH2o.flushBuffer();
	}
}