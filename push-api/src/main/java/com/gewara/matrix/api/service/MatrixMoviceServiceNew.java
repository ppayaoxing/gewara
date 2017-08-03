package com.gewara.matrix.api.service;

import java.util.List;

import com.gewara.api.vo.ResultCode;

public interface MatrixMoviceServiceNew{
	
	public ResultCode<List<Long>> recommendMoviesTopN(Long movieid, Integer topN);
}
