/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import com.gewara.support.TraceErrorException;
import com.gewara.util.GewaLogger;
import com.gewara.util.HttpUtils;
import com.gewara.util.LoggerUtils;
import java.io.File;

public class TmpFileUtil {
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(HttpUtils.class);

	public static void deleteFile(File file) {
		if (file.exists()) {
			if (!file.isFile()) {
				throw new TraceErrorException("can\'t delete directory:" + file);
			}

			file.delete();
		} else {
			dbLogger.warn("fileNotExists:" + file);
		}

	}
}