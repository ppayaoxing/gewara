/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.schedule;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaSettleVo;
import com.gewara.drama.vo.SettleConfigVo;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface DramaSettleAdminVoService {
	ResultCode<DramaSettleVo> getDramaSettle(Long arg0);

	ResultCode<SettleConfigVo> getSettleConfig(Long arg0);

	ResultCode<List<DramaSettleVo>> getDramaSettleListByField(String arg0, Serializable arg1);

	ResultCode<SettleConfigVo> addSettleConfig(Double arg0, String arg1);

	ResultCode<DramaSettleVo> addDramaSettle(Long arg0, Double arg1, String arg2);

	ResultCode<List<SettleConfigVo>> getSettleConfigList(Collection<Long> arg0);

	ResultCode<DramaSettleVo> saveDramaSettle(RequestParamVo arg0);
}