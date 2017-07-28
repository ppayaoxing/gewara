/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.matrix;

import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface MatrixMoviceService {
	ResultCode<List<Long>> recommendMoviesTopN(Long arg0, Integer arg1);

	ResultCode<List<Long>> recommendMoviesTop10(Long arg0);
}