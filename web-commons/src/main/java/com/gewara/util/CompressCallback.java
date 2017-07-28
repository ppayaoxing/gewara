/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.util;

import java.io.File;

public interface CompressCallback {
	void onComplete(File arg0, long arg1, long arg3);

	void onFailure();
}