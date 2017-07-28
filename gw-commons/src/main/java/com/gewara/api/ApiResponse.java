/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api;

import com.gewara.api.ApiNode;
import com.gewara.api.BeanNode;
import com.gewara.api.ListNode;
import com.gewara.api.SimpleNode;
import com.gewara.util.BeanUtil;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

public class ApiResponse {
	private String errorCode;
	private String msg;
	private Map<String, ApiNode> apiNodeMap = new LinkedHashMap();

	public void addDataNode(ApiNode node) {
		this.apiNodeMap.put(node.getNodeName(), node);
	}

	public void addBeanNode(String nodeName, Object bean, boolean ignoreEmpty, String... outputFields) {
		this.apiNodeMap.put(nodeName, new BeanNode(bean, nodeName, ignoreEmpty, outputFields));
	}

	public void addSimpleNode(String key, Object simpleValue, boolean ignoreEmpty) {
		this.apiNodeMap.put(key, new SimpleNode(key, simpleValue, ignoreEmpty));
	}

	public Map getJsonMap() {
		LinkedHashMap result = new LinkedHashMap();
		result.put("errorCode", this.errorCode);
		result.put("msg", this.msg);
		Iterator arg1 = this.apiNodeMap.keySet().iterator();

		while (arg1.hasNext()) {
			String nodeName = (String) arg1.next();
			ApiNode node = (ApiNode) this.apiNodeMap.get(nodeName);
			if (node instanceof SimpleNode) {
				result.put(nodeName, ((SimpleNode) node).getSimpleValue());
			} else if (node instanceof BeanNode) {
				result.put(nodeName, ((BeanNode) node).getDataMap());
			} else if (node instanceof ListNode) {
				result.put(nodeName, ((ListNode) node).getDataMapList());
			}
		}

		return result;
	}

	public String getXmlOutput(String root) {
		StringWriter out = new StringWriter();
		this.writeXmlOutput(out, root);
		return out.toString();
	}

	public void writeXmlOutput(Writer writer, String root) {
		try {
			writer.write(xmlStart(root));
			writeSingleElement(writer, "errorCode", this.errorCode, true);
			writeSingleElement(writer, "msg", this.msg, true);
			Iterator arg2 = this.apiNodeMap.keySet().iterator();

			while (arg2.hasNext()) {
				String key = (String) arg2.next();
				wrapXmlNode(writer, (ApiNode) this.apiNodeMap.get(key));
			}

			writer.write(xmlEnd(root));
		} catch (IOException arg4) {
			;
		}

	}

	private static String xmlStart(String name) {
		return "<" + name + ">";
	}

	private static String xmlEnd(String name) {
		return "</" + name + ">";
	}

	private static void writeSingleElement(Writer writer, String name, Object value, boolean ignoreEmpty) {
		String strValue = BeanUtil.getStringValue(value);
		if (!ignoreEmpty || StringUtils.isNotBlank(strValue)) {
			try {
				writer.write(xmlStart(name));
				writer.write(StringEscapeUtils.escapeXml(strValue));
				writer.write(xmlEnd(name));
			} catch (IOException arg5) {
				;
			}
		}

	}

	private static void writeXmlMap(Writer writer, String nodeName, Map<String, ?> dataMap, boolean ignoreEmpty) {
		if (!ignoreEmpty || dataMap != null && !dataMap.isEmpty()) {
			try {
				writer.write(xmlStart(nodeName));
				Iterator arg3 = dataMap.keySet().iterator();

				while (arg3.hasNext()) {
					String key = (String) arg3.next();
					writeSingleElement(writer, key, dataMap.get(key), ignoreEmpty);
				}

				writer.write(xmlEnd(nodeName));
			} catch (IOException arg5) {
				;
			}
		}

	}

	private static void wrapXmlNode(Writer writer, ApiNode dataNode) {
		if (dataNode instanceof SimpleNode) {
			SimpleNode node = (SimpleNode) dataNode;
			writeSingleElement(writer, node.getNodeName(), node.getSimpleValue(), node.ignoreEmpty);
		} else if (dataNode instanceof BeanNode) {
			BeanNode node1 = (BeanNode) dataNode;
			Map dataMap = node1.getDataMap();
			writeXmlMap(writer, node1.nodeName, dataMap, node1.ignoreEmpty);
		} else if (dataNode instanceof ListNode) {
			ListNode node2 = (ListNode) dataNode;
			if (!node2.ignoreEmpty || node2.getBeanList() != null && !node2.getBeanList().isEmpty()) {
				try {
					writer.write(xmlStart(node2.nodeName));
					Iterator dataMap2 = node2.getDataMapList().iterator();

					while (dataMap2.hasNext()) {
						Map dataMap1 = (Map) dataMap2.next();
						writeXmlMap(writer, node2.getSingleNodeName(), dataMap1, node2.ignoreEmpty);
					}

					writer.write(xmlEnd(node2.nodeName));
				} catch (IOException arg4) {
					;
				}
			}
		}

	}
}