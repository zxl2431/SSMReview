package cn.agree.controller;

import cn.agree.domain.Account;
import cn.agree.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /*
    *  查询所有
    *
    * */
    @RequestMapping(value = "/findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("list");

        List<Account> accounts = accountService.findAll();

        mv.addObject("accounts", accounts);

        for (Account account: accounts) {
            System.out.println(account);
        }
        return mv;
    }

    /*
    *  保存账号
    *
    * */
    @RequestMapping(value = "/add")
    public String add(Account account) {
        System.out.println(account);
        // 增加数据
        accountService.saveAccount(account);

        return "redirect:/account/findAll";
    }
}
