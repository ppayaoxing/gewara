package com.gewara.api.service.movie;

import com.gewara.api.vo.ResultCode;

public interface MemberOrderVoService {
	ResultCode<Integer> getMemberOrderHis(Long memberid, String ordertype);
}
