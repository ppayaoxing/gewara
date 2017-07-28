/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.drama;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaProfileVo;
import java.util.List;

public interface DramaProfileAdminVoService {
	ResultCode<DramaProfileVo> getDramaProfileByDramaid(Long arg0);

	ResultCode<List<DramaProfileVo>> getDramaProfileList();

	ResultCode<DramaProfileVo> saveDramaProfile(RequestParamVo arg0);

	ResultCode<DramaProfileVo> saveDramaMobileInfo(RequestParamVo arg0);
}