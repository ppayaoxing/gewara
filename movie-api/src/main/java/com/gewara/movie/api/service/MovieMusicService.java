package com.gewara.movie.api.service;

import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MovieMusicVo;
import com.gewara.movie.vo.MusicAlbumVo;

public interface MovieMusicService {
	/**
	 * 音乐后台查询电影相关的音乐专辑
	 * @param movieid
	 * @return
	 */
	ResultCode<MusicAlbumVo> getMusicAlbumByMovieid(Long movieid);
	/**
	 * 修改专辑ID
	 * @param albumVo
	 * @param movieid
	 * @return
	 */
	ResultCode updateMusicAlbum(MusicAlbumVo albumVo,Long movieid);
	/**
	 * 删除专辑
	 * @param list_id
	 * @param movieid
	 * @return
	 */
	ResultCode delMusicAlbum(String list_id,Long movieid);
	/**
	 * 添加喜欢
	 * @param song_id
	 * @return 返回喜欢后的总喜欢数
	 */
	ResultCode<Integer> addMusicCollection(String song_id, Long memberid);
	/**
	 * 取消喜欢
	 * @param song_id
	 * @return 返回取消喜欢后的总喜欢数
	 */
	ResultCode<Integer> cancelMusicCollection(String song_id, Long memberid);
	/**
	 * 修改moviemusic属性
	 * @param songId
	 * @param propertiesMap
	 * @return
	 */
	ResultCode<MovieMusicVo> updateMovieMusicProperties(String songId, Map<String, String> propertiesMap);
	
	void removeAllMusicRelation();
}
