package com.gewara.util;

import java.beans.IntrospectionException;
import java.io.StringReader;

import org.apache.commons.betwixt.io.BeanReader;

import com.gewara.support.GewaObjectStringConverter;

public class ApiUtils {
	protected final static transient GewaLogger dbLogger = WebLogger.getLogger(ApiUtils.class);
	public static BeanReader getBeanReader(String nodeName, Class clazz){
		BeanReader beanReader = new BeanReader();
		beanReader.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(true);
		beanReader.getBindingConfiguration().setMapIDs(false);
		beanReader.getBindingConfiguration().setObjectStringConverter(new GewaObjectStringConverter());
		try {
			beanReader.registerBeanClass(nodeName, clazz);
		} catch (IntrospectionException e) {
		}
		return beanReader;
	}
	/*
	public static BeanReader getCusBeanReader(String nodeName, Class clazz){
		BeanReader beanReader = new BeanReader();
		beanReader.setXMLIntrospector(new GewaXMLIntrospector());
		beanReader.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(true);
		beanReader.getBindingConfiguration().setMapIDs(false);
		beanReader.getBindingConfiguration().setObjectStringConverter(new GewaObjectStringConverter());
		try {
			beanReader.registerBeanClass(nodeName, clazz);
		} catch (IntrospectionException e) {
		}
		return beanReader;
	}
	*/	
	public static Object xml2Object(BeanReader reader, String xml){
		StringReader xmlReader = new StringReader(xml);
		try {
			Object result = reader.parse(xmlReader);
			return result;
		} catch (Exception e) {
			dbLogger.warn(e.getMessage()+"\n"+ xml);
		}
		return null;
	}
	public static Object xml2Object(Class clazz, String xml, String nodeName) {
		return ApiUtils.xml2Object(ApiUtils.getBeanReader(nodeName, clazz),xml);
	}
}
