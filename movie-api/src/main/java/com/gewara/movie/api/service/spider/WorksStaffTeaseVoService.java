/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.spider;

import java.sql.Timestamp;

public interface WorksStaffTeaseVoService {
	void worksStaffTease();

	void addCastProfile();

	void clearTeaseData();

	void resetCastProfileOrder(Timestamp arg0);

	void checkCastProfileMovieRelationData();

	void writeToSimpleCastProfileFromExcel(String arg0, String arg1, String arg2);

	void writeToMovieRelationFromExcel(String arg0, Long arg1, Long arg2, String arg3, String arg4, String arg5);

	void writeToCastProfileMovieRelationFromExcel(String arg0, String arg1, Long arg2, Long arg3, String arg4,
			String arg5, String arg6);
}