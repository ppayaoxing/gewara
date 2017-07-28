/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import com.gewara.Config;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindingResult;

public class ViewContextDebugger {
	private static boolean debugEnabled = false;
	private Set unusedList;
	public static Set<String> ignoreUriList = new HashSet();
	public static List<String> ignoreField;

	public static boolean isDebugEnabled(String uri) {
		if (!debugEnabled) {
			return false;
		} else {
			if (!ignoreUriList.isEmpty()) {
				Iterator arg0 = ignoreUriList.iterator();

				while (arg0.hasNext()) {
					String key = (String) arg0.next();
					if (StringUtils.startsWith(uri, key)) {
						return false;
					}
				}
			}

			return true;
		}
	}

	public void addProperty(Map model) {
		if (debugEnabled) {
			if (this.unusedList == null) {
				this.unusedList = new HashSet();
			}

			this.unusedList.addAll(model.keySet());
		}

	}

	public void remove(String property) {
		if (debugEnabled) {
			try {
				if (this.unusedList != null) {
					this.unusedList.remove(property);
				}
			} catch (Exception arg2) {
				;
			}
		}

	}

	public String getUnUsedProperty() {
		try {
			if (this.unusedList != null && !this.unusedList.isEmpty()) {
				Iterator e = this.unusedList.iterator();

				while (e.hasNext()) {
					String key = "" + e.next();
					if (key.startsWith(BindingResult.MODEL_KEY_PREFIX)) {
						e.remove();
					}
				}

				if (Config.getPageTools() != null) {
					this.unusedList.removeAll(Config.getPageTools().keySet());
				}

				this.unusedList.remove("springMacroRequestContext");
				this.unusedList.remove("RENDER_TO_XML");
				this.unusedList.remove("RENDER_TO_JSON");
				this.unusedList.remove("KEY_HTTP_STATUS");
				this.unusedList.remove("USE_OTHER_CHARSET_CONTENT_KEY");
				this.unusedList.remove("IGNORE_EXPORT_TOOL");
				if (ignoreField != null) {
					this.unusedList.removeAll(ignoreField);
				}

				return StringUtils.join(new TreeSet(this.unusedList), ",");
			} else {
				return null;
			}
		} catch (Exception arg2) {
			return "UnUsedException:" + arg2.getMessage();
		}
	}

	public Set getUnusedList() {
		return this.unusedList;
	}

	public void setUnusedList(Set unusedList) {
		this.unusedList = unusedList;
	}

	public static void addIgnoreUri(String ignoreUri) {
		ignoreUriList.add(ignoreUri);
	}

	public static boolean isDebugEnabled() {
		return debugEnabled;
	}

	public static void setDebugEnabled(boolean debugEnabled) {
		ViewContextDebugger.debugEnabled = debugEnabled;
		if (!debugEnabled) {
			ignoreUriList = new HashSet();
		}

	}

	public static String getIgnoreUris() {
		return StringUtils.join(ignoreUriList, ",");
	}
}