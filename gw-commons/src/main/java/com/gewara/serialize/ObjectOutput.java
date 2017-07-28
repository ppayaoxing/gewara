/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.serialize;

import com.gewara.serialize.DataOutput;
import java.io.IOException;

public interface ObjectOutput extends DataOutput {
	void writeObject(Object arg0) throws IOException;
}