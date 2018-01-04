package com.gewara.support;

import java.io.IOException;
import java.io.Writer;

/**
 * @author ge.biao
 * 在写入xml流过程中，直接过滤掉非法字符
 */
public class XmlFriendlyWriter extends Writer{
	private Writer internal;
	public XmlFriendlyWriter(Writer writer){
		internal = writer;
	}
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		StringBuffer sb = new StringBuffer();
		sb.append(cbuf, off, len);
		
		for(int i=0;i<sb.length();i++){
			int c = sb.charAt(i);
			if(c < 0x20 && c!= 0x09/*\t*/ && c!=0x0A/*\n*/ && c!= 0x0D/*\r*/){
				sb.delete(i, i+1);
			}
		}
		if(sb.length()>0){
			internal.write(sb.substring(0));
		}
	}

	@Override
	public void flush() throws IOException {
		internal.flush();
	}

	@Override
	public void close() throws IOException {
		internal.close();
	}
}
