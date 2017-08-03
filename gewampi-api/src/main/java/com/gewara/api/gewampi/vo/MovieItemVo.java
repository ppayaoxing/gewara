package com.gewara.api.gewampi.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.api.gewampi.constant.GewampiConstant;
import com.gewara.api.vo.BaseVo;
import com.gewara.cons.OpiConstant;
import com.gewara.util.DateUtil;
import com.gewara.util.JsonUtils;
import com.gewara.util.StringUtil;

public class MovieItemVo extends BaseVo implements Comparable<MovieItemVo>{
	private static final long serialVersionUID = 7825970506234199792L;
	
	protected Long id;			//场次ID
	protected Long mpid;			//
	protected Long movieid;		//影片ID
	protected Long cinemaid;		//影院ID
	protected String language;	//语言
	protected Date playdate;		//放映日期
	protected String showtime;	//放映时间
	protected Integer price;		//影院价
	protected Integer lowest;		//最低票价
	protected Integer gewaprice;	//格瓦卖价
	protected String edition;		//版本
	protected Long roomid;		//影厅
	protected String roomnum;
	protected String opentype;	//开放类型
	protected String citycode;	//城市
	protected String seqNo;		//外部关联ID
	protected Long batch;				//批次标识
	protected Timestamp createtime;	//创建时间
	protected String openStatus;		//开放状态：init：初始状态，open：已开放，close：以后也不开放
	protected String mpitype;			//场次类型 filmfest 电影节场次
	
	//以下为opi属性
	protected Long openid;			//					------>原opi里的id
	protected String moviename;
	protected String cinemaname;
	protected String roomname;
	protected Timestamp playtime;   //				------>原opi里的playtime
	protected Integer costprice; 		//成本价（票面价）
	protected Integer fee;				//服务费
	protected String status;			//状态：可预订，不可预定等 Y[可预订]N[不可预订]D[删除]
	protected String partner;			//合作伙伴开放状态：Y对外开放,N不对外开放
	protected Timestamp opentime;		//开放购票时间
	protected Timestamp closetime;		//关闭购票时间
	protected String elecard;			//1)可用的抵用券类型ABC，2) M表示参与商家特殊优惠活动

	protected String spflag;			//特价活动标识
	
	protected String buylimit;			//购买张数限制，1,2,3,4,5
	protected Long topicid;				//取票帖子
	protected String dayotime;			//day open time 每日开放时间
	protected String dayctime;			//day close time 每日关闭时间
	protected Integer givepoint;		//给积分：正表示增加积分，负表示减积分
	protected String expressid;			//快递方式
	protected Integer lockminute;
	protected Integer maxseat;
	protected String roomtype;
	protected String otherinfo;
	protected String remark;			//备注
	protected Timestamp updatetime;	//更新时间
	protected Integer seatnum;		//座位数量
	protected Integer asellnum;		//allow 允许卖出数
	protected Integer gsellnum;		//Gewa卖出数
	protected Integer csellnum;		//影院卖出
	protected Integer locknum;		//Gewa锁定数
	
	//
	protected String characteristic;
	
	
	//=======================后加的，区域票价支持==================================================================================
	private String isMultiPrice;	//是否支持区域票价
	private String areaPrices;		//区域票价
	
	public MovieItemVo(){}
	@Override
	public Serializable realId() {
		return mpid;
	}
	/**
	 * @param playItemList
	 * @return 获取未过时的排片
	 */
	public static List<MovieItemVo> getCurrent(Date date, List<MovieItemVo> playItemList) {
		Date today = DateUtil.getBeginningTimeOfDay(new Date());
		if(date.after(today)) return playItemList;
		if(date.before(today)) return new ArrayList<MovieItemVo>();
		String time = DateUtil.format(new Date(), "HH:mm");
		List<MovieItemVo> result = new ArrayList<MovieItemVo>();
		for(MovieItemVo mpi:playItemList){
			if(mpi.showtime.compareTo(time) > 0) result.add(mpi);
		}
		return result;
	}
	
	public boolean isHfh() {
		return !hasGewara() && StringUtils.isNotBlank(seqNo);
	}
	
	public boolean isValid(){
		return StringUtils.isNotBlank(roomname) && this.playdate != null && StringUtils.isNotBlank(this.showtime);
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPlaydate() {
		return playdate;
	}

	public void setPlaydate(Date playdate) {
		this.playdate = playdate;
	}

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public int compareTo(MovieItemVo another) {
		if(this == another) return 0;
		if(another==null) return 1;
		if(this.playdate.after(another.playdate)) return 1;
		if(this.playdate.before(another.playdate)) return -1;
		if(!this.showtime.equals(another.showtime)) return this.showtime.compareTo(another.showtime);
		return StringUtils.isBlank(this.roomname) ? (StringUtils.isBlank(another.roomname) ? 0 : -1) : (StringUtils.isBlank(another.roomname) ? 1 : this.roomname.compareTo(another.roomname));
	}
	public Long getBatch() {
		return batch;
	}
	public void setBatch(Long batch) {
		this.batch = batch;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Long getRoomid() {
		return roomid;
	}

	public void setRoomid(Long roomid) {
		this.roomid = roomid;
	}

	public Long getMovieid() {
		return movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public Long getCinemaid() {
		return cinemaid;
	}

	public void setCinemaid(Long cinemaid) {
		this.cinemaid = cinemaid;
	}

	public Integer getGewaprice() {
		return gewaprice;
	}
	public void setGewaprice(Integer gewaprice) {
		this.gewaprice = gewaprice;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public Integer getLowest() {
		return lowest;
	}
	public void setLowest(Integer lowest) {
		this.lowest = lowest;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getOpenStatus() {
		return openStatus;
	}
	public void setOpenStatus(String openStatus) {
		this.openStatus = openStatus;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public String getOpentype() {
		return opentype;
	}
	public void setOpentype(String opentype) {
		this.opentype = opentype;
	}
	
	public String getMpitype() {
		return mpitype;
	}
	public void setMpitype(String mpitype) {
		this.mpitype = mpitype;
	}
	
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	
	public String getTimeStr(){
		return DateUtil.format(getPlaytime(),"HH:mm");
	}
	public int getMinpoint(){
		return GewampiConstant.MINPOINT;
	}

	public int getMaxpoint(){
		return GewampiConstant.MAXPOINT;
	}

	public Long getOpenid() {
		return openid;
	}

	public void setOpenid(Long openid) {
		this.openid = openid;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getCinemaname() {
		return cinemaname;
	}

	public void setCinemaname(String cinemaname) {
		this.cinemaname = cinemaname;
	}

	public String getRoomname() {
		return roomname;
	}
	public String getPlayroom() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Integer getCostprice() {
		return costprice;
	}

	public void setCostprice(Integer costprice) {
		this.costprice = costprice;
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

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public Timestamp getOpentime() {
		return opentime;
	}

	public void setOpentime(Timestamp opentime) {
		this.opentime = opentime;
	}

	public Timestamp getClosetime() {
		return closetime;
	}

	public void setClosetime(Timestamp closetime) {
		this.closetime = closetime;
	}

	public String getElecard() {
		return elecard;
	}

	public void setElecard(String elecard) {
		this.elecard = elecard;
	}

	public String getSpflag() {
		return spflag;
	}

	public void setSpflag(String spflag) {
		this.spflag = spflag;
	}

	public String getBuylimit() {
		return buylimit;
	}

	public void setBuylimit(String buylimit) {
		this.buylimit = buylimit;
	}

	public Long getTopicid() {
		return topicid;
	}

	public void setTopicid(Long topicid) {
		this.topicid = topicid;
	}

	public String getDayotime() {
		return dayotime;
	}

	public void setDayotime(String dayotime) {
		this.dayotime = dayotime;
	}

	public String getDayctime() {
		return dayctime;
	}

	public void setDayctime(String dayctime) {
		this.dayctime = dayctime;
	}

	public Integer getGivepoint() {
		return givepoint;
	}

	public void setGivepoint(Integer givepoint) {
		this.givepoint = givepoint;
	}

	public String getExpressid() {
		return expressid;
	}

	public void setExpressid(String expressid) {
		this.expressid = expressid;
	}

	public Integer getLockminute() {
		return lockminute;
	}

	public void setLockminute(Integer lockminute) {
		this.lockminute = lockminute;
	}

	public Integer getMaxseat() {
		return maxseat;
	}

	public void setMaxseat(Integer maxseat) {
		this.maxseat = maxseat;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public Integer getSeatnum() {
		return seatnum;
	}

	public void setSeatnum(Integer seatnum) {
		this.seatnum = seatnum;
	}

	public Integer getAsellnum() {
		return asellnum;
	}

	public void setAsellnum(Integer asellnum) {
		this.asellnum = asellnum;
	}

	public Integer getGsellnum() {
		return gsellnum;
	}

	public void setGsellnum(Integer gsellnum) {
		this.gsellnum = gsellnum;
	}

	public Integer getCsellnum() {
		return csellnum;
	}

	public void setCsellnum(Integer csellnum) {
		this.csellnum = csellnum;
	}

	public Integer getLocknum() {
		return locknum;
	}

	public void setLocknum(Integer locknum) {
		this.locknum = locknum;
	}

	public String getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}
	public Long getMpid(){
		if(this.mpid ==null){
			return id;
		}
		return mpid;
	}
	public void setMpid(Long mpid) {
		this.mpid = mpid;
	}
	
	public Timestamp getPlaytime() {
		if(playtime==null){
			return DateUtil.parseTimestamp(DateUtil.formatDate(playdate) + " " + showtime + ":00");
		}
		return playtime;
	}
	public void setPlaytime(Timestamp playtime) {
		this.playtime = playtime;
	}
	public boolean isOpenToPartner(){
		return hasOpenid() && "Y".equals(partner);
	}
	public boolean isOpenPointPay(){
		return hasOpenid() && !StringUtils.contains(this.elecard, "N");
	}
	public boolean isOpenCardPay(){
		return hasOpenid() && StringUtils.containsAny(this.elecard, "ABD");
	}
	public boolean isDisCountPay(){
		return hasOpenid() && StringUtils.contains(this.elecard, "M");
	}
	public String seatAmountStatus(){
		if(seatnum==null || asellnum==null || gsellnum==null || csellnum==null || locknum==null){
			return "2";
		}
		Integer remain = this.seatnum - this.gsellnum - this.csellnum - this.locknum;
		if(remain == 0) return "0";
		if(0 < remain && remain < 10) {
			return "1";
		}
		return "2";
	}
	public String getSeatStatus(){
		if(!hasOpenid()){
			return "";
		}
		if(seatnum==null || asellnum==null ||  gsellnum==null || csellnum==null || locknum==null){
			return "选座购票";
		}
		/*Integer remain = this.seatnum - this.gsellnum - this.csellnum - this.locknum;
		if(remain <= 0) {
			return "卖光了…";
		}else if(remain < 10) {
			return "座位紧张";
		}*/
		Timestamp curtime = DateUtil.getCurFullTimestamp();
		String resText = "选座购票";
		if(opentime!=null){
			if(opentime.after(curtime) && DateUtil.formatDate(curtime).equals(DateUtil.formatDate(opentime))){
				resText = DateUtil.format(opentime, "HH:mm")+"售票";
			}
		}
		return resText;
	}
	public boolean hasGewara(){
		return StringUtils.equals(opentype, OpiConstant.OPEN_GEWARA);
	}
	
	public boolean hasOpentype(String type){
		if(StringUtils.isBlank(type)) return false;
		return StringUtils.equals(this.opentype, type);
	}
	
	public boolean hasOpenStatus(String statuss){
		return StringUtils.equals(this.openStatus, statuss);
	}
	public boolean isUnOpenToGewa(){
		return StringUtils.contains(otherinfo, OpiConstant.UNOPENGEWA);
	}
	public boolean isUnShowToGewa(){
		return StringUtils.contains(otherinfo, OpiConstant.UNSHOWGEWA) || StringUtils.contains(otherinfo, OpiConstant.UNOPENGEWA) || StringUtils.contains(otherinfo, OpiConstant.MPITYPE_BAOCHANG);
	}
	public boolean hasOpenid(){
		return this.openid!=null;
	}
	public boolean isOrder(){
		if(!hasOpenid()){
			return false;
		}
		Timestamp curtime = new Timestamp(System.currentTimeMillis());
		String time = DateUtil.format(curtime, "HHmm");
		boolean open = getPlaytime().after(curtime) && opentime.before(curtime) 
			&& closetime.after(curtime) && status.equals(OpiConstant.STATUS_BOOK) 
			&& StringUtil.between(time, dayotime, dayctime);
		
		return open;
	}
	public boolean isShowOrder(){
		if(!hasOpenid()){
			return false;
		}
		Timestamp curtime = new Timestamp(System.currentTimeMillis());
		if(opentime.after(curtime) && !DateUtil.formatDate(curtime).equals(DateUtil.formatDate(opentime))){
			return false;
		}
		String time = DateUtil.format(curtime, "HHmm");
		boolean open = getPlaytime().after(curtime) 
			&& closetime.after(curtime) && status.equals(OpiConstant.STATUS_BOOK) 
			&& StringUtil.between(time, dayotime, dayctime);
		
		return open;
	}
	public Timestamp getFullPlaytime() {
		if(openid==null){
			return DateUtil.parseTimestamp(DateUtil.formatDate(playdate) + " " + showtime + ":00");
		}
		return playtime;
	}
	//下面的方法只在后台用
	public boolean isOpen(){
		if(hasOpenid()){
			return opentime!=null && opentime.before(new Timestamp(System.currentTimeMillis()));
		}
		return false;
	}
	
	public boolean isBooking(){
		if(hasOpenid()){
			return StringUtils.equals(status, OpiConstant.STATUS_BOOK) && !isClosed();
		}
		return false;
	}
	
	public boolean isExpired(){
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		if(hasOpenid()){
			return playtime!=null && playtime.before(cur) || StringUtils.equals(status, OpiConstant.STATUS_PAST);
		}
		return getPlaytime().before(cur);
	}
	public boolean isClosed(){
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		if(hasOpenid()){
			return closetime==null || cur.after(closetime);
		}
		return cur.before(getPlaytime());
	}
	public boolean hasOpi(){
		Timestamp cur = new Timestamp(System.currentTimeMillis());
		if(hasOpenid()){
			if(closetime.before(cur) || (opentime.after(cur) && !DateUtil.formatDate(cur).equals(DateUtil.formatDate(opentime)))
					|| !StringUtils.equals(status, OpiConstant.STATUS_BOOK) || (gsellnum != null && asellnum != null && gsellnum>=asellnum)){
				return false;
			}
			return true;
		}
		return false;
	}
	public Integer gainServiceFee(){
		if(gewaprice==null || costprice==null){
			return 0;
		}
		int serviceFee=gewaprice-costprice;
		return serviceFee<0?0:serviceFee;
	}
	public Integer getServicefee(){
		return gainServiceFee();
	}
	public String getCharacteristic() {
		return characteristic;
	}
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
	
	public int gainLockSeat(){
		if(hasOpentype(OpiConstant.OPEN_MTX)
			|| hasOpentype(OpiConstant.OPEN_JY)
			|| hasOpentype(OpiConstant.OPEN_NJY)
			|| hasOpentype(OpiConstant.OPEN_MJY)
			|| hasOpentype(OpiConstant.OPEN_WD)
			|| hasOpentype(OpiConstant.OPEN_WD2)
			|| hasOpentype(OpiConstant.OPEN_GPTBS)){
			return OpiConstant.MAXSEAT_PER_ORDER_PNX;
		}
		return OpiConstant.MAXSEAT_PER_ORDER;
	}
	
	public int gainLockMinute(){
		return OpiConstant.MAX_MINUTS_TICKETS;
	}
	
	public boolean hasRefund(){
		Map<String, String> map = JsonUtils.readJsonToMap(otherinfo);
		return StringUtils.equals(map.get("isRefund"), "Y");
	}
	public boolean hasBaoChang(){
		return StringUtils.contains(otherinfo, OpiConstant.MPITYPE_BAOCHANG);
	}
	public String getIsMultiPrice() {
		return isMultiPrice;
	}
	public void setIsMultiPrice(String isMultiPrice) {
		this.isMultiPrice = isMultiPrice;
	}
	public String getAreaPrices() {
		return areaPrices;
	}
	public void setAreaPrices(String areaPrices) {
		this.areaPrices = areaPrices;
	}
}
