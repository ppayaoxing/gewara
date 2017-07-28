/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.helper.sys;

import com.gewara.helper.sys.CachedScript;
import com.gewara.util.StringUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.script.Compilable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptEngineUtil {
	private static Compilable engine;
	private static Map<String, CachedScript> cacheMap;

	public static synchronized CachedScript buildCachedScript(String script, boolean cached) {
		String key = StringUtil.md5(script);
		CachedScript cs = (CachedScript) cacheMap.get(key);
		if (cs == null) {
			cs = new CachedScript(engine, script);
			if (cached && cs.isValid()) {
				cacheMap.put(key, cs);
			}
		}

		return cs;
	}

	public static ScriptEngine getEngine() {
		return (ScriptEngine) engine;
	}

	static {
		ScriptEngineManager manager = new ScriptEngineManager();
		engine = (Compilable) manager.getEngineByName("groovy");
		cacheMap = new LinkedHashMap(500, 1.0F, true) {
			private static final long serialVersionUID = 387454821812532541L;

			protected boolean removeEldestEntry(Entry eldest) {
				return this.size() > 500;
			}
		};
	}
}