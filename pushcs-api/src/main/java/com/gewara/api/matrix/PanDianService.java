package com.gewara.api.matrix;


import com.gewara.api.vo.PanDianVO;
import com.gewara.api.vo.ResultCode;
/**
 * @author 杨福平
 * 盘点dubbo 接口
 */
public interface PanDianService {
	/**
	 * 使用memberid获取用户观影日记
	 * @param memberid 用户id
	 * @return PandianVO对象,封装了统计结果后的数据
	 */
    ResultCode<PanDianVO> getUserMovieDiaryByMemberid(Long memberid);
}
