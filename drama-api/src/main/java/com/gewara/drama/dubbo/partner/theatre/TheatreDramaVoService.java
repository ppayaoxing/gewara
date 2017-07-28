/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.dubbo.partner.theatre;

import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaVo;
import com.gewara.drama.vo.partner.req.TheatreDramaReqVo;
import java.util.List;

public interface TheatreDramaVoService {
	ResultCode<List<DramaVo>> getDramaListByTheatre(TheatreDramaReqVo arg0);
}