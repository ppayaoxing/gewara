/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.serialize;

import com.gewara.serialize.ObjectInput;
import com.gewara.serialize.ObjectOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Serialization {
	byte getContentTypeId();

	String getContentType();

	ObjectOutput serialize(OutputStream arg0) throws IOException;

	ObjectInput deserialize(InputStream arg0) throws IOException;
}