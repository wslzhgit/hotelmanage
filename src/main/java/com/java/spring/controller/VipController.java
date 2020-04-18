package com.java.spring.controller;

import com.java.spring.entity.Vip;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 2020/2/22   11:15
 * Author:W.铭
 */
@Controller
@RequestMapping("/vip")
public class VipController extends BaseController<Vip> {
}
