/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import java.io.IOException;
import java.io.Writer;

public class XmlFriendlyWriter extends Writer {
	private Writer internal;

	public XmlFriendlyWriter(Writer writer) {
		this.internal = writer;
	}

	public void write(char[] cbuf, int off, int len) throws IOException {
		StringBuffer sb = new StringBuffer();
		sb.append(cbuf, off, len);

		for (int i = 0; i < sb.length(); ++i) {
			char c = sb.charAt(i);
			if (c < 32 && c != 9 && c != 10 && c != 13) {
				sb.delete(i, i + 1);
			}
		}

		if (sb.length() > 0) {
			this.internal.write(sb.substring(0));
		}

	}

	public void flush() throws IOException {
		this.internal.flush();
	}

	public void close() throws IOException {
		this.internal.close();
	}
}