package cn.agree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "/model")
@SessionAttributes(value= {"username","password","age"},types= {String.class,String.class, Integer.class})       // 把数据存入到session域对象中
public class ModelController {

    /*
    *  Model使用
    * */
    @RequestMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("msg","张三");
        return "success";
    }

    /*
    *  向session中存入值
    *
    * */
    @RequestMapping(value = "/save")
    public String save(Model model) {
        System.out.println("向session域中保存数据");
        model.addAttribute("username", "root");
        model.addAttribute("password", "123");
        model.addAttribute("age", 20);
        return "success";
    }

    /*
    *  向session中获取值
    *
    * */
    @RequestMapping(path = "/find")
    public String find(ModelMap modelMap) {
        String username = (String) modelMap.get("username");
        String password = (String) modelMap.get("password");
        Integer age = (Integer) modelMap.get("age");
        System.out.println(username + " : "+password +" : "+age);
        return "success";
    }

    /*
    *  清除值
    * */
    @RequestMapping(path="/delete")
    public String delete(SessionStatus status) {
        status.setComplete();
        return "success";
    }

}
