package com.gewara.api.vo.pay;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.cons.SalesPromotionConstant;
import com.gewara.model.BaseObject;
import com.gewara.util.BeanUtil;
import com.gewara.util.DateUtil;
import com.gewara.util.JsonUtils;
import com.gewara.util.VmBaseUtil;

public class PromotionVo extends BaseVo{
	private static final long serialVersionUID = 4201413246406397258L;

	private Long id;

	/***������Ϣ----------------------------------------------------------------------------------------------*/
	
	private String extraInfo;			//��չ��Ϣ
	private String flag;				//�����ʶ
	private String tag;					//�������ͣ���PayConstant.APPLY_TAG*
	private Integer sortnum;			//��������
	private String opentype;			//��������   
	private String ptnids;				//֧������id���� �̼�ID
	private Integer discount;			//�Żݽ�� �ۿ۽��
	private String distype;				//�Żݷ�ʽ
	private String refundEnable;		// �Ƿ�֧����Ʊ��Y�����ˣ�N��������
	private String spType; 				//�������
	private String expression;			//������ʽ
	private String specialrule;			//���������ʽ
	private Integer limitperiod;		//�����޹����ڣ����ӣ�
	private Integer limitnum;			//�����޹�����
	private Integer minbuy;				//ÿ���޹���:��������
	private Integer buynum;				//ÿ���޹���:�������
	private String periodtype;			//�޹���������
	private String uniqueby;			//ʹ��ʲô����Ψһ�� Ψһ��ʶ
	private String description;			//��Ҫ˵��
	private Timestamp timefrom;			//�Żݿ�ʼʱ��
	private Timestamp timeto;			//�Żݽ���ʱ��	
	
	private Timestamp orderTimeFrom;	// �µ���ʼ����
	private Timestamp orderTimeTo;		// �µ���������	
	private String addtime1;			//�µ�ʱ���޶�1��0000
	private String addtime2;			//�µ�ʱ���޶�2��2400
	private String addweek;				//�µ��ܼ�
	
	private String remark;				//������ʱ˵�� �����ñ���
	private String enableRemark;		//����ʱ��˵�� ���ñ���
	private String adcontent;			//������� ��ϸ˵��
	private String recommendRemark;		//�Ƽ�ʱ��˵��
	private String configMessage;   	// ��ʾ��Ϣ
	private String banner;				//����bannerͼƬ
	private String loginfrom;			//��¼��Դ
	private String citycode;			//�����б�
	private Integer fullTotalfee;		//�����ٲŲ����Żݣ�������
	private String otherinfo;			//������Ϣ:
	//������binУ�� ;;;
	//sType��sText��mpiIsShow��exp_minnum��ʽ��С��������exp_maxnum��ʽ���������unCheckCardnum��mpiIndex��
	
	/***ҵ����Ϣ----------------------------------------------------------------------------------------------*/
		
	
	/***֧����Ϣ----------------------------------------------------------------------------------------------*/
	private String paymethod;			//����֧����ʽ
	private String logo;				//����Logo
	private String cardbinUkey;  	 	//������֤��ʶ
	private String validateUrl;			//��֤��תURL
	private String validBackUrl;		//֧��֪ͨURL��֤
	private String cardUkey;			//����֤Ψһ��ʶ ����֤��
	private String cardNumUnique;  		//�Ƿ����п�������֤ ��������
	private Integer cardNumPeriodIntvel; //���п�ÿ��ʹ���޹����� �������
	private Integer cardNumPeriodSpan;	//���п�������� �޹�����
	private Integer cardNumLimitnum; 	//���п��޹����� �޹�����
	
	/***������Ϣ----------------------------------------------------------------------------------------------*/
	private String bankname;			//��������
	private Integer extdiscount;		//�ⲿ�Żݽ��
	private String channel;				//���ͣ���Ż�/���������Ż�
	private String bindmobile;			//���ֻ�
	//���ĳɱ��ۣ���ȯ���߼�һ��
	private String costtype;		//�ɱ������ͣ�ӰƬ��׼ۼ�xԪ������ۼ�xԪ  ���ĳɱ���
	private Integer costnum;		//�ɱ�������  �ɱ�������
	private String verifyType;		//��̬����֤���ͣ��ޣ����ظ�ʹ�ã�������ʹ�ã��������ظ�ʹ�� VERIFYTYPE_ONLYONE  ���������
	private String showCoupon;	//	�Ƿ���ǰ̨չʾ��Ϊ�˼����ϵ�Ĭ��ΪY������ΪY��������ΪN��
	private String excludeSpid;		//�ų������ؼۻ ���������ؼۻ
	private Integer rebates;			//ÿ�ʶ������� ������
	private Integer rebatesmax;			//ǰ���������� ��������
	private String rebatestype;			//�������ͣ���ֵ���Ϳ� 
	private Long drawactivity;  		//�û�����Ʊ�󷵻�ȯ���ó齱��ʽ�����û� �齱�id
	private Integer drawperiod;			//��Ʊ�ɹ���ȡ��ȯ���� ��ȡ����
	private Integer bindDrawCardNum;	//��������ȡ�������� ��ȡ����
	private Long bindgoods;				//�����ײ� ���ײ�
	private Integer bindnum;			//�ײ͹�Ʊ���� ʹ������
	private Integer ipLimitedOrderCount;//��ip�����µ�����	
	private Long spcounterid;			//ʹ��������������ID
	
	/***ҵ����Ϣ----------------------------------------------------------------------------------------------*/
	private Timestamp playTimeFrom;		// ���ο�ʼ����
	private Timestamp playTimeTo;		// ���ν�������	
	private String excludeOpiFlg;		// �ų����ⳡ��Y���ų���N�����ų�	
	private String time1;				//��ӳʱ���޶�1��0000 ����ʱ��
	private String time2;				//��ӳʱ���޶�2��2400 ����ʱ��
	private String weektype;			//�����ܼ� ��������
	
	private String relatedid;			//������б�  ����ID
	private String relatedidEnable;	    // ����ID�Ƿ���ã�Ϊ�˼����ϵ�Ĭ��ΪY������ΪY��������ΪN
	private String categoryid;			//С�����б� ��ĿID
	private String categoryidEnable;	//	��ĿID�Ƿ���ã�Ϊ�˼����ϵ�Ĭ��ΪY������ΪY��������ΪN
	private String itemid;				//��ϸ�����б� ����ID
	private String itemidEnable;		//	����ID�Ƿ���ã�Ϊ�˼����ϵ�Ĭ��ΪY������Y��������ΪN
	private String roomId;				// Ӱ��ID
	private String roomIdEnable;		// Ӱ��ID�Ƿ����
	private String goodsid;				//���ط����б� ��ƷID
	//���� rateinfo gainGoodsBindMovieQuantity
	private String seatType;			//��λ���� ֧����λ
	private String edition;				//�汾���� �汾
	private Integer price1;				//���۷�Χ1
	private Integer price2;				//���۷�Χ2
	private Integer pricegap;			//gewa������ɱ��� ��۷�Χ
	private Integer costprice1;			//�ɱ��۷�Χ1
	private Integer costprice2;			//�ɱ��۷�Χ2
	private String fieldid;				//���ط����б� ����ID
	private Integer daynum;			// ��Ч���� 
	
	private BaseObject relate;

	private Timestamp createtime;		//����ʱ��
	private Timestamp updatetime;		//��������ʱ��
		
	@Override
	public Serializable realId() {
		return id;
	}

	public Integer getBindDrawCardNum() {
		return bindDrawCardNum;
	}
	public void setBindDrawCardNum(Integer bindDrawCardNum) {
		this.bindDrawCardNum = bindDrawCardNum;
	}
	
	public Long getDrawactivity() {
		return drawactivity;
	}
	public void setDrawactivity(Long drawactivity) {
		this.drawactivity = drawactivity;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Timestamp getTimefrom() {
		return timefrom;
	}
	public void setTimefrom(Timestamp timefrom) {
		this.timefrom = timefrom;
	}
	public Timestamp getTimeto() {
		return timeto;
	}
	public void setTimeto(Timestamp timeto) {
		this.timeto = timeto;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public boolean isValidPaymethod(String spaymethod, String paybank){
		if(StringUtils.isBlank(this.paymethod)) {
            return true;
        }
		String[] pmList = StringUtils.split(this.paymethod, ",");
		for(String pm: pmList){
			if(StringUtils.equals(pm, spaymethod)) {
                return true;
            }
			String[] pair = StringUtils.split(pm, ":");
			if(StringUtils.equals(pair[0], spaymethod)){
				if(pair.length==1 || pair.length>1 && StringUtils.equals(pair[1], paybank)) {
                    return true;
                }
			}
		}
		return false;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	
	public Integer getExtdiscount() {
		return extdiscount;
	}

	public void setExtdiscount(Integer extdiscount) {
		this.extdiscount = extdiscount;
	}

	public String getDistype() {
		return distype;
	}
	public void setDistype(String distype) {
		this.distype = distype;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getLimitnum() {
		return limitnum;
	}
	public void setLimitnum(Integer limitnum) {
		this.limitnum = limitnum;
	}
	public Integer getLimitperiod() {
		return limitperiod;
	}
	public void setLimitperiod(Integer limitperiod) {
		this.limitperiod = limitperiod;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public Integer getPricegap() {
		return pricegap;
	}
	public void setPricegap(Integer pricegap) {
		this.pricegap = pricegap;
	}
	public Integer getPrice1() {
		return price1;
	}
	public void setPrice1(Integer price1) {
		this.price1 = price1;
	}
	public Integer getPrice2() {
		return price2;
	}
	public void setPrice2(Integer price2) {
		this.price2 = price2;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getRelatedid() {
		return relatedid;
	}
	public void setRelatedid(String relatedid) {
		this.relatedid = relatedid;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getFieldid() {
		return fieldid;
	}
	public void setFieldid(String fieldid) {
		this.fieldid = fieldid;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	public String getSeatType() {
		return seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	public String getOpentype() {
		return opentype;
	}
	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}
	public String getWeektype() {
		return weektype;
	}
	public void setWeektype(String weektype) {
		this.weektype = weektype;
	}
	public String getAddtime1() {
		return addtime1;
	}
	public void setAddtime1(String addtime1) {
		this.addtime1 = addtime1;
	}
	public String getAddtime2() {
		return addtime2;
	}
	public void setAddtime2(String addtime2) {
		this.addtime2 = addtime2;
	}
	public String getAddweek() {
		return addweek;
	}
	public void setAddweek(String addweek) {
		this.addweek = addweek;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public String getAdcontent() {
		return adcontent;
	}
	public void setAdcontent(String adcontent) {
		this.adcontent = adcontent;
	}
	public Integer getBuynum() {
		return buynum;
	}
	public void setBuynum(Integer buynum) {
		this.buynum = buynum;
	}
	public Integer getRebates() {
		return rebates;
	}
	public void setRebates(Integer rebates) {
		this.rebates = rebates;
	}
	public Integer getRebatesmax() {
		return rebatesmax;
	}
	public void setRebatesmax(Integer rebatesmax) {
		this.rebatesmax = rebatesmax;
	}
	public String getRebatestype() {
		return rebatestype;
	}
	public void setRebatestype(String rebatestype) {
		this.rebatestype = rebatestype;
	}
	public String getEnableRemark() {
		return enableRemark;
	}
	public void setEnableRemark(String enableRemark) {
		this.enableRemark = enableRemark;
	}
	public String getRecommendRemark() {
		return recommendRemark;
	}
	public void setRecommendRemark(String recommendRemark) {
		this.recommendRemark = recommendRemark;
	}
	public String gainFullEnableRemark(Integer amount, Integer sdiscount){
		int tmpDiscount = sdiscount == null ? 0: sdiscount.intValue();
		String res = StringUtils.replace(StringUtils.replace(enableRemark, "amount", amount - tmpDiscount+".00"), "discount", tmpDiscount + ".00");
		if(relate!=null){
			Object tmp = BeanUtil.get(relate, "shortname");
			if(tmp!=null){
				res = tmp + res;
			}
		}
		return res;
	}
	public String gainFullRecommendRemark(Integer amount, Integer sdiscount){
		int tmpDiscount = sdiscount == null ? 0: sdiscount.intValue();
		return StringUtils.replace(StringUtils.replace(recommendRemark, "amount", amount - tmpDiscount+".00"), "discount", tmpDiscount + ".00");
	}
	public Long getBindgoods() {
		return bindgoods;
	}
	public void setBindgoods(Long bindgoods) {
		this.bindgoods = bindgoods;
	}
	public Integer getBindnum() {
		return bindnum;
	}
	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public void setBindnum(Integer bindnum) {
		this.bindnum = bindnum;
	}
	public Integer getMinbuy() {
		return minbuy;
	}
	public void setMinbuy(Integer minbuy) {
		this.minbuy = minbuy;
	}
	public String getValidateUrl() {
		return validateUrl;
	}
	public void setValidateUrl(String validateUrl) {
		this.validateUrl = validateUrl;
	}
	public Integer getSortnum() {
		return sortnum;
	}
	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getUniqueby() {
		return uniqueby;
	}
	public void setUniqueby(String uniqueby) {
		this.uniqueby = uniqueby;
	}
	public String getValidBackUrl() {
		return validBackUrl;
	}
	public void setValidBackUrl(String validBackUrl) {
		this.validBackUrl = validBackUrl;
	}
	public String getLimitperiodStr() {
		int hour = limitperiod/60;
		int min = limitperiod%60;
		int day = 0;
		if(hour > 24){
			day = hour/24;
			hour = hour % 24;
		}
		String result = (day > 0?day+"��":"") + (hour>0? hour+"Сʱ":"") + (min>0?min+"��":"");
		return result;
	}
	
	public String getChannel() {
		return channel;
	}
	
	public String getLimg(){
		return this.logo;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getBindmobile() {
		return bindmobile;
	}
	public void setBindmobile(String bindmobile) {
		this.bindmobile = bindmobile;
	}
	public Long getSpcounterid() {
		return spcounterid;
	}
	public void setSpcounterid(Long spcounterid) {
		this.spcounterid = spcounterid;
	}
	public Integer getCostprice1() {
		return costprice1;
	}
	public void setCostprice1(Integer costprice1) {
		this.costprice1 = costprice1;
	}
	public Integer getCostprice2() {
		return costprice2;
	}
	public void setCostprice2(Integer costprice2) {
		this.costprice2 = costprice2;
	}

	public Integer getDrawperiod() {
		return drawperiod;
	}

	public void setDrawperiod(Integer drawperiod) {
		this.drawperiod = drawperiod;
	}
	
	public boolean hasDistype(String type){
		return StringUtils.equals(this.distype, type);
	}
	
	public boolean hasRebatestype(String retype){
		return StringUtils.equals(this.rebatestype, retype);
	}
	
	public String gainDiscountType(){
		String tmp = "";
		if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERORDER)){
			tmp = "����";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERTICKET)){
			tmp = "����";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERCENT)){
			tmp = "�ۿ�";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_BUYONE_GIVEONE)){
			tmp = tmp + "��1��1";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_FIXPRICE)){
			tmp = "��" + this.discount;
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			tmp = "�";
		}
		if(StringUtils.isBlank(tmp)){
			if(this.rebates>0){
				tmp = "����";
			}else{
				tmp = "�Ż�";
			}
		}
		return tmp;
	}
	public Map<String,String> gainOtherinfoMap(){
		return JsonUtils.readJsonToMap(otherinfo);
	}
	
	public String gainSimpleDiscountType(){
		Map<String,String> otherinfoMap = gainOtherinfoMap();
		if(StringUtils.isNotBlank(otherinfoMap.get(SalesPromotionConstant.WEBVIEW_SIMPLE_TYPE))){
			return otherinfoMap.get(SalesPromotionConstant.WEBVIEW_SIMPLE_TYPE);
		}
		String tmp = "";
		if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERORDER)){
			tmp = "��";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERTICKET)){
			tmp = "��";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERCENT)){
			tmp = "��";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_BUYONE_GIVEONE)){
			tmp = "��";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_FIXPRICE)){
			tmp = "��";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			tmp = "��";
		}
		if(StringUtils.isBlank(tmp)){
			if(this.rebates>0){
				tmp = "��";
			}
		}
		return tmp;
	}
	
	public String gainSimpleDiscountText(String discountText,String rebatesText){
		Map<String,String> otherinfoMap = gainOtherinfoMap();
		if(StringUtils.isNotBlank(otherinfoMap.get(SalesPromotionConstant.WEBVIEW_SIMPLE_TEXT))){
			return otherinfoMap.get(SalesPromotionConstant.WEBVIEW_SIMPLE_TEXT);
		}
		String tmp = "";
		if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERORDER)){
			tmp = "discountԪ";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERTICKET)){
			tmp = "discountԪ";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERCENT)){
			tmp = "discount��";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_BUYONE_GIVEONE)){
			tmp = "��һ��һ";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_FIXPRICE)){
			tmp = "discountԪ";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			tmp = "����";
		}
		if(StringUtils.isBlank(tmp)){
			if(this.rebates>0){
				if(hasRebatestype("Y")) {
                    tmp += "rebatesԪ";
                }
				if(hasRebatestype("P")) {
                    tmp += "rebates����";
                }
				if(hasRebatestype("A") || hasRebatestype("D")) {
                    tmp += "rebatesԪȯ";
                }
				tmp = StringUtils.replace(tmp, "rebates", rebatesText);
			}
		}
		tmp = StringUtils.replace(tmp, "discount", discountText);
		return tmp;
	}
	
	public String getDiscountText(String bankText, String discountText, String rebatesText){
		String tmp = "bankname";
		if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERORDER)){
			if(this.discount != null && this.discount > 0){
				tmp = tmp + "ÿ�ʶ�������discountԪ";
			}
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERTICKET)){
			if(this.discount != null && this.discount > 0){
				tmp = tmp + "ÿ��Ʊ����discountԪ";
			}
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERCENT)){
			tmp = tmp + "ÿ�ʶ���discount���Ż�";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_BUYONE_GIVEONE)){
			tmp = tmp + "��������һ��һ";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_FIXPRICE)){
			tmp = tmp + "ÿ��Ʊ����discountԪ";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			tmp = tmp + this.description;
		}
		tmp = StringUtils.replace(tmp, "bankname", bankText);
		tmp = StringUtils.replace(tmp, "discount", discountText);
		if(this.rebates>0){
			if((hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERTICKET) || hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERORDER)) && !(this.discount != null && this.discount > 0)){
				tmp += "����rebates";
			}else{
				tmp += ", ����rebates";
			}
			if(hasRebatestype("Y")) {
                tmp += "Ԫ";
            }
			if(hasRebatestype("P")) {
                tmp += "����";
            }
			if(hasRebatestype("A") || hasRebatestype("D")) {
                tmp += "Ԫȯ";
            }
			tmp = StringUtils.replace(tmp, "rebates", rebatesText);
		}
		return tmp;
	}
	
	public String gainDiscount(String noRebates){
		int tmp = this.discount;
		if(hasExtdicount()){
			tmp = this.extdiscount;
		}
		String tmpDiscount = String.valueOf(tmp);
		if(Boolean.parseBoolean(noRebates) && hasRebatestype("Y")){
			tmpDiscount = String.valueOf(tmp + this.rebates);
		}
		if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_PERCENT)){
			String tmpPattern = "0";
			if(tmp !=0 && (100-tmp)%10>0) {
                tmpPattern = "0.0";
            }
			tmpDiscount = VmBaseUtil.formatPercent(100-tmp, 10, tmpPattern);
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_BUYONE_GIVEONE)){
			tmpDiscount = "X";
		}else if(hasDistype(SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			tmpDiscount = "XԪ";
		}
		return tmpDiscount;
	}
	
	public boolean hasExtdicount(){
		return this.extdiscount != null && this.discount == 0 && this.extdiscount > 0;
	}

	public Integer getIpLimitedOrderCount() {
		return ipLimitedOrderCount;
	}

	public void setIpLimitedOrderCount(Integer ipLimitedOrderCount) {
		this.ipLimitedOrderCount = ipLimitedOrderCount;
	}

	public String getCardUkey() {
		return cardUkey;
	}

	public void setCardUkey(String cardUkey) {
		this.cardUkey = cardUkey;
	}

	public String getCardNumUnique() {
		return cardNumUnique;
	}

	public void setCardNumUnique(String cardNumUnique) {
		this.cardNumUnique = cardNumUnique;
	}

	public Integer getCardNumLimitnum() {
		return cardNumLimitnum;
	}

	public void setCardNumLimitnum(Integer cardNumLimitnum) {
		this.cardNumLimitnum = cardNumLimitnum;
	}

	public String getCardbinUkey() {
		return cardbinUkey;
	}

	public void setCardbinUkey(String cardbinUkey) {
		this.cardbinUkey = cardbinUkey;
	}

	public Integer getCardNumPeriodIntvel() {
		return cardNumPeriodIntvel;
	}

	public void setCardNumPeriodIntvel(Integer cardNumPeriodIntvel) {
		this.cardNumPeriodIntvel = cardNumPeriodIntvel;
	}

	public Integer getCardNumPeriodSpan() {
		return cardNumPeriodSpan;
	}

	public void setCardNumPeriodSpan(Integer cardNumPeriodSpan) {
		this.cardNumPeriodSpan = cardNumPeriodSpan;
	}
	
	public String getLoginfrom() {
		return loginfrom;
	}

	public void setLoginfrom(String loginfrom) {
		this.loginfrom = loginfrom;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getSpecialrule() {
		return specialrule;
	}

	public void setSpecialrule(String specialrule) {
		this.specialrule = specialrule;
	}

	public String getPeriodtype() {
		return periodtype;
	}

	public void setPeriodtype(String periodtype) {
		this.periodtype = periodtype;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public String getPtnids() {
		return ptnids;
	}

	public void setPtnids(String ptnids) {
		this.ptnids = ptnids;
	}

	public String getCosttype() {
		return costtype;
	}

	public void setCosttype(String costtype) {
		this.costtype = costtype;
	}

	public Integer getCostnum() {
		return costnum;
	}

	public void setCostnum(Integer costnum) {
		this.costnum = costnum;
	}

	public String getVerifyType() {
		return verifyType;
	}

	public void setVerifyType(String verifyType) {
		this.verifyType = verifyType;
	}

	public String getRelatedidEnable() {
		return StringUtils.isEmpty(relatedidEnable) ? SalesPromotionConstant.ENABLE : relatedidEnable;
	}

	public void setRelatedidEnable(String relatedidEnable) {
		this.relatedidEnable = relatedidEnable;
	}

	public String getCategoryidEnable() {
		return StringUtils.isEmpty(categoryidEnable) ? SalesPromotionConstant.ENABLE : categoryidEnable;
	}

	public void setCategoryidEnable(String categoryidEnable) {
		this.categoryidEnable = categoryidEnable;
	}

	public String getItemidEnable() {
		return StringUtils.isEmpty(itemidEnable) ? SalesPromotionConstant.ENABLE : itemidEnable;
	}

	public void setItemidEnable(String itemidEnable) {
		this.itemidEnable = itemidEnable;
	}

	public String getShowCoupon() {
		return StringUtils.isEmpty(showCoupon) ? SalesPromotionConstant.ENABLE : showCoupon;
	}

	public void setShowCoupon(String showCoupon) {
		this.showCoupon = showCoupon;
	}

	public String getExcludeSpid() {
		return excludeSpid;
	}

	public void setExcludeSpid(String excludeSpid) {
		this.excludeSpid = excludeSpid;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomIdEnable() {
		return StringUtils.isEmpty(roomIdEnable) ? SalesPromotionConstant.ENABLE : roomIdEnable;
	}

	public void setRoomIdEnable(String roomIdEnable) {
		this.roomIdEnable = roomIdEnable;
	}

	public Timestamp getPlayTimeFrom() {
		return playTimeFrom;
	}

	public void setPlayTimeFrom(Timestamp playTimeFrom) {
		this.playTimeFrom = playTimeFrom;
	}

	public Timestamp getOrderTimeFrom() {
		return orderTimeFrom;
	}

	public void setOrderTimeFrom(Timestamp orderTimeFrom) {
		this.orderTimeFrom = orderTimeFrom;
	}

	public Timestamp getPlayTimeTo() {
		return playTimeTo;
	}

	public void setPlayTimeTo(Timestamp playTimeTo) {
		this.playTimeTo = playTimeTo;
	}

	public Timestamp getOrderTimeTo() {
		return orderTimeTo;
	}

	public void setOrderTimeTo(Timestamp orderTimeTo) {
		this.orderTimeTo = orderTimeTo;
	}

	public String getRefundEnable() {
		return refundEnable;
	}

	public void setRefundEnable(String refundEnable) {
		this.refundEnable = refundEnable;
	}

	public String getConfigMessage() {
		return configMessage;
	}

	public void setConfigMessage(String configMessage) {
		this.configMessage = configMessage;
	}

	public String getExcludeOpiFlg() {
		return excludeOpiFlg;
	}

	public void setExcludeOpiFlg(String excludeOpiFlg) {
		this.excludeOpiFlg = excludeOpiFlg;
	}

	public String getSpType() {
		return spType;
	}

	public void setSpType(String spType) {
		this.spType = spType;
	}
	//����Ǳ��ʽ�Ļ�����й�ʽ�������Ƶģ��򰴹�ʽ�������������������磺1-2�Ű��ۿۼ۸񣬳���2�ŵİ�ԭ��
	public Integer gainRealQuantity(int quantity){
		if(StringUtils.equals(distype, SalesPromotionConstant.DISCOUNT_TYPE_EXPRESSION)){
			Map<String, String> otherMap = JsonUtils.readJsonToMap(otherinfo);
			if(otherMap.containsKey(SalesPromotionConstant.EXP_MAXNUM)){
				int rq = Integer.valueOf(otherMap.get(SalesPromotionConstant.EXP_MAXNUM));
				if(quantity>rq){
					return rq;
				}
			}
		}
		return quantity;
	}
	public Integer gainGoodsBindMovieQuantity(int quantity){
		if(StringUtils.equals(tag, SalesPromotionConstant.APPLY_TAG_GOODSBINDMOBIE)){
			String rateinfo = JsonUtils.getJsonValueByKey(otherinfo, "rateinfo");
			if(StringUtils.isNotBlank(rateinfo)){
				Map<String, Integer> m = new HashMap<String, Integer>();
				String[] args = rateinfo.split(",");
				if(args!=null && args.length>0){
					for(String arg : args){
						String[] tmp = arg.split(":");
						if(tmp!=null && tmp.length>1) {
							m.put(tmp[0], Integer.valueOf(tmp[1]));
						}
					}
				}
				return m.get(quantity+"");
			}
		}
		return null;
	}
	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public BaseObject getRelate() {
		return relate;
	}

	public void setRelate(BaseObject relate) {
		this.relate = relate;
	}
	public String gainItemMaxSellNumKey(Long itemId){
		return SalesPromotionConstant.ITEM_MAX_SELLNUM + ":" + itemId;
	}
	public Integer gainItemMaxSellNum(){
		String key = JsonUtils.getJsonValueByKey(otherinfo, SalesPromotionConstant.ITEM_MAX_SELLNUM);
		if(StringUtils.isNotBlank(key)){
			return Integer.valueOf(key);
		}
		return null;
	}
	public Long gainDiffSecond(){
		return DateUtil.getDiffSecond(timeto, timefrom);
	}

	public Integer getFullTotalfee() {
		return fullTotalfee;
	}

	public void setFullTotalfee(Integer fullTotalfee) {
		this.fullTotalfee = fullTotalfee;
	}
	public boolean needRedirect(){
		if(StringUtils.isBlank(validateUrl)){
			return false;
		}
		if(!StringUtils.startsWithIgnoreCase(validateUrl, "http") || StringUtils.endsWithIgnoreCase(validateUrl, "Fast.xhtml")){
			return true;
		}
		return false;
	}

	public Integer getDaynum() {
		return daynum;
	}

	public void setDaynum(Integer daynum) {
		this.daynum = daynum;
	}
	
}
