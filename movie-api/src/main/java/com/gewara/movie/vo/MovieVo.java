package com.gewara.movie.vo;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.movie.vo.common.BaseEntityVo;
/**
 * @author <a href="mailto:acerge@163.com">gebiao(acerge)</a>
 * @since 2007-9-28下午02:05:17
 */
public class MovieVo extends BaseEntityVo implements Comparable<MovieVo>{
	private static final long serialVersionUID = 7175746260709239571L;
	private String language;
	private String moviename;
	private String moviealias;
	private String director;
	private String playwright;
	private String actors;
	private String filmfirm;
	private String originalcountry;
	private Date releasedate;
	private String type;
	private String honor;
	private String website;
	private Integer videolen;	//影片时长：以分钟为单位
	private String remark;
	private String state;
	private String prevideo;
	private String highlight; //经典一句话
	private String playdate;
	private Integer avgprice;
	private Integer minprice;
	private Integer maxprice;
	private String imdbid;
	private String flag;
	private Integer boughtcount;	// 购票人次
	private String otherinfo;	
	private String edition;   //电影版本
	private String colorEggs; //电影彩蛋
	private String hlogo;//横板的logo
	private String offlineDate; //电影下线日期
	private String filmType;		//片种：故事片、纪录片、美术片、科学教育片
	private String importModel;		//引进模式：国产、合拍、买断、分账
	private String period;			//年代：现代、近代、古代
	private String ageLayer;		//年龄层：80,90,00
	private String characteristic;	// 用户特征:学生等
	private String filmmark;
	private String countryRelease;	// 各国上映日期，以“,”分割
	private String sameMovie;		// 关联影片ID，以“,”分割
	
	public String getHlogo() {
		return hlogo;
	}
	public void setHlogo(String hlogo) {
		this.hlogo = hlogo;
	}
	private static Map<String, Integer[]> priceMap = new HashMap();
	static{
		priceMap.put("1", new Integer[]{0,30});
		priceMap.put("2", new Integer[]{30,50});
		priceMap.put("3", new Integer[]{50,80});
		priceMap.put("4", new Integer[]{80,1000});
	}
	public MovieVo() {
	}
	public Long getMovieid() {
		return id;
	}
	public String getPrevideo() {
		return prevideo;
	}

	public void setPrevideo(String prevideo) {
		this.prevideo = prevideo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMoviename() {
		return this.moviename;
	}

	public void setMoviename(String name) {
		this.moviename = StringUtils.trimToNull(name);
	}
	
	@Override
	public String getName(){
		return moviename;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getPlaywright() {
		return this.playwright;
	}

	public void setPlaywright(String playwright) {
		this.playwright = playwright;
	}

	public String getActors() {
		return this.actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getFilmfirm() {
		return this.filmfirm;
	}

	public void setFilmfirm(String filmfirm) {
		this.filmfirm = filmfirm;
	}

	public String getOriginalcountry() {
		return this.originalcountry;
	}

	public void setOriginalcountry(String originalcountry) {
		this.originalcountry = originalcountry;
	}

	public Date getReleasedate() {
		return this.releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void setMovietype(String type){
		this.type = type;
	}
	public String getHonor() {
		return this.honor;
	}

	public void setHonor(String honor) {
		this.honor = honor;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		if(StringUtils.isNotBlank(website) && !StringUtils.startsWith(website, "http://")) website = "http://" + website;
		this.website = website;
	}

	public String getLength() {
		if(videolen==null) return "";
		return this.videolen + "分钟";
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMoviealias() {
		return moviealias;
	}

	public void setMoviealias(String moviealias) {
		this.moviealias = moviealias;
	}
	
	public static String getPricetype(String priceStr){
		try{
			int price = Integer.parseInt(priceStr);
			for(String key: priceMap.keySet()){
				if(price >= priceMap.get(key)[0] && price < priceMap.get(key)[1]) return key;
			}
		}catch(Exception e){
		}
		return "";
	}
	public String getUrl(){
		return "movie/" + this.id;
	}
	public String getLimg(){
		if(StringUtils.isBlank(logo)) return "img/default_movie.png";
		return logo;
	}
	public String getHighlight() {
		return highlight;
	}
	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}
	public String getPlaydate() {
		return playdate;
	}
	public void setPlaydate(String playdate) {
		this.playdate = playdate;
	}
	public String getImdbid() {
		return imdbid;
	}
	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}
	public String getCname() {
		return this.moviename;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Integer getAvgprice() {
		return avgprice;
	}
	public void setAvgprice(Integer avgprice) {
		this.avgprice = avgprice;
	}
	
	public Integer getMinprice() {
		return minprice;
	}
	public void setMinprice(Integer minprice) {
		this.minprice = minprice;
	}
	public Integer getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(Integer maxprice) {
		this.maxprice = maxprice;
	}
	public Integer getRclickedtimes() {
		return this.clickedtimes;
	}
	public Integer getVideolen() {
		return videolen;
	}
	public void setVideolen(Integer videolen) {
		this.videolen = videolen;
	}

	public String getDirAndAct(){
		return (StringUtils.isNotBlank(this.director)?this.director:"") + (StringUtils.isNotBlank(this.actors)?" / "+this.actors:"");
	}

	public Integer getBoughtcount() {
		return boughtcount;
	}
	public void setBoughtcount(Integer boughtcount) {
		this.boughtcount = boughtcount;
	}
	
	public void addBoughtcount(int num){
		this.boughtcount += num;
	}
	public String getOtherinfo() {
		return otherinfo;
	}
	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getColorEggs() {
		return colorEggs;
	}
	public void setColorEggs(String colorEggs) {
		this.colorEggs = colorEggs;
	}
	public String getOfflineDate() {
		return offlineDate;
	}
	public void setOfflineDate(String offlineDate) {
		this.offlineDate = offlineDate;
	}
	public String getFilmType() {
		return filmType;
	}
	public void setFilmType(String filmType) {
		this.filmType = filmType;
	}
	public String getImportModel() {
		return importModel;
	}
	public void setImportModel(String importModel) {
		this.importModel = importModel;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getAgeLayer() {
		return ageLayer;
	}
	public void setAgeLayer(String ageLayer) {
		this.ageLayer = ageLayer;
	}
	public String getCharacteristic() {
		return characteristic;
	}
	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
	public String getFilmmark() {
		return filmmark;
	}
	public void setFilmmark(String filmmark) {
		this.filmmark = filmmark;
	}
	
	public String getCountryRelease() {
		return countryRelease;
	}
	public void setCountryRelease(String countryRelease) {
		this.countryRelease = countryRelease;
	}
	
	public String getSameMovie() {
		return sameMovie;
	}
	public void setSameMovie(String sameMovie) {
		this.sameMovie = sameMovie;
	}
	@Override
	public int compareTo(MovieVo another) {
		if(another.equals(this)) return 0; 
		int result = (this.getHotvalue() - another.getHotvalue()) + (this.getClickedtimes() - another.getClickedtimes()); 
		return -result;
	}
}
	
