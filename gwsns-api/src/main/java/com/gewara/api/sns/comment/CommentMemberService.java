/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.comment;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.sns.vo.comment.FlowerMemberVo;
import com.gewara.api.vo.ResultCode;
import com.gewara.api.vo.VoMap;
import java.util.List;

public interface CommentMemberService {
	ResultCode<List<Long>> getFlowerMemberIdList(String arg0, Long arg1, int arg2, int arg3);

	ResultCode<List<FlowerMemberVo>> getFlowerMemberByParent(Long arg0, Long arg1, String arg2, int arg3, int arg4);

	ResultCode<List<CommentVo>> getCommentListByMemberIdAndTags(String arg0, Long arg1, String arg2, String arg3,
			int arg4, int arg5);

	ResultCode<VoMap<String, Object>> getMemberCountVoMap(Long arg0);
}