/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtils {
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(XmlUtils.class);

	public static String formatXml(String str, String encoding) {
		try {
			StringWriter e = new StringWriter();
			formatXml(str, encoding, e);
			e.close();
			return e.toString();
		} catch (Exception arg2) {
			dbLogger.warn(str + LoggerUtils.getExceptionTrace(arg2, 100));
			return str;
		}
	}

	public static void formatXml(String str, String encoding, Writer writer) throws IOException {
		OutputFormat format = OutputFormat.createCompactFormat();
		format.setEncoding(encoding);
		XMLWriter xmlWriter = new XMLWriter(writer, format);

		try {
			Document e = DocumentHelper.parseText(str);
			xmlWriter.write(e);
		} catch (DocumentException arg5) {
			dbLogger.warn(str + LoggerUtils.getExceptionTrace(arg5, 100));
		}

	}

	public static Document getDocument(String xml) {
		SAXReader reader = new SAXReader();
		Document document = null;

		try {
			document = reader.read(new CharArrayReader(xml.toCharArray()));
		} catch (DocumentException arg3) {
			dbLogger.error(LoggerUtils.getExceptionTrace(arg3, 100));
		}

		return document;
	}

	public static String filterInvalid(String xml) {
		StringBuffer sb = new StringBuffer(xml);

		for (int i = 0; i < sb.length(); ++i) {
			char c = sb.charAt(i);
			if (c < 32 && c != 9 && c != 10 && c != 13) {
				sb.delete(i, i + 1);
			}
		}

		return sb.toString();
	}

	public static String getNodeText(String xml, String xpath) {
		return getNodeText(getDocument(xml), xpath);
	}

	public static String getNodeText(Document document, String xpath) {
		if (document == null) {
			return null;
		} else {
			try {
				List e = document.selectNodes(xpath);
				return e.isEmpty() ? null : getText((Node) e.get(0));
			} catch (Exception arg2) {
				dbLogger.error(document.getText() + LoggerUtils.getExceptionTrace(arg2, 100));
				return null;
			}
		}
	}

	public static List<String> getNodeTextList(String xml, String xpath, boolean ignoreEmpty) {
		return getNodeTextList(getDocument(xml), xpath, ignoreEmpty);
	}

	public static List<String> getNodeTextList(Document document, String xpath, boolean ignoreEmpty) {
		ArrayList result = new ArrayList();
		if (document == null) {
			return result;
		} else {
			try {
				List e = document.selectNodes(xpath);
				Iterator arg4 = e.iterator();

				while (true) {
					String s;
					do {
						if (!arg4.hasNext()) {
							return result;
						}

						Node node = (Node) arg4.next();
						s = getText(node);
					} while (!StringUtils.isNotBlank(s) && ignoreEmpty);

					result.add(s);
				}
			} catch (Exception arg7) {
				dbLogger.error(document.getText() + LoggerUtils.getExceptionTrace(arg7, 100));
				return result;
			}
		}
	}

	private static String getText(Node node) {
		return node instanceof Attribute ? ((Attribute) node).getValue() : node.getText();
	}

	public static Map<String, Object> xml2Map(String infoXML) {
		HashMap map = new HashMap();

		try {
			Document document = DocumentHelper.parseText(infoXML);
			Element e1 = document.getRootElement();
			Iterator it = e1.elements().iterator();

			while (it.hasNext()) {
				Element info = (Element) it.next();
				map.put(info.getName(), info.getText());
				Iterator itc = info.elements().iterator();

				while (itc.hasNext()) {
					Element infoc = (Element) itc.next();
					map.put(infoc.getName(), infoc.getText());
				}
			}
		} catch (DocumentException arg7) {
			dbLogger.warn(arg7, 20);
		}

		return map;
	}

	public static void main(String[] args) {
		String xml = "<?xml version=\"1.0\" encoding=\"GBK\"?><bookstore><book><title lang=\"eng\">Harry Potter</title><price> 29.99 </price></book></bookstore>";
		xml = "<notify><trade_status>TRADE_FINISHED</trade_status><total_fee>0.90</total_fee><subject>123456</subject><out_trade_no>1118060201-7555</out_trade_no><notify_reg_time>2010-11-18 14:02:43.000</notify_reg_time><trade_no>2010111800209965</trade_no></notify>";
		Map map = xml2Map(xml);
		System.out.println(map);
	}
}