package cn.agree.controller;

import cn.agree.domain.Mobile;
import cn.agree.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    /*
    *  接受基本类型和String
    *  注意url请求参数的名字要和函数入参的名字一致
    * */
    // http://localhost:8080/user/add1?id=78&name=%E6%97%B6%E4%BB%A3%E5%B3%BB%E5%B3%B0%E8%82%AF%E5%AE%9A%E6%98%AF
    @RequestMapping(value = "/add1")
    public String addUser(int id, String name) {
        System.out.println("id:"+id+",name:"+name);
        return "success";
    }

    /*
    * 接受参数是javabean类型
    *
    * */
    @RequestMapping(value = "/add2")
    public String addUser(User user) {
        System.out.println("age:"+user.getAge()+",name:"+user.getName());
        return "success";
    }

    /*
    *
    * 接受Map类型的参数
    * */
    @RequestMapping(value = "/add3")
    public String addUser(@RequestParam Map userMap) {
        System.out.println(userMap);
        return "success";
    }

    /*
    * 接受List参数类型
    *
    * */
    @RequestMapping(value = "/add4")
    public String addUser(@RequestParam List<Integer> id) {
        System.out.println(id);
        return "success";
    }

    /*
    *  接受javaBean
    *  javabean里面引用另外一个javaBean
    * */
    @RequestMapping(value = "/add5")
    public String add5User(User user) {
        System.out.println("用户" + user.getName() + ",今年" + user.getAge() + "岁，住在" + user.getIdCard().getAddress() + ",身份证号是:" + user.getIdCard().getNumber());
        System.out.println(user);
        return "success";
    }

    /*
    *  接受javaBean
    *  javaBean里面引用另外一个javaBean的List
    * */
    @RequestMapping(value = "/add6")
    public String add6User(User user) {
        System.out.println("用户" + user.getName() + ",今年" + user.getAge() + "岁，住在" + user.getIdCard().getAddress() + ",身份证号是" + user.getIdCard().getNumber());
        for (Mobile mobile : user.getMobiles()) {
            System.out.println(mobile.getMobileName()+"花了"+mobile.getPrice());
        }
        System.out.println("------------");
        System.out.println(user);
        return "success";
    }




}
