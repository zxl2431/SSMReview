package cn.agree.controller;

import cn.agree.domain.Account;
import cn.agree.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/account")
public class AccountController {

    /*
    * @RequestParam注解
    * */
    @RequestMapping(path="/param")
    public String sayHello(@RequestParam(value = "username", required = false)String name){
        System.out.println("@RequestParam");
        System.out.println(name);
        return "accountSuccess";
    }

    /*
    * @RequestBody 注解
    *
    * */
    @RequestMapping(path = "/body")
    public String body(@RequestBody String body) {
        System.out.println("@RequestBody");
        System.out.println(body);
        return "accountSuccess";
    }

    /*
    *  @PathVariable注解
    *  拥有绑定url中的占位符
    *  value 指定url中占位符名称
    *
    * */
    @RequestMapping(path = "/variable/{id}")
    public String vari(@PathVariable(value = "id") String id) {
        System.out.println(id);
        return "accountSuccess";
    }

    /*
    *  RequestHeader注解
    *  获取指定请求头的值
    *  value 请求头的名称
    *
    * */
    @RequestMapping(path = "/header")
    public String header(@RequestHeader(value = "Accept") String header){
        System.out.println(header);
        return "accountSuccess";
    }

    /*
    *  CookieValue注解
    *
    * */
    @RequestMapping(path = "/cookie")
    public String cookie(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println(cookieValue);
        return "accountSuccess";
    }

    /*
    * @ModelAttribute 注解
    * 作用
    *   出现在方法上:表示当前方法会在控制器方法执行前执行
    *   出现在参数上 获取指定的数据给参数复制
    *   应用场景
    *       当提交表单数据不是完整的实体数据时,保证没有提交的字段使用数据库原来的数据
    *
    *
    * */

    /*
    *  优先执行
    * */
    @ModelAttribute
    public Account parameterAccount() {
        System.out.println("parameterAccount优先执行");
        Account account = new Account();
        account.setSex("nan");
        account.setId(90);
        return account;
    }

    /*
    *  此时account已经被上面的ParemeterAccount函数先执行了
    *
    * */
    @RequestMapping(value = "/add")
    public String addAccount(Account account) {
        System.out.println(account);
        return "accountSuccess";
    }


    /**/


}
