package com.gewara.api.service.mongo;

import java.util.List;
import java.util.Map;

import com.gewara.api.partner.res.vo.MovieAppIconVo;
import com.gewara.api.partner.res.vo.PhoneActivityVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.mongo.FriendCardCfgVo;
import com.gewara.api.vo.mongo.GewaraMoviePlayVo;
import com.gewara.api.vo.mongo.PersonalSeatVo;
import com.gewara.api.vo.mongo.RoomOuterRingSeatVo;
import com.gewara.api.vo.mongo.SeeMovieVo;
import com.gewara.api.vo.mongo.SpecilMpiAppIconVo;
import com.gewara.api.vo.mongo.WeixinFriendCardVo;

public interface AvatarMongoVoService {

	/**
	 * 获取购票排行
	 * @return
	 */
	ResultCode<List<Map>> getBuyTicketRankingList();
	
	/**
	 * 根据城市编码查询IndexPageEffectRoom列表 ,按order字段排序
	 * @param cityCode
	 * @return
	 */
	ResultCode<List<Map>> getIndexPageEffectRoomListByCityCodeAsc(String cityCode);
	
	/**
	 * 查询SeeMovie列表
	 * @param tag 			不能为空
	 * @param relatedId
	 * @param from			不能为空
	 * @param maxnum		不能为空
	 * @return
	 */
	ResultCode<List<SeeMovieVo>> getSeeMovieList(String tag, Long relatedId, int from, int maxnum);
	
	/**
	 * 保存ShortUrl
	 * @param tradeNo
	 * @param addNum
	 * @return
	 */
	ResultCode<String> saveShortUrl(String tradeNo, int addNum);
	
	/**
	 * 查询 FriendCardCfg 列表
	 * @param cardId
	 * @return
	 */
	ResultCode<List<FriendCardCfgVo>> getFriendCardCfgListByCardId(String cardId);
	
	/**
	 * 查询微信朋友卡券列表
	 * @param cardId
	 * @param openId
	 * @param cardCode
	 * @return
	 */
	ResultCode<List<WeixinFriendCardVo>> getWeixinFriendCardList(String cardId, String openId, String cardCode);
	
	/**
	 * 新增微信朋友卡券
	 * @param friendCard
	 * @return
	 */
	ResultCode saveWeixinFriendCard(WeixinFriendCardVo friendCard);
	
	/**
	 * 获取格瓦拉放映
	 * @return
	 */
	ResultCode<List<GewaraMoviePlayVo>> getGewaraMoviePlayList();
	
	/**
	 * 获取MovieAppIcon列表 
	 * @return
	 */
	ResultCode<List<MovieAppIconVo>> getMovieAppIconList();
	
	/**
	 * 根据ID查询电影APP特殊场次打标
	 * @param id
	 * @return
	 */
	ResultCode<SpecilMpiAppIconVo> getSpecilMpiAppIconById(String id);
	
	/**
	 * 根据当前时间查询PersonalSeat 列表
	 * 查询时间> stoptime
	 * @return
	 */
	ResultCode<List<PersonalSeatVo>> getPersonalSeatListGTStopTime();
	
	/**
	 * 根据当前时间查询PersonalSeat 列表
	 * 查询时间>= stoptime
	 * @return
	 */
	ResultCode<List<PersonalSeatVo>> getPersonalSeatListGTEStopTime();
	
	/**
	 * 根据ID查询PhoneActivity
	 * @param activityId
	 * @return
	 */
	ResultCode<PhoneActivityVo> getPhoneActivityById(String activityId);
	
	/**
	 * 根据roomId查询 RoomOuterRingSeat列表
	 * @param roomId
	 * @return
	 */
	ResultCode<List<RoomOuterRingSeatVo>> getRoomOuterRingSeatListByRoomId(Long roomId);
	
	/**
	 * 新增 RoomOuterRingSeat
	 * @param outerRingSeat
	 * @return
	 */
	ResultCode saveOrUpdateRoomOuterRingSeat(RoomOuterRingSeatVo outerRingSeat);
}
