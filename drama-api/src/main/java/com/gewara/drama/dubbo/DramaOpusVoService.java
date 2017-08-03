package com.gewara.drama.dubbo;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.cmd.DramaOpusVo;

public interface DramaOpusVoService {

	ResultCode<DramaOpusVo> getOpusById(Long id);
	
	ResultCode<List<DramaOpusVo>> getOpusListByDramaId(Long dramaid);
	
}
