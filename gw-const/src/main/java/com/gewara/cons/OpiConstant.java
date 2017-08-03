/**
 * 
 */
package com.gewara.cons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
public abstract class OpiConstant {
	public static final String STATUS_BOOK = "Y";			//接受预订
	public static final String STATUS_NOBOOK = "N";			//不接受预订
	public static final String STATUS_RECOVER = "R";		//从删除状态恢复，需要处理
	public static final String STATUS_DISCARD = "D";		//废弃
	public static final String STATUS_CLOSE = "C";			//场次状态	
	public static final String STATUS_PAST = "P";			//场次过期
	public static final String PARTNER_OPEN = "Y";			//对外开放
	public static final String PARTNER_CLOSE = "N";			//不对外开放

	//废弃
	//public static final String OPEN_PNX = "PNX";			//开放类型：与东票对接
	public static final String OPEN_DADI = "DADI";			//大地数字院线
	public static final String OPEN_HFH = "HFH";			//开放类型：与火凤凰对接
	public static final String OPEN_WD = "WD";				//开放类型：与万达对接
	public static final String OPEN_VISTA = "VISTA";		//开放类型：与Vista对接
	public static final String OPEN_JY = "JY";				//开放类型：与JY对接
	public static final String OPEN_FB = "FB";				//火烈鸟
	public static final String OPEN_XFLH = "XFLH";			//幸福蓝海
	public static final String OPEN_LMA = "LMA";			//卢米埃
	public static final String OPEN_NJY = "NJY";			//金逸票务接口（新自助机）
	public static final String OPEN_TXPC = "TXPC";			//天下票仓
	public static final String OPEN_UL = "UL";				//UL
	public static final String OPEN_MJ = "MJ";				//美嘉
	public static final String OPEN_MJY = "MJY";				//金逸（2.4）
	public static final String OPEN_WD2 = "WD2";				//万达2
	public static final String OPEN_FB2 = "FB2";				//火烈鸟2
	public static final String OPEN_DADI2 = "DADI2";				//大地vista
	public static final String OPEN_YXLT = "YXLT";				//银兴乐天
	public static final String OPEN_WM = "WM";					//沃美
	public static final String OPEN_VISTA2 = "VISTA2";			//vista2
	public static final String OPEN_MJY2 = "MJY2";				//M金逸2 
	
	//使用中
	public static final String OPEN_GEWARA = "GEWA";		//开放类型：不与火凤凰对接
	public static final String OPEN_MTX = "MTX";			//开放类型：与满天星对接
	public static final String OPEN_DX = "DX";				//开放类型：与鼎新对接
	public static final String OPEN_GPTBS = "GPTBS";		//票务系统
	public static final String OPEN_STPF = "STPF";			//辰星（大地新版）
	public static final String OPEN_FB3 = "FB3";				//火烈鸟3平台中心
	public static final String OPEN_XFLH2 = "XFLH2";			//幸福蓝海2
	public static final String OPEN_M1905 = "M1905";			//1905
	public static final String OPEN_DADI3 = "DADI3";			//大地直营平台3
	public static final String OPEN_DADI4 = "DADI4";			//大地直营平台4
	public static final String OPEN_CGV = "CGV";				//cgv
	public static final String OPEN_CFC = "CFC";				//中影
	public static final String OPEN_TXPC2 = "TXPC2";			//天下票仓2
	public static final String OPEN_SDZX = "SDZX";				//时代在线
	public static final String OPEN_VISTA3 = "VISTA3";			//VISTA RESET平台
	public static final String OPEN_WP = "WP";			//微票
	public static final String OPEN_BL = "BL";			//保利
	public static final String OPEN_HFH2 = "HFH2";		//火凤凰2
	public static final String OPEN_CTJH = "CTJH";		//橙天嘉禾
	public static final String OPEN_WD3 = "WD3";		//WD3
	public static final String OPEN_CGV2 = "CGV2";	//CGV2
	
	public static final List<String> OPEN_LOWEST_IS_COST = Arrays.asList(
			OPEN_STPF,OPEN_XFLH2,OPEN_M1905,OPEN_DADI3,OPEN_DADI4,OPEN_CFC,OPEN_CGV,OPEN_TXPC2,OPEN_SDZX,
			OPEN_VISTA3,OPEN_WP,OPEN_BL,OPEN_CTJH,OPEN_WD3,OPEN_CGV2);//最低价即结算价的类型

	
	public static final String OPERATION_DISCARD = "discard";//废弃场次

	public static final String PAYOPTION = "payoption";						//支付选项
	public static final String PAYCMETHODLIST = "paymethodlist";			//支付方法
	public static final String CARDOPTION = "cardoption";					//券选项
	public static final String BATCHIDLIST = "batchidlist";					//批次id集合
	public static final String DEFAULTPAYMETHOD = "defaultpaymethod";		//默认支付方式
	public static final String MEALOPTION = "mealoption";					//套餐项
	public static final String UNVALIDSEATPOS = "unvalidseatpos";			//不验证选择的座位位置
	public static final String ISREFUND = "isRefund";						//是否可以退票
	public static final String AUTO_OPEN_INFO = "autoOpen";					//自动开放
	public static final String AUTO_OPEN_INFO_STATUS = "autoOpenStatus";	//自动设置器的状态，手动还是自动。
	public static final String AUTO_OPEN_SETTER_ID = "setterId";			//自动设置器ID
	public static final String AUTO_OPEN_DISCARD = "autoOpenDiscard";					//自动开放废弃过的场次
	public static final String SMPNO = "smpno";								//特定的场次编号
	public static final String SIGN = "sign";									//来宾场次标识
	public static final String	AREADESC = "areadesc";						//场次区域描述
	public static final String LYMOVIEIDS = "lymovieids";					//连映场次场次ids
	public static final String SHOWLABEL = "showLabel";							//是否赠送周边
	
	public static final String SDIDS = "sdids";								//关联特价活动id
	public static final String SDIDSREMARK = "sdidsRemark";					//关联特价活动id提示给用户
	
	public static final String FROM_SPID = "fromSpid";						//从某种渠道下的订单
	public static final String ADDRESS = "address";							//地址必填
	public static final String UNOPENGEWA = "unopengewa";					//场次不对格瓦拉开放
	public static final String UNSHOWGEWA = "unshowgewa";					//场次不对格瓦拉显示
	public static final String OPENCLIENT = "openclient";					//开放客户端
	
	public static final String MPI_OPENSTATUS_INIT = "init";
	public static final String MPI_OPENSTATUS_OPEN = "open";
	public static final String MPI_OPENSTATUS_CLOSE = "close";
	public static final String MPI_OPENSTATUS_DISABLED = "disabled";		//
	public static final String MPI_OPENSTATUS_PAST = "past";				//过期
	
	
	public static final String MPITYPE_FILMFEST = "filmfest";			// 电影节标识
	public static final String MPITYPE_BAOCHANG = "baoChang";			// 包场标识
	public static final String MPITYPE_GWBAOCHANG = "gwBaoChang";			// 格瓦拉自己包场标识

	//座位图刷新频率
	public static final int SECONDS_SHOW_SEAT = 900;		//显示座位图，20分钟
	public static final int SECONDS_ADDORDER = 300;		//下单，5分钟
	public static final int SECONDS_UPDATE_SEAT = 60;		//更新，1分钟
	public static final int SECONDS_FORCEUPDATE_SEAT = 10;		//更新，10秒
	
	public static final int MAX_MINUTS_TICKETS = 15;		//电影票交易最大保留时间（分钟）
	public static final int MAX_MINUTS_TICKETS_MTX = 10; 	//满天星座位保留时间
	public static final int MAX_MINUTS_TICKETS_PNX = 5;		//票务系统座位保留时间
	
	public static final int MAXSEAT_PER_ORDER = 5;			//最大锁座数
	public static final int MAXSEAT_PER_ORDER_PNX = 4;		//最大锁座数（东票，满天星）
	
	
	public static final List<String> EDITIONS = Arrays.asList("2D","3D","IMAX2D","IMAX3D","双机3D","巨幕2D","巨幕3D", "4D", "4DX", "5D", "6D");
	public static final List<String> EDITIONS_3D = Arrays.asList("3D", "IMAX3D", "双机3D","巨幕3D", "4D", "4DX", "5D", "6D");
	public static final List<String> ADV_EDITION = Arrays.asList("6D", "5D", "4DX");
	public static final List<String> LANGUAGES = Arrays.asList(
			"国语","英语","粤语","法语","韩语","赛德克语","西班牙语","德语","俄语","日语",
			"泰语","意大利语","印度语","土耳其语","希腊语","波斯语","芬兰语","丹麦语",
			"荷兰语","葡萄牙语","波兰语","阿拉伯语","印尼语","乌克兰语","匈牙利语","马来语",
			"越南语","陕西话","闽南语","闽南话","巴西语","原版","藏语","沪语");
	public static boolean isValidEdition(String edition){
		return StringUtils.isNotBlank(edition) && EDITIONS.contains(edition);
	}
	
	public static final Map<String, String> partnerTextMap;
	public static final Map<String, String> partnerFlagMap;
	public static final Map<String, String> takemethodMap;
	public static final Map<String, String> invaildPartnerMap;//无效第三方Map
	static{
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put(OPEN_HFH, "火凤凰");
		tmp.put(OPEN_MTX, "满天星");
		tmp.put(OPEN_DX, "鼎新");
		tmp.put(OPEN_WD, "万达");
		tmp.put(OPEN_VISTA, "Vista");
		tmp.put(OPEN_GEWARA, "格瓦拉");
		//tmp.put(OPEN_PNX, "东票");
		tmp.put(OPEN_JY, "老金逸");
		tmp.put(OPEN_DADI, "大地");
		tmp.put(OPEN_FB, "火烈鸟");
		tmp.put(OPEN_XFLH, "幸福蓝海");
		tmp.put(OPEN_LMA, "卢米埃");
		tmp.put(OPEN_GPTBS, "票务系统");
		tmp.put(OPEN_NJY, "金逸（新）");
		tmp.put(OPEN_TXPC, "天下票仓");
		tmp.put(OPEN_UL, "UL系统");
		tmp.put(OPEN_MJ, "美嘉");
		tmp.put(OPEN_MJY, "金逸");
		tmp.put(OPEN_WD2, "万达2");
		tmp.put(OPEN_STPF, "辰星");
		tmp.put(OPEN_FB2, "火烈鸟2");
		tmp.put(OPEN_FB3, "火烈鸟3");
		tmp.put(OPEN_DADI2, "大地2");
		tmp.put(OPEN_YXLT, "银兴乐天");
		tmp.put(OPEN_WM, "沃美");
		tmp.put(OPEN_XFLH2, "幸福蓝海2");
		tmp.put(OPEN_M1905, "1905电影");
		tmp.put(OPEN_DADI3, "大地3");
		tmp.put(OPEN_DADI4, "大地4");
		tmp.put(OPEN_CGV, "CGV");
		tmp.put(OPEN_CFC, "中影");
		tmp.put(OPEN_TXPC2, "天下票仓2");
		tmp.put(OPEN_VISTA2, "vista2");
		tmp.put(OPEN_SDZX, "时代在线");
		tmp.put(OPEN_MJY2, "M金逸2");
		tmp.put(OPEN_VISTA3, "VISTA3");
		tmp.put(OPEN_WP, "微票");
		tmp.put(OPEN_BL, "保利");
		tmp.put(OPEN_HFH2, "火凤凰2");
		tmp.put(OPEN_CTJH, "橙天嘉禾");
		tmp.put(OPEN_WD3, "万达3");
		tmp.put(OPEN_CGV2, "CGV2");

		partnerTextMap = MapUtils.unmodifiableMap(tmp);
		Map<String, String> tmpFlag = new HashMap<String, String>();
		tmpFlag.put(OPEN_HFH, "H");
		tmpFlag.put(OPEN_MTX, "M");
		tmpFlag.put(OPEN_DX, "DX");
		tmpFlag.put(OPEN_WD, "W");
		tmpFlag.put(OPEN_VISTA, "V");
		tmpFlag.put(OPEN_GEWARA, "G");
		//tmpFlag.put(OPEN_PNX, "P");
		tmpFlag.put(OPEN_JY, "J");
		tmpFlag.put(OPEN_DADI, "DD");
		tmpFlag.put(OPEN_FB, "FB");
		tmpFlag.put(OPEN_XFLH, "XF");	
		tmpFlag.put(OPEN_LMA, "L");	
		tmpFlag.put(OPEN_GPTBS, "GP");	
		tmpFlag.put(OPEN_NJY, "NJ");
		tmpFlag.put(OPEN_TXPC, "T");	
		tmpFlag.put(OPEN_UL, "UL");	
		tmpFlag.put(OPEN_MJ, "MJ");	
		tmpFlag.put(OPEN_MJY, "MJY");
		tmpFlag.put(OPEN_WD2, "W2");
		tmpFlag.put(OPEN_STPF, "C");
		tmpFlag.put(OPEN_FB2, "FB2");
		tmpFlag.put(OPEN_FB3, "FB3");
		tmpFlag.put(OPEN_DADI2, "DADI2");
		tmpFlag.put(OPEN_YXLT, "Y");
		tmpFlag.put(OPEN_WM, "WM");
		tmpFlag.put(OPEN_XFLH2, "XFLH2");
		tmpFlag.put(OPEN_M1905, "M1905");
		tmpFlag.put(OPEN_DADI3, "DADI3");
		tmpFlag.put(OPEN_DADI4, "DADI4");
		tmpFlag.put(OPEN_CGV, "CGV");
		tmpFlag.put(OPEN_CFC, "CFC");
		tmpFlag.put(OPEN_TXPC2, "TXPC2");
		tmpFlag.put(OPEN_VISTA2, "VISTA2");
		tmpFlag.put(OPEN_SDZX, "SDZX");
		tmpFlag.put(OPEN_MJY2, "MJY2");
		tmpFlag.put(OPEN_VISTA3, "VISTA3");
		tmpFlag.put(OPEN_WP, "WP");
		tmpFlag.put(OPEN_BL, "BL");
		tmpFlag.put(OPEN_HFH2, "HFH2");
		tmpFlag.put(OPEN_CTJH, "CTJH");
		tmpFlag.put(OPEN_WD3, "WD3");
		tmpFlag.put(OPEN_CGV2, "CGV2");
		partnerFlagMap = MapUtils.unmodifiableMap(tmpFlag);
		Map<String, String> tmpTakemethod = new LinkedHashMap<String, String>();
		tmpTakemethod.put("P", "现场派送");
		tmpTakemethod.put("W", "影院售票窗口");
		tmpTakemethod.put("A", "格瓦拉取票机");
		tmpTakemethod.put("F", "格瓦拉全网取票机");
		tmpTakemethod.put("U", "联和院线自助取票机");
		tmpTakemethod.put("L", "卢米埃影院自助取票机");
		tmpTakemethod.put("D", "万达院线自助取票机");
		tmpTakemethod.put("J", "金逸院线自助取票机");
		tmpTakemethod.put("M", "影院会员自助取票机");
		tmpTakemethod.put("E", "大地会员取票机");
		tmpTakemethod.put("T", "天下票仓取票机");
		takemethodMap = MapUtils.unmodifiableMap(tmpTakemethod);
		
		Map<String, String> tmpInvalidMap = new HashMap<String, String>();
		tmpInvalidMap.put(OPEN_FB, "火烈鸟");
		tmpInvalidMap.put(OPEN_FB2, "火烈鸟2");
		tmpInvalidMap.put(OPEN_JY, "老金逸");
		tmpInvalidMap.put(OPEN_DADI, "大地");
		tmpInvalidMap.put(OPEN_XFLH, "幸福蓝海");
		invaildPartnerMap = MapUtils.unmodifiableMap(tmpInvalidMap);
	}
	
	public static boolean hasPartner(String opentype){
		if(StringUtils.equals(OPEN_GEWARA, opentype)) return false;
		if(StringUtils.isBlank(partnerTextMap.get(opentype))) return false;
		return true;
	}
	
	public static String getParnterText(String opentype){
		if(StringUtils.isBlank(opentype)) return "";
		String tmpText = partnerTextMap.get(opentype);
		if(StringUtils.isNotBlank(tmpText)) return tmpText;
		return "未知";
	}

	/**
	 * 验证放映版本与影厅的是否匹配
	 * @param roomPlaytype
	 * @param opiEdition
	 * @return
	 */
	public static String validateRoomPlaytype(String roomPlaytype, String opiEdition){
		if(StringUtils.isBlank(roomPlaytype)) return "";
		if(opiEdition.equals("3D")){
			if(roomPlaytype.equals("3D")) return "";
		}else if(opiEdition.equals("IMAX")){
			if(roomPlaytype.equals("IMAX")) return "";
		}else{//2D
			if(roomPlaytype.equals("2D")) return "";
		}
		return "场次和影厅放映版本不匹配：" + roomPlaytype + "<---->" + opiEdition;
	}
	/**
	 * 下载到排片后该影厅的场次自动转换为对应的名称
	 * 如填写为双机3D，只要下载到的场次为3D，自动转换为双机3D，下载到位2D场次不转换。
	 * 如：巨幕2D，巨幕3D，下载到的2D场次自动转换为巨幕2D，3D场次自动转换为巨幕3D。
	 * @param synchEdition
	 * @param roomDefaultEdition
	 * @return
	 */
	public static String getDefaultEdition(String synchEdition,String roomDefaultEdition){
		if(StringUtils.isBlank(synchEdition) || StringUtils.isBlank(roomDefaultEdition)){
			return synchEdition;
		}
		// 场次版本和影厅版本保持一致：优先顺序为6D、5D、4DX
		for(String edition : ADV_EDITION) {
			if(roomDefaultEdition.contains(edition)) {
				return edition;
			}
		}
		String defaults[] = StringUtils.split(roomDefaultEdition, ",");
		for(String defaultEdition : defaults){
			if(defaultEdition.contains(synchEdition)){
				return defaultEdition;
			}
		}
		return synchEdition;
	}
	
	//用来记录最后一次更新
	public static String getLastChangeKey(Long mpid) {
		return "LastChange" + mpid;
	}
}
