package com.gewara.util;

import java.io.File;

import com.gewara.support.TraceErrorException;

public class TmpFileUtil {
	private static final transient GewaLogger dbLogger = LoggerUtils.getLogger(HttpUtils.class);
	public static void deleteFile(File file){
		if(file.exists()){
			if(file.isFile()){
				file.delete();
			}else{
				throw new TraceErrorException("can't delete directory:" + file);
			}
		}else{
			dbLogger.warn("fileNotExists:" + file);
		}
	}

}
