package com.gewara.mall.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.ResultCode;
import com.gewara.mall.vo.express.ExpressRes;
import com.gewara.util.HttpResult;
import com.gewara.util.HttpUtils;
import com.gewara.util.JsonUtils;
//快递的物流信息的跟踪
public class ExpressUtil {
	public static final String EXPRESS_SF = "shunfeng";
	//使用lun.li@gewara.com登陆showapi.com
	public static final String APPID = "2440";
	public static final String SECRET = "2703ea38b023468099941a827cb4818a";
	public static final String URL4EXP = "https://route.showapi.com/64-19";
	//快递公司查询
	public static final String URL4EXPCOMPANY = "http://route.showapi.com/64-20";
	public static final Map<String, String> companyMap = new HashMap<String, String>();
	public static final Map<String,String> statusMap =  new HashMap<String,String>();
	public static ResultCode<ExpressRes> getQryRes(String nu, String com){
		if(StringUtils.isBlank(nu) || StringUtils.isBlank(com)){
			return ResultCode.getFailure("数据不能为空！");
		}
		if(StringUtils.equalsIgnoreCase(com, "ygzt") || StringUtils.length(nu)<=6 || StringUtils.startsWith(nu, "0000")){
			return ResultCode.getFailure("员工自提不查询！");
		}
		Map<String, String> map = new HashMap<String, String>();
		Long curtime = System.currentTimeMillis();
		map.put("com",com);
		map.put("nu", nu);
		map.put("showapi_appid", APPID);
		map.put("showapi_timestamp",curtime+"");
		map.put("showapi_sign","simple_" + SECRET);
		HttpResult code = HttpUtils.postUrlAsString(URL4EXP, map);
		if(!code.isSuccess()){
			return ResultCode.getFailure(code.getStatus()+"", code.getMsg());
		}
		String res = code.getResponse();
		ExpressRes expRes = JsonUtils.readJsonToObject(ExpressRes.class, res);
		if(!expRes.getShowapi_res_code().equals(0)){
			return ResultCode.getFailure(expRes.getShowapi_res_error());
		}
		return ResultCode.getSuccessReturn(expRes);
	}
	public static ResultCode<ExpressRes> getCompanyQryRes(){
		Map<String, String> map = new HashMap<String, String>();
		Long curtime = System.currentTimeMillis();
		map.put("showapi_appid", APPID);
		map.put("showapi_timestamp",curtime+"");
		map.put("showapi_sign","simple_" + SECRET);
		HttpResult code = HttpUtils.postUrlAsString(URL4EXPCOMPANY, map);
		if(!code.isSuccess()){
			return ResultCode.getFailure(code.getStatus()+"", code.getMsg());
		}
		String res = code.getResponse();
		ExpressRes expRes = JsonUtils.readJsonToObject(ExpressRes.class, res);
		if(!expRes.getShowapi_res_code().equals(0)){
			return ResultCode.getFailure(expRes.getShowapi_res_error());
		}
		return ResultCode.getSuccessReturn(expRes);
	}
	public static void main(String[] args) {
	/*	ResultCode<ExpressRes> code = getCompanyQryRes();
		ExpressRes res = code.getRetval();
		List<ExpressCompany> companyList = res.getShowapi_res_body().getExpressList();
		for(ExpressCompany company : companyList){
			System.out.println(company.getSimpleName()+"\t" + company.getExpName());
		}*/
		ResultCode<ExpressRes> code= getQryRes("968393787473","shentong");
		ExpressRes  exp=code.getRetval();
		System.out.println(exp.getShowapi_res_body().getStatus());
	}
	static{
		companyMap.put("ygzt", 	"员工自提");
		companyMap.put("abc", 	"爱彼西快递");
		companyMap.put("ande", 	"安得物流");
		companyMap.put("aol", 	"AOL快递");
		companyMap.put("pingyou", 	"包裹/挂号信/小包");
		companyMap.put("baotongda", 	"宝通达物流");
		companyMap.put("ppbyb", 	"贝邮宝");
		companyMap.put("dida", 	"递达快递");
		companyMap.put("dashun", 	"大顺物流");
		companyMap.put("guada", 	"冠达快递");
		companyMap.put("bgn", 	"布谷鸟快递");
		companyMap.put("lanhu", 	"蓝狐快递");
		companyMap.put("gdems", 	"广东ems快递");
		companyMap.put("xlyt", 	"祥龙运通");
		companyMap.put("gjbg", 	"国际包裹");
		companyMap.put("yitongda", 	"易通达");
		companyMap.put("gtsd", 	"高铁速递");
		companyMap.put("dada", 	"大达物流");
		companyMap.put("aramex", 	"Aramex");
		companyMap.put("fangfangda", 	"方方达物流");
		companyMap.put("hebeijianhua", 	"河北建华物流");
		companyMap.put("haimeng", 	"海盟速递");
		companyMap.put("haolaiyun", 	"好来运快递");
		companyMap.put("ucs", 	"合众速递");
		companyMap.put("jiayunmei", 	"加运美物流");
		companyMap.put("jinyue", 	"晋越快递");
		companyMap.put("jixianda", 	"急先达物流");
		companyMap.put("jiahuier", 	"佳惠尔快递");
		companyMap.put("kuaitao", 	"快淘快递");
		companyMap.put("lanbiao", 	"蓝镖快递");
		companyMap.put("mingliang", 	"明亮物流");
		companyMap.put("minsheng", 	"闽盛物流");
		companyMap.put("peixing", 	"陪行物流");
		companyMap.put("quanjitong", 	"全际通快递");
		companyMap.put("jppost", 	"日本邮政");
		companyMap.put("riyu", 	"日昱物流");
		companyMap.put("tnt", 	"TNT快递");
		companyMap.put("usps", 	"USPS快递");
		companyMap.put("wanjia", 	"万家物流");
		companyMap.put("pingyou", 	"小包");
		companyMap.put("singpost", 	"新加坡邮政");
		companyMap.put("hkpost", 	"香港邮政");
		companyMap.put("yuancheng", 	"远成物流");
		companyMap.put("yuefeng", 	"越丰快递");
		companyMap.put("ytfh", 	"一统飞鸿快递");
		companyMap.put("yumeijie", 	"誉美捷快递");
		companyMap.put("pingyou", 	"中国邮政快递");
		companyMap.put("intmail", 	"中国邮政国际包裹");
		companyMap.put("zhongxinda", 	"中信达快递");
		companyMap.put("zhongtian", 	"中天快运");
		companyMap.put("zuochuan", 	"佐川急便");
		companyMap.put("eyoubao", 	"E邮宝");
		companyMap.put("chengguang", 	"程光快递");
		companyMap.put("cszx", 	"城市之星");
		companyMap.put("chuanzhi", 	"传志快递");
		companyMap.put("dpex", 	"DPEX快递");
		companyMap.put("fkd", 	"飞康达快递");
		companyMap.put("feibao", 	"飞豹快递");
		companyMap.put("huitong", 	"百世汇通");
		companyMap.put("tiantian", 	"天天快递");
		companyMap.put("huiqiang", 	"汇强快递");
		companyMap.put("jldt", 	"嘉里大通");
		companyMap.put("jiaji", 	"佳吉物流");
		companyMap.put("kuaijie", 	"快捷快递");
		companyMap.put("longbang", 	"龙邦物流");
		companyMap.put("lianhaotong", 	"联昊通快递");
		companyMap.put("lejiedi", 	"乐捷递");
		companyMap.put("lijisong", 	"成都立即送快递");
		companyMap.put("minbang", 	"民邦速递");
		companyMap.put("minhang", 	"民航快递");
		companyMap.put("ocs", 	"OCS国际快递");
		companyMap.put("quanfeng", 	"全峰快递");
		companyMap.put("quanyi", 	"全一快递");
		companyMap.put("quanchen", 	"全晨快递");
		companyMap.put("quanritong", 	"全日通快递");
		companyMap.put("shentong", 	"申通快递");
		companyMap.put("haihong", 	"山东海红快递");
		companyMap.put("santai", 	"三态速递");
		companyMap.put("shenghui", 	"盛辉物流");
		companyMap.put("shengfeng", 	"盛丰物流");
		companyMap.put("shengan", 	"圣安物流");
		companyMap.put("saiaodi", 	"赛澳递");
		companyMap.put("ups", 	"UPS快递");
		companyMap.put("yousu", 	"优速快递");
		companyMap.put("xinbang", 	"新邦物流");
		companyMap.put("yuantong", 	"圆通快递");
		companyMap.put("yunda", 	"韵达快递");
		companyMap.put("yibang", 	"一邦快递");
		companyMap.put("yafeng", 	"亚风快递");
		companyMap.put("zhongtong", 	"中通快递");
		companyMap.put("zhongtie", 	"中铁快运");
		companyMap.put("zhongyou", 	"中邮物流");
		companyMap.put("jingdong", 	"京东快递");
		companyMap.put("zengyi", 	"增益快递");
		companyMap.put("huaqi", 	"华企快递");
		companyMap.put("fanyu", 	"凡宇快递");
		companyMap.put("yad", 	"源安达快递");
		companyMap.put("feiyang", 	"飞洋快递");
		companyMap.put("wanbo", 	"万博快递");
		companyMap.put("fengda", 	"丰达快递");
		companyMap.put("xindan", 	"新蛋物流");
		companyMap.put("bfdf", 	"百福东方");
		companyMap.put("bgpyghx", 	"包裹、平邮、挂号信");
		companyMap.put("coe", 	"东方快递");
		companyMap.put("ems", 	"EMS");
		companyMap.put("henglu", 	"恒路物流");
		companyMap.put("klwl", 	"康力物流");
		companyMap.put("meiguo", 	"美国快递");
		companyMap.put("weitepai", 	"微特派快递");
		companyMap.put("yuntong", 	"运通快递");
		companyMap.put("ycwl", 	"远成物流");
		companyMap.put("zjs", 	"宅急送快递");
		companyMap.put("zzjh", 	"郑州建华快递");
		companyMap.put("ztwy", 	"中天万运快递");
		companyMap.put("chengji", 	"城际快递");
		companyMap.put("anneng", 	"安能物流");
		companyMap.put("shiyun", 	"世运快递");
		companyMap.put("yxwl", 	"宇鑫物流");
		companyMap.put("meilong", 	"美龙快递");
		companyMap.put("guangtong", 	"广通速递");
		companyMap.put("ees", 	"百福东方快递(EES)");
		companyMap.put("disifang", 	"递四方速递");
		companyMap.put("dsu", 	"D速快递");
		companyMap.put("rufeng", 	"如风达快递");
		companyMap.put("anjie", 	"安捷快递");
		companyMap.put("anxinda", 	"安信达快递");
		companyMap.put("changtong", 	"长通物流");
		companyMap.put("chengshi100", 	"城市100快递");
		companyMap.put("chuanxi", 	"传喜物流(传喜快递");
		companyMap.put("datian", 	"大田物流");
		companyMap.put("dayang", 	"大洋物流快递");
		companyMap.put("feibang", 	"飞邦物流");
		companyMap.put("gongsuda", 	"共速达物流");
		companyMap.put("haosheng", 	"昊盛物流");
		companyMap.put("yinsu", 	"音速快递(音速速运");
		companyMap.put("rpx", 	"RPX保时达");
		companyMap.put("huaxialong", 	"华夏龙物流");
		companyMap.put("jiayi", 	"佳怡物流");
		companyMap.put("kuanrong", 	"宽容物流");
		companyMap.put("nell", 	"尼尔物流(尼尔快递");
		companyMap.put("sure", 	"速尔快递");
		companyMap.put("sutong", 	"速通物流");
		companyMap.put("huayu", 	"天地华宇物流");
		companyMap.put("tongcheng", 	"通成物流");
		companyMap.put("tonghe", 	"通和天下物流");
		companyMap.put("wanxiang", 	"万象物流");
		companyMap.put("scs", 	"伟邦快递(SCS快递)");
		companyMap.put("xinfeng", 	"信丰快递");
		companyMap.put("yuanzhi", 	"元智捷诚快递");
		companyMap.put("feihang", 	"原飞航快递");
		companyMap.put("zhima", 	"芝麻开门");
		companyMap.put("nengda", 	"港中能达快递");
		companyMap.put("ririshun", 	"海尔日日顺物流");
		companyMap.put("zhaijisong", 	"宅急送快递");
		companyMap.put("anxun", 	"安迅物流");
		companyMap.put("debang", 	"德邦快递");
		companyMap.put("baiqian", 	"百千诚国际物流");
		companyMap.put("cces", 	"CCES快递");
		companyMap.put("citylink", 	"CityLink快递");
		companyMap.put("chukouyi", 	"出口易");
		companyMap.put("diantong", 	"店通快递");
		companyMap.put("dajin", 	"大金物流");
		companyMap.put("feiyuan", 	"飞远物流");
		companyMap.put("feite", 	"飞特物流");
		companyMap.put("pingyou", 	"挂号信");
		companyMap.put("gnxb", 	"国内小包");
		companyMap.put("gangkuai", 	"港快速递");
		companyMap.put("huacheng", 	"华诚物流");
		companyMap.put("huahan", 	"华翰物流");
		companyMap.put("hengyu", 	"恒宇运通");
		companyMap.put("huahang", 	"华航快递");
		companyMap.put("jiuyi", 	"久易快递");
		companyMap.put("jiete", 	"捷特快递");
		companyMap.put("jingshi", 	"京世物流");
		companyMap.put("kuayue", 	"跨越快递");
		companyMap.put("mengsu", 	"蒙速快递");
		companyMap.put("nanbei", 	"南北快递");
		companyMap.put("pingyou", 	"平邮包裹");
		companyMap.put("pinganda", 	"平安达快递");
		companyMap.put("ruifeng", 	"瑞丰速递");
		companyMap.put("rongqing", 	"荣庆物流");
		companyMap.put("suijia", 	"穗佳物流");
		companyMap.put("simai", 	"思迈快递");
		companyMap.put("suteng", 	"速腾快递");
		companyMap.put("shengbang", 	"晟邦物流");
		companyMap.put("suchengzhaipei", 	"速呈宅配");
		companyMap.put("wuhuan", 	"五环速递");
		companyMap.put("xingchengzhaipei", 	"星程宅配");
		companyMap.put("ywfex", 	"源伟丰快递");
		companyMap.put("yinjie", 	"银捷快递");
		companyMap.put("gnxb", 	"邮政小包");
		companyMap.put("yanwen", 	"燕文物流");
		companyMap.put("zongxing", 	"纵行物流");
		companyMap.put("aae", 	"AAE快递");
		companyMap.put("dhl", 	"DHL快递");
		companyMap.put("fedex", 	"Fedex联邦快递(国际)");
		companyMap.put("fedexcn", 	"Fedex联邦快递(国内)");
		companyMap.put("feihu", 	"飞狐快递");
		companyMap.put("guotong", 	"国通快递");
		companyMap.put("jingguang", 	"京广速递(KKE快递)");
		companyMap.put("shunfeng", 	"顺丰快递(顺丰速运)");
		companyMap.put("spring", 	"春风物流");
		
		
		statusMap.put("-1", "待查询");
		statusMap.put("0", "查询异常");
		statusMap.put("1", "暂无记录");
		statusMap.put("2", "在途中");
		statusMap.put("3", "派送中");
		statusMap.put("4", "已签收");
		statusMap.put("5", "用户拒签");
		statusMap.put("6", "疑难件");
		statusMap.put("7", "无效单");
		statusMap.put("8", "超时单");
		statusMap.put("9", "签收失败");
		statusMap.put("10", "退回");
		
	}
}
