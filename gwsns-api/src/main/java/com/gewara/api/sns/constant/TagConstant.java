package com.gewara.api.sns.constant;

import java.util.Arrays;
import java.util.List;


public class TagConstant {
	public static final String TAG_TOPIC = "topic";					//普通无关联哇啦
	public static final String TAG_DIARY = "diary";					//帖子_哇啦
	public static final String TAG_DIARY_MEMBER = "member_diary";
	public static final String TAG_QA = "qa";						//QA_哇啦
	public static final String TAG_QA_MEMBER = "member_qa";			//用户知道
	public static final String TAG_VIDEO = "video";					//上传视频哇啦
	public static final String TAG_PICTURE = "picture";				//上传图片哇啦
	public static final String TAG_MOVIE = "movie";
	public static final String TAG_MOVIE_DOWN= "movie_down"; 		//电影下映
	public static final String TAG_MOVIE_RELEASE= "movie_release"; 	//电影上映
	public static final String TAG_MOVIE_COMMENT= "movie_comment";
	public static final String TAG_CINEMA = "cinema";               //电影院
	public static final String TAG_STAR = "star";                   //影人
	public static final String TAG_STAR_DETAIL="starDetail";        //影人详情页Tag
	public static final String TAG_DRAMA = "drama";					//话剧
	public static final String TAG_DRAMASTAR = "dramastar";			//社团、导演、明星
	public static final String TAG_AGENCY = "agency";				//机构培训
	public static final String TAG_CINEMA_ACTIVITY = "cinema_activity";				//影院活动
	public static final String TAG_THEATRE_ACTIVITY = "theatre_activity";			//剧院活动
	public static final String TAG_THEATRE = "theatre";         		//剧院
	public static final String TAG_ACTIVITY = "activity";				//活动
	public static final String TAG_ACTIVITY_MEMBER = "member_activity";	//活动
	public static final String TAG_PICTURE_MEMBER = "member_picture";	//管理员传图片
	public static final String TAG_MEMBERPICTURE_MEMBER = "member_memberpicture";	//用户传图片
	public static final String TAG_CONACTIVITY = "conllectactivity";	//关注活动
	public static final Integer MULTIPLE_EXPVALUE= 10000;//最低经验值基数
	public static final Integer EXPVALUE_TO_POINT = 1000;//经验值转换成积分
	public static final String TAG_QUESTION = "gewaquestion";						//	问题
	public static final String TAG_COMMU_MEMBER = "member_commu";						//	用户圈子
	public static final String TAG_COMMENT = "member_comment";						//	哇啦
	public static final String TAG_COMMU_ACTIVITY = "commu_activity"; //圈子活动
	public static final String TAG_COMMU = "commu"; //圈子
	public static final String TAG_MEMBER_CINEMA = "member_cinema";						//用户评论影院哇啦
	public static final String TAG_MEMBER_THEATRE = "member_theatre";						//用户评论剧院哇啦
	public static final String TAG_POINT = "everyPoint";//每日红包
	
	public static final String TAG_MEMBERCARD = "membercard";	
	
	public static final String TAG_COMMENT_TYPE = "comment";				//哇啦
	public static final String TAG_MODERATOR_TYPE = "moderator";			//话题
	
	public static final String TAG_BIGLABEL="biglabel";        //标签关联哇啦	
	// 教育经历
	public static final String TAG_EDU = "edu";
	// 工作经历
	public static final String TAG_JOB = "job";
	//适合人群
	public static final String TAG_CROWD = "crowd";
	
	public static final List<String> TAGList = Arrays.asList(new String[]{"cinema", "movie", "theatre", "drama", "dramastar", "agency"});
	public static final String FLAG_PIC = "pic";
	public static final String FLAG_VIDEO = "video";

	public static final Integer READ_YES = 1;
	public static final Integer READ_NO = 0;
	public static final Integer READ_STATUS_ALL = -1;
	public static final String STATUS_FDEL = "fdel";
	public static final String STATUS_TDEL = "tdel";
	public static final String STATUS_TOALL = "toall";//管理员发给全站用户的帖子(暂未使用)
	public static final Long ADMIN_FROMMEMBERID = 0L;	// 管理员发送给全站用户, 设置管理员ID为   0
	public static final Long ADMIN_TOMEMBERID = 0L;	// 管理员发送给全站用户, 设置全站用户ID为 0
	
	public static final String DEFAULT_SUBJECT = "站内信";
	public static final Integer MAX_SECOND = 20; //发短信时间间隔，防止刷机
	
	public static final String DATETYPE_LASTWEEK = "lastweek";//上周
	public static final String DATETYPE_THISWEEK = "thisweek";//本周
	public static final String DATETYPE_NEXTWEEK = "nextweek";//下周
	
	public static final String LAST_WEEK_DIR = "lastweekdir";
	public static final String NEXT_WEEK_DIR = "nextweekdir";
	
	public static final String AGENDA_ACTION_TICKET = "ticket";						//买电影票安排生活
	public static final String AGENDA_ACTION_DRAMA = "drama";						//买话剧票安排生活
	public static final String AGENDA_ACTION_AGENDA = "agenda";						//自己安排生活
	public static final String AGENDA_ACTION_JOIN_ACTIVITY = "joinactivity";		//参加活动安排生活
	public static final String AGENDA_ACTION_CREATE_ACTIVITY = "createactivity";	//创建活动安排生活
	public static final String AGENDA_ACTION_CREATE_RESERVE = "createreserve";		//发起约战安排生活
	public static final String AGENDA_ACTION_JOIN_RESERVE = "joinreserve";			//参加约战安排生活
	public static final String AGENDA_ACTION_PUBSALE="pubsale";//竞拍
	public static final String AGENDA_ACTION_PRICE5="price5";//5元抢票
	
	
	public static final String RIGHTS_ALBUM_PUBLIC = "album_public";
	public static final String RIGHTS_ALBUM_FRIEND = "album_friend";
	public static final String RIGHTS_ALBUM_PRIVATE = "album_private";
	public static final String ALBUM_PUBLIC = "public";
	public static final String ALBUM_PRIVATE = "private";
	public static final String ALBUM_FRIEND = "friend";
	
	public static final String TAG_DRAMAORDER = "dramaOrder"; //演出购票
	public static final String TAG_MOVIEORDER = "movieOrder"; //电影购票
	public static final String TAG_JOINACTIVITY = "joinActivity";//短信预约参加活动
	public static final String TAG_ACTIVITYORDER = "activityOrder"; //活动收费
	public static final String TAG_ZHUANTI = "zhuanti";

	public static final String TAG_AGENDA = "agenda";
	public static final String TAG_MOVIEAGENDA_MEMBER = "member_movieagenda"; //电影生活安排
	public static final String TAG_DRAMAAGENDA_MEMBER = "member_dramaagenda"; //话剧生活安排
	public static final String TAG_AGENDA_MEMBER = "member_agenda";//用户生活安排
	public static final String TAG_SUBJECTACTIVITY = "subjectActivity"; 	//活动专题
	
	public static final String SUBJECT_CHRISTMAS="christmas";
	
	public static final String SQUARE_MODEL="square_model";//广场模块
	//APP广场推荐设置
	public static final String SQUARE_RECOMMENDED="square_recommended";//APP广场推荐设置
	//推荐大V用户
	public static final String RECOMMENDED_USERS="recommended_users";//推荐大V用户
	
	// 推荐
	public static final String RECOMMENDED_BATCHTYPE_FRIEND = "friend";// 电影圈推荐
	public static final String RECOMMENDED_BATCHTYPE_SQUARE = "square";// 广场推荐
	//app个人主页推荐数据
	public static final String RECOMMENDED_PERSON="recommended_person";//app个人主页推荐数据  
	//app个人主页背景图片
	public static final String RECOMMENDED_BACKGROUND="recommended_background";//app个人主页背景图片
	//app个人中心动态节点
	public static final String RECOMMENDED_DYNAMIC = "recommended_dynamic";	//app个人中心动态节点
	//app个人中心个人喜好
	public static final String RECOMMENDED_FANCY = "recommended_fancy";	//app个人中心个人喜好
	public static final String RECOMMENDED_SHORTWALA = "recommended_shortWala";	//app7.0推荐哇啦(短哇啦)
	public static final String RECOMMENDED_LONGWALA = "recommended_longWala";	//app7.0推荐哇啦(短哇啦)
}
