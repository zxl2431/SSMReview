package cn.agree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {
    /*
    *  接受请求 已GET请求的方式
    *
    * */
    @RequestMapping(path = "/say", method = RequestMethod.GET)
    public String sayHello() {
        System.out.println("Hello SpringMVC! 调用了GET方法");
        return "success";
    }

    /*
    *   接受请求 已post请求的方式
    *   @RequestMapping注解中
    *   name属性 value属性
    *   method属性的
    *
    * */
    @RequestMapping(path = "/say", method = RequestMethod.POST)
    public String sayYourName() {
        System.out.println("Hello SpringMVC! 调用了POST提交方式的请求");
        return "success";
    }

    /*
    *  @RequestMapping中
    *  params参数
    *
    * */
    // http://localhost:8080/hello/say1?name=zhangsan&address=s&working=sz
    @RequestMapping(path = "/say1", method = RequestMethod.GET,
                    params = {"name", "!age", "address!=usa", "working=sz"})
    public String say1SpringMVC() {
        System.out.println();
        return "success";
    }


}
