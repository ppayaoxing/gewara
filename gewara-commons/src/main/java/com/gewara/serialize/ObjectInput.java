/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.serialize;

import com.gewara.serialize.DataInput;
import java.io.IOException;
import java.lang.reflect.Type;

public interface ObjectInput extends DataInput {
	Object readObject() throws IOException, ClassNotFoundException;

	<T> T readObject(Class<T> arg0) throws IOException, ClassNotFoundException;

	<T> T readObject(Class<T> arg0, Type arg1) throws IOException, ClassNotFoundException;
}