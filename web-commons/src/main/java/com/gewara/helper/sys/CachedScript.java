/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.helper.sys;

import com.gewara.util.BeanUtil;
import com.gewara.util.GewaLogger;
import com.gewara.util.Util4Script;
import com.gewara.util.WebLogger;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

public class CachedScript implements Serializable {
	private static final long serialVersionUID = -5632756060640454376L;
	private CompiledScript compiledScript;
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());

	public CachedScript() {
	}

	public CachedScript(Compilable scriptEngine, String script) {
		try {
			this.compiledScript = scriptEngine.compile(script);
		} catch (Exception arg3) {
			this.dbLogger.warn(arg3, 300);
		}

	}

	public boolean isValid() {
		return this.compiledScript != null;
	}

	public <T> CachedScript.ScriptResult<T> run(Map<String, Object> context) {
		SimpleScriptContext ctx = new SimpleScriptContext();
		if (context != null) {
			put(ctx, context);
		}

		CachedScript.ScriptResult result = new CachedScript.ScriptResult(ctx);
		if (this.compiledScript == null) {
			result.setErrorMsg("script cannot be compiled!!");
			return result;
		} else {
			try {
				Object e = this.compiledScript.eval(ctx);
				result.setRetval(e);
			} catch (ScriptException arg4) {
				this.dbLogger.warn(arg4, 100);
				result.setErrorMsg("execption:" + arg4 + "," + arg4.getMessage());
			}

			return result;
		}
	}

	private static void put(ScriptContext ctx, Map<String, Object> context) {
		Iterator arg1 = context.entrySet().iterator();

		while (true) {
			while (arg1.hasNext()) {
				Entry entry = (Entry) arg1.next();
				Object value = entry.getValue();
				if (value != null && !BeanUtil.isSimpleProperty(value.getClass())) {
					if (value instanceof Collection) {
						ctx.setAttribute((String) entry.getKey(), BeanUtil.getBeanMapList((Collection) value, true),
								100);
					} else if (value instanceof Util4Script) {
						ctx.setAttribute((String) entry.getKey(), value, 100);
					} else {
						ctx.setAttribute((String) entry.getKey(), BeanUtil.getBeanMap(value), 100);
					}
				} else {
					ctx.setAttribute((String) entry.getKey(), value, 100);
				}
			}

			return;
		}
	}

	public CompiledScript getCompiledScript() {
		return this.compiledScript;
	}

	public static class ScriptResult<T> {
		private ScriptContext ctx;
		private T retval;
		private String errorMsg;

		public ScriptResult(ScriptContext ctx) {
			this.ctx = ctx;
		}

		public T getRetval() {
			return this.retval;
		}

		public Object getAttribute(String name) {
			return this.ctx.getAttribute(name);
		}

		public void setRetval(T retval) {
			this.retval = retval;
		}

		public String getErrorMsg() {
			return this.errorMsg;
		}

		public void setErrorMsg(String errorMsg) {
			this.errorMsg = errorMsg;
		}

		public boolean hasError() {
			return this.errorMsg != null;
		}
	}
}