/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.CinemaProfileVo;
import com.gewara.movie.vo.CinemaRoomVo;
import com.gewara.movie.vo.CinemaVo;
import com.gewara.movie.vo.common.EntityClobVo;
import com.gewara.movie.vo.partner.SearchCinemaCommandVo;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CinemaVoService2 {
	ResultCode<List<CinemaVo>> getCinemaListByIdList(List<Long> arg0);

	ResultCode<List<CinemaVo>> getCinemaListByCitycode(String arg0);

	ResultCode<CinemaVo> getCinemaByIdWithOutCache(Long arg0);

	ResultCode<CinemaProfileVo> getCinemaProfileByIdWithOutCache(Long arg0);

	ResultCode<CinemaProfileVo> getCinemaProfileById(Long arg0);

	ResultCode<CinemaVo> getCinemaById(Long arg0);

	ResultCode<EntityClobVo> getCinemaEntityClob(Long arg0);

	ResultCode saveCinemaEntityClob(Long arg0, String arg1);

	ResultCode<List<Long>> getRoomIdListByCinemaAndCtype(long arg0, String arg2);

	ResultCode<CinemaRoomVo> getCinemaRoomById(long arg0);

	ResultCode<CinemaRoomVo> getRoomByRoomnum(Long arg0, String arg1);

	ResultCode<CinemaRoomVo> getRoomByRoomname(Long arg0, String arg1);

	ResultCode<Map<Long, String>> getMovieInfoByIds(String arg0, List<Long> arg1);

	ResultCode<Map<Long, List<String>>> getCinemaOtherInfo(List<CinemaVo> arg0, String arg1, Long arg2);

	ResultCode<Map<Long, List<String>>> getCinemaRoomCharacter(String arg0, Long arg1, Date arg2);

	ResultCode<Map<Long, List<String>>> getCinemaRoomCharacter(List<Long> arg0, String arg1, Long arg2, Date arg3);

	ResultCode<Map<Long, String>> getCinemaPlayText(List<Long> arg0, Long arg1, Date arg2);

	ResultCode<Map<Long, CinemaRoomVo>> getCinemaRoomByRoomIds(List<Long> arg0);

	ResultCode cinemaCanRefund(Long arg0);

	ResultCode<Map<String, List<CinemaVo>>> getCharacteristicCinemaRoom(String arg0);

	ResultCode<Map<String, List<Map>>> getCinemaMapListByCitycode(String arg0, String arg1, int arg2, int arg3);

	ResultCode<List<CinemaVo>> getCinemaListByFiled(String arg0, Serializable arg1);

	ResultCode<List<CinemaVo>> getCinemaListLikeName(String arg0);

	ResultCode<List<CinemaRoomVo>> getCinemaRoomListByIdList(List<Long> arg0);

	ResultCode<List<CinemaVo>> getBookingCinemaListByCitycodeNoCache(String arg0);

	ResultCode<List<CinemaRoomVo>> getCinemaRoomListByCinemaId(Long arg0);

	ResultCode<List<CinemaRoomVo>> getCinemaRoomListByFiled(String arg0, Serializable arg1);

	ResultCode<List<CinemaProfileVo>> getCinemaProfileListByFiled(String arg0, Serializable arg1);

	ResultCode<List<CinemaProfileVo>> getCinemaProfileListByIdList(List<Long> arg0);

	ResultCode<List<CinemaRoomVo>> getCloseCinemaRoomListForPage(int arg0, int arg1);

	ResultCode<List<Map>> getCinemaidAndNameDataListMapByCityData(String arg0);

	ResultCode<List<Map>> getAllCinemaidAndNameDataListMap();

	ResultCode<List<CinemaVo>> getCinemaListByCPStatus(String arg0);

	ResultCode<List<CinemaVo>> getCinemaListByCPOpenType(String arg0);

	ResultCode<List<Map>> getCinemaCharacteristicAndcitycodeDataMap();

	ResultCode<List<Long>> getCinemaIdListLikeName(String arg0);

	ResultCode<List<Long>> getCinemaIdListByOpenPriority(String arg0);

	ResultCode<List<Long>> getCinemaIdListByOpenPriorityAndCityCodeList(String arg0, List<String> arg1);

	ResultCode<List<Long>> getCinemaIdListByBooking(String arg0, List<Long> arg1);

	ResultCode<List<CinemaVo>> getCinemaListByCityCodeListProfileNotNull(List<String> arg0);

	ResultCode<List<Long>> getCinemaIdListByCitycodeAndBookingStatus(String arg0, List<String> arg1);

	ResultCode<List<Long>> getCinemaProfileIdListByOpenProiorityList(List<String> arg0);

	ResultCode<CinemaVo> getCinemaByUkey(String arg0, Serializable arg1);

	ResultCode<List<CinemaVo>> getCinemaListByBookingOrderMark(String arg0);

	ResultCode<List<CinemaVo>> getCinemaListByCountycode(String arg0);

	ResultCode<List<Long>> getCinemaIdListByRoomCharacteristic(String arg0, String arg1);

	ResultCode<Integer> getTicketCinemaCount(String arg0, String arg1, String arg2, String arg3);

	ResultCode<List<Long>> getBookingCinemaIdList(String arg0, String arg1);

	ResultCode<Map<String, Integer>> getRoomFeatureCinema(String arg0);

	ResultCode<Integer> getCinemaCountByCitycode(String arg0);

	ResultCode<List<CinemaVo>> getCinemaListByCitycodeAndCitycodeForFilm(String arg0, String arg1, String arg2);

	ResultCode<Map<Long, String>> getCtypeMapByRoomIdList(List<Long> arg0);

	ResultCode<List<Long>> getCinemaIdListBySearchCmd(SearchCinemaCommandVo arg0, String arg1);

	ResultCode<Map<Long, String>> getCharacteristicCinemaRoomByCinema(Long arg0);

	ResultCode<List<Long>> getBuyInsureCinemaIdList();

	ResultCode<List<Long>> getCinemaListByUpdatetime(Timestamp arg0, int arg1, int arg2);

	ResultCode<List<CinemaVo>> getCinemaListByHotvalue(String arg0, int arg1, int arg2);

	ResultCode<List<CinemaVo>> getCinemaListByCountyCodeOrderClick(String arg0, String arg1, boolean arg2);

	ResultCode<List<Map>> getFieldsMapByUpdate(String arg0, Timestamp arg1, int arg2, int arg3);

	ResultCode<List<CinemaVo>> getCinemaListByCitycodeForPage(String arg0, int arg1, int arg2);

	ResultCode<CinemaVo> updateCinemaProperties(Long arg0, String[] arg1, Serializable[] arg2);

	ResultCode<String> getCinemaCharacteristicByCinemaId(Long arg0);

	ResultCode<String> getSearchCinemaByCitycode(String arg0);

	ResultCode<List<Long>> getCinemaIdListByCountycode(String arg0);

	ResultCode<List<Long>> getCinemaIdListByIndexareacode(String arg0);

	ResultCode<List<Long>> getCinemaIdListByLineId(String arg0, String arg1);

	ResultCode<List<CinemaRoomVo>> getBatchUpdateRoomList(String arg0, Date arg1, String arg2);

	ResultCode refreshRoomList(Long arg0);

	ResultCode<Integer> getCinemaCount();

	ResultCode<CinemaRoomVo> updateCinemaRoomProperties(Long arg0, Long arg1, String[] arg2, Serializable[] arg3);

	ResultCode<List<Long>> getCinemaProfileIdListByUpdatetime(Timestamp arg0, int arg1, int arg2);

	ResultCode<Integer> getCinemaProfileCount();
}