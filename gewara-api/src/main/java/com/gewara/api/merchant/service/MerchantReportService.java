/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.api.merchant.service;

import com.gewara.api.merchant.vo.EverydayMpiReportVo;
import com.gewara.api.merchant.vo.GoodsSummaryReportTotalVo;
import com.gewara.api.merchant.vo.MovieCityBoughtReportVo;
import com.gewara.api.merchant.vo.MovieSellerTotalVo;
import com.gewara.api.merchant.vo.RefundOrderTotalVo;
import com.gewara.api.vo.ResultCode;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface MerchantReportService {
	ResultCode<MovieSellerTotalVo> movieSellStatistics(String arg0, Long arg1, String arg2, Timestamp arg3,
			Timestamp arg4, int arg5, int arg6);

	ResultCode<MovieSellerTotalVo> movieSellStatistics(long arg0, Long arg2, String arg3, String arg4, Timestamp arg5,
			Timestamp arg6, String arg7, int arg8, int arg9);

	ResultCode<RefundOrderTotalVo> refundReport(String arg0, Long arg1, String arg2, Timestamp arg3, Timestamp arg4,
			int arg5, int arg6);

	ResultCode<RefundOrderTotalVo> refundOrderByCinema(long arg0, Long arg2, String arg3, Timestamp arg4,
			Timestamp arg5, int arg6, int arg7);

	ResultCode<GoodsSummaryReportTotalVo> goodsSummaryReport(String arg0, String arg1, Timestamp arg2, Timestamp arg3,
			int arg4, int arg5);

	ResultCode<GoodsSummaryReportTotalVo> goodsSummaryReportByCinema(long arg0, String arg2, Timestamp arg3,
			Timestamp arg4, int arg5, int arg6);

	ResultCode<EverydayMpiReportVo> mpiReportByPlayDate(Date arg0);

	ResultCode<List<MovieCityBoughtReportVo>> movieCityBoughtReport(Timestamp arg0, Timestamp arg1);

	ResultCode addCinemaNotify(String arg0, Long arg1, String arg2, String arg3, String arg4);
}