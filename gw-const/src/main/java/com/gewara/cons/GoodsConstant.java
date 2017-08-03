package com.gewara.cons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.UnmodifiableMap;

public abstract class GoodsConstant {
	public static final String MANAGER_USER = "user";					//管理员
	public static final String MANAGER_MEMBER = "member";				//普通用户
	public static final String MANAGER_ORGANIZATION = "organization";	//组织
	public static final List<String> MANAGER_LIST = Arrays.asList(MANAGER_MEMBER, MANAGER_USER, MANAGER_ORGANIZATION);
	
	public static final String GOODS_TYPE_GOODS = "goods";		
	public static final String GOODS_TYPE_ACTIVITY = "activity";					//活动收费
	public static final String GOODS_TYPE_TICKET = "ticket";							//通票
	
	//活动收费的TAG
	public static final String GOODS_TAG_POINT = "point"; 							//积分兑换物品
	public static final String GOODS_TAG_GROUPON = "groupon";						//团购
	public static final String GOODS_TAG_BMH = "bmh";								//影院附属商品：爆米花	
	public static final String GOODS_TAG_BMH_THEATRE= "bmh_theatre";				//话剧
	
	//预售、衍生品
	public static final String SMALLTYPE_PRE = "pre";								//预售类型卖品
	public static final String SMALLTYPE_DERIVATIVE = "derivative";					//衍生品
	public static final String SMALLTYPE_POINT = "point"; 							//积分兑换物品
	public static final String SMALLTYPE_BMH = "bmh";									//影院附属商品：爆米花	
	public static final String SMALLTYPE_BS_MP = "bs_maipin";						//商户联盟：卖品
	public static final String SMALLTYPE_BS_DER = "bs_derivative";					//商户联盟：衍生品
	public static final String SMALLTYPE_BS_PART = "bs_partner";					//商户联盟：第三方卖品
	
	public static final String BS_ACTIVITYID = "bsActivityid";						//商户联盟：活动ID

	public static final String EXTRA_TYPE = "T";	//演出团销

	public static final List<String> SMALLTYPE_BSLIST = Arrays.asList(SMALLTYPE_BS_MP, SMALLTYPE_BS_DER, SMALLTYPE_BS_PART);
	
	public static final List<String> SMALLTYPE_PRELIST = Arrays.asList(SMALLTYPE_PRE, SMALLTYPE_DERIVATIVE);
	
	public static final String DELIVER_ELEC = "elec"; 			//电子券
	public static final String DELIVER_ENTITY= "entity"; 		//实物
	public static final String DELIVER_ADDRESS= "address"; 		//地址
	public static final String GOODS_SHOPPING_COUNT = "shoppingcount";	//购买物品人数
	
	public static final String PERIOD_Y = "Y";		//有时间
	public static final String PERIOD_N = "N";		//无时间
	
	public static final String CHECK_GOODS_PRICE = "price";
	public static final String CHECK_GOODS_DISCOUNT = "discount";
	public static final List<String> CHECK_GOODSLIST = Arrays.asList(CHECK_GOODS_PRICE, CHECK_GOODS_DISCOUNT);
	
	
	public static final String FEETYPE_O = "O"; //第三方卖品（我们卖收服务费）
	public static final String FEETYPE_G = "G";	//Gewara卖品（我们自己货物）
	public static final String FEETYPE_P = "P";	//代售平台（别人卖收佣金）
	public static final String FEETYPE_C = "C";	//预售(物品卖券方式实现)
	public static final String FEETYPE_T = "T";	//指定服务平台
	
	
	public static final String GOODS_SHARE_KEY = "gsk@sWet";
	
	public static final String GOODS_OTHER_MOVIEORDER = "movieOrder";
	public static final String GOODS_OTHER_LASTMOVIETIME = "lastMovieTime";
	public static final String GOODS_OTHER_BUYTICKET = "buyticket";
	public static final String GOODS_OTHER_EDITION = "edition";
	public static final String GOODS_OTHER_CHARACTERISTIC = "characteristic";

	public static final String TAG_CINEMA = "cinema";				//场馆类型-cinema
	public static final String TAG_THEATRE = "theatre";				//场馆类型-theatre
	
	public static final String SERVICETYPE_MOVIE = "movie";					//电影模块
	public static final String SERVICETYPE_DRAMA = "drama";					//演出模块
	public static final String SERVICETYPE_ACTIVITY = "activity";			//活动模块
	
	public static final Map<String, String> feetypeMap;
	public static final Map<String, String> SERVICETYPEMAP;
	public static final String TEAM_MSG_FLAG = "teammsgflag";	//拼团短信状态
	static{
		Map<String, String> tmp = new LinkedHashMap<String, String>();
		tmp.put(FEETYPE_O, "第三方卖品");
		tmp.put(FEETYPE_G, "Gewara卖品");
		tmp.put(FEETYPE_P, "代售平台");
		tmp.put(FEETYPE_C, "预售");
		tmp.put(FEETYPE_T, "指定服务平台");
		feetypeMap = UnmodifiableMap.decorate(tmp);
		
		Map<String, String> tmpMap = new HashMap<String, String>();
		tmpMap.put(SERVICETYPE_MOVIE, "电影模块");
		tmpMap.put(SERVICETYPE_DRAMA, "演出模块");
		tmpMap.put(SERVICETYPE_ACTIVITY, "活动模块");
		SERVICETYPEMAP = UnmodifiableMap.decorate(tmpMap);
	}
}
