package com.gewara.drama.dubbo;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaStyleVo;

public interface DramaStyleVoService {

	ResultCode<DramaStyleVo> getStyleById(Long id);
	
}
