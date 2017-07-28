/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.util.BeanUtil;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public class JsonViewer {
	public static final JsonViewer instance = new JsonViewer();

	public static String getHtml(Object obj) {
		StringWriter writer = new StringWriter();

		try {
			outputObject(obj, writer);
		} catch (IOException arg2) {
			;
		}

		return writer.toString();
	}

	public static void outputObject(Object obj, Writer writer) throws IOException {
		if (obj == null) {
			writer.write("null");
		} else if (BeanUtil.isSimpleValueType(obj.getClass())) {
			writer.write(obj.toString());
		} else if (obj instanceof Map) {
			outputMap((Map) obj, writer);
		} else if (obj instanceof Collection) {
			outputCollection((Collection) obj, writer);
		} else {
			writer.write(obj.toString());
		}

	}

	private static void outputMap(Map<String, ?> map, Writer sb) throws IOException {
		sb.write("<table class=\"table\">");
		Iterator arg1 = map.keySet().iterator();

		while (arg1.hasNext()) {
			String key = (String) arg1.next();
			sb.write("<tr><td>");
			sb.write(key);
			sb.write("</td><td>");
			outputObject(map.get(key), sb);
			sb.write("</td></tr>");
		}

		sb.write("</table>");
	}

	private static void outputCollection(Collection rowList, Writer sb) throws IOException {
		LinkedHashSet columns = new LinkedHashSet();
		Iterator arg2 = rowList.iterator();

		Object row;
		while (arg2.hasNext()) {
			row = arg2.next();
			if (row instanceof Map) {
				columns.addAll(((Map) row).keySet());
			}
		}

		if (columns.size() > 0) {
			sb.write("<table class=\"table\"><tr>");
			arg2 = columns.iterator();

			while (arg2.hasNext()) {
				row = arg2.next();
				sb.write("<td>" + row + "</td>");
			}

			sb.write("</tr>");
			arg2 = rowList.iterator();

			while (arg2.hasNext()) {
				row = arg2.next();
				sb.write("<tr>");
				Iterator arg4 = columns.iterator();

				while (arg4.hasNext()) {
					Object column = arg4.next();
					sb.write("<td>");
					outputObject(((Map) row).get(column), sb);
					sb.write("</td>");
				}

				sb.write("</tr>");
			}

			sb.write("</table>");
		} else {
			sb.write("<table class=\"table\">");
			arg2 = rowList.iterator();

			while (arg2.hasNext()) {
				row = arg2.next();
				sb.write("<tr>");
				sb.write("<td>");
				outputObject(row, sb);
				sb.write("</td>");
				sb.write("</tr>");
			}

			sb.write("</table>");
		}

	}
}