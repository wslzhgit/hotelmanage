package com.java.spring.service;

import com.java.spring.entity.Orders;

/**
 * 2020/2/23   16:02
 * Author:W.铭
 */
public interface OrdersService extends BaseService<Orders> {

    //支付成功之后的操作
    String afterOrdesPay(String out_trade_no)throws Exception;
}
