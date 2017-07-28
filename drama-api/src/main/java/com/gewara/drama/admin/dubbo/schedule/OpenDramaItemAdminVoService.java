/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.drama.admin.dubbo.schedule;

import com.gewara.api.vo.RequestParamVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.drama.vo.OpenDramaItemExtVo;
import com.gewara.drama.vo.OpenDramaItemVo;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface OpenDramaItemAdminVoService {
	ResultCode<OpenDramaItemVo> getOpenDramaItemByid(Long arg0);

	ResultCode<OpenDramaItemVo> getOpenDramaItemBydpid(Long arg0);

	ResultCode<List<OpenDramaItemVo>> getOpenDramaItemListByDpid(Collection<Long> arg0);

	ResultCode<OpenDramaItemVo> saveOpenDramaItem(RequestParamVo arg0);

	ResultCode<List<OpenDramaItemVo>> getOpenDramaItemListByTheatreid(Long arg0, Long arg1);

	ResultCode<OpenDramaItemVo> updateProperties(Long arg0, String arg1, Serializable... arg2);

	ResultCode<OpenDramaItemVo> saveOdiOther(RequestParamVo arg0);

	ResultCode<List<OpenDramaItemVo>> getOpenDramaItemExpireListByTheatreid(Long arg0, Long arg1);

	ResultCode<OpenDramaItemExtVo> getOdiExtbyDpid(Long arg0);

	ResultCode<OpenDramaItemExtVo> saveOdiExt(RequestParamVo arg0);

	ResultCode<List<OpenDramaItemVo>> getOpenDramaItemListByDramaid(Long arg0);
}