/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support.magent;

import com.gewara.util.GewaLogger;
import com.gewara.util.JsonUtils;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ResourceStatsUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.support.PropertyComparator;

public abstract class WebContainerUtils {
	private static GewaLogger dbLogger = WebLogger.getLogger(WebContainerUtils.class);

	public static Map<String, String> exportRequestToFile(String filePath, String fileName) {
		File savePath = new File(filePath);
		if (!savePath.exists()) {
			savePath.mkdirs();
		}

		BufferedWriter writer = null;
		HashMap data = new HashMap();
		File file = new File(filePath, fileName);

		label85 : {
			HashMap arg7;
			try {
				writer = new BufferedWriter(new FileWriter(file));
				List e = ResourceStatsUtil.getUriStats().getProcessingList(0);
				Collections.sort(e, new PropertyComparator("processing", false, false));
				JsonUtils.writeObjectToWriter(writer, e, true);
				data.put("fileName", fileName);
				break label85;
			} catch (Exception arg17) {
				dbLogger.warn("", arg17);
				HashMap result = new HashMap();
				result.put("error", arg17.getClass().getName() + ":" + arg17.getMessage());
				arg7 = result;
			} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (Exception arg16) {
						;
					}
				}

			}

			return arg7;
		}

		if (file.exists()) {
			data.put("fileSize", "" + file.length());
		}

		return data;
	}
}