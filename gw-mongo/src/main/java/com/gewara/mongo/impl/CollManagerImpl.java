package com.gewara.mongo.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

import com.fasterxml.jackson.databind.util.ClassUtil;
import com.gewara.mongo.CollManager;
import com.gewara.mongo.annotation.MPK;
import com.gewara.mongo.annotation.OID;
import com.gewara.mongo.support.MGObject;
import com.gewara.serialize.ReflectUtils;
import com.gewara.util.Assert;
import com.gewara.util.GewaIpConfig;
import com.gewara.util.GewaLogger;
import com.gewara.util.LoggerUtils;

public class CollManagerImpl implements CollManager, InitializingBean{
	private static transient GewaLogger dbLogger = LoggerUtils.getLogger(CollManagerImpl.class);
	private String[] scanPathList = new String[]{"com/gewara"};
	private Map<String/*class.canonicalName*/, String/*pkname*/> pkeyMap = new HashMap<String, String>(); 
	private void registerMGObject(){
		Set<Class<? extends MGObject>> mgcList = getMGObjectList(scanPathList);
		mgcList.remove(MGObject.class);
		int errorCount = 0;
		for(Class<? extends MGObject> mgc: mgcList){
			OID oid = mgc.getAnnotation(OID.class);
			String pkname = null;
			if(oid!=null){
				if(oid.value().length>0){
					pkname = oid.value()[0];
				}
				if(StringUtils.isBlank(pkname)){
					errorCount ++;
					dbLogger.warn("Error Mongon Class: " + mgc.getCanonicalName() + ", OID value cannot be null !!");
				}
			}else{
				Map<String, Annotation> mpkMap = findMethodAn(mgc, MPK.class);
				if(mpkMap.size() > 1){
					errorCount ++;
					dbLogger.warn("Error Mongon Class: " + mgc.getCanonicalName() + ", multi MPK or MUK !!" + mpkMap);
				}else if(mpkMap.size() == 1){
					pkname = mpkMap.keySet().iterator().next();
				}else{
					errorCount ++;
					dbLogger.warn("Error Mongon Class: " + mgc.getCanonicalName() + ", OID or MPK or MUK required !!");
				}
			}
			if(StringUtils.isNotBlank(pkname)){
				pkeyMap.put(mgc.getCanonicalName(), pkname);
			}
		}
		if(GewaIpConfig.isDevServer() && errorCount > 0){
			System.out.println("Mongo Error MGObject, count:" + errorCount);
			System.out.println("Mongo Error MGObject, count:" + errorCount);
			System.out.println("Mongo Error MGObject, count:" + errorCount);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
		}
	}
	private Map<String, Annotation> findMethodAn(Class<? extends MGObject> mgc, Class<? extends Annotation> requireType){
		Map<String, Annotation> result = new HashMap<>();
		try{
			Map<String, Field> fieldsMap = ReflectUtils.getBeanPropertyFields(mgc);
			for(Field field: fieldsMap.values()){
				Annotation an = field.getAnnotation(requireType);
				if(an!=null){
					result.put(field.getName(), an);
				}
			}
		}catch(Exception e){
			dbLogger.warn(e, 50);
		}
		return result;
	}
	
	public static Set<Class<? extends MGObject>> getMGObjectList(String[] pathList){
		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
		provider.addIncludeFilter(new AssignableTypeFilter(MGObject.class));
		Set<Class<? extends MGObject>> result = new HashSet<>();
		for(String path: pathList){
			Set<BeanDefinition> components = provider.findCandidateComponents(path.trim());
			for (BeanDefinition component : components) {
				try {
					Class cls = Class.forName(component.getBeanClassName());
					if(ClassUtil.isConcrete(cls)){
						result.add(cls);
					}else{
						dbLogger.warn("ignore abstract class:" + cls.getCanonicalName());
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				// use class cls found
			}
		}
		
		return result;
	}

	public void setScanPath(String scanPath) {
		scanPath = StringUtils.replace(scanPath, ".", "/");
		this.scanPathList = StringUtils.split(scanPath, ",");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		for(String scanPath: scanPathList){
			Assert.isTrue(StringUtils.startsWith(scanPath, "com/gewara"), "scanPath must starts with com.gewara");
		}
		registerMGObject();
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~service method~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * @return Map(class.canonicalName,fieldname)
	 */
	@Override
	public Map<String, String> getPkeyMap(){
		return new HashMap<String, String>(pkeyMap);
	}
	@Override
	public void validateColl(String collname) {
		// do nothing
	}
	@Override
	public String getPkey(String collname) {
		return pkeyMap.get(collname);
	}
}
