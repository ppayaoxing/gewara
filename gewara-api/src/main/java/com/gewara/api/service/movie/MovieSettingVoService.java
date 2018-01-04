package com.gewara.api.service.movie;

import com.gewara.api.vo.ResultCode;

public interface MovieSettingVoService {
	/**
	 * 电影赠送积分
	 * @param movieid
	 * @return
	 */
	ResultCode<Integer> getMovieScore(Long movieid);

}
