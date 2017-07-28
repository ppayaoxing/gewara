/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import com.gewara.Config;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaLogger;
import com.gewara.util.LogTraceUtil;
import com.gewara.util.WebLogger;
import com.gewara.web.support.DirectOut;
import com.gewara.web.support.GewaViewContext;
import com.gewara.web.support.RequestTrace;
import com.gewara.web.support.ViewContextDebugger;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.tools.view.CookieTool;
import org.apache.velocity.tools.view.ParameterTool;
import org.springframework.web.servlet.view.velocity.VelocityToolboxView;
import org.springframework.web.util.NestedServletException;

public class GewaVelocityView extends VelocityToolboxView {
	protected final transient GewaLogger log = WebLogger.getLogger(this.getClass());
	public static final String RENDER_XML = "RENDER_TO_XML";
	public static final String RENDER_JSON = "RENDER_TO_JSON";
	public static final String KEY_HTTP_STATUS = "KEY_HTTP_STATUS";
	public static final String USE_OTHER_CHARSET = "USE_OTHER_CHARSET_CONTENT_KEY";
	public static final String KEY_IGNORE_TOOLS = "IGNORE_EXPORT_TOOL";
	public static final String DIRECT_OUTPUT = "directOut";
	public static final String HEADER_KEY_LOG = "_header_log_";
	public static final String RETURN_LOG_HEADER = "__add_log_header_";

	public static void processHeader(HttpServletRequest request, HttpServletResponse response, Map model) {
		if (model.get("USE_OTHER_CHARSET_CONTENT_KEY") != null) {
			response.setCharacterEncoding((String) model.remove("USE_OTHER_CHARSET_CONTENT_KEY"));
		}

		if (model.get("KEY_HTTP_STATUS") != null) {
			response.setStatus(((Integer) model.get("KEY_HTTP_STATUS")).intValue());
		}

		if (model.get("RENDER_TO_XML") != null) {
			model.remove("RENDER_TO_XML");
			response.setContentType("text/xml");
			model.put("charset", "UTF-8");
			if (StringUtils.isNotBlank(request.getParameter("charset"))) {
				response.setCharacterEncoding(request.getParameter("charset"));
				model.put("charset", request.getParameter("charset"));
			}
		} else if (model.get("RENDER_TO_JSON") != null) {
			model.remove("RENDER_TO_JSON");
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
		}

		try {
			if (request.getAttribute("__add_log_header_") != null) {
				Map logEntry = (Map) request.getAttribute("_REQ_LOG_ENTRY_KEY");
				Iterator arg3 = logEntry.entrySet().iterator();

				while (arg3.hasNext()) {
					Entry row = (Entry) arg3.next();
					if (StringUtils.isNotBlank((String) row.getValue())
							&& StringUtils.startsWith((String) row.getKey(), "log_")) {
						response.setHeader((String) row.getKey(), (String) row.getValue());
					}
				}
			}
		} catch (Exception arg5) {
			;
		}

	}

	protected void renderMergedTemplateModel(Map model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		processHeader(request, response, model);

		try {
			PrintWriter e = response.getWriter();
			Iterator cause1 = model.values().iterator();

			while (cause1.hasNext()) {
				Object obj = cause1.next();
				if (obj != null && obj instanceof DirectOut) {
					DirectOut dout = (DirectOut) obj;
					dout.setWriter(e);
				}
			}

			GewaViewContext cause2 = this.createVelocityContext(model, request, response);
			this.getTemplate().merge(cause2, e);
			response.getWriter().flush();
			this.debug(cause2, request);
		} catch (IllegalStateException arg7) {
			this.log.error("uri:" + request.getRequestURI() + ", model:" + model, arg7);
		} catch (MethodInvocationException arg8) {
			Throwable cause = arg8.getWrappedThrowable();
			throw new NestedServletException("Method invocation failed during rendering of Velocity view with name \'"
					+ this.getBeanName() + "\': " + arg8.getMessage() + "; reference [" + arg8.getReferenceName()
					+ "], method \'" + arg8.getMethodName() + "\'", (Throwable) (cause == null ? arg8 : cause));
		} catch (Exception arg9) {
			this.log.error("uri:" + request.getRequestURI() + ", params:"
					+ BaseWebUtils.getParamStr(request, true, new String[0]), arg9);
			throw arg9;
		}

	}

	private void debug(GewaViewContext context, HttpServletRequest request) {
		String uri = request.getRequestURI();
		if (ViewContextDebugger.isDebugEnabled(uri)) {
			String unused = context.getUnUsedProperty();
			if (StringUtils.isNotBlank(unused)) {
				String params = BaseWebUtils.getParamStr(request, true, new String[0]);
				if (StringUtils.isNotBlank(unused)) {
					this.log.warn("UNUSED_PROPERTY:" + uri + ":" + unused + ":REQUEST:" + params);
				}
			}
		}

	}

	protected GewaViewContext createVelocityContext(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GewaViewContext velocityContext = new GewaViewContext(this.getVelocityEngine(), request, response,
				this.getServletContext());
		velocityContext.putModel(model);
		if (model.get("IGNORE_EXPORT_TOOL") == null) {
			ParameterTool tool = new ParameterTool(request);
			velocityContext.put("params", tool);
			CookieTool cookieTool = new CookieTool();
			cookieTool.setRequest(request);
			cookieTool.setResponse(response);
			velocityContext.put("cookieTool", cookieTool);
			velocityContext.putAll(Config.getPageTools());
		} else {
			model.remove("IGNORE_EXPORT_TOOL");
		}

		return velocityContext;
	}

	static {
		LogTraceUtil.addTrace(new RequestTrace());
	}
}