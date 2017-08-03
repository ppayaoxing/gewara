package com.gewara.cons;


public abstract class Status {

	public static final String Y = "Y";							//对外显示
	public static final String Y_NEW = "Y_NEW";				//新帖子、问答、回复...
	public static final String Y_LOCK = "Y_LOCK";			//锁
	public static final String Y_DOWN = "Y_DOWN";			//下沉帖子
	public static final String Y_LOCK_DOWN = "Y_LD";
	
	public static final String DEL = "D";						//删除
	public static final String N = "N";							//对外不显示
	public static final String N_DELETE = "N_DELETE";		//被删除
	public static final String N_FILTER = "N_FILTER";		//被关键字过滤
	public static final String N_ACCUSE = "N_ACCUSE";		//举报属实
	public static final String N_NIGHT = "N_NIGHT";			//夜间发帖
	
	public static final String N_ERROR = "N_ERR";			//出现错误
	
	public static final String Y_STOP = "Y_STOP";			//活动停止报名
	public static final String Y_PROCESS = "Y_PROCESS";	//活动可以报名
	public static final String Y_TREAT = "Y_TREAT";			//活动正在处理

	public static final String SINA = "sina";//新浪微博
	public static final String NO_ATTENTION = "0";//无关系
	public static final String ONLY_ATTENTION = "1";//仅我关注的
	public static final String ONLY_BEATTENTION = "2";//仅关注我的
	public static final String EACH_ATTENTION = "3";//相互关注
	public static final String MOBILE_PHONE = "mobile";//通讯录
	public static final String MOBILE_MD5_CODE = "!*@#$d";
}
