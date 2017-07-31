package com.gewara.ucenter.vo.sns;


public class MarkCountDataVo extends MarkCountVo{

	private static final long serialVersionUID = 7486444487060223602L;

	public MarkCountDataVo(){}
	
	public MarkCountDataVo(MarkCountVo markCount, Double scale) {
		this.mkey = markCount.getMkey();
		this.tag = markCount.getTag();
		this.relatedid = markCount.getRelatedid();
		this.bookingtimes = markCount.getBookingtimes();
		this.unbookingtimes = markCount.getUnbookingtimes();
		if(scale!=null){
			if(markCount.getUnbookingmarks() > 0){
				Double unbook = Math.min(8.0, markCount.getUnbookingmarks() * scale/(1.0 * unbookingtimes)) *  unbookingtimes;
				this.unbookingmarks = unbook.intValue();
			}else{
				this.unbookingmarks = markCount.getUnbookingmarks();
			}
			if(markCount.getBookingmarks() > 0){
				Double book = Math.min(8.0, markCount.getBookingmarks() * scale/(1.0 * bookingtimes)) *  bookingtimes;
				this.bookingmarks = book.intValue();
			}else{
				this.bookingmarks = markCount.getBookingmarks();
			}
			
		}else{
			this.bookingmarks = markCount.getBookingmarks();
			this.unbookingmarks = markCount.getUnbookingmarks();
		}
	}
}
