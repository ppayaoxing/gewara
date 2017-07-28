/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import org.springframework.web.context.support.ServletRequestHandledEvent;

public class RequestEventHolder {
	private static boolean enable = false;
	private static ThreadLocal<ServletRequestHandledEvent> event = new ThreadLocal();

	public static ServletRequestHandledEvent getAndClearEvent() {
		ServletRequestHandledEvent srhe = (ServletRequestHandledEvent) event.get();
		event.set((Object) null);
		return srhe;
	}

	public static void setEvent(ServletRequestHandledEvent evt) {
		if (enable) {
			event.set(evt);
		}

	}

	public static void setEnable(boolean enable2) {
		enable = enable2;
	}
}