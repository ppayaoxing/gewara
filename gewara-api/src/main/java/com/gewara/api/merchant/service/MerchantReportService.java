package com.gewara.api.merchant.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.gewara.api.merchant.vo.EverydayMpiReportVo;
import com.gewara.api.merchant.vo.GoodsSummaryReportTotalVo;
import com.gewara.api.merchant.vo.MovieCityBoughtReportVo;
import com.gewara.api.merchant.vo.MovieSellerTotalVo;
import com.gewara.api.merchant.vo.RefundOrderTotalVo;
import com.gewara.api.vo.ResultCode;

public interface MerchantReportService {
	/**
	 * 影票销售统计
	 * 
	 * @param cinemaIds
	 *            多个影院id 用,分隔
	 * @param movieId
	 *            电影id，可为空
	 * @param timeType
	 *            放映时间，还是下单时间 addtime 为下单时间 否则按放映时间
	 * @param startTime
	 *            统计的开始时间
	 * @param endTime
	 *            统计的结束时间
	 * @param from
	 *            数据起使用位置
	 * @param maxnum
	 *            一页多少
	 * @return
	 */
	ResultCode<MovieSellerTotalVo> movieSellStatistics(String cinemaIds, Long movieId, String timeType,
			Timestamp startTime, Timestamp endTime, int from, int maxnum);

	/**
	 * 具体影院销售统计
	 * 
	 * @param cinemaId
	 * @param movieId
	 *            可为空
	 * @param timeType
	 *            放映时间，还是下单时间 addtime 为下单时间 否则按放映时间
	 * @param opentype
	 *            场次类型
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	ResultCode<MovieSellerTotalVo> movieSellStatistics(long cinemaId, Long movieId, String timeType, String opentype,
			Timestamp startTime, Timestamp endTime, String edition, int from, int maxnum);

	ResultCode<MovieSellerTotalVo> movieSellStatistics(long cinemaId, Long movieId, String timeType, String opentype,
			Timestamp startTime, Timestamp endTime, int from, int maxnum);

	/**
	 * 退款报表
	 * 
	 * @param cinemaIds
	 *            影院id，多个, 号分隔
	 * @param movieId
	 *            可以为空
	 * @param timeType
	 *            值为addtime时，是根据下单时间， playtime时，是根据消费时间
	 * @param startTime
	 * @param endTime
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<RefundOrderTotalVo> refundReport(String cinemaIds, Long movieId, String timeType, Timestamp startTime,
			Timestamp endTime, int from, int maxnum);

	/**
	 * 影院具体退票订单
	 * 
	 * @param cinemaId
	 *            不为空
	 * @param movieId
	 * @param timeType
	 * @param startTime
	 * @param endTime
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<RefundOrderTotalVo> refundOrderByCinema(long cinemaId, Long movieId, String timeType,
			Timestamp startTime, Timestamp endTime, int from, int maxnum);

	/**
	 * 
	 * @param cinemaIds
	 *            多个影院id 用,分隔
	 * @param timetype
	 *            下单时间 addtime 为下单时间 否则按消费时间
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<GoodsSummaryReportTotalVo> goodsSummaryReport(String cinemaIds, String timetype, Timestamp startTime,
			Timestamp endTime, int from, int maxnum);

	/**
	 * 详细套餐报表
	 * 
	 * @param cinemaId
	 *            影院id
	 * @param timetype
	 *            下单时间 addtime 为下单时间 否则按消费时间
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param from
	 * @param maxnum
	 * @return
	 */
	ResultCode<GoodsSummaryReportTotalVo> goodsSummaryReportByCinema(long cinemaId, String timetype,
			Timestamp startTime, Timestamp endTime, int from, int maxnum);

	/**
	 * 统计每天的排片信息
	 * 
	 * @param playDate
	 *            查询日期 ，值为当天的开始时间 例如 2013-09-25 00:00:00
	 * @return
	 */
	ResultCode<EverydayMpiReportVo> mpiReportByPlayDate(Date playDate);

	/**
	 * 时间段内电影在具体城市的购票数
	 * 
	 * @param startTime
	 *            查询开始时间 例如 2013-09-27 13:00:00 查询时是 >= startTime的
	 * @param endTime
	 *            查询结束时间 例如 2013-09-27 14:00:00 查询时是< endTime 的
	 * @return
	 */
	ResultCode<List<MovieCityBoughtReportVo>> movieCityBoughtReport(Timestamp startTime, Timestamp endTime);

	/**
	 * 添加影院公告
	 * 
	 * @param num
	 *            编号id
	 * @param cinemaId
	 *            影院id
	 * @param title
	 *            标题
	 * @param content
	 *            内容
	 * @param publishUser
	 *            发布人昵称
	 * @return
	 */
	ResultCode addCinemaNotify(String num, Long cinemaId, String title, String content, String publishUser);
}
