package com.gewara.partner2.dubbo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.partner2.vo.AdvertCommendVo;
import com.gewara.partner2.vo.CinemaConstraintVo;
import com.gewara.partner2.vo.DistributionPartnerVo;
import com.gewara.partner2.vo.PartnerVo;
import com.gewara.partner2.vo.PaymethodIconVo;
import com.gewara.partner2.vo.ShareBenefitVo;
import com.gewara.partner2.vo.WpConfigVo;

/**
 * (wap站 远程服务)
 * @author chunhui.wang
 */
public interface WpVoService {
	/**
	 * (获取所有支付方式及图标)
	 * @return
	 */
	ResultCode<List<PaymethodIconVo>> getPaymethodIconsVoList();
	
	/**
	 * (根据支付方式获取支付图标)
	 * @param params	请求参数
	 * @return
	 */
	ResultCode<String> getPayIconByPayMethod(Map<String, Object> params);
	
	ResultCode<WpConfigVo> getWpConfig(Serializable id);
	
	PartnerVo loadAdminPartnerByAppkey(String appkey, boolean reload);
	
	ResultCode<List<AdvertCommendVo>> getAdvertCommendList(String appkey, String citycode);
	
	/**
	 * 获取分销系统合作商 (若partnerId为0 则根据partnerKey查询,否则根据partnerID查询)
	 * @param partnerid	合作商ID[必参 默认值：0]
	 * @param partnerKey	合作商key[可选 允许空]
	 * @return
	 */
	ResultCode<DistributionPartnerVo> getPartnerByIdOrKey(long partnerId,String partnerKey);
	
	/**
	 * 获取所有合作商
	 * @return
	 */
	ResultCode<List<DistributionPartnerVo>> gainDistributionPartnerList();
	
	/**
	 * 获取隐藏约束
	 * @param partnerKey	合作商key
	 * @param hidetype		隐藏类型【若空，仅根据partnerkey查询】	1 影院  2 高价 3 时间
	 * @return
	 */
	ResultCode<List<CinemaConstraintVo>> getCinemaConstraintList(String partnerKey, String hidetype);
	
	/**
	 * 分润记录
	 * @param shareBenefitVo
	 * @return
	 */
	ResultCode<String> shareBenefitRecord(ShareBenefitVo shareBenefitVo);
}