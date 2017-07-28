/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import com.gewara.web.support.ViewContextDebugger;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.tools.view.ViewToolContext;

public class GewaViewContext extends ViewToolContext {
	private ViewContextDebugger gvd;

	public GewaViewContext(VelocityEngine velocity, HttpServletRequest request, HttpServletResponse response,
			ServletContext application) {
		super(velocity, request, response, application);
	}

	protected Object internalGet(String key) {
		Object result = super.internalGet(key);
		if (this.gvd != null) {
			this.gvd.remove(key);
		}

		return result;
	}

	public void putModel(Map model) {
		super.putAll(model);
		if (ViewContextDebugger.isDebugEnabled()) {
			if (this.gvd == null) {
				this.gvd = new ViewContextDebugger();
			}

			this.gvd.addProperty(model);
		}

	}

	public String getUnUsedProperty() {
		return this.gvd == null ? null : this.gvd.getUnUsedProperty();
	}
}