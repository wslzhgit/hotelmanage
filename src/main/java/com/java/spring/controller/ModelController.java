package com.java.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 2020/2/20   12:06
 * Author:W.铭
 * 页面跳转
 */
@Controller
@RequestMapping("/model")
public class ModelController {
    //首页
   /* @RequestMapping("/toIndex")
    public String toInfo() {
        return "index";
    }
*/
    //入住信息查询页面
    @RequestMapping("/toShowInRoomInfo")
    public String showInRoomInfo() {
        return "inroominfo/showInRoomInfo";
    }

    //入住信息添加页面
    @RequestMapping("/toAddInRoomInfo")
    public String toAddInRoomInfo() {
        return "inroominfo/addInRoomInfo";
    }

    //订单查询页面
    @RequestMapping("/toShowOrders")
    public String toShowOrders() {
        return "orders/showOrders";
    }

    //订单查询页面
    @RequestMapping("/toShowRoomSale")
    public String toShowRoomSale() {
        return "roomSale/showRoomSale";
    }

    //会员显示页面
    @RequestMapping("/toShowVip")
    public String toShowVip() {
        return "vip/showVip";
    }

    //会员添加页面
    @RequestMapping("/toAddVip")
    public String toAddVip() {
        return "vip/addVip";
    }

    //房间显示页面
    @RequestMapping("/toShowRooms")
    public String toShowRooms() {
        return "room/showRooms";
    }

    //登录显示页面
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login/login";
    }

    //角色信息管理页面
    @RequestMapping("/toShowRole")
    public String toShowRole(){
        return "role/showRole";
    }

    //用户显示页面
    @RequestMapping("/toShowUser")
    public String toShowUser(){
        return "user/showUser";
    }

    //用户添加页面
    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "user/addUser";
    }

    //数据分析页面
    @RequestMapping("/toShowIdd")
    public String toShowIdd(){
        return "idd/showIdd";
    }

    //房型信息页面
    @RequestMapping("/toShowRoomType")
    public String toShowRoomType(){
        return "roomType/showRoomType";
    }
}
