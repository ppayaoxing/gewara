/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans;

import com.gewara.model.BaseObject;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface CacheObjectService {
	<T extends BaseObject, S extends Serializable> List<T> getObjectList(Class<T> arg0, Collection<S> arg1);

	<T extends BaseObject, S extends Serializable> List<T> getObjectList(Class<T> arg0, String arg1, boolean arg2,
			int arg3, int arg4);

	<T extends BaseObject, S extends Serializable> T getObject(Class<T> arg0, S arg1);

	<T extends BaseObject, S extends Serializable> T getObjectByUkey(Class<T> arg0, String arg1, S arg2);

	<T extends BaseObject> List<T> getObjectListByField(Class<T> arg0, String arg1, Serializable arg2);

	<T extends BaseObject> Class<?> getEntityIdType(Class<T> arg0);
}