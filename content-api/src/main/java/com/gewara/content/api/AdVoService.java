package com.gewara.content.api;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.content.vo.AdvertisingVo;

public interface AdVoService {
	ResultCode<AdvertisingVo> getFirstAdByPostionTag(String tag);
	ResultCode<List<AdvertisingVo>> getAdListByPid(String citycode, String pid);
}
