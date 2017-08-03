package com.gewara.drama.dubbo.partner.theatre;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaVo;
import com.gewara.drama.vo.partner.req.TheatreDramaReqVo;

public interface TheatreDramaVoService {
	
	/**
	 * 获取场馆项目
	 * @param reqVo
	 * @return
	 */
	ResultCode<List<DramaVo>> getDramaListByTheatre(TheatreDramaReqVo reqVo);
}
