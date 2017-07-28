/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.service.mongo;

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
import java.util.List;
import java.util.Map;

public interface AvatarMongoVoService {
	ResultCode<List<Map>> getBuyTicketRankingList();

	ResultCode<List<Map>> getIndexPageEffectRoomListByCityCodeAsc(String arg0);

	ResultCode<List<SeeMovieVo>> getSeeMovieList(String arg0, Long arg1, int arg2, int arg3);

	ResultCode<String> saveShortUrl(String arg0, int arg1);

	ResultCode<List<FriendCardCfgVo>> getFriendCardCfgListByCardId(String arg0);

	ResultCode<List<WeixinFriendCardVo>> getWeixinFriendCardList(String arg0, String arg1, String arg2);

	ResultCode saveWeixinFriendCard(WeixinFriendCardVo arg0);

	ResultCode<List<GewaraMoviePlayVo>> getGewaraMoviePlayList();

	ResultCode<List<MovieAppIconVo>> getMovieAppIconList();

	ResultCode<SpecilMpiAppIconVo> getSpecilMpiAppIconById(String arg0);

	ResultCode<List<PersonalSeatVo>> getPersonalSeatListGTStopTime();

	ResultCode<List<PersonalSeatVo>> getPersonalSeatListGTEStopTime();

	ResultCode<PhoneActivityVo> getPhoneActivityById(String arg0);

	ResultCode<List<RoomOuterRingSeatVo>> getRoomOuterRingSeatListByRoomId(Long arg0);

	ResultCode saveOrUpdateRoomOuterRingSeat(RoomOuterRingSeatVo arg0);
}