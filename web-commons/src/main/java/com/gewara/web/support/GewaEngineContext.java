package com.gewara.web.support;

import java.util.Map;

import org.apache.velocity.VelocityContext;

public class GewaEngineContext extends VelocityContext {
	private ViewContextDebugger gvd;
		
	public GewaEngineContext(Map context) {
		super(context);
		if(ViewContextDebugger.isDebugEnabled()){
			if(gvd==null) {
				gvd = new ViewContextDebugger();
			}
			gvd.addProperty(context);
		}
	}

	public String getUnUsedProperty(){
		if(gvd==null) return null;
		return gvd.getUnUsedProperty();
	}

	@Override
	public Object get(String key) {
		Object result = super.get(key);
		if(gvd!=null) {
			gvd.remove(key);
		}
		return result;
	}
	

}
