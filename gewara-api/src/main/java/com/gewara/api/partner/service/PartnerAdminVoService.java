package com.gewara.api.partner.service;

import java.util.List;

import com.gewara.api.partner.res.vo.ApiUserPaymethodVo;
import com.gewara.api.partner.res.vo.ApiUserVo;
import com.gewara.api.partner.res.vo.MovieAppIconVo;
import com.gewara.api.partner.res.vo.PaymethodVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.api.ApiUserExtraVo;

public interface PartnerAdminVoService {
	ResultCode<List<PaymethodVo>> paymethodList();
	
	ResultCode<PaymethodVo> getPaymethod(String paymethod); 

	ResultCode savePaymethod(PaymethodVo vo);
	
	ResultCode savePaymethodDesc(Long userid, PaymethodVo vo);
	
	ResultCode<List<ApiUserVo>> apiUserList();
	
	ResultCode<List<ApiUserPaymethodVo>> getApiUserPaymethodList(Long apiUserId);
	
	ResultCode modApiUserPaymethodList(Long apiUserId, String paymethod, Integer msort, Long userid);
	
	ResultCode<List<MovieAppIconVo>> MovieAppIconList();
	
	ResultCode<MovieAppIconVo> getMovieAppIcon(String id);
	
	ResultCode saveMovieAppIcon(String id, MovieAppIconVo movieIcon);
	
	/**
	 * 获取ApiUser
	 * @param apiUserId
	 * @return
	 * @author leo
	 * @addTime 2016年9月22日下午4:32:16
	 */
	ResultCode<com.gewara.api.vo.api.ApiUserVo> getApiUser(Long apiUserId);

	/**
	 * 获取ApiUserExtra
	 * @param apiUserId
	 * @return
	 * @author leo
	 * @addTime 2016年9月22日下午4:32:42
	 */
	ResultCode<ApiUserExtraVo> getApiUserExtra(Long apiUserId);
}
