package com.gewara.api.sns.constant;

import org.apache.commons.lang.StringUtils;

public abstract class Status {
	public static final String Y = "Y";							//对外显示
	public static final String Y_NEW = "Y_NEW";				//新帖子、问答、回复...
	public static final String Y_LOCK = "Y_LOCK";			//锁
	public static final String Y_DOWN = "Y_DOWN";			//下沉帖子
	public static final String Y_LOCK_DOWN = "Y_LD";

	public static final String N = "N";							//对外不显示
	public static final String N_DELETE = "N_DELETE";		//被删除
	public static final String N_FILTER = "N_FILTER";		//被关键字过滤
	public static final String N_ACCUSE = "N_ACCUSE";		//举报属实
	public static final String N_NIGHT = "N_NIGHT";			//夜间发帖
	
	public static final String N_ERROR = "N_ERR";			//出现错误
	
	public static final String Y_STOP = "Y_STOP";			//活动停止报名
	public static final String Y_PROCESS = "Y_PROCESS";	//活动可以报名
	public static final String Y_TREAT = "Y_TREAT";			//活动正在处理
	
	public static final String STATUS_OPEN = "Y"; //已开
	public static final String STATUS_UNOPEN = "N"; //未开
	
	public static final String Y_END = "Y_END"; //猜票房已开奖
	
	public static final String STATUS_OPENED = "Y_OPEN"; //已开
	public static final String STATUS_UNPOST = "Y_NOTPOST";//未邮寄
	public static final String STATUS_POST_EXPRESS = "Y_EXP"; //快递
	public static final String STATUS_POST_COMMON = "Y_POST";//平邮 
	public static final String STATUS_UNOPENED = "N_NOTOPEN";//未开
	public static final String STATUS_APPLY = "N_APPLY";//申请
	//20110822
	public static final String STATUS_TRASH="N_TRASH";//发票废弃，重新申请
	public static final String STATUS_APPLY_AGAIN="N_APPLYAGAIN";//申请补开
	public static final String STATUS_OPEN_AGAIN="Y_AGAIN";//已补开
	public static boolean isHidden(String status){
		return StringUtils.isNotBlank(status) && status.startsWith(N);
	}
	
	public static final String STATUS_N = "n";
	public static final String STATUS_Y = "y";
	public static final String TAG_BINDMOBILE = "bindMobile"; //手机解绑
	public static final String TAG_USERLOGIN ="userLogin"; //管理员登录
	public static final Integer VALDMIN = 30;
}
