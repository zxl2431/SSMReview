package cn.agree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    /*
    *  接受请求
    *
    * */
    @RequestMapping(path = "/hello")
    public String sayHello() {

        System.out.println("Hello SpringMVC");
        return "success";
    }
}
