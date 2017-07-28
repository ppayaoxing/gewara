/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.MovieMusicVo;
import com.gewara.movie.vo.MusicAlbumVo;
import java.util.Map;

public interface MovieMusicService {
	ResultCode<MusicAlbumVo> getMusicAlbumByMovieid(Long arg0);

	ResultCode updateMusicAlbum(MusicAlbumVo arg0, Long arg1);

	ResultCode delMusicAlbum(String arg0, Long arg1);

	ResultCode<Integer> addMusicCollection(String arg0, Long arg1);

	ResultCode<Integer> cancelMusicCollection(String arg0, Long arg1);

	ResultCode<MovieMusicVo> updateMovieMusicProperties(String arg0, Map<String, String> arg1);

	void removeAllMusicRelation();
}