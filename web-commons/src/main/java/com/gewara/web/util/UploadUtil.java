/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.util;

import com.gewara.Config;
import com.gewara.util.DateUtil;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.StringUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

public abstract class UploadUtil {
	private static String UPLOAD_KEY = "GewaUploadFile";

	public static String writeCKUploadRes(HttpServletResponse response, String uploadPath, Long userid, String callback,
			String successFile, String msg, String tag, Long relatedid) throws IOException {
		String dstPath = "/userfiles/image/" + DateUtil.format(new Date(), "yyyyMM") + "/";
		return writeCKUploadRes(response, uploadPath, userid, callback, successFile, msg, tag, relatedid, dstPath);
	}

	public static String writeCKUploadRes(HttpServletResponse response, String uploadPath, Long userid, String callback,
			String successFile, String msg, String tag, Long relatedid, String dstPath) throws IOException {
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		if (StringUtils.isBlank(msg)) {
			msg = "";
		}

		String imgUrl = "";
		if (StringUtils.isNotBlank(successFile)) {
			imgUrl = uploadPath + dstPath + successFile;
			moveFilesTo(uploadPath, userid, dstPath, successFile, tag, relatedid);
		}

		String result = "<script type=\"text/javascript\">";
		result = result + "window.parent.CKEDITOR.tools.callFunction(" + callback + ",\'" + imgUrl + "\',\'" + msg
				+ "\')";
		result = result + "</script>";
		out.print(result);
		out.flush();
		out.close();
		return result;
	}

	public static boolean moveFilesTo(String uploadPath, Long userid, String dstPath, String files, String tag,
			Long relatedid) {
		String check = StringUtil.md5(files + dstPath + Config.SYSTEMID + userid + UPLOAD_KEY);
		HashMap params = new HashMap();
		params.put("userid", userid.toString());
		params.put("systemid", Config.SYSTEMID);
		params.put("files", files);
		params.put("path", dstPath);
		params.put("check", check);
		if (StringUtils.isNotBlank(tag)) {
			params.put("tag", tag);
		}

		if (relatedid != null) {
			params.put("relatedid", "" + relatedid);
		}

		String url = uploadPath + "/common/moveTempFilesTo.xhtml";
		HttpResult result = HttpUtils.getUrlAsString(url, params);
		return result.isSuccess() && StringUtils.contains(result.getResponse(), "SUCCESS");
	}
}