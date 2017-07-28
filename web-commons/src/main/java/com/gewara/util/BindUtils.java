/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import com.gewara.support.RequestMapDataBinder;
import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.BindException;

public class BindUtils {
	public static BindException bindData(Object bean, Map requestParam) {
		RequestMapDataBinder binder = new RequestMapDataBinder(bean);
		binder.bind(requestParam);
		BindException errors = new BindException(binder.getBindingResult());
		return errors;
	}

	public static BindException bindData(Object bean, Map map, String[] allowedFields, String[] disallowedFields) {
		RequestMapDataBinder binder = new RequestMapDataBinder(bean);
		if (allowedFields != null && allowedFields.length > 0) {
			binder.setAllowedFields(allowedFields);
		}

		if (disallowedFields != null && disallowedFields.length > 0) {
			binder.setDisallowedFields(disallowedFields);
		}

		binder.bind(map);
		BindException errors = new BindException(binder.getBindingResult());
		return errors;
	}

	public static BindException bind(Object bean, Map requestParam, boolean allow, String[] fields) {
		HashMap bindData = null;
		if (allow) {
			bindData = new HashMap();
		} else {
			bindData = new HashMap(requestParam);
		}

		String[] arg4 = fields;
		int arg5 = fields.length;

		for (int arg6 = 0; arg6 < arg5; ++arg6) {
			String field = arg4[arg6];
			Object value = requestParam.get(field);
			if (allow) {
				if (requestParam.containsKey(field)) {
					bindData.put(field, value);
				}
			} else {
				bindData.remove(field);
			}
		}

		return bindData(bean, bindData);
	}
}