package com.gewara.support;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;

import com.gewara.Config;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.GewaEngineContext;

public class VelocityTemplate {
	private transient final GewaLogger log = WebLogger.getLogger(getClass());
	//public static boolean DEBUG_ENABLED = false;
	private VelocityEngine velocityEngine;
	private Config config;
	public VelocityTemplate(){
	}
	public String parseTemplate(String template, Map model){
		model.putAll(Config.getPageTools());
		GewaEngineContext context = new GewaEngineContext(model);
		Writer writer = new StringWriter();
		try {
			velocityEngine.mergeTemplate(template, "UTF-8", context, writer);
		} catch (Exception e) {
			log.warn("模板错误", e);
		}
		return writer.toString();
	}
	public void parseTemplate(String template, Map model, Writer writer){
		model.putAll(Config.getPageTools());
		GewaEngineContext context = new GewaEngineContext(model);
		try {
			velocityEngine.mergeTemplate(template, "UTF-8", context, writer);
		} catch (Exception e) {
			log.warn("模板错误", e);
		}
	}
	public void parseTemplate(String template, Map model, OutputStream os){
		model.putAll(Config.getPageTools());
		GewaEngineContext context = new GewaEngineContext(model);
		Writer writer = new OutputStreamWriter(os);
		try {
			velocityEngine.mergeTemplate(template, "UTF-8", context, writer);
		} catch (Exception e) {
			log.warn("", e);
		}
	}
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
	public Config getConfig() {
		return config;
	}
	public void setConfig(Config config) {
		this.config = config;
	}
}
