/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.service;

import java.util.List;
import java.util.Map;
import org.hibernate.criterion.DetachedCriteria;

public interface ReadOnlyDaoService {
	List findByCriteria(DetachedCriteria arg0);

	List findByCriteria(DetachedCriteria arg0, int arg1, int arg2);

	List findByHql(String arg0, Object... arg1);

	List<Map<String, Object>> queryMapBySQL(String arg0, int arg1, int arg2, Object... arg3);

	List queryByRowsRange(String arg0, int arg1, int arg2, Object... arg3);

	List queryByNameParams(String arg0, int arg1, int arg2, String arg3, Object... arg4);

	void setReadonly(boolean arg0);

	boolean isReadOnly();
}