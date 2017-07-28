/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.magent;

import com.gewara.support.magent.JVMCommandProcessorGroup;
import com.gewara.support.magent.MessageCommandCenter;
import com.gewara.support.magent.MethodCommandProcessorGroup;

public class MCCHelper {
	private static MessageCommandCenter mcc = new MessageCommandCenter();

	public static MessageCommandCenter getDefaultInstance() {
		return mcc;
	}

	static {
		mcc.registerGroup(new JVMCommandProcessorGroup());
		mcc.registerGroup(new MethodCommandProcessorGroup());
	}
}