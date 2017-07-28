/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.partner;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.CinemaVo;
import com.gewara.movie.vo.MovieVo;
import com.gewara.movie.vo.partner.PartnerCinemaQueryReqVo;
import com.gewara.movie.vo.partner.PartnerCommonReqVo;
import com.gewara.movie.vo.partner.PartnerMovieReqVo;
import java.util.Date;
import java.util.List;

public interface PartnerMCPVoService2 {
	ResultCode<List<MovieVo>> getHotMovies(PartnerMovieReqVo arg0);

	ResultCode<List<CinemaVo>> getCinemaList(PartnerCinemaQueryReqVo arg0);

	ResultCode<List<MovieVo>> getFutureMovies(String arg0, String arg1, Integer arg2, Integer arg3);

	ResultCode<MovieVo> getMovieDetail(String arg0, Long arg1);

	ResultCode<String> characteristicList(String arg0, String arg1, Long arg2);

	ResultCode<CinemaVo> getCinemaDetail(String arg0, Long arg1);

	ResultCode<List<MovieVo>> getMovieVoList(String arg0, List<Long> arg1);

	ResultCode<List<MovieVo>> getCurMovieByCinemaId(String arg0, String arg1, Long arg2, Long arg3, Integer arg4,
			Integer arg5);

	ResultCode<List<CinemaVo>> getCinemaListByCitycodeAndMovieid(PartnerCommonReqVo arg0);

	ResultCode<String> getMovieCharacteristic(String arg0, Long arg1);

	ResultCode<List<CinemaVo>> getSpecailRoomCinemaList(PartnerCommonReqVo arg0);

	ResultCode<String> getMovieCharacteristic(PartnerCommonReqVo arg0);

	ResultCode<String> getMovieCharacteristic2(PartnerCommonReqVo arg0, Date arg1);

	ResultCode<List<CinemaVo>> getCinemaListByCountyAndMovieidAndPlaydate(PartnerCommonReqVo arg0);

	ResultCode<List<CinemaVo>> getCinemaVoList4Advert(PartnerCinemaQueryReqVo arg0);
}