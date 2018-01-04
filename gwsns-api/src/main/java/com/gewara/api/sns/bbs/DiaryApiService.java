package com.gewara.api.sns.bbs;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gewara.api.sns.vo.bbs.DiaryCommentVo;
import com.gewara.api.sns.vo.bbs.DiaryVo;
import com.gewara.api.sns.vo.bbs.VoteChooseVo;
import com.gewara.api.sns.vo.bbs.VoteOptionVo;
import com.gewara.api.vo.ResultCode;

/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28下午02:05:17
 */
public interface DiaryApiService {
	/**
	 * 查询帖子
	 * @param id
	 * @return
	 */
	ResultCode<DiaryVo> getDiary(Long id);
	ResultCode<List<VoteChooseVo>> getVoteChooseList(Long diaryId);
	/**
	 * 查询帖子回复
	 * @param id
	 * @return
	 */
	ResultCode<DiaryCommentVo> getDiaryComment(Long id);
	
	
	ResultCode<Integer> getDiaryCount(String citycode, String type, String tag, Long relatedid);
	ResultCode<Integer> getDiaryCountByKey(String citycode, String type, String tag, Long relatedid, String key, Timestamp startTime, Timestamp endTime);
	ResultCode<List<DiaryVo>> getDiaryList(String citycode, String type, String tag, Long relatedid, int start, int maxnum);
	/**
	 * 有排序字段
	 */
	ResultCode<List<DiaryVo>> getDiaryList(String citycode, String type, String tag, Long relatedid, int start, int maxnum, String order);
	/**
	 * 查询一段时间内的帖子信息
	 */
	ResultCode<List<DiaryVo>> getDiaryListByOrder(String citycode, String type, String tag, Long relatedid, Timestamp startTime,Timestamp endTime, String order, boolean asc, int start, int maxnum);
	/**
	 * 有搜索字段
	 */
	ResultCode<List<DiaryVo>> getDiaryListByKey(String citycode, String type, String tag, Long relatedid, int start, int maxnum, String key, Timestamp startTime,Timestamp endTime);
	/**
	 * 有Flag字段 
	 */
	ResultCode<List<DiaryVo>> getDiaryListByFlag(String citycode, String type, String tag, String flag, int from, int maxnum);
	/**
	 * @param type
	 * @param tag
	 * @return 置顶的Diary
	 */
	ResultCode<List<DiaryVo>> getTopDiaryList(String citycode, String type, String tag, boolean isCache);
	/**
	 * 获取24小时排行帖子（根据24小时内回复个数）
	 * @param tag
	 * @return
	 */
	ResultCode<List<Map>> getOneDayHotDiaryList(String citycode, String tag);
	/**
	 * @param type
	 * @param tag
	 * @param memberid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<DiaryVo>> getDiaryListByMemberid(String type, String tag, Long memberid, int from, int maxnum);
	/**
	 * 某个用户的评论数量
	 * @param type
	 * @param tag
	 * @param mid
	 * @return
	 */
	ResultCode<Integer> getDiaryCountByMemberid(String type, String tag, Long memberId);
	
	
	/**
	 * 得到某个Diary的回复
	 * @param diaryId
	 * @return
	 */
	ResultCode<List<DiaryCommentVo>> getDiaryCommentList(Long diaryId, int from, int maxnum); 
	ResultCode<List<DiaryCommentVo>> getDiaryCommentList(Long diaryId); 
	/**
	 * 根据投票的id，它的选项
	 * @param vid
	 * @return
	 */
	ResultCode<List<VoteOptionVo>> getVoteOptionByVoteid(Long vid);
	/**
	 * 投票的数量
	 * @param did
	 * @return
	 */
	ResultCode<Integer> getVotecount(Long did);
	/**
	 * 我对某个帖子的投票详情
	 * @return
	 */
	ResultCode<List<VoteChooseVo>> getVoteChooseByDiaryidAndMemberid(Long did,Long mid);
	ResultCode<Integer> getDiaryCommentCount(String tag, Long diaryId);
	/**
	 * 是否已经投票(准对杜拉拉活动)
	 * @param memberid
	 * @return
	 */
	ResultCode<Boolean> isMemberVoted(Long memberid, Long diaryid);
	
	//最近一周最热影评
	ResultCode<List<DiaryVo>> getHotCommentDiary(String citycode, String type, String tag, Long relateid, int from,int maxnum);
	/**
	 * 查询圈内热门话题
	 */
	ResultCode<List<DiaryVo>> getHotCommuDiary(String citycode, boolean isCommu,String type,int from,int maxnum);
	
	/**
	 * 根据status查询帖子
	 * @param status
	 * @return
	 */
	ResultCode<List<DiaryVo>> getDiaryListByStatus(String keyname, String status, Date fromDate, Date endDate, int from, int maxnum);
	ResultCode<Integer> getDiaryCountByStatus(String keyname, String status, Date fromDate, Date endDate);
	/**
	 * 根据status查询帖子留言
	 * @param status
	 * @return
	 */
	ResultCode<List<DiaryCommentVo>> getDiaryCommentListByStatus(String keyname, String status, Date fromDate, Date endDate, int from, int maxnum);
	ResultCode<Integer> getDiaryCommentCountByStatus(String keyname, String status, Date fromDate, Date endDate);
	ResultCode<List<DiaryVo>> getRepliedDiaryList(Long memberid, int from, int maxnum);
	ResultCode<Integer> getRepliedDiaryCount(Long memberid);

	/**
	 * 查询电影、话剧、的点评列表
	 * @param keyname
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<Map>> getMDSDiaryListByKeyname(String citycode, String keyname, String tag, String name, int from, int maxnum);
	ResultCode<Integer> getMDSDiaryCountByKeyname(String citycode, String keyname, String tag, String name);
	/**
	 * 分页查询演出评论列表数据
	 * @param citycode
	 * @param key
	 * @param starttime
	 * @param endtime
	 * @param order
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<DiaryVo>> getDiaryBySearchkeyAndOrder(String citycode,String key,Timestamp starttime, Timestamp endtime, String order,int from,int maxnum);
	
	/**
	 * 根据圈子id查询圈子帖子信息(这是从commuApiService移动到这里的)
	 */
	ResultCode<List<DiaryVo>> getCommuDiaryListById(Long id, String[] type,Long commuTopicId, int from, int maxnum);
	
	/**
	 * 根据搜索条件查询帖子(这是从commuApiService移动到这里的)
	 */
	ResultCode<List<DiaryVo>> getCommuDiaryListBySearch(Long id, String type, Long
			commuTopicId, Date fromDate, Integer flag, String text, int from, int maxnum);
	ResultCode<Integer> getCommuDiaryCountBySearch(Long id,String type,Long 
			commuTopicId, Date fromDate, Integer flag, String text);
	
	/**
	 * 根据圈子id查询圈子帖子信息数量(这是从commuApiService移动到这里的)
	 */
	ResultCode<Integer> getCommuDiaryCount(Long id,String[] type,Long commuTopicId);
	
	
	
	/**
	 * 根据圈子的id列表查询所有圈子的话题信息(这是从commuApiService移动到这里的)
	 * @param commuIds TODO
	 */
	ResultCode<List<DiaryVo>> getAllCommuDiaryByCommuIds(List<Long> commuIds, int from, int maxnum);
	
	
	/**
	 * 根据当前用户id查询他加入的所有圈子的话题信息数量
	 * @param commuIds TODO
	 */
	ResultCode<Integer> getAllCommuDiaryCountByCommuIds(List<Long> commuIds);

	/**
	 * 根据日期范围查询报表数据
	 * @param datefrom
	 * @param dateto
	 * @return
	 */
	ResultCode<Map<String, Integer>> getDiaryReportList(Date datefrom, Date dateto);

	/**
	 * 根据条件查询Diary
	 * @param memberid 会员id
	 * @param starttime 开始时间
	 * @param endtime 介绍时间
	 * @param tag 业务模块（比如电影）
	 * @param status 状态
	 * @param keyname 关键字
	 * @param firstRow 开始记录行
	 * @param rowsPerpage 结束记录行
	 * @return
	 */
	ResultCode<List<DiaryVo>> queryDiary(Long memberid, Timestamp starttime, Timestamp endtime, String tag, String status,
			String keyname, int firstRow, int rowsPerpage);

	ResultCode<Integer> queryDiaryCount(Long memberid, Timestamp starttime, Timestamp endtime, String tag, String status,
			String keyname);
	/**
	 * 根据条件查询DiaryComment
	 * @param did Diary
	 * @param memberid 会员id
	 * @param starttime 开始时间
	 * @param endtime 介绍时间
	 * @param status 状态
	 * @param keyname 关键字
	 * @param firstRow 开始记录行
	 * @param rowsPerpage 结束记录行
	 * @return
	 */
	ResultCode<List<DiaryCommentVo>> queryDiaryComment(Long did, Long memberid, Timestamp starttime, Timestamp endtime,
			String status, String keyname, int firstRow, int rowsPerpage);

	ResultCode<Integer> queryDiaryCommentCount(Long did, Long memberid, Timestamp starttime, Timestamp endtime, String status,
			String keyname);

	ResultCode<List<Map<String, Object>>> getDiary(Set<Long> movieIdSet, String queryType, Date queryDate);

	ResultCode<List<DiaryVo>> queryDiary(Timestamp addTime, String tag);

	ResultCode<List<DiaryVo>> getDeletedDiaryList(boolean isDeleteDbRecord);

	ResultCode<Integer> getDiaryCountByMovieid(Long movieid);

	ResultCode<List<Long>> getDiaryIdList(Date begindate, Date enddate);
	
	ResultCode<List<Long>> getDiaryIdList(Date begindate);

	ResultCode<List<Map>> getDiaryCountMapList();

	/**
	 * 帖子总数
	 * @param queryTime
	 * @return
	 */
	ResultCode<Integer> getDiaryCount(Date queryTime);
	
	/**
	 * 影评数
	 * @param queryTime
	 * @return
	 */
	ResultCode<Integer> getComentDiaryCount(Date queryTime);
	
	
	/**
	 * 保存帖子,TODO: 分离成多个Service方法
	 * @param diary
	 * @return
	 */
	ResultCode<DiaryVo> saveDiary(DiaryVo diary);
	
	/**
	 * 保存帖子回复
	 * @param dc
	 * @return
	 */
	ResultCode<DiaryCommentVo> saveDiaryComment(DiaryCommentVo dc);


	/**
	 * 根据id列表查询帖子
	 * @param idList
	 * @return
	 */
	ResultCode<List<DiaryVo>> getDiaryList(List<Long> idList);


	/**
	 * 修改帖子
	 * @param diary
	 * @return
	 */
	ResultCode<DiaryVo> updateDiary(DiaryVo diary);


	/**
	 * 获取VoteOption
	 * @param id
	 * @return
	 */
	ResultCode<VoteOptionVo> getVoteOption(Long id);


	/**
	 * 保存VoteChooseList
	 * @param vcList
	 */
	ResultCode saveVoteChooseList(List<VoteChooseVo> vcList);


	/**
	 * 保存VoteOptionList
	 * @param voList
	 */
	ResultCode saveVoteOptionList(List<VoteOptionVo> voList);


	/**
	 * 保存voteChoose
	 * @param voteChoose
	 * @return
	 */
	ResultCode<VoteChooseVo> saveVoteChoose(VoteChooseVo voteChoose);
	
	
	/**
	 * @param diaryid
	 * @return
	 */
	ResultCode<String> getDiaryBody(long diaryid);
	/**
	 * @param diaryid
	 * @param body
	 */
	ResultCode saveDiaryBody(long diaryid, Timestamp updatetime, String body);

	
	ResultCode<List<Map>> getDiaryMapList(Timestamp starttime, Timestamp endtime);

	public ResultCode<List<DiaryVo>> getDiaryListByFlag(String citycode, String type, String tag, String flag, boolean notLike, String order, 
			int start, int maxnum);
	
	
	



	

	



	
	
	
}
