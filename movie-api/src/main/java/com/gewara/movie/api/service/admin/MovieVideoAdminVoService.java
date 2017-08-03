package com.gewara.movie.api.service.admin;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MovieVideoVo;

public interface MovieVideoAdminVoService {
	/**
	 * 保存movievideo对象
	 * @param movieid
	 * @param videoid
	 * @param imgUrl
	 * @return
	 */
	ResultCode<MovieVideoVo> saveOrUpdateMovieVideo(Long movieid, String videoid, String imgUrl);
	/**
	 * 删除movievideo对象
	 * @param videoid
	 * @return
	 */
	ResultCode<MovieVideoVo> removeMovieVideoByVideoid(String videoid);
	/**
	 * 根据videoid查询MovieVideo
	 * @param videoid
	 * @return
	 */
	ResultCode<MovieVideoVo> getMovieVideoByVideoid(String videoid);
}
