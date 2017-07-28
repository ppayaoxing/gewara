/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import java.util.Map;

public interface JmsService {
	void addQueue(String arg0, boolean arg1, boolean arg2);

	void sendMsgToDst(String arg0, String arg1, String arg2);

	void sendMsgToDst(String arg0, String arg1, Map arg2);

	void sendMsgToDst(String arg0, String arg1, String arg2, Object... arg3);

	void sendMsgToDstWithMultiHead(String arg0, String arg1, Map arg2, Map<String, String> arg3);

	void delaySendMsgToDst(String arg0, String arg1, Map arg2, long arg3);

	void delaySendMsgToDst(String arg0, String arg1, String arg2, long arg3);

	void periodSendMsgToDst(String arg0, String arg1, Map arg2, long arg3, long arg5, int arg7);
}