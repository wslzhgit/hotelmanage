package com.java.spring.controller;

import com.java.spring.entity.RoomSale;
import com.java.spring.entity.Vip;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 2020/2/22   11:15
 * Author:W.铭
 */
@Controller
@RequestMapping("/roomSale")
public class RoomSaleController extends BaseController<RoomSale> {
    //根据房间编号分组统计房间的出租总金额
    @RequestMapping("/getSalePriceByRoomNum")
    public @ResponseBody
    Map<String,Object> getSalePriceByRoomNum(){
        try {
            return roomSaleService.findSalePriceByRoomNum();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
