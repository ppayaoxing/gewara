/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import com.gewara.web.support.ViewContextDebugger;
import java.util.Map;
import org.apache.velocity.VelocityContext;

public class GewaEngineContext extends VelocityContext {
	private ViewContextDebugger gvd;

	public GewaEngineContext(Map context) {
		super(context);
		if (ViewContextDebugger.isDebugEnabled()) {
			if (this.gvd == null) {
				this.gvd = new ViewContextDebugger();
			}

			this.gvd.addProperty(context);
		}

	}

	public String getUnUsedProperty() {
		return this.gvd == null ? null : this.gvd.getUnUsedProperty();
	}

	public Object get(String key) {
		Object result = super.get(key);
		if (this.gvd != null) {
			this.gvd.remove(key);
		}

		return result;
	}
}