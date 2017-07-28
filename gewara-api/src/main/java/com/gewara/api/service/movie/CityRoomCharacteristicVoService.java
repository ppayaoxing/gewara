/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.movie;

import com.gewara.api.vo.ResultCode;
import java.util.Map;

public interface CityRoomCharacteristicVoService {
	ResultCode<Map<String, String>> getCharacteristicRoomById(String arg0);
}