/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import com.gewara.model.BaseObject;
import com.gewara.util.Gcache;
import org.apache.commons.lang.StringUtils;

public class CacheMeta<T extends BaseObject> {
	public final Gcache gcache;
	public final String tag;
	public final Class<T> gclass;
	public final boolean eager;
	public final String[] notifies;

	public CacheMeta(Gcache gcache, Class<T> gclass, String tag, boolean eager, String notify) {
		this.gcache = gcache;
		this.gclass = gclass;
		this.tag = tag;
		this.eager = eager;
		if (StringUtils.isNotBlank(notify)) {
			this.notifies = StringUtils.split(notify, ",");
		} else {
			this.notifies = null;
		}

	}
}