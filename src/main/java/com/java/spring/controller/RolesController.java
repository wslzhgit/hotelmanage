package com.java.spring.controller;

import com.java.spring.entity.Roles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 2020/2/22   11:15
 * Author:W.铭
 */
@Controller
@RequestMapping("/roles")
public class RolesController extends BaseController<Roles> {
}
