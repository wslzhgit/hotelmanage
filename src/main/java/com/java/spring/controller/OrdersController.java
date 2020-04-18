package com.java.spring.controller;

import com.java.spring.entity.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 2020/2/23   15:51
 * Author:W.铭
 */
@Controller
@RequestMapping("/orders")
public class OrdersController extends BaseController<Orders> {
    //跳转订单支付页面
    @RequestMapping("/toPay")
    public String toPay(){
        return "alipay/ordersPay";
    }

    //支付完成后的路径回调
    @RequestMapping("myOrdersPay")
    public String myOrdersPay(String out_trade_no) {
        try {
            return ordersService.afterOrdesPay(out_trade_no);
        } catch (Exception e) {
            e.printStackTrace();
            return "payError";
        }
    }

}
