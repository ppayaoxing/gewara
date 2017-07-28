/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.web.util;

import com.gewara.web.util.PageInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.util.HtmlUtils;

public class PageUtil {
	public static final String PARAM_PAGE_NUM = "pageNo";
	public static final String PARAM_ROWS_COUNT = "rowsCount";
	public static final String PARAM_ROWS_PER_PAGE = "rowsPerPage";
	private int currentPage;
	private int rowsCount;
	private int startNum;
	private int endNum;
	private int pageCount;
	private int rowsPerPage;
	private boolean isShowFirst;
	private boolean isShowLast;
	private String scriptParams;
	private String commonParams;
	private String firsturl;
	private String preurl;
	private String nexturl;
	private String lasturl;
	private String encode = "UTF-8";
	private List<PageInfo> pageInfoList;
	private String baseUrl;

	public String getEncode() {
		return this.encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	public List<PageInfo> getPageInfoList() {
		return this.pageInfoList;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public int getRowsCount() {
		return this.rowsCount;
	}

	public int getRowsPerPage() {
		return this.rowsPerPage;
	}

	public int getPageCount() {
		return this.pageCount;
	}

	public PageUtil(int rowsCount, int rowsPerPage, int currentPage, String url) {
		this.rowsCount = rowsCount;
		this.rowsPerPage = rowsPerPage;
		this.currentPage = currentPage;
		this.pageCount = (rowsCount - 1) / rowsPerPage + 1;
		this.startNum = Math.max(0, currentPage - 3);
		this.endNum = Math.min(this.startNum + 6, this.pageCount);
		if (StringUtils.isBlank(url)) {
			this.baseUrl = "";
		} else {
			this.baseUrl = url;
		}

	}

	public PageUtil(int rowsCount, int rowsPerPage, int currentPage, String url, boolean isShowFirst,
			boolean isShowLast) {
		this.rowsCount = rowsCount;
		this.rowsPerPage = rowsPerPage;
		this.currentPage = currentPage;
		this.pageCount = (rowsCount - 1) / rowsPerPage + 1;
		this.startNum = Math.max(0, currentPage - 3);
		this.endNum = Math.min(this.startNum + 6, this.pageCount);
		if (StringUtils.isBlank(url)) {
			this.baseUrl = "";
		} else {
			this.baseUrl = url;
		}

		this.isShowFirst = isShowFirst;
		this.isShowLast = isShowLast;
	}

	public void initPageInfo(Map params, List paramNames) {
		this.pageInfoList = new ArrayList();
		String commonParam = "";
		String scriptParam = "{";
		if (params != null) {
			if (paramNames == null) {
				paramNames = new ArrayList(params.keySet());
			}

			Iterator pn = ((List) paramNames).iterator();

			label105 : while (true) {
				Object pageInfo;
				Object tmpUrl;
				do {
					do {
						if (!pn.hasNext()) {
							break label105;
						}

						pageInfo = pn.next();
					} while (pageInfo.equals("pageNo"));

					tmpUrl = params.get(pageInfo);
				} while (tmpUrl == null);

				String[] tmp = null;
				if (tmpUrl instanceof String[]) {
					tmp = (String[]) ((String[]) tmpUrl);
				} else {
					tmp = new String[]{"" + tmpUrl};
				}

				String[] arg8 = tmp;
				int arg9 = tmp.length;

				for (int arg10 = 0; arg10 < arg9; ++arg10) {
					String value = arg8[arg10];
					if (StringUtils.isNotBlank(value)) {
						try {
							commonParam = commonParam + "&" + pageInfo + "=" + URLEncoder.encode(value, this.encode);
							scriptParam = scriptParam + "\'" + pageInfo + "\':\'" + HtmlUtils.htmlEscape(value) + "\',";
						} catch (UnsupportedEncodingException arg13) {
							;
						}
					}
				}
			}
		}

		if (scriptParam.length() > 1) {
			this.scriptParams = scriptParam.substring(0, scriptParam.length() - 1) + "}";
		}

		this.commonParams = commonParam;
		if (this.isPrePage()) {
			String arg14 = this.baseUrl;
			int arg15 = this.currentPage - 1;
			if (arg15 == 0) {
				if (StringUtils.isNotBlank(commonParam)) {
					arg14 = arg14 + "?" + StringUtils.substring(commonParam, 1);
				}
			} else {
				arg14 = arg14 + "?pageNo=" + arg15 + commonParam;
			}

			this.preurl = arg14;
		}

		for (int arg16 = this.startNum; arg16 < this.endNum; ++arg16) {
			PageInfo arg17 = new PageInfo();
			String arg18 = this.baseUrl;
			if (arg16 == 0) {
				if (StringUtils.isNotBlank(commonParam)) {
					arg18 = arg18 + "?" + StringUtils.substring(commonParam, 1);
				}
			} else {
				arg18 = arg18 + "?pageNo=" + arg16 + commonParam;
			}

			arg17.setUrl(arg18);
			arg17.setPageNo("" + (arg16 + 1));
			arg17.setRealPageNo(arg16);
			if (arg16 == this.currentPage) {
				arg17.setCurrentPage(true);
			}

			if (this.isLastPage()) {
				if (arg16 + 1 != this.pageCount) {
					this.pageInfoList.add(arg17);
				}
			} else {
				this.pageInfoList.add(arg17);
			}
		}

		if (this.isNextPage()) {
			this.nexturl = this.baseUrl + "?pageNo=" + (this.currentPage + 1) + commonParam;
		}

		if (this.isFirstPage()) {
			if (StringUtils.isNotBlank(commonParam)) {
				this.firsturl = this.baseUrl + "?" + StringUtils.substring(commonParam, 1);
			} else {
				this.firsturl = this.baseUrl;
			}
		}

		if (this.isLastPage()) {
			this.lasturl = this.baseUrl + "?pageNo=" + (this.pageCount - 1) + commonParam;
		}

	}

	public void initPageInfo() {
		this.initPageInfo((Map) null);
	}

	public void initPageInfo(Map<String, ?> params) {
		this.initPageInfo(params, (List) null);
	}

	public String getCommonParams() {
		return this.commonParams;
	}

	public void setCommonParams(String commonParams) {
		this.commonParams = commonParams;
	}

	public String getScriptParams() {
		return this.scriptParams;
	}

	public void setScriptParams(String scriptParams) {
		this.scriptParams = scriptParams;
	}

	public boolean getIsShowFirst() {
		return this.isShowFirst;
	}

	public void setIsShowFirst(boolean isShowFirst) {
		this.isShowFirst = isShowFirst;
	}

	public boolean getIsShowLast() {
		return this.isShowLast;
	}

	public void setIsShowLast(boolean isShowLast) {
		this.isShowLast = isShowLast;
	}

	public String getFirsturl() {
		return this.firsturl;
	}

	public void setFirsturl(String firsturl) {
		this.firsturl = firsturl;
	}

	public String getPreurl() {
		return this.preurl;
	}

	public void setPreurl(String preurl) {
		this.preurl = preurl;
	}

	public String getNexturl() {
		return this.nexturl;
	}

	public void setNexturl(String nexturl) {
		this.nexturl = nexturl;
	}

	public String getLasturl() {
		return this.lasturl;
	}

	public void setLasturl(String lasturl) {
		this.lasturl = lasturl;
	}

	public boolean isFirstPage() {
		return this.isShowFirst && this.currentPage > 5;
	}

	public boolean isPrePage() {
		return this.currentPage > 0;
	}

	public boolean isNextPage() {
		return this.currentPage + 1 < this.pageCount;
	}

	public boolean isLastPage() {
		return this.isShowLast && this.pageCount > 5;
	}

	public boolean isOnLast(String pageNo) {
		if (StringUtils.isBlank(pageNo)) {
			pageNo = "0";
		}

		return this.isLastPage()
				&& StringUtils.equals(Integer.valueOf(pageNo).intValue() + 1 + "", this.pageCount + "");
	}
}