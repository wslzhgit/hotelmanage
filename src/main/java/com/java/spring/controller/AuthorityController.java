package com.java.spring.controller;

import com.java.spring.entity.Authority;
import com.java.spring.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 2020/2/22   11:15
 * Author:W.铭
 */
@Controller
@RequestMapping("/authority")
public class AuthorityController extends BaseController<Authority> {
    //登陆完成后加载用户拥有的权限跳转到平台首页
    @RequestMapping("/toIndex")
    public String toIndex(Model model, HttpSession session){
        //1.在登陆后从session容器中取到登陆的用户数据
        User loginUser = (User) session.getAttribute("loginUser");
        try {
            //2.根据登陆用户角色id查询用户拥有的权限
            List<Map<String,Object>> mapList = authorityService.findAuthoritiesByLogin(loginUser);
            //3.将查询出的权限装入到容器中
            model.addAttribute("mapList",mapList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
    /**
     *   根据角色id查询角色拥有的权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping("/getAuthoritiesByRoleId")
    public @ResponseBody
    List<Authority> getAuthoritiesByRoleId(Integer roleId){
        try {
            return authorityService.findAuthoritiesByRoleId(roleId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
