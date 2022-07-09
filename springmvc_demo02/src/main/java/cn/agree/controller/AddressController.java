package cn.agree.controller;

import cn.agree.domain.Address;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/address")
public class AddressController {

    /*
    *  把ajax传过来的 data json类型的数据
    *  直接打印出来
    *
    *  add 和 add1 return 不会跳转到success页面
    *  因为使用的是ajax发送的
    *
    *
    * */
    @RequestMapping(value = "/add")
    public String add(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    /*
    *  使用@RequestBody接收整个提交内容体
    *  并转换成Address对象
    *
    *
    * */
    @RequestMapping(value = "/add1")
    public String add1(@RequestBody Address address) {
        System.out.println(address);
        return "success";
    }

    /*
    *  使用@RequestBody接收整个提交的内容
    *  并转换成Address对象
    *  在方法上加上@Response注解 每次响应数据为JSON数据
    *
    * */
    @ResponseBody
    @RequestMapping(value = "/add2")
    public Address add2(@RequestBody Address address) {
        System.out.println(address);
        return address;
    }








}
