package com.java.spring.controller;

import com.java.spring.entity.User;
import com.java.spring.utils.MD5;
import com.java.spring.utils.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 2020/3/2   16:37
 * Author:W.铭
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User> {
    //获取用户登陆时的验证码
    @RequestMapping("/getVerifyCode")
    public void getVerifyCode(HttpSession session, HttpServletResponse response) throws Exception{
        //通过工具类产生随机验证码  3DcfG
        String verifyCode = VerifyCodeUtils.generateVerifyCode(5);
        //将服务器端产生的随机验证码中的英文字母转为小写并放在session容器中   3dcfg
        session.setAttribute("verifyCode",verifyCode.toLowerCase());
        //将产生的验证码转为图片显示（响应）到页面中   3DcfG
        VerifyCodeUtils.outputImage(250,35,response.getOutputStream(),verifyCode);
    }

    //验证用户输入的验证码
    @RequestMapping("/checkVerifyCode")
    public @ResponseBody
    String checkVerifyCode(HttpSession session, String verifyCodeIpt){
        //从session容器中取出之前装入的验证码
        String verifyCode = (String)session.getAttribute("verifyCode");
        //此时将用户输入的验证码与session中取出的验证码进行比较
        if(verifyCodeIpt.equals(verifyCode)){
            return "success";
        }else {
            return "fail";
        }
    }


    //执行登陆
    @RequestMapping("/login")
    public @ResponseBody String login(User user,HttpSession session){
        //将用户输入的登陆密码进行加密
        user.setPwd(MD5.md5crypt(user.getPwd()));
        try {
            //执行登陆
            User loginUser = baseService.findByPramas(user);
            //判断登陆是否成功
            if(loginUser!=null){ //有此用户，登陆成功
                session.setAttribute("loginUser",loginUser);  //将登陆的用户对象装入到session容器中
                return "success";
            }else {
                return "fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //执行退出
    @RequestMapping("/exitUser")
    public @ResponseBody String exitUser(HttpSession session){
        try {
            //移除session容器中的用户登陆对象
            session.removeAttribute("loginUser");
            return "success";
        }catch (Exception e){
            return "error";
        }

    }

    //重写添加方法
    @Override
    public String add(User user)  {
        user.setPwd(MD5.md5crypt(user.getPwd()));
        return super.add(user);
    }
}
