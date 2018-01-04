package com.gewara.web.support;

import com.gewara.Config;
import com.gewara.util.BaseWebUtils;
import com.gewara.util.GewaLogger;
import com.gewara.util.LogTraceUtil;
import com.gewara.util.WebLogger;
import com.gewara.web.util.ReqLogUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.tools.view.CookieTool;
import org.apache.velocity.tools.view.ParameterTool;
import org.springframework.web.servlet.view.velocity.VelocityToolboxView;
import org.springframework.web.util.NestedServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 *  扩展velocity视图解析器
 */
public class GewaVelocityView extends VelocityToolboxView{
	protected final transient GewaLogger log = WebLogger.getLogger(getClass());
	public static final String RENDER_XML = "RENDER_TO_XML";
	public static final String RENDER_JSON = "RENDER_TO_JSON";
	public static final String KEY_HTTP_STATUS = "KEY_HTTP_STATUS";
	public static final String USE_OTHER_CHARSET = "USE_OTHER_CHARSET_CONTENT_KEY";
	public static final String KEY_IGNORE_TOOLS = "IGNORE_EXPORT_TOOL";
	public static final String DIRECT_OUTPUT = "directOut";
	public static final String HEADER_KEY_LOG = "_header_log_";
	public static final String RETURN_LOG_HEADER = "__add_log_header_";//是否将reqlog返回到response头中（便于openapi调用）
	
	static{
		//用于定位错误信息
		LogTraceUtil.addTrace(new RequestTrace());
	}
	public GewaVelocityView(){
		super();
	}
	public static void processHeader(HttpServletRequest request, HttpServletResponse response, Map model){
		if(model.get(USE_OTHER_CHARSET) != null){
			response.setCharacterEncoding((String) model.remove(USE_OTHER_CHARSET));
		}
		if(model.get(KEY_HTTP_STATUS) != null){
			response.setStatus((Integer) model.get(KEY_HTTP_STATUS));
		}
		if(model.get(RENDER_XML) != null){
			model.remove(RENDER_XML);
			response.setContentType("text/xml");
			model.put("charset", "UTF-8");
			if(StringUtils.isNotBlank(request.getParameter("charset"))){
				response.setCharacterEncoding(request.getParameter("charset"));
				model.put("charset", request.getParameter("charset"));
			}
		}else if(model.get(RENDER_JSON) != null){
			//json视图设置
			model.remove(RENDER_JSON);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json;charset=utf-8");
		}
		try{
			if(request.getAttribute(RETURN_LOG_HEADER)!=null){
				Map<String, String> logEntry = (Map<String, String>) request.getAttribute(ReqLogUtil.REQ_LOG_ENTRY_ATTR_KEY);
				for(Map.Entry<String, String> row:logEntry.entrySet()){
					if(StringUtils.isNotBlank(row.getValue())){
						if(StringUtils.startsWith(row.getKey(), ReqLogUtil.REQ_LOG_ENTRY_KEY_PRE)){
							response.setHeader(row.getKey(), row.getValue());
						}
					}
				}
			}
		}catch(Exception e){

		}
	}
	@Override
	protected void renderMergedTemplateModel(Map model,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		processHeader(request, response, model);
		try {
			PrintWriter writer = response.getWriter();//IllegalStateException
			//为了vm中间能直接输出Json流，减少一次string转换
			for(Object obj: model.values()){
				if(obj!=null && obj instanceof DirectOut){
					DirectOut dout = (DirectOut)obj;
					dout.setWriter(writer);
				}
			}
			GewaViewContext context = createVelocityContext(model, request, response);
			getTemplate().merge(context, writer);
			response.getWriter().flush();
			debug(context, request);

		}catch(IllegalStateException e){//response output
			log.error("uri:" + request.getRequestURI() + ", model:" + model, e);
		}catch (MethodInvocationException ex) {
			Throwable cause = ex.getWrappedThrowable();
			throw new NestedServletException(
					"Method invocation failed during rendering of Velocity view with name '" +
					getBeanName() + "': " + ex.getMessage() + "; reference [" + ex.getReferenceName() +
					"], method '" + ex.getMethodName() + "'",
					cause==null ? ex : cause);
		} catch (Exception e) {
			log.error("uri:" + request.getRequestURI() + ", params:" + BaseWebUtils.getParamStr(request, true), e);
			throw e;
		}
	}
	private void debug(GewaViewContext context, HttpServletRequest request) {
		String uri = request.getRequestURI();
		if(ViewContextDebugger.isDebugEnabled(uri)){
			String unused = context.getUnUsedProperty();
			if(StringUtils.isNotBlank(unused)){
				String params = BaseWebUtils.getParamStr(request, true);
				if(StringUtils.isNotBlank(unused)){
					log.warn("UNUSED_PROPERTY:" + uri + ":" + unused + ":REQUEST:" + params);
				}
			}
		}
	}

	@Override
	protected GewaViewContext createVelocityContext(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		GewaViewContext velocityContext = new GewaViewContext(getVelocityEngine(), request, response, getServletContext());
		velocityContext.putModel(model);
		if(model.get(KEY_IGNORE_TOOLS)==null){//API等不需要这些渲染
			ParameterTool tool = new ParameterTool(request);
			velocityContext.put("params", tool);
			CookieTool cookieTool = new CookieTool();
			cookieTool.setRequest(request);
			cookieTool.setResponse(response);
			velocityContext.put("cookieTool", cookieTool);
			velocityContext.putAll(Config.getPageTools());
		}else{
			model.remove(KEY_IGNORE_TOOLS);
		}
		return velocityContext;
	}
}
