/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin;

import com.gewara.api.vo.ResultCode;
import java.util.List;
import java.util.Map;

public interface CinemaPriceTierAdminVoService {
	ResultCode<Map> getCinemaPriceTierByCinemaId(Long arg0);

	ResultCode<List<Map>> getCinemaPriceTierListByCinemaId(Long arg0);

	ResultCode<List<Map>> getCinemaPriceTierByCinemaIdList(List<Long> arg0);

	ResultCode<List<Map>> getCinemaPriceTierByCityCode(String arg0);

	ResultCode<List<Map>> getCinemaPriceTierByCityCodeAsc(String arg0);

	ResultCode removeCinemaPriceTierByCinemaId(Long arg0);

	ResultCode addCinemaPriceTierByCinemaId(Map arg0);

	ResultCode addCinemaPriceTierBySystemId(Map arg0);

	ResultCode saveOrUpdateByCinemaId(Map arg0);
}