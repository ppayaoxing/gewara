/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.partner2.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.partner2.vo.AdvertCommendVo;
import com.gewara.partner2.vo.CinemaConstraintVo;
import com.gewara.partner2.vo.DistributionPartnerVo;
import com.gewara.partner2.vo.PartnerVo;
import com.gewara.partner2.vo.PaymethodIconVo;
import com.gewara.partner2.vo.ShareBenefitVo;
import com.gewara.partner2.vo.WpConfigVo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface WpVoService {
	ResultCode<List<PaymethodIconVo>> getPaymethodIconsVoList();

	ResultCode<String> getPayIconByPayMethod(Map<String, Object> arg0);

	ResultCode<WpConfigVo> getWpConfig(Serializable arg0);

	PartnerVo loadAdminPartnerByAppkey(String arg0, boolean arg1);

	ResultCode<List<AdvertCommendVo>> getAdvertCommendList(String arg0, String arg1);

	ResultCode<DistributionPartnerVo> getPartnerByIdOrKey(long arg0, String arg2);

	ResultCode<List<DistributionPartnerVo>> gainDistributionPartnerList();

	ResultCode<List<CinemaConstraintVo>> getCinemaConstraintList(String arg0, String arg1);

	ResultCode<String> shareBenefitRecord(ShareBenefitVo arg0);
}