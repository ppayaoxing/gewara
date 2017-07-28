/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.admin;

import com.gewara.api.vo.ResultCode;
import java.util.List;
import java.util.Map;

public interface CityPriceTierAdminVoService {
	ResultCode removeCityPriceTierById(String arg0);

	ResultCode saveOrUpdateCityPriceTier(Map arg0);

	ResultCode<List<Map>> getAllCityPriceTier();

	ResultCode<Map> getCityPriceTierById(String arg0);
}