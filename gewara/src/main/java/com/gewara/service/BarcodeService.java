package com.gewara.service;

import com.gewara.model.drama.OpenDramaItem;
import com.gewara.model.goods.TicketGoods;
import com.gewara.model.machine.Barcode;
import com.gewara.model.pay.OrderNote;
import com.gewara.support.ErrorCode;

import java.util.List;

/**
 * 条形码服务
 *
 * @author sunder
 */
public interface BarcodeService {

    /** 获取条形码集合
     * @param barcode
     * @param relatedid
     * @param placeid
     * @param itemid
     * @param tradeno
     * @param from
     * @param maxnum
     * @return
     */
    List<Barcode> getBarcodeList(String barcode, Long relatedid, Long placeid, Long itemid, String tradeno, int from, int maxnum);

    /** 获取条形码数量
     * @param barcode
     * @param relatedid
     * @param placeid
     * @param itemid
     * @param tradeno
     * @return
     */
    Integer getBarcodeCount(String barcode, Long relatedid, Long placeid, Long itemid, String tradeno);

    /** 优惠条形码集合
     * @param relatedid
     * @param placeid
     * @param itemid
     * @param from
     * @param maxnum
     * @return
     */
    List<Barcode> getFreeBarcodeList(Long relatedid, Long placeid, Long itemid, int from, int maxnum);

    /**
     * @param placeid
     * @param from
     * @param maxnum
     * @return
     */
    List<Barcode> getSynchNewBarcodeList(Long placeid, int from, int maxnum);

    /** 优惠条形码数量
     * @param relatedid
     * @param placeid
     * @param itemid
     * @return
     */
    Integer getFreeBarcodeCount(Long relatedid, Long placeid, Long itemid);

    /** 根据订单号获取条形码数量
     * @param tradeno
     * @return
     */
    Integer getBarcodeCountByTradeno(String tradeno);

    /** 根据订单号获取条形码集合
     * @param tradeno
     * @return
     */
    List<Barcode> getBarcodeListByTradeno(String tradeno);

    /**
     * @param placeid
     * @return
     */
    Integer createNewBarcodeByPlaceid(Long placeid);

    /**
     * @param orderNote
     * @param goods
     * @return
     */
    ErrorCode<String> createBarcodeList(OrderNote orderNote, TicketGoods goods);

    /**
     * @param orderNote
     * @param odi
     * @return
     */
    ErrorCode<String> createBarcodeList(OrderNote orderNote, OpenDramaItem odi);

    /**
     * @param placeid
     * @return
     */
    Integer handCreateNewBarcodeByPlaceid(Long placeid);
}
