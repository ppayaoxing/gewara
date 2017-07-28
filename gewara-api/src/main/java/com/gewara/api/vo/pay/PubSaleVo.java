/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.vo.pay;

import com.gewara.api.vo.BaseVo;
import com.gewara.util.BeanUtil;
import com.gewara.util.DateUtil;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class PubSaleVo extends BaseVo {
	private static final long serialVersionUID = 1058839210087103092L;
	public static final String SALETYPE_GOODS = "goods";
	public static final String SALETYPE_CARD = "card";
	private Long id;
	private String name;
	private Integer lowerprice;
	private Integer curprice;
	private String dupprice;
	private Integer needpoint;
	private Integer countdown;
	private Integer ordernum;
	private Timestamp begintime;
	private Timestamp endtime;
	private String status;
	private String logo;
	private String source;
	private String remark;
	private String description;
	private Integer version;
	private String nickname;
	private Long memberid;
	private Timestamp lasttime;
	private String saletype;
	private String cardpass;
	private String citycode;
	private Long goodsid;
	private Integer pubperiod;
	private Integer pubnumber;
	private Integer unitMinute;
	private String expressid;

	public Serializable realId() {
		return this.id;
	}

	public String getCardpass() {
		return this.cardpass;
	}

	public void setCardpass(String cardpass) {
		this.cardpass = cardpass;
	}

	public String getSaletype() {
		return this.saletype;
	}

	public void setSaletype(String saletype) {
		this.saletype = saletype;
	}

	public Timestamp getLasttime() {
		return this.lasttime;
	}

	public void setLasttime(Timestamp lasttime) {
		this.lasttime = lasttime;
	}

	public PubSaleVo() {
	}

	public PubSaleVo(String name) {
		this.ordernum = Integer.valueOf(0);
		this.status = "N";
		this.name = name;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Long getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNeedpoint() {
		return this.needpoint;
	}

	public void setNeedpoint(Integer needpoint) {
		this.needpoint = needpoint;
	}

	public Timestamp getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Timestamp begintime) {
		this.begintime = begintime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public Integer getCountdown() {
		return this.countdown;
	}

	public void setCountdown(Integer countdown) {
		this.countdown = countdown;
	}

	public Integer getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLimg() {
		return StringUtils.isBlank(this.logo) ? "img/default_head.png" : this.logo;
	}

	public String getTitle() {
		return this.name;
	}

	public boolean isProgress() {
		Timestamp curtime = new Timestamp(System.currentTimeMillis());
		return this.endtime == null ? this.begintime.before(curtime)
				: this.begintime.before(curtime) && this.endtime.after(curtime);
	}

	public boolean isEnd(Timestamp curtime) {
		return this.endtime == null ? false : this.endtime.before(curtime);
	}

	public boolean isEnd2() {
		if (this.endtime == null) {
			return false;
		} else {
			Timestamp curtime = new Timestamp(System.currentTimeMillis());
			return curtime.after(this.endtime);
		}
	}

	public boolean isEnd3() {
		if (this.endtime == null) {
			return "N".equals(this.status);
		} else {
			Timestamp curtime = new Timestamp(System.currentTimeMillis());
			Timestamp endt = (Timestamp) DateUtil.addMinute(this.endtime, 5);
			return endt.after(curtime);
		}
	}

	public boolean isEnd4(Timestamp curtime) {
		if (this.endtime == null) {
			return !"N".equals(this.status);
		} else {
			Timestamp t = (Timestamp) DateUtil.addSecond(curtime, -2);
			return t.after(this.endtime);
		}
	}

	public boolean isSoon() {
		Timestamp curtime = new Timestamp(System.currentTimeMillis());
		return this.begintime.after(curtime);
	}

	public boolean isJoin() {
		return this.isProgress() && "N".equals(this.status);
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void addCurprice(Integer price) {
		if (price != null) {
			this.curprice = Integer.valueOf(this.curprice.intValue() + price.intValue());
		}

	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public boolean saleSuccess() {
		return this.memberid != null && "Y".equals(this.status);
	}

	public boolean isGoods() {
		return "goods".equals(this.saletype);
	}

	public boolean isCard() {
		return "card".equals(this.saletype);
	}

	public Integer getLowerprice() {
		return this.lowerprice;
	}

	public void setLowerprice(Integer lowerprice) {
		this.lowerprice = lowerprice;
	}

	public Integer getCurprice() {
		return this.curprice;
	}

	public void setCurprice(Integer curprice) {
		this.curprice = curprice;
	}

	public String getDupprice() {
		return this.dupprice;
	}

	public void setDupprice(String dupprice) {
		this.dupprice = dupprice;
	}

	public Double gainRprice(Integer p) {
		if (p == null) {
			return Double.valueOf(0.0D);
		} else {
			Double d = Double.valueOf((double) p.intValue() / 100.0D);
			return d;
		}
	}

	public List<Double> gainDupprice() {
		ArrayList dList = new ArrayList();
		if (StringUtils.isBlank(this.dupprice)) {
			return dList;
		} else {
			List tmpList = BeanUtil.getIntgerList(this.dupprice, ",");

			try {
				Iterator arg2 = tmpList.iterator();

				while (arg2.hasNext()) {
					Integer tmp = (Integer) arg2.next();
					dList.add(this.gainRprice(tmp));
				}
			} catch (Exception arg4) {
				;
			}

			return dList;
		}
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public boolean isClose() {
		return "N_DELETE".equals(this.status);
	}

	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public Long getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(Long goodsid) {
		this.goodsid = goodsid;
	}

	public Integer getPubnumber() {
		return this.pubnumber;
	}

	public void setPubnumber(Integer pubnumber) {
		this.pubnumber = pubnumber;
	}

	public Integer getUnitMinute() {
		return this.unitMinute;
	}

	public void setUnitMinute(Integer unitMinute) {
		this.unitMinute = unitMinute;
	}

	public Integer getPubperiod() {
		return this.pubperiod;
	}

	public void setPubperiod(Integer pubperiod) {
		this.pubperiod = pubperiod;
	}

	public String getExpressid() {
		return this.expressid;
	}

	public void setExpressid(String expressid) {
		this.expressid = expressid;
	}
}