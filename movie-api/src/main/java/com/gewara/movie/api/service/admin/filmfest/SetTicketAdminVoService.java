/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin.filmfest;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.filmfest.SetTicketVo;
import java.util.List;
import java.util.Map;

public interface SetTicketAdminVoService {
	ResultCode<SetTicketVo> getSetTicketVoById(String arg0);

	ResultCode<List<SetTicketVo>> getSetTicketListByTag(String arg0);

	ResultCode<SetTicketVo> saveSetTicketVo(String arg0, Map<String, String> arg1);

	ResultCode removeSetTicketVo(String arg0);
}