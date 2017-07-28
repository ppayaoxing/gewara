/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.serialize.support.hessian;

import com.gewara.serialize.ObjectInput;
import com.gewara.serialize.ObjectOutput;
import com.gewara.serialize.Serialization;
import com.gewara.serialize.support.hessian.Hessian2ObjectInput;
import com.gewara.serialize.support.hessian.Hessian2ObjectOutput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Hessian2Serialization implements Serialization {
	public static final byte ID = 2;

	public byte getContentTypeId() {
		return 2;
	}

	public String getContentType() {
		return "x-application/hessian2";
	}

	public ObjectOutput serialize(OutputStream out) throws IOException {
		return new Hessian2ObjectOutput(out);
	}

	public ObjectInput deserialize(InputStream is) throws IOException {
		return new Hessian2ObjectInput(is);
	}
}