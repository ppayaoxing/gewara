package com.gewara.support.magent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.support.PropertyComparator;

import com.gewara.util.GewaLogger;
import com.gewara.util.JsonUtils;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ResourceStatsUtil;

public abstract class WebContainerUtils {
	private static GewaLogger dbLogger = WebLogger.getLogger(WebContainerUtils.class);
	public static Map<String, String> exportRequestToFile(String filePath, String fileName) {
		File savePath = new File(filePath);
		if (!savePath.exists()) {
			savePath.mkdirs();
		}
		Writer writer = null;
		Map<String, String> data = new HashMap<String, String>();
		File file = new File(filePath, fileName);
		try{
			writer = new BufferedWriter(new FileWriter(file));
			List<Map> processing = ResourceStatsUtil.getUriStats().getProcessingList(0);
			Collections.sort(processing, new PropertyComparator("processing", false, false));
			JsonUtils.writeObjectToWriter(writer, processing, true);
			data.put("fileName", fileName);
		}catch(Exception e){
			dbLogger.warn("", e);
			HashMap<String, String> result = new HashMap<String, String>();
			result.put("error", e.getClass().getName() + ":" + e.getMessage());
			return result;
		}finally{
			if(writer!=null){
				try{writer.close();}catch(Exception e){}
			}
		}
		if(file.exists()){
			data.put("fileSize", "" + file.length());
		}
		return data;
	}
}
