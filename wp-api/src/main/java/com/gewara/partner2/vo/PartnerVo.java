package com.gewara.partner2.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.model.BaseObject;

public class PartnerVo extends BaseObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6832295342083678638L;
	
	public static final String NAME_WAP = "gewap";
	public static final String NAME_WEIXIN = "weixin";
	public static final String NAME_WANDAWAP = "wandawap";
	public static final String NAME_QIEKE = "qieke";
	public static final String NAME_BAISHITONG = "baishitong";
	public static final String NAME_SPD_BANK = "spd";
	// 交行
	public static final String NAME_BANK_COMM = "bankcomm";
	// 平安一钱包
	public static final String NAME_PINGANFU = "pinganfu";
	// 
	public static final String NAME_CHUBAO = "chubao";
	// 高德地图
	public static final String NAME_AMAP = "amap";
	// 平安万里通
	public static final String NAME_PINGANWLT = "pinganwlt";
	// 优你购
	public static final String NAME_UNIONGO = "uniongo";
	// 余姚生活网
	public static final String NAME_EYUYAO = "eyuyao";
	// 建行
	public static final String NAME_CCBANK = "ccbank";
	// 微博
	public static final String NAME_WEIBOH5 = "weibo_h5";
	public static final String NAME_CMB_BANK = "cmbchina";
	public static final String NAME_BAIDU_MAP = "openapi_baidumap";
	public static final String NAME_HANGZHOUAPP = "hangzhouapp";
	public static final String NAME_139SZ = "139sz";//掌上苏州
	public static final String NAME_CM_PAY = "cmpay";
	// 上海大光明
	public static final String NAME_SHDGM = "shdgm";
	// 广发银行
	public static final String NAME_CGBCHINA = "cgbchina";
	// 泰隆银行
	public static final String NAME_TAILONGBANK = "tailongbank";
	
	public static final String NAME_UNION = "unionClient";
	// 一号店
	public static final String NAME_YIHAODIAN = "yihaodian";
	// 平安信用卡
	public static final String NAME_PINGANCREDITCARD = "pinganCreditcard";
	
	public static final String NAME_CCBAPP = "CCBAPP";
	
	public static final String NAME_UNIONPAYWALLET = "unionpayWallet";

	// 菜苗网
	public static final String NAME_CAIMIAO = "caimiao";
	
	private Long id;
	
	/** 合作商名称  */
	private String name;
	/** 秘钥 */
	private String privatekey;
	/** 合作商KEY(唯一标识) */
	private String appkey;
	
	/** 合作商其他定制信息(json格式) */
	private String otherinfo;
	private String defaultCityCode;
	
	/** 版本号 */
	private String version;
	
	/** 默认城市CODE */
	private String citycode;
	
	/** 数据格式(xml/json)*/
	private String format;
	
	/** 备注 */
	private String remark;
	
	/** 创建时间 */
	private Timestamp createtime;
	
	/** 更新时间 */
	private Timestamp updatetime;
	
	/** RSA解密私钥 */
	private String rsaprivatekey;

	/** RSA解密公钥 */
	private String rsapublickey;

	/** 跳转URL */
	private String redirecturl;
	
	public PartnerVo(){
		
	}
	public PartnerVo(String name){
		this.name  = name;
	}
	public String getName() {
		if(StringUtils.equalsIgnoreCase(name, "androidV64")){
			return "android2009";
		}else if(StringUtils.equalsIgnoreCase(name, "iphoneV64")){
			return "iphonepk2009";
		}
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrivatekey() {
		return privatekey;
	}
	public void setPrivatekey(String privatekey) {
		this.privatekey = privatekey;
	}
	public String getAppkey() {
		if(StringUtils.equalsIgnoreCase(appkey, "androidV64")){
			return "android2009";
		}else if(StringUtils.equalsIgnoreCase(appkey, "iphoneV64")){
			return "iphonepk2009";
		}
		return appkey;
	}
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public String getDefaultCityCode() {
		return defaultCityCode;
	}
	public void setDefaultCityCode(String defaultCityCode) {
		this.defaultCityCode = defaultCityCode;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRsaprivatekey() {
		return rsaprivatekey;
	}
	public void setRsaprivatekey(String rsaprivatekey) {
		this.rsaprivatekey = rsaprivatekey;
	}
	public String getRsapublickey() {
		return rsapublickey;
	}
	public void setRsapublickey(String rsapublickey) {
		this.rsapublickey = rsapublickey;
	}
	public String getRedirecturl() {
		return redirecturl;
	}
	public void setRedirecturl(String redirecturl) {
		this.redirecturl = redirecturl;
	}
	@Override
	public Serializable realId() {
		return id;
	}
	
}