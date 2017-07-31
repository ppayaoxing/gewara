package com.gewara.trace.agent;

import java.util.List;

import com.gewara.trace.Span;

public interface DtAgent {
	public void sendTraceInfo(List<Span> spanList);
}
