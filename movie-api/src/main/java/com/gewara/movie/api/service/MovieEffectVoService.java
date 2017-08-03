package com.gewara.movie.api.service;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.EffectInfoVo;

public interface MovieEffectVoService {
	ResultCode<List<EffectInfoVo>> getEffectInfoListByMovieId(Long movieid);
	ResultCode<Long> getWatchMovieCountByMidEffect(Long movieid,String effect);
	/**
	 * 查询用户观看过的特效的集合
	 * 注意特效集合是每个特效的统一标示，例如IMAX2D,IMAX3D的统一标示都是IMAX
	 * @param memberid
	 * @return
	 */
	ResultCode<List<String>> getEffectsByMemberid(Long memberid);
	ResultCode<List<String>> getCityEffectUnifysByCitycode(String citycode);
	ResultCode<Map<String,Map<String,String>>> getMovieEffectMap();
	
	/**
	 * 获取电影特效图片
	 * @param mobilePath
	 * @param citycode
	 * @param movieid
	 * @param isIphone
	 * @return
	 */
	ResultCode<Map<String, Object>> getMovieIcon(String mobilePath, String citycode, Long movieid, boolean isIphone);
	
}
