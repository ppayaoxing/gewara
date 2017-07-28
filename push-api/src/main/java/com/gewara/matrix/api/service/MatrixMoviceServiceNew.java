/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.matrix.api.service;

import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface MatrixMoviceServiceNew {
	ResultCode<List<Long>> recommendMoviesTopN(Long arg0, Integer arg1);
}