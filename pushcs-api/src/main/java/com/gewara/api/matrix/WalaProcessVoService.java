package com.gewara.api.matrix;

import com.gewara.api.vo.ResultCode;



public interface WalaProcessVoService {

	/***
	 * 判断wala是否是广告
	 * @param wala
	 * @return true:广告,false:正常
	 */
    public ResultCode<Boolean> recogniseWala(String wala);
    /***
	 * 添加wala 
	 * @param walaId,walaSpam (广告还是正常,ham正常,spam广告),walaContent(wala内容),data_from(e.g.:调用系统名:activi,wap .etc)
	 * @return true:添加成功,false:添加失败
	 */
    public ResultCode<Boolean> addWalaSpam(Long walaId, String walaSpam, String walaContent,String data_from);
    
}
