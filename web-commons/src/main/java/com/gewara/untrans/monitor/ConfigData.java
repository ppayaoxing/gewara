package com.gewara.untrans.monitor;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.gewara.util.BeanUtil;
import com.gewara.util.DateUtil;

/**
 * @author gebiao
 * Map 的值必须是 简单类型或Map
 * 可以嵌套查询，如：getLong("member.id") 获取Map中member的id 
 */
public abstract class ConfigData implements ConfigTrigger{
	private Object data;
	public ConfigData(Map data){
		this.data = data;
	}
	public Integer getInteger(String key){
		Object value = BeanUtil.get(data, key);
		if(value!=null){
			try{
				return Integer.parseInt(value.toString());
			}catch(Exception e){//ignore
			}
		}
		return null;
	}
	public Long getLong(String key){
		Object value = BeanUtil.get(data, key);
		if(value!=null){
			try{
				return Long.parseLong(value.toString());
			}catch(Exception e){//ignore
			}
		}
		return null;
	}
	public Date getDate(String key){
		Object value = BeanUtil.get(data, key);
		if(value!=null){
			try{
				return DateUtil.parseDate(value.toString());
			}catch(Exception e){//ignore
			}
		}
		return null;
	}
	public Timestamp getTimestamp(String key){
		Object value = BeanUtil.get(data, key);
		if(value!=null){
			try{
				return DateUtil.parseTimestamp(value.toString());
			}catch(Exception e){//ignore
			}
		}
		return null;

	}
	public String getString(String key){
		Object value = BeanUtil.get(data, key);
		if(value!=null){
			try{
				return value.toString();
			}catch(Exception e){//ignore
			}
		}
		return null;
	}
	public Object get(String property) {
		try {
			return PropertyUtils.getNestedProperty(data, property);
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		} catch (NoSuchMethodException e) {
		} catch (Exception e) {
		}
		return null;
	}
	@Override
	public abstract void refreshCurrent(String newConfig);
}
