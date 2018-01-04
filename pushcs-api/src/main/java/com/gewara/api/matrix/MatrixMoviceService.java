package com.gewara.api.matrix;

import java.util.List;

import com.gewara.api.vo.ResultCode;

/**
 * Matrix电影业务接口
 * @author jeremylei
 * @date 2016/05/16
 */
public interface MatrixMoviceService {
	
	/**
	 * 根据电影id，获取推荐的电影列表
	 * @param movieid
	 * @param topN
	 * @return
	 */
	public ResultCode<List<Long>> recommendMoviesTopN(Long movieid,Integer topN);
	
	/**
	 * 根据电影id，获取推荐的电影列表
	 * @param movieid
	 * @return
	 */
	public ResultCode<List<Long>> recommendMoviesTop10(Long movieid);
}
