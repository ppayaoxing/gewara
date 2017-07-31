package com.gewara.util;

import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.betwixt.XMLBeanInfo;
import org.apache.commons.betwixt.XMLIntrospector;

/**
 * 针对配置文件做缓存,测试中
 * @author gebiao(ge.biao@gewara.com)
 * @since Jul 18, 2013 10:58:41 PM
 */
public class GewaXMLIntrospector extends XMLIntrospector{
	private static Map<String/*name*/, XMLBeanInfo> beanInfoMap = new ConcurrentHashMap<String, XMLBeanInfo>();
	private static Map<String/*name*/, Long> lastModify = new ConcurrentHashMap<String, Long>();
	@Override
	protected synchronized XMLBeanInfo findByXMLDescriptor( Class aClass ) {
        // trim the package name
        String name = aClass.getName();
        int idx = name.lastIndexOf( '.' );
        if ( idx >= 0 ) {
            name = name.substring( idx + 1 );
        }
        name += ".betwixt";
        URL url = aClass.getResource( name );
        if ( url != null ) {
        	String fileName = url.getFile();
        	File file = new File(fileName);
        	if(file.exists()){
        		Long last = lastModify.get(fileName);
        		Long fileLast = file.lastModified();
        		if(last!=null){
        			if(last.equals(fileLast)){
        				return beanInfoMap.get(fileName); 
        			}
        		}
        		XMLBeanInfo info = super.findByXMLDescriptor(aClass);
            	if(info!=null){
            		beanInfoMap.put(fileName, info);
            		lastModify.put(fileName, fileLast);
            	}
        	}
        }
        
        if ( getLog().isTraceEnabled() ) {
            getLog().trace( "Could not find betwixt file " + name );
        }
        return null;
	}
	
}

