package com.gewara.json.order;

import com.gewara.mongo.support.MGObject;

import lombok.Data;

/**
 * 360CPS过来的订单，详情参考 http://union.360.cn/help/apidocnew#cxjk
 * 
 */
@Data
public class OutOriginOrder extends MGObject {

	private static final long serialVersionUID = 6892151540714821316L;
	private String outOrigin;
	// 订单主键
	private Long id;
	// 合作网站编号
	private String bid;
	// 360用户ID
	private String qid;
	// 360业务编号
	private String qihoo_id;
	// 扩展字段，
	private String ext;
	// 订单号
	private String order_id;
	// 下单时间
	private String order_time;
	// 订单最后更新时间
	private String order_updtime;
	// 总佣金
	private String total_comm;
	// 佣金明细
	private String commission;
	// 订单商品的详细信息
	private String p_info;
	// 服务费用
	private String server_price;
	// 订单应付总额
	private Integer total_price;
	// 商品优惠的金额
	private String coupon;
	// 合作方订单状态
	private String status;
	// 影片ID
	private Long movieid;

	private String description2;
	private String quantity;
	private String unitprice;
	private Integer amount;

}
