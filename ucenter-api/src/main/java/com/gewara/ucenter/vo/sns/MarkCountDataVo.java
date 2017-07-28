/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.ucenter.vo.sns;

import com.gewara.ucenter.vo.sns.MarkCountVo;

public class MarkCountDataVo extends MarkCountVo {
	private static final long serialVersionUID = 7486444487060223602L;

	public MarkCountDataVo() {
	}

	public MarkCountDataVo(MarkCountVo markCount, Double scale) {
		this.mkey = markCount.getMkey();
		this.tag = markCount.getTag();
		this.relatedid = markCount.getRelatedid();
		this.bookingtimes = markCount.getBookingtimes();
		this.unbookingtimes = markCount.getUnbookingtimes();
		if (scale != null) {
			Double book;
			if (markCount.getUnbookingmarks().intValue() > 0) {
				book = Double.valueOf(Math.min(8.0D,
						(double) markCount.getUnbookingmarks().intValue() * scale.doubleValue()
								/ (1.0D * (double) this.unbookingtimes.intValue()))
						* (double) this.unbookingtimes.intValue());
				this.unbookingmarks = Integer.valueOf(book.intValue());
			} else {
				this.unbookingmarks = markCount.getUnbookingmarks();
			}

			if (markCount.getBookingmarks().intValue() > 0) {
				book = Double.valueOf(Math.min(8.0D,
						(double) markCount.getBookingmarks().intValue() * scale.doubleValue()
								/ (1.0D * (double) this.bookingtimes.intValue()))
						* (double) this.bookingtimes.intValue());
				this.bookingmarks = Integer.valueOf(book.intValue());
			} else {
				this.bookingmarks = markCount.getBookingmarks();
			}
		} else {
			this.bookingmarks = markCount.getBookingmarks();
			this.unbookingmarks = markCount.getUnbookingmarks();
		}

	}
}