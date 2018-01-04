package com.gewara.api.terminal.service;

import java.util.List;
import java.util.Map;

import com.gewara.api.terminal.vo.MachineAdVo;
import com.gewara.api.terminal.vo.MachineVo;
import com.gewara.api.vo.ResultCode;

/**
 * terminal 提供的dubbo服务
 *
 */
public interface TerminalMachineVoSerice {

	ResultCode<List<MachineVo>> getMachineList(List<Long> placeIdList, String monitorType);

	ResultCode<List<MachineAdVo>> getMachineAdList(List<Long> placeIdList);

	ResultCode<MachineAdVo> getMachineAd(Long adid);

	ResultCode<String> delMachineAd(Long adid);

	ResultCode<MachineAdVo> saveMachine(MachineAdVo adVo, String realname);

	/**
	 * 根据查询条件，查询已有终端机的影院信息
	 * @param params
	 * @return
	 */
	ResultCode<List<Object>> getMachineCinemaList(Map<String, Object> params);
	
}
