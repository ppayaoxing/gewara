/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import com.gewara.Config;
import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.GewaEngineContext;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import org.apache.velocity.app.VelocityEngine;

public class VelocityTemplate {
	private final transient GewaLogger log = WebLogger.getLogger(this.getClass());
	private VelocityEngine velocityEngine;
	private Config config;

	public String parseTemplate(String template, Map model) {
		model.putAll(Config.getPageTools());
		GewaEngineContext context = new GewaEngineContext(model);
		StringWriter writer = new StringWriter();

		try {
			this.velocityEngine.mergeTemplate(template, "UTF-8", context, writer);
		} catch (Exception arg5) {
			this.log.warn("模板错误", arg5);
		}

		return writer.toString();
	}

	public void parseTemplate(String template, Map model, Writer writer) {
		model.putAll(Config.getPageTools());
		GewaEngineContext context = new GewaEngineContext(model);

		try {
			this.velocityEngine.mergeTemplate(template, "UTF-8", context, writer);
		} catch (Exception arg5) {
			this.log.warn("模板错误", arg5);
		}

	}

	public void parseTemplate(String template, Map model, OutputStream os) {
		model.putAll(Config.getPageTools());
		GewaEngineContext context = new GewaEngineContext(model);
		OutputStreamWriter writer = new OutputStreamWriter(os);

		try {
			this.velocityEngine.mergeTemplate(template, "UTF-8", context, writer);
		} catch (Exception arg6) {
			this.log.warn("", arg6);
		}

	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public Config getConfig() {
		return this.config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}
}