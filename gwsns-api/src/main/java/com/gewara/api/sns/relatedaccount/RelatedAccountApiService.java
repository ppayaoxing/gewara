package com.gewara.api.sns.relatedaccount;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;

public interface RelatedAccountApiService {

	/**
	 * 获取用户关联账户信息
	 * @param memberid
	 * @return
	 */
	ResultCode<List<VoMap<String, String>>> getRelatedAccountVoMapList(Long memberid, String mobilePath);
}
