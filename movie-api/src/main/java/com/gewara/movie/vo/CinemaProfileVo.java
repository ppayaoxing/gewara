package com.gewara.movie.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.vo.BaseVo;
import com.gewara.movie.constant.Status;
import com.gewara.util.DateUtil;

/**
 * @author acerge(acerge@163.com)
 * @since 3:05:09 PM Jan 15, 2010
 */
public class CinemaProfileVo extends BaseVo{
	private static final long serialVersionUID = -3804714651086763962L;
	public static final String STATUS_OPEN = "open";
	public static final String STATUS_CLOSE = "close";
	public static final String POPCORN_STATUS_Y ="Y";//�б��׻�
	public static final String POPCORN_STATUS_N ="N";//û�б��׻�
	public static final String SERVICEFEE_Y ="Y";//�з����
	public static final String SERVICEFEE_N ="N";//û�з����
	public static final String INSURE_STATUS_OPEN = "open";
	public static final String INSURE_STATUS_CLOSE = "close";
	
	public static final String TAKEMETHOD_P = "P";//�ֳ�����
	public static final String TAKEMETHOD_W = "W";//ӰԺ��Ʊ����
	public static final String TAKEMETHOD_A = "A";//������ȡƱ��
	public static final String TAKEMETHOD_F = "F";//������ȫ��ȡƱ��
	public static final String TAKEMETHOD_U = "U";//����Ժ��
	public static final String TAKEMETHOD_L = "L";//¬�װ�ӰԺ����ȡƱ��
	public static final String TAKEMETHOD_D = "D";//���Ժ������ȡƱ��
	public static final String TAKEMETHOD_J = "J";//����Ժ������ȡƱ��
	public static final String TAKEMETHOD_M = "M";//ӰԺ��Ա����ȡƱ��
	public static final String TAKEMETHOD_E = "E";//��ػ�Ա����ȡƱ��
	public static final String TAKEMETHOD_T = "T";//����Ʊ������ȡƱ��
	public static final String TAKEMETHOD_AFT = "AFT";//���������Լ���ȡƱ����
	
	private Long id;				//��Cinema����ID
	private String notifymsg1;		//ȡƱ����
	private String notifymsg2;		//��ǰ3Сʱ���Ѷ���
	private String notifymsg3;		//΢ƱȡƱ����
	private String notifymsg4;		//΢ƱȡƱ����
	private String notifymsg5;		//΢ƱȡƱ����
	private String takemethod; 		//ȡƱ��ʽ: P���ֳ����ͣ�W��ӰԺ��Ʊ���ڣ�A���Զ�ȡƱ��
	private Long topicid;			//ȡƱ����
	private String takeAddress;     //ȡƱλ��
	private String opentime;		//ÿ�쿪�Ź�Ʊʱ�䣬��6:00����д 0600
	private String closetime;		//ÿ��رչ�Ʊʱ��
	private String startsale;		//ÿ�����ײ͵Ŀ�ʼʱ�� 0800
	private String endsale;			//ÿ�����ײ͵Ľ���ʱ�� 2300
	private String popcorn;      	//�Ƿ��Ǻ��б��׻�ӰԺ
	private String servicefee;		//�����
	private String status;			//����״̬
	private Integer cminute;		//��ǰ�೤ʱ��ر�(����)
	private Integer openDay;         //��ǰ����ʱ��(���磺1 ��ʾ1��)
	private String openDayTime;		 //��ǰ���ż���ľ���ʱ��(���磺6:00����д 0600)
	private Integer fee;			//�����
	private String isRefund;		//�Ƿ������ƱY or N
	private String isGewaRefund;	//�Ƿ�֧��Gewa�˿Y/N��
	private String opentype;		//ӰԺ�������ͣ�HFH, MTX, DX
	private String direct;			//�Ƿ�ֱ��Y or N
	private String prompting;		//��ʾ˵��
	private String isInsure;    	//�Ƿ�֧�ֹ���ƽ������  N��nullֵ��ʾ��֧�֡�open��ʾ����֧�֣�close��ʾ��ͣ�ر�����
	private String openPriority;  	//�������ÿ������ȼ�
	private String globalLimit;		//ȫ��������GlobalLimit��Y���ã�N������
	private Integer passlen;		//ȡƱ���볤��
	protected Timestamp updatetime;	//�޸�ʱ��	
	private Boolean fromCache = false; //�Ƿ����Ա��ػ���

	@Override
	public Serializable realId() {
		return id;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CinemaProfileVo(){
	}
	public CinemaProfileVo(Long cinemaid){
		this();
		this.opentime = "0000";
		this.closetime = "2400";
		this.cminute = 60;
		this.id = cinemaid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNotifymsg1() {
		return notifymsg1;
	}
	public void setNotifymsg1(String notifymsg1) {
		this.notifymsg1 = notifymsg1;
	}
	public String getNotifymsg2() {
		return notifymsg2;
	}
	public void setNotifymsg2(String notifymsg2) {
		this.notifymsg2 = notifymsg2;
	}
	public Long getTopicid() {
		return topicid;
	}
	public void setTopicid(Long topicid) {
		this.topicid = topicid;
	}
	public String getTakemethod() {
		return takemethod;
	}
	public void setTakemethod(String takemethod) {
		this.takemethod = takemethod;
	}
	public String getOpentime() {
		return opentime;
	}
	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}
	public String getClosetime() {
		return closetime;
	}
	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}
	public String getStartsale() {
		return startsale;
	}
	public void setStartsale(String startsale) {
		this.startsale = startsale;
	}
	public String getEndsale() {
		return endsale;
	}
	public void setEndsale(String endsale) {
		this.endsale = endsale;
	}
	public String getTakeAddress() {
		return takeAddress;
	}
	public void setTakeAddress(String takeAddress) {
		this.takeAddress = takeAddress;
	}
	public boolean isBuyItem(Timestamp playtime){
		if(StringUtils.isNotBlank(startsale) && StringUtils.isNotBlank(endsale)){
			String time = DateUtil.format(playtime, "HHmm");
			if(time.compareTo(startsale)<0 || time.compareTo(endsale)>0) {
                return false;
            }
		}
		return true;
	}
	public String getPopcorn() {
		return popcorn;
	}
	public void setPopcorn(String popcorn) {
		this.popcorn = popcorn;
	}
	public String getTakeInfo(){
		String result = "��λ��ӰԺ�ĸ���������ȡƱ��ȡƱ";
		if(StringUtils.equals(takemethod, TAKEMETHOD_U)){
			result = "��λ��ӰԺ������Ժ������ȡƱ��ȡƱ";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_W)){
			result = "ӰԺ��Ʊ����ȡƱ";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_P)){
			result = "�ֳ�����";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_L)){
			result = "��λ��ӰԺ��¬�װ�ӰԺ����ȡƱ��";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_D)){
			result = "��λ��ӰԺ�����Ժ������ȡƱ��";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_J)){
			result = "��λ��ӰԺ�Ľ���Ժ������ȡƱ��";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_M)){
			result = "��λ��ӰԺ��ӰԺ��Ա����ȡƱ��";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_E)){
			result = "��λ��ӰԺ�Ĵ�ػ�Ա����ȡƱ��";
		}else if(StringUtils.equals(takemethod, TAKEMETHOD_T)){
			result = "��λ��ӰԺ������Ʊ������ȡƱ��";
		}
		return result;
	}
	public String getServicefee() {
		return servicefee;
	}
	public void setServicefee(String servicefee) {
		this.servicefee = servicefee;
	}
	public Integer getCminute() {
		return cminute;
	}
	public void setCminute(Integer cminute) {
		this.cminute = cminute;
	}
	public String getIsRefund() {
		return isRefund;
	}
	public void setIsRefund(String isRefund) {
		this.isRefund = isRefund;
	}
	public String getIsGewaRefund() {
		return isGewaRefund;
	}
	public void setIsGewaRefund(String isGewaRefund) {
		this.isGewaRefund = isGewaRefund;
	}
	public boolean supportRefundEnabled() {
		return (StringUtils.equals(isRefund, "Y") || StringUtils.equals(isGewaRefund, "Y"));
	}
	public String getDirect() {
		return direct;
	}
	public void setDirect(String direct) {
		this.direct = direct;
	}
	public String getPrompting() {
		return prompting;
	}
	public void setPrompting(String prompting) {
		this.prompting = prompting;
	}
	public boolean hasDirect(){
		return StringUtils.equals(this.direct, Status.Y);
	}
	public String getOpentype() {
		return opentype;
	}
	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}
	public Integer getOpenDay() {
		return openDay;
	}
	public void setOpenDay(Integer openDay) {
		this.openDay = openDay;
	}
	public String getOpenDayTime() {
		return openDayTime;
	}
	public void setOpenDayTime(String openDayTime) {
		this.openDayTime = openDayTime;
	}
	
	public boolean hasDefinePaper(){
		return StringUtils.isNotBlank(this.takemethod) && CinemaProfileVo.TAKEMETHOD_AFT.contains(this.takemethod)
			&& CinemaProfileVo.STATUS_OPEN.equals(this.status);
	}
	public String getOpenPriority() {
		return openPriority;
	}
	public void setOpenPriority(String openPriority) {
		this.openPriority = openPriority;
	}
	public String getIsInsure() {
		return isInsure;
	}
	public void setIsInsure(String isInsure) {
		this.isInsure = isInsure;
	}
	public String getGlobalLimit() {
		return globalLimit;
	}
	public void setGlobalLimit(String globalLimit) {
		this.globalLimit = globalLimit;
	}
	public Integer getPasslen() {
		return passlen;
	}
	public void setPasslen(Integer passlen) {
		this.passlen = passlen;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public Boolean getFromCache() {
		return fromCache;
	}
	public void setFromCache(Boolean fromCache) {
		this.fromCache = fromCache;
	}
	public String getNotifymsg3() {
		return notifymsg3;
	}
	public void setNotifymsg3(String notifymsg3) {
		this.notifymsg3 = notifymsg3;
	}
	public String getNotifymsg4() {
		return notifymsg4;
	}
	public void setNotifymsg4(String notifymsg4) {
		this.notifymsg4 = notifymsg4;
	}
	public String getNotifymsg5() {
		return notifymsg5;
	}
	public void setNotifymsg5(String notifymsg5) {
		this.notifymsg5 = notifymsg5;
	}
}
