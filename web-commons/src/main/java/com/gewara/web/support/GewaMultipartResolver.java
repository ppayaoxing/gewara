/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.support;

import com.gewara.util.GewaLogger;
import com.gewara.util.WebLogger;
import com.gewara.web.support.ErrorMultipartRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport.MultipartParsingResult;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class GewaMultipartResolver extends CommonsMultipartResolver {
	private final transient GewaLogger dbLogger = WebLogger.getLogger(this.getClass());

	public MultipartHttpServletRequest resolveMultipart(HttpServletRequest request) throws MultipartException {
		Assert.notNull(request, "Request must not be null");
		if (!this.isMultipart(request)) {
			return new ErrorMultipartRequest(request, "请重新选择文件上传！");
		} else {
			try {
				MultipartParsingResult e = this.parseRequest(request);
				return new DefaultMultipartHttpServletRequest(request, e.getMultipartFiles(),
						e.getMultipartParameters(), e.getMultipartParameterContentTypes());
			} catch (MaxUploadSizeExceededException arg2) {
				return new ErrorMultipartRequest(request, "文件大小超出范围！");
			} catch (Exception arg3) {
				this.dbLogger.warn("", arg3);
				return new ErrorMultipartRequest(request, "上传出现错误！");
			}
		}
	}
}