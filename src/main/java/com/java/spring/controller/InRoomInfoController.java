package com.java.spring.controller;

import com.java.spring.entity.InRoomInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 2020/2/20   12:06
 * Author:W.铭
 * 入住信息
 */
@Controller
@RequestMapping("/inRoomInfo")
public class InRoomInfoController extends BaseController<InRoomInfo> {
}
