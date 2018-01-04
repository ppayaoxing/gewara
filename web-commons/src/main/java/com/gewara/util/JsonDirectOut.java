package com.gewara.util;

import java.io.Writer;

import com.gewara.web.support.DirectOut;

/**
 * 鐩存帴杈撳嚭json娴侊紝灏戜竴娆″ぇ鐨凷tring杞崲
 * @param req
 * @param obj
 */
public class JsonDirectOut implements DirectOut{
	private Writer writer;
	private Object json;
	public JsonDirectOut(Object json){
		this.json = json;
	}
	@Override
	public void write(){
		JsonUtils.writeObjectToWriter(writer, json, false);
	}
	@Override
	public void setWriter(Writer writer) {
		this.writer = writer;
	}
}
