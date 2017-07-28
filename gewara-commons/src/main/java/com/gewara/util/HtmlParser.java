/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {
	public static List<String> getNodeAttrList(String html, String nodename, String attrName) {
		ArrayList result = new ArrayList();

		try {
			Document doc = Jsoup.parse(html);
			Elements els = doc.select(nodename);
			Iterator it = els.iterator();

			while (it.hasNext()) {
				Element el = (Element) it.next();
				String s = el.attr(attrName);
				result.add(s);
			}
		} catch (Exception arg8) {
			;
		}

		return result;
	}

	public static String getHtmlText(String html) {
		if (StringUtils.isBlank(html)) {
			return html;
		} else {
			String html2 = html.replaceAll("&nbsp;", " ");
			html2 = html2.replaceAll("<br/>", "\n");
			html2 = html2.replaceAll("<br />", "\n");
			if (html2.indexOf(62) >= 0 && html2.indexOf(60) >= 0) {
				String result = parseHtmlInternal(html2);
				return result;
			} else {
				return html2;
			}
		}
	}

	private static String parseHtmlInternal(String html) {
		String html2 = html.replaceAll("\n", "@nn@");

		try {
			Document doc = Jsoup.parse(html2);
			doc.select("head").remove();
			doc.select("script").remove();
			doc.select("style").remove();
			return StringUtils.replace(doc.text(), "@nn@", "\n");
		} catch (Exception arg2) {
			return html;
		}
	}
}