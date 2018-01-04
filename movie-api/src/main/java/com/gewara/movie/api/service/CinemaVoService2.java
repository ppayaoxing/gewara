package com.gewara.movie.api.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.CinemaProfileVo;
import com.gewara.movie.vo.CinemaRoomVo;
import com.gewara.movie.vo.CinemaVo;
import com.gewara.movie.vo.common.EntityClobVo;
import com.gewara.movie.vo.partner.SearchCinemaCommandVo;

public interface CinemaVoService2 {
	/**
	 * 获取影院信息
	 * @param cinemaids
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByIdList(List<Long> idList);
	
	/**
	 * 根据城市代码获取影院列表 
	 * @param citycode
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByCitycode(String citycode);
	
	/**
	 * 根据id查询影院
	 * 注意：该方法只用与avatar jms同步Cinema数据用。方法直接查询Mysql数据库，不走缓存，慎重使用。
	 * @param cinemaId
	 * @return
	 */
	ResultCode<CinemaVo> getCinemaByIdWithOutCache(Long cinemaId);
	
	/**
	 * 根据id查询影院概况
	 * 注意：该方法只用与avatar jms同步CinemaProfile数据用。方法直接查询Mysql数据库，不走缓存，慎重使用。
	 * @param cinemaId
	 * @return
	 */
	ResultCode<CinemaProfileVo> getCinemaProfileByIdWithOutCache(Long cinemaId);
	
	/**
	 * 获取影院概况
	 * @param cinemaid
	 * @return
	 */
	ResultCode<CinemaProfileVo> getCinemaProfileById(Long cinemaid);
	
	/**
	 * 查询影院详细
	 * @param cinemaid
	 * @return
	 */
	ResultCode<CinemaVo> getCinemaById(Long cinemaid);
	
	/**
	 * 查询影院描述
	 * @param cinemaid
	 * @return
	 */
	ResultCode<EntityClobVo> getCinemaEntityClob(Long cinemaId);
	
	/**
	 * 保存影院描述
	 * @param cinemaId
	 * @param content
	 * @return
	 * @author leo
	 * @addTime 2016年9月22日下午2:49:44
	 */
	ResultCode saveCinemaEntityClob(Long cinemaId, String content);
	
	/**
	 * 查询影厅ID集合
	 * @param cinemaid
	 * @param ctype
	 * @return
	 */
	ResultCode<List<Long>> getRoomIdListByCinemaAndCtype(long cinemaId,String ctype);
	
	/**
	 * 根据影厅ID查询影厅详细
	 * @param cinemaRoomId
	 * @return
	 */
	ResultCode<CinemaRoomVo> getCinemaRoomById(long cinemaRoomId);
	/**
	 * 根据影厅编号查询影厅
	 * @param cinemaId
	 * @param roomnum
	 * @return
	 */
	ResultCode<CinemaRoomVo> getRoomByRoomnum(Long cinemaId, String roomnum);
	/**
	 * 根据影厅名称查询
	 * @param cinemaId
	 * @param roomname
	 * @return
	 */
	ResultCode<CinemaRoomVo> getRoomByRoomname(Long cinemaId, String roomname);
	/**
	 * 获取包含见面会的电影
	 * @param citycode	城市
	 * @param movieIds	电影ID集合
	 * @return 集合中包含见面会的map，Key:电影ID，value:jianmianhui
	 */
	ResultCode<Map<Long,String>> getMovieInfoByIds(String citycode, List<Long> movieIds);
	/**
	 * 获取影院是否可退票、自定义票纸、取消险、见面会等信息
	 * @param cinemas	影院集合
	 * @param citycode	城市代码
	 * @param movieid	电影ID
	 * @return 影院各影院包含的服务MAP，key:影院ID，value:服务列表
	 */
	ResultCode<Map<Long,List<String>>> getCinemaOtherInfo(List<CinemaVo> cinemas,String citycode, Long movieid);
	
	/**
	 * 根据CITYCODE,MOVIEID,PLAYDATE查询影院的character
	 * @param cinemaId
	 * @return
	 */
	ResultCode<Map<Long,List<String>>> getCinemaRoomCharacter(String citycode, Long movieid, Date playdate);
	
	/**
	 * @Description: 查询影院的Character
	* @param cinemaIds 影院列表
	* @param citycode
	* @param movieid
	* @param playdate
	* @return ResultCode<Map<Long,List<String>>>  
	*
	* @date 2016年9月22日 上午10:55:00
	 */
	ResultCode<Map<Long,List<String>>> getCinemaRoomCharacter(List<Long> cinemaIds,String citycode, Long movieid, Date playdate);
	
	/**
	 * 获取影院近期放映字段
	 * @param cinemaIds	影院列表
	 * @param mid	电影ID
	 * @param playDate	日期
	 * @return
	 */
	ResultCode<Map<Long,String>> getCinemaPlayText(List<Long> cinemaIds,Long mid,Date playDate);
	/**
	 * 获取影厅列表
	 * @param roomIds
	 * @return
	 */
	ResultCode<Map<Long,CinemaRoomVo>> getCinemaRoomByRoomIds(List<Long> roomIds);
	/**
	 * 根据影院ID查询是否支持退票
	 * @param cinemaId
	 * @return
	 */
	ResultCode cinemaCanRefund(Long cinemaId);
	/**
	 * 获取特效影院
	 * 
	 * @param citycode
	 * @return
	 * @author leo
	 * @addTime 2014年6月24日下午1:39:16
	 */
	ResultCode<Map<String,List<CinemaVo>>> getCharacteristicCinemaRoom(String citycode);
	ResultCode<Map<String, List<Map>>> getCinemaMapListByCitycode(String citycodes, String hasOpiCount, int from, int maxnum);
	
	/**
	 * 根据filedname，filedvalue查询影院信息
	 * @param fieldname
	 * @param fieldvalue
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByFiled(String fieldname, Serializable fieldvalue);
	/**
	 * 根据名称模糊匹配，查询影院信息
	 * @param name
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListLikeName(String name);
	/**
	 * 查询影厅信息
	 * @param roomIdList
	 * @return
	 */
	ResultCode<List<CinemaRoomVo>> getCinemaRoomListByIdList(List<Long> roomIdList);
	/**
	 * 公开订票影院列表（后台）
	 * @param citycode
	 * @return
	 */
	ResultCode<List<CinemaVo>> getBookingCinemaListByCitycodeNoCache(String citycode);
	/**
	 * 根据影院id，查询影厅信息
	 * @param cinemaid
	 * @return
	 */
	ResultCode<List<CinemaRoomVo>> getCinemaRoomListByCinemaId(Long cinemaid);
	/**
	 * 根据filedname，filedvalue查询影厅信息
	 * @param fieldname
	 * @param fieldvalue
	 * @return
	 */
	ResultCode<List<CinemaRoomVo>> getCinemaRoomListByFiled(String fieldname, Serializable fieldvalue);
	/**
	 * 根据filedname，filedvalue查询影院信息
	 * @param fieldname
	 * @param fieldvalue
	 * @return
	 */
	ResultCode<List<CinemaProfileVo>> getCinemaProfileListByFiled(String fieldname, Serializable fieldvalue);
	/**
	 * 根据idList，查询CinemaProfile
	 * @param idList
	 * @return
	 */
	ResultCode<List<CinemaProfileVo>> getCinemaProfileListByIdList(List<Long> idList);
	/**
	 * 查询关闭的影厅信息
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CinemaRoomVo>> getCloseCinemaRoomListForPage(int from, int maxnum);
	/**
	 * 根据城市代码获得影院id、影院名称
	 * @param citycode
	 * @return
	 */
	ResultCode<List<Map>> getCinemaidAndNameDataListMapByCityData(String citycode);
	/**
	 * 获得所有影院id、影院名称
	 * @return
	 */
	ResultCode<List<Map>> getAllCinemaidAndNameDataListMap();
	/**
	 * 根据cinemaProfile的status查询CinemaList
	 * @param status
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByCPStatus(String status);
	/**
	 * 根据cinemaProfile的opentype查询CinemaList
	 * @param opentype
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByCPOpenType(String opentype);
	/**
	 * 获得影院特效和城市
	 * @return
	 */
	ResultCode<List<Map>> getCinemaCharacteristicAndcitycodeDataMap();
	/**
	 * 根据影院名称，查询影院id
	 * @param cinemaname
	 * @return
	 */
	ResultCode<List<Long>> getCinemaIdListLikeName(String cinemaname);
	/**
	 * 获得影院id
	 * @param openPriority
	 * @return
	 */
	ResultCode<List<Long>> getCinemaIdListByOpenPriority(String openPriority);
	/**
	 * 获得影院id
	 * @param openPriority
	 * @param citycodeList
	 * @return
	 */
	ResultCode<List<Long>> getCinemaIdListByOpenPriorityAndCityCodeList(String openPriority, List<String> citycodeList);
	/**
	 * 获得影院id
	 * @param bookingStatus
	 * @param cidList 可以为空
	 * @return
	 */
	ResultCode<List<Long>> getCinemaIdListByBooking(String bookingStatus, List<Long> cidList);
	/**
	 * 根据城市code，查询cinema
	 * @param citycode
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByCityCodeListProfileNotNull(List<String> citycodeList);
	/**
	 * 查询影院idList
	 * @param bookingStatus
	 * @param citycodeList
	 * @return
	 */
	ResultCode<List<Long>> getCinemaIdListByCitycodeAndBookingStatus(String bookingStatus, List<String> citycodeList);
	/**
	 * 获得profileIdList
	 * @param openProiorityList
	 * @return
	 */
	ResultCode<List<Long>> getCinemaProfileIdListByOpenProiorityList(List<String> openProiorityList);
	
	ResultCode<CinemaVo> getCinemaByUkey(String ukeyName, Serializable ukeyValue);
	/**
	 * 根据是否开放查询影院列表，按照mark排序
	 * @param booking
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByBookingOrderMark(String booking);
	/**
	 * 根据区域countycode 和是否开放购票查询列表
	 * @param booking
	 * @param countycode
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByCountycode(String countycode);
	/**
	 * 根据特色影厅类型查询特色影厅影院id列表
	 * @param cType
	 * @param citycode
	 * @return
	 */
	ResultCode<List<Long>> getCinemaIdListByRoomCharacteristic(String cType,String citycode);
	/**
	 * 查询可订票影院数量
	 * @param citycode
	 * @param countycode
	 * @param indexareacode
	 * @param cname
	 * @return
	 */
	ResultCode<Integer> getTicketCinemaCount(String citycode, String countycode,String indexareacode, String cname);
	/**
	 * 根据城市和区域查询开放影院
	 * @param citycode
	 * @param countycode
	 * @return
	 */
	ResultCode<List<Long>> getBookingCinemaIdList(String citycode, String countycode);
	/**
	 * 特色影厅的影院统计
	 * IMAX，10家   4D 11家 。。。
	 * @param citycode
	 * @return
	 */
	ResultCode<Map<String,Integer>> getRoomFeatureCinema(String citycode);
	/**
	 * 查询所有影院数量
	 * @param citycode
	 * @return
	 */
	ResultCode<Integer> getCinemaCountByCitycode(String citycode);
	/**
	 * 根据区县 标识获取影院列表
	 * @param citycode
	 * @param countycode
	 * @param filmtag
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByCitycodeAndCitycodeForFilm(String citycode, String countycode, String filmtag);
	/**
	 * 获取所有影厅的特效厅对应
	 * @param ridList
	 * @return
	 */
	ResultCode<Map<Long, String>> getCtypeMapByRoomIdList(List<Long> ridList);
	ResultCode<List<Long>> getCinemaIdListBySearchCmd(SearchCinemaCommandVo cmdVo, String citycode);
	/**
	 * 某个影院的特色影厅类型
	 * @param cinemaId
	 * @return
	 */
	ResultCode<Map<Long, String>> getCharacteristicCinemaRoomByCinema(Long cinemaId);
	/**
	 * 可以购买保险的影院ID
	 * @return
	 */
	ResultCode<List<Long>> getBuyInsureCinemaIdList();
	/**
	 * 根据更新时间查询影院
	 * @param updatetime
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<Long>> getCinemaListByUpdatetime(Timestamp updatetime, int from, int maxnum);
	/**
	 * 根据热度查询影院
	 * @param citycode
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByHotvalue(String citycode, int from, int maxnum);
	/**
	 * 根据区域查询影院列表，按照点击次数排序
	 * @param countycode
	 * @param orderField
	 * @param asc
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByCountyCodeOrderClick(String countycode,String orderField, boolean asc);
	/**
	 * 根据更新时间获取需要字段的ListMap
	 * @param fields
	 * @param updatetime
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<Map>> getFieldsMapByUpdate(String fields, Timestamp updatetime, int from, int maxnum);
	/**
	 * 根据城市代码查询影院信息（分页）
	 * @param citycode
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CinemaVo>> getCinemaListByCitycodeForPage(String citycode, int from, int maxnum);
	ResultCode<CinemaVo> updateCinemaProperties(Long cinemaId, String[] properties, Serializable[] values);
	/**
	 * 获取影院特效
	 * @param cinemaId
	 * @return
	 */
	ResultCode<String> getCinemaCharacteristicByCinemaId(Long cinemaId);
	/**
	 * 根据城市获取可搜索的影院
	 * @param citycode
	 * @return
	 */
	ResultCode<String> getSearchCinemaByCitycode(String citycode);
	/**
	 * 根据区域查询影院列表
	 * @param countycode
	 * @return
	 */
	ResultCode<List<Long>> getCinemaIdListByCountycode(String countycode);
	/**
	 * 根据商圈查询影院列表
	 * @param indexareacode
	 * @return
	 */
	ResultCode<List<Long>> getCinemaIdListByIndexareacode(String indexareacode);
	/**
	 * 根据地铁线路查询影院列表
	 * @param citycode
	 * @param lineId
	 * @return
	 */
	ResultCode<List<Long>> getCinemaIdListByLineId(String citycode, String lineId);
		
	/**
	 * 获取需要更新座位图的影厅</br>
	 * updateEmpty,from，须传一个值，否则返回空
	 * @param updateEmpty
	 * @param from
	 * @param citycode
	 * @return
	 * @author leo
	 * @addTime 2016年9月19日上午11:46:15
	 */
	public ResultCode<List<CinemaRoomVo>> getBatchUpdateRoomList(String updateEmpty, Date from, String citycode);
		
	/**
	 * 刷新影厅缓存</br>
	 * only refreshRoomList
	 * @param cinemaId
	 * @param updateTime
	 * @return
	 * @author leo
	 * @addTime 2016年9月18日下午6:55:39
	 */
	ResultCode refreshRoomList(Long cinemaId);
	
	/**
	 * 查询所有影院数量
	 * @return
	 */
	ResultCode<Integer> getCinemaCount();
	
	/**
	 * @param userid 0L为系统调用
	 * @param roomid
	 * @param properties
	 * @param values
	 * @return
	 */
	public ResultCode<CinemaRoomVo> updateCinemaRoomProperties(Long userid, Long roomid, String[] properties, Serializable[] values);
	
	/**
	 * 根据指定时间获取ID列表
	 * @param updatetime
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<Long>> getCinemaProfileIdListByUpdatetime(Timestamp updatetime, int from, int maxnum);
	
	/**
	 * 查询所有CinemaProfile数量
	 * @return
	 */
	ResultCode<Integer> getCinemaProfileCount();
}
