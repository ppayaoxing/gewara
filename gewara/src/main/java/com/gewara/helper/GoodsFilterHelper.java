package com.gewara.helper;

import com.gewara.model.goods.Goods;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 商品过滤帮助类
 */
public class GoodsFilterHelper {
    /**
     * 过滤Goods中不是partnerid的商品
     *
     * @param goodsList
     * @param partnerid
     */
    public static void goodsFilter(List<Goods> goodsList, Long partnerid) {
        if (goodsList == null || partnerid == null) return;
        List<Goods> removeList = Lists.newArrayList();
        for (Goods goods : goodsList) {
            if (StringUtils.isNotBlank(goods.getPartners())) {
                List<String> partneridList = Arrays.asList(goods.getPartners().split(","));
                if (!partneridList.contains(partnerid + "")) removeList.add(goods);
            }
        }
        goodsList.removeAll(removeList);
    }
}
