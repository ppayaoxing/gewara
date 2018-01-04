package com.gewara.api.vo.movie;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gewara.drama.vo.common.BaseEntityVo;

public class MovieVo extends BaseEntityVo implements Comparable<MovieVo> {
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
	private Integer videolen; // 影片时锟斤拷锟斤拷锟皆凤拷锟斤拷为锟斤拷位
	private Integer mcpCount; // 影片时锟斤拷锟斤拷锟皆凤拷锟斤拷为锟斤拷位

	private String remark;
	private String state;
	private String prevideo;
	private String highlight; // 锟斤拷锟斤拷一锟戒话
	private String playdate;
	private Integer avgprice;
	private Integer minprice;
	private Integer maxprice;
	private String imdbid;
	private String flag;
	private Integer boughtcount; // 锟斤拷票锟剿达拷
	private String otherinfo;
	private String edition; // 锟斤拷影锟芥本
	private String colorEggs; // 锟斤拷影锟绞碉拷
	private static Map<String, Integer[]> priceMap = new HashMap();
	static {
		priceMap.put("1", new Integer[] { 0, 30 });
		priceMap.put("2", new Integer[] { 30, 50 });
		priceMap.put("3", new Integer[] { 50, 80 });
		priceMap.put("4", new Integer[] { 80, 1000 });
	}

	public MovieVo() {
	}

	public MovieVo(String moviename) {
		this.generalmark = 14;
		this.generalmarkedtimes = 2;
		this.quguo = 1;
		this.xiangqu = 1;
		this.clickedtimes = 20;
		this.addtime = new Timestamp(System.currentTimeMillis());
		this.collectedtimes = 1;
		this.avgprice = 0;
		this.minprice = 0;
		this.maxprice = 0;
		this.boughtcount = 0; // 默锟斤拷0
		this.moviename = moviename;
	}

	public Integer getMcpCount() {
		return mcpCount;
	}

	public void setMcpCount(Integer mcpCount) {
		this.mcpCount = mcpCount;
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
    public String getName() {
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

	public void setMovietype(String type) {
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
		if (StringUtils.isNotBlank(website) && !StringUtils.startsWith(website, "http://")) {
            website = "http://" + website;
        }
		this.website = website;
	}

	public String getLength() {
		if (videolen == null) {
            return "";
        }
		return this.videolen + "锟斤拷锟斤拷";
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

	@Override
    public int compareTo(MovieVo another) {
		if (another.equals(this)) {
            return 0;
        }
		int result = (this.getHotvalue() - another.getHotvalue())
				+ (this.getClickedtimes() - another.getClickedtimes());
		return -result;
	}

	public static String getPricetype(String priceStr) {
		try {
			int price = Integer.parseInt(priceStr);
			for (String key : priceMap.keySet()) {
				if (price >= priceMap.get(key)[0] && price < priceMap.get(key)[1]) {
                    return key;
                }
			}
		} catch (Exception e) {
		}
		return "";
	}

	public String getUrl() {
		return "movie/" + this.id;
	}

	@Override
    public String getLogo() {
		return logo;
	}

	@Override
    public String getLimg() {
		if (StringUtils.isBlank(logo)) {
            return "img/default_movie.png";
        }
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

	/***
	 * 锟斤拷锟斤拷1=(锟斤拷锟斤拷*2锟斤拷3之锟斤拷锟斤拷锟斤拷锟斤拷)锟斤拷 1锟斤拷 锟斤拷票锟剿达拷= 锟较次癸拷票+锟斤拷锟斤拷1 2锟斤拷 锟诫看锟剿达拷= 实锟斤拷锟诫看锟斤拷锟斤拷锟斤拷 3锟斤拷 锟斤拷锟斤拷锟剿达拷= 实锟绞匡拷锟斤拷锟斤拷锟斤拷+锟斤拷锟斤拷1锟斤拷
	 * 4锟斤拷 锟斤拷锟斤拷趣锟剿达拷= 实锟绞碉拷锟斤拷锟斤拷锟饺わ拷舜锟�+锟诫看锟剿次ｏ拷 5锟斤拷 锟斤拷锟斤拷锟�= 锟较达拷锟斤拷锟斤拷锟斤拷锟�+锟斤拷锟斤拷1锟斤拷 6锟斤拷 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷= (实锟绞诧拷锟斤拷锟斤拷锟斤拷锟剿达拷+锟斤拷票锟剿达拷)/2锟斤拷
	 * 
	 **/
	public Integer getRxiangqu() {
		return this.xiangqu;
	}

	public Integer getRquguo() {
		return this.quguo + this.boughtcount;
	}

	public Integer getRcollectedtimes() {
		return this.collectedtimes + this.xiangqu;
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

	public String getDirAndAct() {
		return (StringUtils.isNotBlank(this.director) ? this.director : "")
				+ (StringUtils.isNotBlank(this.actors) ? " / " + this.actors : "");
	}

	public Integer getBoughtcount() {
		return boughtcount;
	}

	public void setBoughtcount(Integer boughtcount) {
		this.boughtcount = boughtcount;
	}

	public void addBoughtcount(int num) {
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
}
