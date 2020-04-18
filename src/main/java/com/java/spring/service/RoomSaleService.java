package com.java.spring.service;

import com.java.spring.entity.RoomSale;

import java.util.Map;

/**
 * 2020/2/27   11:08
 * Author:W.铭
 */
public interface RoomSaleService extends BaseService<RoomSale>  {

    //根据房间编号分组统计房间的出租总金额
    Map<String,Object> findSalePriceByRoomNum() throws Exception;

}
