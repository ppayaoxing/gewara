/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.partner.service;

import com.gewara.api.partner.res.vo.ApiUserPaymethodVo;
import com.gewara.api.partner.res.vo.ApiUserVo;
import com.gewara.api.partner.res.vo.MovieAppIconVo;
import com.gewara.api.partner.res.vo.PaymethodVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.api.ApiUserExtraVo;
import java.util.List;

public interface PartnerAdminVoService {
	ResultCode<List<PaymethodVo>> paymethodList();

	ResultCode<PaymethodVo> getPaymethod(String arg0);

	ResultCode savePaymethod(PaymethodVo arg0);

	ResultCode savePaymethodDesc(Long arg0, PaymethodVo arg1);

	ResultCode<List<ApiUserVo>> apiUserList();

	ResultCode<List<ApiUserPaymethodVo>> getApiUserPaymethodList(Long arg0);

	ResultCode modApiUserPaymethodList(Long arg0, String arg1, Integer arg2, Long arg3);

	ResultCode<List<MovieAppIconVo>> MovieAppIconList();

	ResultCode<MovieAppIconVo> getMovieAppIcon(String arg0);

	ResultCode saveMovieAppIcon(String arg0, MovieAppIconVo arg1);

	ResultCode<com.gewara.api.vo.api.ApiUserVo> getApiUser(Long arg0);

	ResultCode<ApiUserExtraVo> getApiUserExtra(Long arg0);
}