/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.trace.agent;

import com.gewara.trace.Span;
import java.util.List;

public interface DtAgent {
	void sendTraceInfo(List<Span> arg0);
}