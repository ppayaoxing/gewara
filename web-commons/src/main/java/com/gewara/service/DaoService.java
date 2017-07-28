/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.service;

import com.gewara.model.BaseObject;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.hibernate.criterion.DetachedCriteria;

public interface DaoService {
	<T extends BaseObject> T saveObject(T arg0);

	<T extends BaseObject> T getObject(Class<T> arg0, Serializable arg1);

	<T extends BaseObject> List<T> getObjectListByField(Class<T> arg0, String arg1, Serializable arg2);

	<T extends BaseObject> T removeObject(T arg0);

	<T extends BaseObject> T removeObjectById(Class<T> arg0, Serializable arg1);

	<T extends BaseObject> List<T> getAllObjects(Class<T> arg0);

	<T extends BaseObject> int getObjectCount(Class<T> arg0);

	<T extends BaseObject> void removeObjectList(Collection<T> arg0);

	<T extends BaseObject> void saveObjectList(Collection<T> arg0);

	<T extends BaseObject> void addObjectList(Collection<T> arg0);

	<T extends BaseObject> void saveObjectList(T... arg0);

	<T extends BaseObject> List<T> getObjectList(Class<T> arg0, String arg1, boolean arg2, int arg3, int arg4);

	<T extends BaseObject, S extends Serializable> List<T> getObjectList(Class<T> arg0, Collection<S> arg1);

	<T extends BaseObject, S extends Serializable> Map<S, T> getObjectMap(Class<T> arg0, Collection<S> arg1);

	<T extends BaseObject> Map getObjectPropertyMap(Class<T> arg0, String arg1, String arg2);

	<T extends BaseObject, S extends Serializable> Map getObjectPropertyMap(Class<T> arg0, String arg1, String arg2,
			Collection<S> arg3);

	<T extends BaseObject, S extends Serializable> List<S> getObjectPropertyList(Class<T> arg0, String arg1,
			boolean arg2);

	<T extends BaseObject> T updateObject(T arg0);

	<T extends BaseObject> T addObject(T arg0);

	<T extends BaseObject> T getObjectByUkey(Class<T> arg0, String arg1, Serializable arg2);

	List queryByRowsRange(String arg0, int arg1, int arg2, Object... arg3);

	<T extends BaseObject> T addPropertyNum(Class<T> arg0, Serializable arg1, String arg2, Integer arg3);

	<T extends BaseObject> void addPropertyNum(T arg0, String arg1, Integer arg2);

	<T extends BaseObject> void addPropertiesNum(T arg0, String arg1, Integer... arg2);

	<T extends BaseObject> T addPropertiesNum(Class<T> arg0, Serializable arg1, String arg2, Integer... arg3);

	<T extends BaseObject> T updateProperties(Class<T> arg0, Serializable arg1, String arg2, Serializable... arg3);

	<T extends BaseObject> void updateProperties(T arg0, String arg1, Serializable... arg2);

	<T extends BaseObject> int updateProperties2(T arg0, String arg1, Serializable... arg2);

	<T extends BaseObject, S extends Serializable> S getObjectPropertyByUkey(Class<T> arg0, String arg1,
			Serializable arg2, String arg3);

	<T extends BaseObject> Object getObjectProperty(Class<T> arg0, Serializable arg1, String arg2);

	<T extends BaseObject, S extends Serializable> List<T> getObjectBatch(Class<T> arg0, String arg1,
			Collection<S> arg2);

	List<Map<String, Object>> queryMapBySQL(String arg0, int arg1, int arg2, Object... arg3);

	List findByCriteria(DetachedCriteria arg0);

	List findByCriteria(DetachedCriteria arg0, int arg1, int arg2);

	List findByHql(String arg0, Object... arg1);

	<T extends BaseObject> void refreshUpdateProperty(T arg0, String arg1, Object arg2);

	Map<Class, String> getEntityIdNameMap();
}