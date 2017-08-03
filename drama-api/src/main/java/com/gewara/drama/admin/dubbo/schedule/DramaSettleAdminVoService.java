package com.gewara.drama.admin.dubbo.schedule;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.DramaSettleVo;
import com.gewara.drama.vo.SettleConfigVo;

public interface DramaSettleAdminVoService {
	
	ResultCode<DramaSettleVo> getDramaSettle(Long id);
	
	ResultCode<SettleConfigVo> getSettleConfig(Long id);
	
	ResultCode<List<DramaSettleVo>> getDramaSettleListByField(String fieldname, Serializable fieldvalue);
	
	ResultCode<SettleConfigVo> addSettleConfig(Double discount, String distype);

	ResultCode<DramaSettleVo> addDramaSettle(Long dramaid, Double discount, String distype);

	ResultCode<List<SettleConfigVo>> getSettleConfigList(Collection<Long> idList);
	
	ResultCode<DramaSettleVo> saveDramaSettle(RequestParamVo paramVo);

}
