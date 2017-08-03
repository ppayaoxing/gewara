package com.gewara.api.vo;

import java.io.Serializable;

/***
 * 盘点Model对象
 */
public class PanDianVO implements Serializable{
	private static final long serialVersionUID = 142345234562634L;
	private Long memberid; //用户id
    //page1
    private String nickName; //用户昵称
    private Integer registerDuration; //注册时长
    //page2
    private Integer watchedMovieNum;//看过电影数
    private Integer dayNum; //白天看的电影数
    private Integer nightNum;//晚上看的电影数
    private String repeatMovies; //观看的重复电影列表
    private Integer movieCost;//看电影实际花费
    private Integer saveMoney;//节省费用
    //page3
    private Long mostCinema;//常去影院id
    private Integer cinemaMovieNum;//看得电影数
    private Integer cinemaUserCount;//电影院观影总人次
    private String  userMeetList;//和哪些用户擦肩而过
    //page4
    private Integer maxTogetherNum; //陪伴人数
    private Integer aloneNum; //一个人观看次数
    //page5
    private Integer totalMarkNum;//打分次数
    private Integer leFiveNum; //小于等于5分的次数
    private Integer geEightNum;  //大于等于8分的次数
    private Integer greatMovieNum;  //了不起电影数
    private String goodMovieIds; //  5部电影logo、id、 名称、自己的评分
    private String badMovieIds;  //5部怒打电影logo、id、 名称、自己的评分
    private String markMovieIds ; //打过分的电影.
    //page6
    private Integer totalOrdersNum; //一年总订单数
    private Integer walaCount;  //写哇啦数
    private String ticketWalaCount; //购票并发wala 次数
    private Integer beFloweredCount;    //哇啦被赞总数
    private Integer beReplyedCount; //哇啦被回复总数
    private Long bestWalaID;    //获得评论或者赞数最多的一条哇啦
    //page7
    private Long bestMovieId; //订单中评分最高的电影
    private Long recommendWalaID; //评论或赞最多的一条wala
    private Integer flowerCount;//点赞总数
    private Integer replyCount;//回复总数
    private Integer friendCount; //导入通讯录找到的好友数量
    //page8
    private Integer redPacketsNum;//领取每日红包的次数
    private Integer totalAnswerNum;//每日答题的次数
    private Integer rightAnswerNum;//答对次数
    private Integer wrongAnswerNum;//答错次数
    private Integer joinActivityNum;//参加活动的次数
    private String honorLabel;//荣誉标签

    public PanDianVO() {
    }
    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getRegisterDuration() {
        return registerDuration;
    }

    public void setRegisterDuration(Integer registerDuration) {
        this.registerDuration = registerDuration;
    }

    public Integer getWatchedMovieNum() {
        return watchedMovieNum;
    }

    public void setWatchedMovieNum(Integer watchedMovieNum) {
        this.watchedMovieNum = watchedMovieNum;
    }

    public Integer getDayNum() {
        return dayNum;
    }

    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }

    public Integer getNightNum() {
        return nightNum;
    }

    public void setNightNum(Integer nightNum) {
        this.nightNum = nightNum;
    }

    
    public Integer getMovieCost() {
		return movieCost;
	}
	public void setMovieCost(Integer movieCost) {
		this.movieCost = movieCost;
	}
	public Integer getSaveMoney() {
		return saveMoney;
	}
	public void setSaveMoney(Integer saveMoney) {
		this.saveMoney = saveMoney;
	}

    public Long getMostCinema() {
		return mostCinema;
	}
	public void setMostCinema(Long mostCinema) {
		this.mostCinema = mostCinema;
	}
	public Integer getCinemaMovieNum() {
        return cinemaMovieNum;
    }

    public void setCinemaMovieNum(Integer cinemaMovieNum) {
        this.cinemaMovieNum = cinemaMovieNum;
    }

    public Integer getMaxTogetherNum() {
        return maxTogetherNum;
    }

    public void setMaxTogetherNum(Integer maxTogetherNum) {
        this.maxTogetherNum = maxTogetherNum;
    }

    public Integer getAloneNum() {
        return aloneNum;
    }

    public void setAloneNum(Integer aloneNum) {
        this.aloneNum = aloneNum;
    }

    public Integer getTotalMarkNum() {
        return totalMarkNum;
    }

    public void setTotalMarkNum(Integer totalMarkNum) {
        this.totalMarkNum = totalMarkNum;
    }

    public Integer getLeFiveNum() {
        return leFiveNum;
    }

    public void setLeFiveNum(Integer leFiveNum) {
        this.leFiveNum = leFiveNum;
    }

    public Integer getGeEightNum() {
        return geEightNum;
    }

    public void setGeEightNum(Integer geEightNum) {
        this.geEightNum = geEightNum;
    }

    public Integer getGreatMovieNum() {
        return greatMovieNum;
    }

    public void setGreatMovieNum(Integer greatMovieNum) {
        this.greatMovieNum = greatMovieNum;
    }

    public String getGoodMovieIds() {
		return goodMovieIds;
	}
	public void setGoodMovieIds(String goodMovieIds) {
		this.goodMovieIds = goodMovieIds;
	}
	public String getBadMovieIds() {
		return badMovieIds;
	}
	public void setBadMovieIds(String badMovieIds) {
		this.badMovieIds = badMovieIds;
	}
	public String getMarkMovieIds() {
		return markMovieIds;
	}
	public void setMarkMovieIds(String markMovieIds) {
		this.markMovieIds = markMovieIds;
	}
	public Integer getTotalOrdersNum() {
        return totalOrdersNum;
    }

    public void setTotalOrdersNum(Integer totalOrdersNum) {
        this.totalOrdersNum = totalOrdersNum;
    }

    public Integer getWalaCount() {
        return walaCount;
    }

    public void setWalaCount(Integer walaCount) {
        this.walaCount = walaCount;
    }

    public Integer getBeFloweredCount() {
        return beFloweredCount;
    }

    public void setBeFloweredCount(Integer beFloweredCount) {
        this.beFloweredCount = beFloweredCount;
    }

    public Integer getBeReplyedCount() {
        return beReplyedCount;
    }

    public void setBeReplyedCount(Integer beReplyedCount) {
        this.beReplyedCount = beReplyedCount;
    }

    public Long getBestWalaID() {
        return bestWalaID;
    }

    public void setBestWalaID(Long bestWalaID) {
        this.bestWalaID = bestWalaID;
    }

    public Long getRecommendWalaID() {
        return recommendWalaID;
    }

    public void setRecommendWalaID(Long recommendWalaID) {
        this.recommendWalaID = recommendWalaID;
    }

    public Integer getFlowerCount() {
        return flowerCount;
    }

    public void setFlowerCount(Integer flowerCount) {
        this.flowerCount = flowerCount;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getFriendCount() {
        return friendCount;
    }

    public void setFriendCount(Integer friendCount) {
        this.friendCount = friendCount;
    }

    public Integer getRedPacketsNum() {
        return redPacketsNum;
    }

    public void setRedPacketsNum(Integer redPacketsNum) {
        this.redPacketsNum = redPacketsNum;
    }

    public Integer getTotalAnswerNum() {
        return totalAnswerNum;
    }

    public void setTotalAnswerNum(Integer totalAnswerNum) {
        this.totalAnswerNum = totalAnswerNum;
    }

    public Integer getRightAnswerNum() {
        return rightAnswerNum;
    }

    public void setRightAnswerNum(Integer rightAnswerNum) {
        this.rightAnswerNum = rightAnswerNum;
    }

    public Integer getWrongAnswerNum() {
        return wrongAnswerNum;
    }

    public void setWrongAnswerNum(Integer wrongAnswerNum) {
        this.wrongAnswerNum = wrongAnswerNum;
    }

    public Integer getJoinActivityNum() {
        return joinActivityNum;
    }

    public void setJoinActivityNum(Integer joinActivityNum) {
        this.joinActivityNum = joinActivityNum;
    }

    public String getHonorLabel() {
        return honorLabel;
    }

    public void setHonorLabel(String honorLabel) {
        this.honorLabel = honorLabel;
    }
	public String getRepeatMovies() {
		return repeatMovies;
	}
	public void setRepeatMovies(String repeatMovies) {
		this.repeatMovies = repeatMovies;
	}
	public String getTicketWalaCount() {
		return ticketWalaCount;
	}
	public void setTicketWalaCount(String ticketWalaCount) {
		this.ticketWalaCount = ticketWalaCount;
	}
	public Long getBestMovieId() {
		return bestMovieId;
	}
	public void setBestMovieId(Long bestMovieId) {
		this.bestMovieId = bestMovieId;
	}
	public Integer getCinemaUserCount() {
		return cinemaUserCount;
	}
	public void setCinemaUserCount(Integer cinemaUserCount) {
		this.cinemaUserCount = cinemaUserCount;
	}
	public String getUserMeetList() {
		return userMeetList;
	}
	public void setUserMeetList(String userMeetList) {
		this.userMeetList = userMeetList;
	}
}
