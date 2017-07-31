package com.gewara.api.service.drama;

import com.gewara.api.vo.ResultCode;

public interface DramaPrioritizeVoService {

	ResultCode checkPrioritize(Long dramaid, Long memberid, Long partnerid);
}
