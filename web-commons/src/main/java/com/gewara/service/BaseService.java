/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.service;

import java.util.List;

public interface BaseService {
	List queryByRowsRange(String arg0, int arg1, int arg2, Object... arg3);

	List queryByNameParams(String arg0, int arg1, int arg2, String arg3, Object... arg4);
}