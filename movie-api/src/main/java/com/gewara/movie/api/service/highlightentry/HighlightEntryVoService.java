/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.api.service.highlightentry;

import com.gewara.api.vo.ResultCode;
import com.gewara.movie.vo.highlightentry.HighlightEntryVo;
import java.util.List;

public interface HighlightEntryVoService {
	ResultCode<List<HighlightEntryVo>> getHighlightEntryVoList(int arg0, int arg1);

	ResultCode<HighlightEntryVo> updateHighlightEntryVo(HighlightEntryVo arg0);

	ResultCode<HighlightEntryVo> saveHighlightEntryVo(HighlightEntryVo arg0);

	ResultCode<HighlightEntryVo> getHighlightEntryVoById(Long arg0);

	ResultCode<HighlightEntryVo> removeHighlightEntryVoById(Long arg0);
}