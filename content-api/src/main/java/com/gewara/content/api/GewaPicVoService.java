package com.gewara.content.api;

import java.util.List;

import com.gewara.api.vo.ResultCode;
import com.gewara.content.vo.PictureVo;

public interface GewaPicVoService {
	ResultCode<String> saveToTempPic(String pic, String filetype);
	ResultCode<String> saveTempFileToRemote(String filename, boolean retPicSize);
	ResultCode<String> moveRemoteTempTo(Long memberid, String tag, Long relatedid, String path, String filename);
	ResultCode<String> uploadPic(String pic, String filetype, boolean retPicSize, Long memberid, String tag, Long relatedid, String path);
	ResultCode<String> uploadPicture(String pic, String filetype, boolean retPicSize, Long memberid, String tag, Long relatedid, String path);

	/**
	 * 影院影片的剧照
	 * 
	 * @param appkey
	 *            合作商appkey
	 * @param relatedId
	 *            影院ID、影片ID……
	 * @param tag
	 *            影院（cinema），影片（movie）
	 * @param from
	 * @param max
	 * @return
	 */
	ResultCode<List<PictureVo>> getPictureList(Long relatedId, String tag, Integer from, Integer maxnum);
}
