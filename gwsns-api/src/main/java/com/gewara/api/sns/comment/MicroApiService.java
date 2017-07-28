/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.sns.comment;

import com.gewara.api.sns.vo.comment.CommentVo;
import com.gewara.api.sns.vo.comment.ModeratorTagVo;
import com.gewara.api.sns.vo.comment.ModeratorVo;
import com.gewara.api.vo.ResultCode;
import java.util.List;

public interface MicroApiService {
	ResultCode<List<ModeratorTagVo>> getModeratorTagList(String arg0, Long arg1, String arg2, boolean arg3, int arg4,
			int arg5);

	ResultCode<List<ModeratorTagVo>> getModeratorTagListByTypeAndRelatedid(String arg0, Long arg1, String arg2,
			boolean arg3, int arg4, int arg5);

	ResultCode<ModeratorTagVo> getModeratorTag(Long arg0);

	ResultCode<List<CommentVo>> getModeratorDetailList(String arg0, boolean arg1, int arg2, int arg3);

	ResultCode<ModeratorVo> getModerator(Long arg0, String arg1, Long arg2);
}