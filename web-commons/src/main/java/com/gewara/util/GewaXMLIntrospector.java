/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.betwixt.XMLBeanInfo;
import org.apache.commons.betwixt.XMLIntrospector;

public class GewaXMLIntrospector extends XMLIntrospector {
	private static Map<String, XMLBeanInfo> beanInfoMap = new ConcurrentHashMap();
	private static Map<String, Long> lastModify = new ConcurrentHashMap();

	protected synchronized XMLBeanInfo findByXMLDescriptor(Class aClass) {
		String name = aClass.getName();
		int idx = name.lastIndexOf(46);
		if (idx >= 0) {
			name = name.substring(idx + 1);
		}

		name = name + ".betwixt";
		URL url = aClass.getResource(name);
		if (url != null) {
			String fileName = url.getFile();
			File file = new File(fileName);
			if (file.exists()) {
				Long last = (Long) lastModify.get(fileName);
				Long fileLast = Long.valueOf(file.lastModified());
				if (last != null && last.equals(fileLast)) {
					return (XMLBeanInfo) beanInfoMap.get(fileName);
				}

				XMLBeanInfo info = super.findByXMLDescriptor(aClass);
				if (info != null) {
					beanInfoMap.put(fileName, info);
					lastModify.put(fileName, fileLast);
				}
			}
		}

		if (this.getLog().isTraceEnabled()) {
			this.getLog().trace("Could not find betwixt file " + name);
		}

		return null;
	}
}