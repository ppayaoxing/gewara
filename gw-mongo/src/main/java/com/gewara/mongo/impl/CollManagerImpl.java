/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mongo.impl;

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
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;

public class CollManagerImpl implements CollManager, InitializingBean {
	private static transient GewaLogger dbLogger = LoggerUtils.getLogger(CollManagerImpl.class);
	private String[] scanPathList = new String[] { "com/gewara" };
	private Map<String, String> pkeyMap = new HashMap();

	private void registerMGObject() {
		Set mgcList = getMGObjectList(this.scanPathList);
		mgcList.remove(MGObject.class);
		int errorCount = 0;
		Iterator arg2 = mgcList.iterator();

		while (arg2.hasNext()) {
			Class mgc = (Class) arg2.next();
			OID oid = (OID) mgc.getAnnotation(OID.class);
			String pkname = null;
			if (oid != null) {
				if (oid.value().length > 0) {
					pkname = oid.value()[0];
				}

				if (StringUtils.isBlank(pkname)) {
					++errorCount;
					dbLogger.warn("Error Mongon Class: " + mgc.getCanonicalName() + ", OID value cannot be null !!");
				}
			} else {
				Map mpkMap = this.findMethodAn(mgc, MPK.class);
				if (mpkMap.size() > 1) {
					++errorCount;
					dbLogger.warn("Error Mongon Class: " + mgc.getCanonicalName() + ", multi MPK or MUK !!" + mpkMap);
				} else if (mpkMap.size() == 1) {
					pkname = (String) mpkMap.keySet().iterator().next();
				} else {
					++errorCount;
					dbLogger.warn("Error Mongon Class: " + mgc.getCanonicalName() + ", OID or MPK or MUK required !!");
				}
			}

			if (StringUtils.isNotBlank(pkname)) {
				this.pkeyMap.put(mgc.getCanonicalName(), pkname);
			}
		}

		if (GewaIpConfig.isDevServer() && errorCount > 0) {
			System.out.println("Mongo Error MGObject, count:" + errorCount);
			System.out.println("Mongo Error MGObject, count:" + errorCount);
			System.out.println("Mongo Error MGObject, count:" + errorCount);

			try {
				Thread.sleep(5000L);
			} catch (InterruptedException arg7) {
				;
			}
		}

	}

	private Map<String, Annotation> findMethodAn(Class<? extends MGObject> mgc,
			Class<? extends Annotation> requireType) {
		HashMap result = new HashMap();

		try {
			Map e = ReflectUtils.getBeanPropertyFields(mgc);
			Iterator arg4 = e.values().iterator();

			while (arg4.hasNext()) {
				Field field = (Field) arg4.next();
				Annotation an = field.getAnnotation(requireType);
				if (an != null) {
					result.put(field.getName(), an);
				}
			}
		} catch (Exception arg7) {
			dbLogger.warn(arg7, 50);
		}

		return result;
	}

	public static Set<Class<? extends MGObject>> getMGObjectList(String[] pathList) {
		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
		provider.addIncludeFilter(new AssignableTypeFilter(MGObject.class));
		HashSet result = new HashSet();
		String[] arg2 = pathList;
		int arg3 = pathList.length;

		for (int arg4 = 0; arg4 < arg3; ++arg4) {
			String path = arg2[arg4];
			Set components = provider.findCandidateComponents(path.trim());
			Iterator arg7 = components.iterator();

			while (arg7.hasNext()) {
				BeanDefinition component = (BeanDefinition) arg7.next();

				try {
					Class e = Class.forName(component.getBeanClassName());
					if (ClassUtil.isConcrete(e)) {
						result.add(e);
					} else {
						dbLogger.warn("ignore abstract class:" + e.getCanonicalName());
					}
				} catch (ClassNotFoundException arg10) {
					arg10.printStackTrace();
				}
			}
		}

		return result;
	}

	public void setScanPath(String scanPath) {
		scanPath = StringUtils.replace(scanPath, ".", "/");
		this.scanPathList = StringUtils.split(scanPath, ",");
	}

	public void afterPropertiesSet() throws Exception {
		String[] arg0 = this.scanPathList;
		int arg1 = arg0.length;

		for (int arg2 = 0; arg2 < arg1; ++arg2) {
			String scanPath = arg0[arg2];
			Assert.isTrue(StringUtils.startsWith(scanPath, "com/gewara"), "scanPath must starts with com.gewara");
		}

		this.registerMGObject();
	}

	public Map<String, String> getPkeyMap() {
		return new HashMap(this.pkeyMap);
	}

	public void validateColl(String collname) {
	}

	public String getPkey(String collname) {
		return (String) this.pkeyMap.get(collname);
	}
}