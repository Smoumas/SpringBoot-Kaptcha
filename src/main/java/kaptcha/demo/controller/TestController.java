package kaptcha.demo.controller;

import kaptcha.demo.util.CodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {
    @RequestMapping("/hello")
    @ResponseBody
    public String test(HttpServletRequest request){
        if(!CodeUtil.checkVerifyCode(request)){
            return "验证码有误！";
        }else{
            return "hello,world.";
        }
    }

    @RequestMapping("/test")
    public String page(){
        return "page";
    }
}
