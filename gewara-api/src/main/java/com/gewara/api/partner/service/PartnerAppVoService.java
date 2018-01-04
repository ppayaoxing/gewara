package com.gewara.api.partner.service;

import java.util.List;

import com.gewara.api.partner.req.vo.PartnerCommonReqVo;
import com.gewara.api.partner.res.vo.OpenCityVo;
import com.gewara.api.partner.res.vo.PhoneActivityVo;
import com.gewara.api.partner.res.vo.UpGradeVo;
import com.gewara.api.partner.res.vo.WeiXinAdVo;
import com.gewara.api.vo.ResultCode;

public interface PartnerAppVoService {
	/**
	 * 为app、wap增加意见反馈
	 * @param reqVo
	 * @return
	 */
	ResultCode<String> addComplain(PartnerCommonReqVo reqVo);
	/**
	 * app升级接口
	 * @param reqVo
	 * @return
	 */
	ResultCode<UpGradeVo> getUpGrade(PartnerCommonReqVo reqVo);
	/**
	 * 获取手机活动广告详情
	 * @param reqVo
	 * @return
	 */
	ResultCode<PhoneActivityVo> getPhoneActivity(PartnerCommonReqVo reqVo);
	/**
	 * 获取手机活动广告列表
	 * @param reqVo
	 * @return
	 */
	ResultCode<List<PhoneActivityVo>> getPhoneActivityList(PartnerCommonReqVo reqVo);
	/**
	 * 获取微信活动广告详情
	 * @param reqVo
	 * @return
	 */
	ResultCode<WeiXinAdVo> getWeiXinAd(PartnerCommonReqVo reqVo);
	/**
	 * 获取开放购票的城市
	 * @param reqVo
	 * @return
	 */
	ResultCode<List<OpenCityVo>> getOpenCity(PartnerCommonReqVo reqVo);
}
