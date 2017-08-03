package com.gewara.api.sns.comment;

import java.util.List;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.sns.vo.comment.ModeratorTagVo;
import com.gewara.api.sns.vo.comment.ModeratorVo;
import com.gewara.api.vo.ResultCode;

public interface MicroApiService {
	
	ResultCode<List<ModeratorTagVo>> getModeratorTagList(String tag, Long relatedid, String order, boolean isAsc, int from, int maxnum);

	ResultCode<List<ModeratorTagVo>> getModeratorTagListByTypeAndRelatedid(String type, Long relatedid, String order, boolean isAsc, int from, int maxnum);
	
	ResultCode<ModeratorTagVo> getModeratorTag(Long id);
	
	ResultCode<List<CommentVo>> getModeratorDetailList(String topic, boolean asc, int from, int maxnum) ;
	
	ResultCode<ModeratorVo> getModerator(Long moderatorid, String tag, Long relatedid);

}
