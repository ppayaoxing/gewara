package com.gewara.api.sns.label;

import java.sql.Timestamp;
import java.util.List;

import com.gewara.api.activity.domain.TreasureVo;
import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.sns.vo.label.BigLabelVo;
import com.gewara.api.sns.vo.label.LabelRelatedVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;

public interface BigLabelApiService {
	/**
	 * 根据标签ID列表获取标签数据
	 * @param   ids  标签ID列表  
	 */
	ResultCode<List<BigLabelVo>> getBigLabelListByIds(List<Long> ids);
	/**
	 * 根据标签名称获取数据
	 * @param   name  标签名称
	 */
	ResultCode<BigLabelVo> getBigLabelByName(String name);
	/**
	 * 根据标签名称模糊匹配获取数据
	 * @param   name  模糊匹配标签名称
	 */
	ResultCode<List<BigLabelVo>> getBigLabelListByMatchName(String name);
	
	/**
     * 根据查询条件获取标签数据
     * @param   memberid  添加标签的用户
     * @param   name  标签名称
     * @param   starttime 查询创建时间范围
     * @param   endtime   查询创建时间范围
     * @param   orders   排序字段数组
     * @param   isAsc    排序类型(ASC?)
     * @param   from     分页参数
     * @param   maxnum   分页参数
     */
	ResultCode<List<BigLabelVo>> getBigLabelList(Long memberid,String name,Timestamp starttime, Timestamp endtime,String [] orders, boolean isAsc, int from, int maxnum);
    /**
     * 添加标签信息
     * @param   memberid  添加标签的用户
     * @param   name  标签名称
     */
	ResultCode<BigLabelVo> addBigLabel(Long memberid, String name);
    /**
     * 添加标签关联关系
     * @param   id    标签ID
     * @param   tag  关联对象类型
     * @param   relatedid  关联对象ID
     */
	ResultCode addRelatedBigLabel(Long id,String tag,Long relatedid);
    /**
     * 移除标签关联关系
     * @param   id    标签ID
     * @param   tag  关联对象类型
     * @param   relatedid  关联对象ID
     */
	ResultCode cancelRelatedBigLabel(Long id,String tag,Long relatedid);
    /**
     * 获取标签关联的对象
     * @param   id    标签ID (不能为空)
     * @param   tag  关联对象类型 (可忽略)
     * @param   relatedid  关联对象ID (可忽略)
     * @param   from  分页参数
     * @param   maxnum  分页参数
     */
	ResultCode<List<LabelRelatedVo>> getRelatedBigLabelList(Long id,String tag, Long relatedid, int from, int maxnum);
	/**
     * 获取标签关联的对象总条数
     * @param   id    标签ID
     * @param   tag  关联对象类型
     */
	ResultCode<Integer> getRelatedBigLabelCount(Long id, String tag);
    /**
     * 获取对象关联的标签ID列表
     * @param   relatedid    关联对象ID
     * @param   tag  关联对象类型
     * @param   from  分页参数
     * @param   maxnum  分页参数
     */
	ResultCode<List<Long>> getRelatedBeBigLabelList(String tag,Long relatedid, int from, int maxnum);
	/**
	 * 关注标签
	 * @param labelid 标签id
	 * @param memberid 用户id
	 * @return
	 */
	ResultCode<String> collectBigLabel(Long labelid, Long memberid);
	/**
	 * 批量关注标签
	 * @param labelids
	 * @param memberid
	 * @return
	 */
	ResultCode<String> collectBigLabel(List<Long> labelids, Long memberid);
	/**
	 * 取消关注标签
	 * @param labelid 标签id
	 * @param memberid 用户id
	 * @return
	 */
	ResultCode<String> cancelCollectBigLabel(Long labelid, Long memberid);
	/**
	 * 得到关注标签
	 * @param labelid 标签id
	 * @param memberid 用户id
	 * @return
	 */
	ResultCode<TreasureVo> getCollectBigLabel(Long labelid, Long memberid);
	
	/**
	 * 得到关注标签列表
	 * @param memberid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<Long>> getCollectBigLabel(Long memberid, int from, int maxnum);
	/**
	 * 得到关注标签的粉丝
	 * @param labelid 标签id
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<TreasureVo>> getBigLabelTreasureList(Long labelid, int from, int maxnum);
	/**
	 * 根据标签id得到wala
	 * @param labelid 标签id
	 * @param order  排序字段  movieweightorder 电影权重
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<CommentVo>> getLabelCommentList(Long labelid, String order, int from, int maxnum);
	
	/**
	 * 获取标签贡献用户列表
	 * @param labelid
	 * @param startTime
	 * @param endTime
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List> getContributeFansList(Long labelid,Timestamp startTime, Timestamp endTime, int from, int maxnum);
	
	/**
	 * 获取推荐标签
	 * @param memberid 
	 * @param relatedid 
	 * @param tag 
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<List<BigLabelVo>> getRecommendBigLabelList(String tag, Long relatedid, Long memberid, int from, int maxnum);
	
	/**
	 * 获取用户关注的标签未读数量
	 * @param ids
	 * @return
	 */
	ResultCode<VoMap<String,Integer>> getUnreadBigLabelNumVoMap(List<String> ids);
	
	/**
	 * 将用户关注的标签未读数量清空
	 * @param id
	 * @param num
	 * @return
	 */
	ResultCode cleanUnReadBigLabelNum(String id, Integer num);
	
	/**
	 * 添加电影标签
	 * @param movieids
	 * @return
	 */
	ResultCode<Integer> addLabelByMovie(List<Long> movieids);
	
	/**
	 * 获取哇啦数
	 * @param id
	 * @return
	 */
	ResultCode<Integer> getRelatedCommentCount(Long id);
	/**
	 * 得到关注的标签对应的未读数量
	 * @param memberid
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<VoMap<Long,Integer>> getCollectBigLabelVoMapByMemberid(Long memberid, int from, int maxnum);
	/**
	 * 修改用户收藏标签未读数量
	 * @param memberid
	 * @param relatedid
	 * @param num
	 * @return
	 */
	ResultCode updateUnReadBigLabelByMemberid(Long memberid,Long relatedid, Integer num, String tag, String action);
	
	
	
	
}
