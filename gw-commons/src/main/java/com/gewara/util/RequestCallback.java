package com.gewara.util;

import java.io.InputStream;
import java.util.Map;

public interface RequestCallback {
	public abstract boolean processResult(InputStream stream, Map<String, String> resHeader);
}
