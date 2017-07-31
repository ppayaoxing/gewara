package com.gewara.ucenter.constant;

import java.util.Arrays;
import java.util.List;

public class MemberConstant {
	// 注册来源
	public static final String REGISTER_EMAIL = "email"; //邮箱注册
	public static final String REGISTER_MOBLIE = "mobile"; // 手机注册
	public static final String REGISTER_CODE = "code"; //动态码
	public static final String REGISTER_APP = "app"; //联名登录

	public static final String NEWTASK = "newtask";
	//现用
	public static final String TASK_CONFIRMREG = "confirmreg";		//注册后邮箱确认
	public static final String TASK_SENDWALA = "sendwala";			//发表一条哇啦
	public static final String TASK_UPDATE_HEAD_PIC= "headpic"; 	//更新头像
	public static final String TASK_BINDMOBILE = "bindmobile";		//绑定手机

	public static final String TASK_BUYED_TICKET = "buyticket"; 	//成功购买电影票
	public static final String MODIFY_NICKNAME = "modify_nickname";	//用户修改了昵称
	
	public static final List<String> TASK_LIST = Arrays.asList(
			TASK_UPDATE_HEAD_PIC, TASK_BUYED_TICKET, TASK_BINDMOBILE, TASK_CONFIRMREG, TASK_SENDWALA);
	
	//~~~~~~~~~~~~联名登录~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static final String TAG_SOURCE = "bindstatus"; //非自动注册用户的otherinfo标识
	public static final String TAG_MOBILE_BINDTIME = "mblbindtime";
	public static final String TAG_EMAIL_BINDTIME = "emlbindtime";
	public static final String TAG_DANGER = "danger";
	
	public static final String SOURCE_ALIPAY = "alipay";	//支付宝
	public static final String SOURCE_SDO = "sdo";
	public static final String SOURCE_SINA = "sina";
	public static final String SOURCE_QQ ="qq";
	public static final String SOURCE_TENCENT = "tencent"; //腾讯QQ
	public static final String SOURCE_CHINAPAY = "chinapay"; //银联
	public static final String SOURCE_DYNCODE = "dyncode"; //手机动态码登录
	public static final String SOURCE_TAOBAO = "taobao";
	public static final String SOURCE_BAIDU = "baidu";
	public static final String SOURCE_FILMFEST = "filmfest"; //电影节
	
	public static final String SOURCE_WEIXIN = "weixin";
	public static final String SOURCE_WEIXIN_DELETE = "weixin_delete";
	public static final String SOURCE_PINGANFU = "pinganfu";	// 平安付
	
	//民生其妙app
	public static final String SOURCE_CMBCQM = "cmbcqm";
	
	// 交行
	public static final String SOURCE_BANKCOMM = "bankcomm";
	public static final String SOURCE_CHUBAO = "chubao";
	
	public static final String SHORT_ALIPAY = "a";
	public static final String SHORT_SINA = "S";
	public static final String SHORT_QQ ="q";
	public static final String SHORT_TENCENT = "t";
	public static final String SHORT_CHINAPAY = "c";
	public static final String SHORT_FILMFEST = "f";
	
	public static final String CATEGORY_ALIKUAIJIE = "alikuaijie";
	public static final String CATEGORY_ALIWALLET = "aliwallet";
	
	//~~~~~~~~~~~~~~~~~~~~用户行为记录~~~~~~~~~~~~~~~
	public static final String ACTION_REGCARD = "regcard";		//绑定卡
	public static final String ACTION_MODPWD = "modpwd";		//修改密码
	public static final String ACTION_NEWTASK = "newtask";		//完成新手任务
	public static final String ACTION_SETPAYPWD = "setpaypwd";	//设置支付密码
	public static final String ACTION_GETPAYPWD = "getpaypwd";	//找回支付密码
	public static final String ACTION_MDYPAYPWD = "mdypaypwd";	//修改支付密码
	public static final String ACTION_MODEMAIL = "modemail";	//修改邮箱
	public static final String ACTION_BINDMOBILE = "bindmobile";//绑定手机
	public static final String ACTION_VDDRAWMOBILE = "validdrawmobile";//验证抽奖手机
	public static final String ACTION_CHGBINDMOBILE = "chgbindmobile";//修改绑定手机
	public static final String ACTION_RELIEVEMOBILE = "relievemobile";//解绑手机
	public static final String ACTION_TOWABI = "towabi";		//账户金额转wabi
	public static final String ACTION_DROPMESS = "drpmessage";	//删除私信
	public static final String ACTION_LOGIN = "login";	//登录
	
	
	public static final String OM_MOBILE = "mobile";			//第三方手机号
	public static final String OPENMEMBER = "openMember";		//记录是第三方用户登陆
	
	public static final String ALIWALLET_SHORTTOKEN = "aliwallet_shorttoken";	//支付宝钱包短token
	public static final String ALIWALLET_LONGTOKEN = "aliwallet_longtoken";		//支付宝钱包短token
	public static final String ALIWALLET_EXPIRESIN = "aliwallet_expiresIn";		//支付宝钱包短token
	public static final String ALIWALLET_REEXPIRESIN = "aliwallet_reExpiresIn";		//支付宝钱包短token
	public static final String ALIWALLET_SHORTVALIDTIME = "aliwallet_shortvalidtime";	//支付宝钱包短token
	public static final String ALIWALLET_LONGVALIDTIME = "aliwallet_longvalidtime";
	public static final String ALIWALLET_EXTERN_TOKEN = "extern_token";
	
	public static final String PINGAN1QBPAY_LOGINKEND = "loginToken";
	public static final String PINGAN1QBPAY_REFRESHTOKEN = "refreshToken";
	
	public static final String BINDMOBILE_STATUS_Y = "Y";	//绑定
	public static final String BINDMOBILE_STATUS_N = "N";	//未绑定
	public static final String BINDMOBILE_STATUS_YS = "Y_S";	//手机能通话验证过
	//public static final String BINDMOBILE_STATUS_X = "X";	//未知
	public static final String TYPE_MEMBER_BAND = "member_band_type";	//账户绑定
	public static final String TYPE_MEMBER_BAND_AND_GET_HEAD_PIC = "member_band_type_and_get_head_pic";	//账户绑定并获取头像返回
	
	public static final String NEEDVALID_Y = "Y";	//需要上行验证
	public static final String NEEDVALID_N = "N";	//不需要上行验证
	public static final String NEEDVALID_U = "U";	//暂时不需要上行验证
	public static final String NEEDVALID_MSG = "为保证您的账号安全，请按短信指示验证账号，完成验证后请重试！";
	public static final String RESET_PASSWORD = "mustResetPass";	//重设密码
	public static final String RESET_PASS_ERROR_MSG = "您的账户存在安全风险，请点击“忘记密码”重设密码！";
	public static final String RELOGIN_MSG = "获取登录信息失败，请刷新重试或重新登录！";
}
