package com.gewara.api;

import java.util.Map;

import com.gewara.util.BeanUtil;

public abstract class ApiNode {
	protected String nodeName;
	protected String[] outputFields;
	protected boolean ignoreEmpty;
	
	public boolean isIgnoreEmpty() {
		return ignoreEmpty;
	}
	public String getNodeName(){
		return nodeName;
	}
	public String[] getOutputFields(){
		return outputFields;
	}
	public static Map getBeanMap(Object bean, String[] outputFields){
		Map result = BeanUtil.getBeanMapWithKey(bean, false, outputFields);
		for(String field: outputFields){
			Object value = BeanUtil.get(bean, field);
			if(value!=null){
				if(BeanUtil.isSimpleValueType(value.getClass())){
					result.put(field, value);
				}else{
					//TODO:“Ï≥££ø
				}
			}
		}
		return result;
	}
}
