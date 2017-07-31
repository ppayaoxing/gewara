package com.gewara.ucenter.api.sns;

import java.util.List;
import java.util.Map;

import com.gewara.api.vo.ResultCode;
import com.gewara.ucenter.vo.sns.TreasureVo;

public interface TreasureVoService {
	ResultCode<TreasureVo> getTreasureByTagMemberidRelatedid(String tag, Long memberid, Long relatedid, String action);
	ResultCode<List<Long>> getTreasureIdList(Long memberId, String tag, String action, int from, int maxnum);
	ResultCode addTreasure(Long memberid, String tag, Long relatedid, String action);
	/**
	 * 批量关注
	 * @param memberid
	 * @param tag
	 * @param relatedid
	 * @param action
	 * @return
	 */
	ResultCode addTreasure(Long memberid, String tag, List<Long> relatedid, String action);
	ResultCode delTreasure(Long id, Long movieId);
	ResultCode delTreasureById(Long id);
	ResultCode<List<Long>> getTreasureCinemaidList(/*String citycode, */Long memberid);
	ResultCode<List<Long>> getTreasureIdListNoPage(Long memberId, String tag, String action);
	/**
	 * 记录电影关注数
	 * @param memberId
	 */
	ResultCode addCollectedtimes(Long movieId);
	/**
	 * 影院影片场馆的关注数
	 * @param tag
	 * @param relatedId
	 */
	ResultCode addRelatedClickedtimes(String tag, Long relatedId);
	/**
	 * 根据memberId、movieid，判断songIdList中是否添加关注
	 * @param memberId
	 * @param songIdList
	 * @return 返回map结构数据，key=音乐ID；value=是否喜欢（0：未喜欢；1：已喜欢）
	 */
	ResultCode<Map<String, String>> getIsLikeMovieMusic(Long memberId, List<String> songIdList);
}
