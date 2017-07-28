/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.serialize;

import java.io.IOException;

public interface DataOutput {
	void writeBool(boolean arg0) throws IOException;

	void writeByte(byte arg0) throws IOException;

	void writeShort(short arg0) throws IOException;

	void writeInt(int arg0) throws IOException;

	void writeLong(long arg0) throws IOException;

	void writeFloat(float arg0) throws IOException;

	void writeDouble(double arg0) throws IOException;

	void writeUTF(String arg0) throws IOException;

	void writeBytes(byte[] arg0) throws IOException;

	void writeBytes(byte[] arg0, int arg1, int arg2) throws IOException;

	void flushBuffer() throws IOException;
}