/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import java.io.CharArrayReader;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;

public class NSXmlUtils {
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(NSXmlUtils.class);
	private DocumentFactory factory = new DocumentFactory();

	public NSXmlUtils(Map<String, String> nameSpaceMap) {
		this.factory.setXPathNamespaceURIs(nameSpaceMap);
	}

	public Document getDocument(String xml) {
		SAXReader reader = new SAXReader(this.factory);
		Document document = null;

		try {
			document = reader.read(new CharArrayReader(xml.toCharArray()));
		} catch (DocumentException arg4) {
			dbLogger.error(LoggerUtils.getExceptionTrace(arg4, 100));
		}

		return document;
	}
}