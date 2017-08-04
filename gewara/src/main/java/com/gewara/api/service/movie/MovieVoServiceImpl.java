package com.gewara.api.service.movie;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gewara.api.vo.ResultCode;
//import com.gewara.api.vo.movie.CinemaVo;
//import com.gewara.api.vo.movie.MovieGeneralmarkDetailVo;
import com.gewara.api.vo.movie.MovieVo;
import com.gewara.constant.TagConstant;
import com.gewara.model.movie.Cinema;
import com.gewara.model.movie.Movie;
import com.gewara.movie.api.service.MovieVoService;
import com.gewara.movie.vo.CinemaVo;
import com.gewara.movie.vo.MovieVideoVo;
import com.gewara.movie.vo.common.EntityClobVo;
import com.gewara.service.bbs.MarkService;
import com.gewara.service.impl.BaseServiceImpl;
import com.gewara.ucenter.vo.sns.MovieGeneralmarkDetailVo;
import com.gewara.util.VmUtils;
import com.gewara.util.VoCopyUtil;

public class MovieVoServiceImpl extends BaseServiceImpl implements MovieVoService{
	@Autowired@Qualifier("markService")
	private MarkService markService;
	
	@Override
	public ResultCode<CinemaVo> getCinemaVoById(Long cinemaid) {
		Cinema cinema = baseDao.getObject(Cinema.class, cinemaid);
		return VoCopyUtil.copyProperties(CinemaVo.class, cinema);
	}

	@Override
	public ResultCode<MovieVo> getMovieVoById(Long movieid) {
		Movie movie = baseDao.getObject(Movie.class, movieid);
		ResultCode<MovieVo> result = VoCopyUtil.copyProperties(MovieVo.class, movie);
		if(!result.isSuccess()){
			return result;
		}
		Map markData = markService.getMarkdata(TagConstant.TAG_MOVIE);
		result.getRetval().setGeneralmark(VmUtils.getLastMarkStar(movie, "general", markService.getMarkCountByTagRelatedid(TagConstant.TAG_MOVIE, movie.getId()),
				markData));
		return result;
	}

	@Override
	public ResultCode<List<MovieGeneralmarkDetailVo>> getMovieGeneralmarkDetail(long movieId) {
		Movie movie = baseDao.getObject(Movie.class, movieId);
		if(movie == null){
			return ResultCode.getFailure(ResultCode.CODE_DATA_ERROR, "电影数据不存在！"); 
		}
		List<Map> detailMap = markService.getGradeDetail(TagConstant.TAG_MOVIE, movie.getId());
		return VoCopyUtil.copyListProperties(MovieGeneralmarkDetailVo.class, detailMap);
	}

	@Override
	public ResultCode<com.gewara.movie.vo.MovieVo> getMovieById(Long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<com.gewara.movie.vo.MovieVo> getMovieByUkey(String ukeyName, Serializable ukeyValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getMovieListByIdList(List<Long> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getMovieListByIdListWithOutCache(List<Long> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<EntityClobVo> getMovieEntityClob(Long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getFutureMovieList(int from, int maxnum, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getCurMovieList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getCurMovieListByCitycode(String citycode, int from,
			int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<Long>> getMovieListByReleasedate(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getCurMovieListByCitycodeOrderClickedtimes(String citycode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Long> refreshQzMovieid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Integer> getMovieCountByidAndName(Long movieid, String movieName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getMovieListByMovieName(String moviename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getMovieListByLikeMovieName(String moviename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getOffLineMoveList(String citycode, String order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getAdminMovieList(String hot, String moviename, Date fromDate,
			Date toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getMovieListByDate(String playdate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getCurMovieListByCinemaId(Long cinemaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getCurMovieListByCinemaIdAndDate(Long cinemaId,
			Date playdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getMovieListByDateAndPage(String playdate, String endDate,
			int from, int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Integer> countMovieListByDate(String playdate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<MovieVideoVo> getMovieVideoByMovieId(Long movieid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<MovieVideoVo> getMovieVideoByVideoid(String videoid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<Long>> checkMovieExist(List<Long> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<Long>> getFilmFestMovieIdList(String flag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Map<String, Object>> getHotMovieAndStar(String citycode, Long cinemaid, Date playdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getMovieList(Integer from, Integer rows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Integer> getAllMovieCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<Long>> getMpidListByMovieidAndStarmeet(Long movieid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<Map>> getFieldsMapByUpdate(String fields, Timestamp updatetime, int from, int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<Map<String, Object>>> getStarListByMovieId(Long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<com.gewara.movie.vo.MovieVo> updateMovieProperties(Long movieId, String[] properties,
			Serializable[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getCurMovieListByDate(Date playdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getCurMovieListByDate(String citycode, Date playdate, int from,
			int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getMovieListBetweenPlaydate(String startPlayDate,
			String endPlayDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<com.gewara.movie.vo.MovieVo>> getMovieListBetweenReleasedate(Date startReleasedate,
			Date endReleasedate, String offlineDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<String> getSearchMovieOrderReleasedate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<String> getMovieMark(Long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<Long> getCacheMovieIdByMoviename(String moviename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultCode<List<Long>> getMovieListByUpdatetime(Timestamp updatetime, int from, int maxnum) {
		// TODO Auto-generated method stub
		return null;
	}
}
