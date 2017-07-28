/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.movie.vo;

import com.gewara.movie.vo.common.BaseEntityVo;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

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
	private Integer videolen;
	private String remark;
	private String state;
	private String prevideo;
	private String highlight;
	private String playdate;
	private Integer avgprice;
	private Integer minprice;
	private Integer maxprice;
	private String imdbid;
	private String flag;
	private Integer boughtcount;
	private String otherinfo;
	private String edition;
	private String colorEggs;
	private String hlogo;
	private String offlineDate;
	private String filmType;
	private String importModel;
	private String period;
	private String ageLayer;
	private String characteristic;
	private String filmmark;
	private String countryRelease;
	private String sameMovie;
	private static Map<String, Integer[]> priceMap = new HashMap();

	public String getHlogo() {
		return this.hlogo;
	}

	public void setHlogo(String hlogo) {
		this.hlogo = hlogo;
	}

	public Long getMovieid() {
		return this.id;
	}

	public String getPrevideo() {
		return this.prevideo;
	}

	public void setPrevideo(String prevideo) {
		this.prevideo = prevideo;
	}

	public String getState() {
		return this.state;
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

	public String getName() {
		return this.moviename;
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
		return this.videolen == null ? "" : this.videolen + "·ÖÖÓ";
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMoviealias() {
		return this.moviealias;
	}

	public void setMoviealias(String moviealias) {
		this.moviealias = moviealias;
	}

	public static String getPricetype(String priceStr) {
		try {
			int price = Integer.parseInt(priceStr);
			Iterator arg1 = priceMap.keySet().iterator();

			while (arg1.hasNext()) {
				String key = (String) arg1.next();
				if (price >= ((Integer[]) priceMap.get(key))[0].intValue()
						&& price < ((Integer[]) priceMap.get(key))[1].intValue()) {
					return key;
				}
			}
		} catch (Exception arg3) {
			;
		}

		return "";
	}

	public String getUrl() {
		return "movie/" + this.id;
	}

	public String getLimg() {
		return StringUtils.isBlank(this.logo) ? "img/default_movie.png" : this.logo;
	}

	public String getHighlight() {
		return this.highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public String getPlaydate() {
		return this.playdate;
	}

	public void setPlaydate(String playdate) {
		this.playdate = playdate;
	}

	public String getImdbid() {
		return this.imdbid;
	}

	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}

	public String getCname() {
		return this.moviename;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getAvgprice() {
		return this.avgprice;
	}

	public void setAvgprice(Integer avgprice) {
		this.avgprice = avgprice;
	}

	public Integer getMinprice() {
		return this.minprice;
	}

	public void setMinprice(Integer minprice) {
		this.minprice = minprice;
	}

	public Integer getMaxprice() {
		return this.maxprice;
	}

	public void setMaxprice(Integer maxprice) {
		this.maxprice = maxprice;
	}

	public Integer getRclickedtimes() {
		return this.clickedtimes;
	}

	public Integer getVideolen() {
		return this.videolen;
	}

	public void setVideolen(Integer videolen) {
		this.videolen = videolen;
	}

	public String getDirAndAct() {
		return (StringUtils.isNotBlank(this.director) ? this.director : "")
				+ (StringUtils.isNotBlank(this.actors) ? " / " + this.actors : "");
	}

	public Integer getBoughtcount() {
		return this.boughtcount;
	}

	public void setBoughtcount(Integer boughtcount) {
		this.boughtcount = boughtcount;
	}

	public void addBoughtcount(int num) {
		this.boughtcount = Integer.valueOf(this.boughtcount.intValue() + num);
	}

	public String getOtherinfo() {
		return this.otherinfo;
	}

	public void setOtherinfo(String otherinfo) {
		this.otherinfo = otherinfo;
	}

	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getColorEggs() {
		return this.colorEggs;
	}

	public void setColorEggs(String colorEggs) {
		this.colorEggs = colorEggs;
	}

	public String getOfflineDate() {
		return this.offlineDate;
	}

	public void setOfflineDate(String offlineDate) {
		this.offlineDate = offlineDate;
	}

	public String getFilmType() {
		return this.filmType;
	}

	public void setFilmType(String filmType) {
		this.filmType = filmType;
	}

	public String getImportModel() {
		return this.importModel;
	}

	public void setImportModel(String importModel) {
		this.importModel = importModel;
	}

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getAgeLayer() {
		return this.ageLayer;
	}

	public void setAgeLayer(String ageLayer) {
		this.ageLayer = ageLayer;
	}

	public String getCharacteristic() {
		return this.characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

	public String getFilmmark() {
		return this.filmmark;
	}

	public void setFilmmark(String filmmark) {
		this.filmmark = filmmark;
	}

	public String getCountryRelease() {
		return this.countryRelease;
	}

	public void setCountryRelease(String countryRelease) {
		this.countryRelease = countryRelease;
	}

	public String getSameMovie() {
		return this.sameMovie;
	}

	public void setSameMovie(String sameMovie) {
		this.sameMovie = sameMovie;
	}

	public int compareTo(MovieVo another) {
		if (another.equals(this)) {
			return 0;
		} else {
			int result = this.getHotvalue().intValue() - another.getHotvalue().intValue()
					+ (this.getClickedtimes().intValue() - another.getClickedtimes().intValue());
			return -result;
		}
	}

	static {
		priceMap.put("1", new Integer[] { Integer.valueOf(0), Integer.valueOf(30) });
		priceMap.put("2", new Integer[] { Integer.valueOf(30), Integer.valueOf(50) });
		priceMap.put("3", new Integer[] { Integer.valueOf(50), Integer.valueOf(80) });
		priceMap.put("4", new Integer[] { Integer.valueOf(80), Integer.valueOf(1000) });
	}
}