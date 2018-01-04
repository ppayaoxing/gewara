package com.gewara.api.gewampi.service;

import java.util.List;

import com.gewara.api.gewampi.vo.MovieItemBasicQueryRequest;
import com.gewara.api.gewampi.vo.MovieItemVo;
import com.gewara.api.vo.ResultCode;

@Deprecated
public interface MovieItemComplexQueryService {

	/**
	 * 根据各种条件查询场次
	 * 按放映时间正序排
	 * 系统自动将结果缓存10分钟
	 * 废弃，日后为电影节提供专门接口
	 * @param request
	 * @return
	 * @author leo
	 * @addTime 2015年6月29日下午4:29:01
	 */
	@Deprecated
	ResultCode<List<MovieItemVo>> findByBasicQuery(MovieItemBasicQueryRequest request);
	
	/**
	 * 查询排片数量
	 * 系统自动将结果缓存10分钟
	 * @param request
	 * @return
	 * @author leo
	 * @addTime 2015年6月30日下午4:04:34
	 */
	@Deprecated
	ResultCode<Integer> findCountByBasicQuery(final MovieItemBasicQueryRequest request);
	
	/**
	 * 将排片中某个属性返回
	 * 系统自动将结果缓存10分钟
	 * @param request
	 * @return
	 * @author leo
	 * @see com.gewara.api.gewampi.service.PlayItemVoService#findCinemaIdByCharacteristic(String characteristic, String citycode, Long movieid, Date playdate)
	 * @addTime 2015年6月30日下午4:04:50
	 */
	@Deprecated
	ResultCode<List> findPropertyListByBasicQuery(final MovieItemBasicQueryRequest request);
	
	/**
	 * 将排片中某个属性，去重后的数量
	 * 系统自动将结果缓存10分钟
	 * @param request
	 * @return
	 * @author leo
	 * @addTime 2015年6月30日下午4:49:23
	 */
	@Deprecated
	ResultCode<Integer> findPropertyCountByBasicQuery(MovieItemBasicQueryRequest request);
}
