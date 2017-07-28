/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.terminal.service;

import com.gewara.api.terminal.vo.MachineAdVo;
import com.gewara.api.terminal.vo.MachineVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;
import java.util.Map;

public interface TerminalMachineVoSerice {
	ResultCode<List<MachineVo>> getMachineList(List<Long> arg0, String arg1);

	ResultCode<List<MachineAdVo>> getMachineAdList(List<Long> arg0);

	ResultCode<MachineAdVo> getMachineAd(Long arg0);

	ResultCode<String> delMachineAd(Long arg0);

	ResultCode<MachineAdVo> saveMachine(MachineAdVo arg0, String arg1);

	ResultCode<List<Object>> getMachineCinemaList(Map<String, Object> arg0);
}