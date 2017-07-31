package com.gewara.untrans;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.gewara.model.BaseObject;

public interface CacheObjectService{

	<T extends BaseObject, S extends Serializable> List<T> getObjectList(Class<T> clazz, Collection<S> idList);
	
	<T extends BaseObject, S extends Serializable> List<T> getObjectList(Class<T> clazz, String sortField, boolean asc, int from, int maxnum);
	
	<T extends BaseObject, S extends Serializable> T getObject(Class<T> clazz, S id);

	<T extends BaseObject, S extends Serializable> T getObjectByUkey(Class<T> clazz, String ukeyName, S ukeyValue);
	
	<T extends BaseObject> List<T> getObjectListByField(Class<T> clazz, String fieldname, Serializable fieldvalue);
	
	<T extends BaseObject> Class<?> getEntityIdType(Class<T> clazz);
}
