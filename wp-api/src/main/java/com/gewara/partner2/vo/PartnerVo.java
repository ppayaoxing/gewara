/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.partner2.vo;

import com.gewara.model.BaseObject;
import java.io.Serializable;
import java.sql.Timestamp;
import org.apache.commons.lang.StringUtils;

public class PartnerVo extends BaseObject implements Serializable {
	private static final long serialVersionUID = 6832295342083678638L;
	public static final String NAME_WAP = "gewap";
	public static final String NAME_WEIXIN = "weixin";
	public static final String NAME_WANDAWAP = "wandawap";
	public static final String NAME_QIEKE = "qieke";
	public static final String NAME_BAISHITONG = "baishitong";
	public static final String NAME_SPD_BANK = "spd";
	public static final String NAME_BANK_COMM = "bankcomm";
	public static final String NAME_PINGANFU = "pinganfu";
	public static final String NAME_CHUBAO = "chubao";
	public static final String NAME_AMAP = "amap";
	public static final String NAME_PINGANWLT = "pinganwlt";
	public static final String NAME_UNIONGO = "uniongo";
	public static final String NAME_EYUYAO = "eyuyao";
	public static final String NAME_CCBANK = "ccbank";
	public static final String NAME_WEIBOH5 = "weibo_h5";
	public static final String NAME_CMB_BANK = "cmbchina";
	public static final String NAME_BAIDU_MAP = "openapi_baidumap";
	public static final String NAME_HANGZHOUAPP = "hangzhouapp";
	public static final String NAME_139SZ = "139sz";
	public static final String NAME_CM_PAY = "cmpay";
	public static final String NAME_SHDGM = "shdgm";
	public static final String NAME_CGBCHINA = "cgbchina";
	public static final String NAME_TAILONGBANK = "tailongbank";
	public static final String NAME_UNION = "unionClient";
	public static final String NAME_YIHAODIAN = "yihaodian";
	public static final String NAME_PINGANCREDITCARD = "pinganCreditcard";
	public static final String NAME_CCBAPP = "CCBAPP";
	public static final String NAME_UNIONPAYWALLET = "unionpayWallet";
	public static final String NAME_CAIMIAO = "caimiao";
	private Long id;
	private String name;
	private String privatekey;
	private String appkey;
	private String otherinfo;
	private String defaultCityCode;
	private String version;
	private String citycode;
	private String format;
	private String remark;
	private Timestamp createtime;
	private Timestamp updatetime;
	private String rsaprivatekey;
	private String rsapublickey;
	private String redirecturl;

	public PartnerVo() {
	}

	public PartnerVo(String name) {
		this.name = name;
	}

	public String getName() {
		return StringUtils.equalsIgnoreCase(this.name, "androidV64") ? "android2009"
				: (StringUtils.equalsIgnoreCase(this.name, "iphoneV64") ? "iphonepk2009" : this.name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrivatekey() {
		return this.privatekey;
	}

	public void setPrivatekey(String privatekey) {
		this.privatekey = privatekey;
	}

	public String getAppkey() {
		return StringUtils.equalsIgnoreCase(this.appkey, "androidV64") ? "android2009"
				: (StringUtils.equalsIgnoreCase(this.appkey, "iphoneV64") ? "iphonepk2009" : this.appkey);
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getDefaultCityCode() {
		return this.defaultCityCode;
	}

	public void setDefaultCityCode(String defaultCityCode) {
		this.defaultCityCode = defaultCityCode;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRsaprivatekey() {
		return this.rsaprivatekey;
	}

	public void setRsaprivatekey(String rsaprivatekey) {
		this.rsaprivatekey = rsaprivatekey;
	}

	public String getRsapublickey() {
		return this.rsapublickey;
	}

	public void setRsapublickey(String rsapublickey) {
		this.rsapublickey = rsapublickey;
	}

	public String getRedirecturl() {
		return this.redirecturl;
	}

	public void setRedirecturl(String redirecturl) {
		this.redirecturl = redirecturl;
	}

	public Serializable realId() {
		return this.id;
	}
}