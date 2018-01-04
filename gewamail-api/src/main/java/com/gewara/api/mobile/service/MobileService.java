package com.gewara.api.mobile.service;

import java.util.List;

import com.gewara.api.Response;
import com.gewara.api.vo.ResultCode;

/**
 * 手机号服务
 * @author quzhuping
 *
 */
public interface MobileService {

	/**
	 * 保存传递过来的手机号列表
	 * @param mobileList
	 * @return
     * @see #saveMobiles2
	 */
	@Deprecated
	public Response saveMobiles(List<String> mobileList);

	/**
	 * 保存传递过来的手机号列表
	 * @param mobileList
	 * @return
	 */
	public ResultCode saveMobiles2(List<String> mobileList);
	
	/**
	 * 从mongo批量导入手机号
	 * @param batchId mongo批次号
	 * @return
     * @see #batchImportMobiles2
	 */
	@Deprecated
	public Response batchImportMobiles(String batchId);
	
	/**
	 * 从mongo批量导入手机号
	 * @param batchId mongo批次号
	 * @return
	 */
	public ResultCode batchImportMobiles2(String batchId);
	
}
