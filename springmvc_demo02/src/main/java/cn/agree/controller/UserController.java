package cn.agree.controller;

import cn.agree.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    /*
    *  如果返回值为空
    *  它将跳转到 WEB-INT/pages/initUpdate.jsp页面
    *
    * */
    @RequestMapping(path = "/initUpdate")
    public String initUpdate(Model model) {
        // 模拟从数据库中查询的数据
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setMoney(100d);
        user.setBirthday(new Date());
        model.addAttribute("user", user);
        System.out.println("initUpdate方法执行了...user:"+user);

        return "update";
    }

    /*
    *  请求转发 或者重定向
    *
    * */
    @RequestMapping(value = "/initAdd")
    public void initAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求转发或者重定向ContextPath:"+request.getContextPath());

        // 请求转发
        request.getRequestDispatcher("/WEB-INF/pages/add.jsp").forward(request, response);
        // 重定向
        // response.sendRedirect(request.getContextPath()+"/add2.jsp");

        // 直接返回 向html里面写内容
        // response.setCharacterEncoding("UTF-8");
        // response.setContentType("text/html;charset=UTF-8");
        // response.getWriter().print("你好");
        return;

    }

    /*
    *  返回ModelAndView对象
    *  可以传入视图的名称(即跳转的页面), 还可以传入对象
    *
    * */
    @RequestMapping(value = "/findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        // 跳转的页面
        mv.setViewName("list");

        // 模拟从数据库中查询所有的用户信息
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("张三");
        user1.setPassword("123");

        User user2 = new User();
        user2.setUsername("赵四");
        user2.setPassword("456");

        users.add(user1);
        users.add(user2);

        // 添加对象
        mv.addObject("users", users);

        return mv;
    }


    /*
    *  SpringMVC框架 提供的请求转发
    *  不走视图解析器了, 所以需要编写完整的路径
    *
    * */
    @RequestMapping("delete")
    public String delete() {
        System.out.println("delete方法执行了...");
        // return "forward:/WEB-INF/pages/success.jsp";
        return "forward:/user/findAll";
    }

    /*
    *  SpringMVC框架 提供的重定向
    *
    * */
    @RequestMapping("/count")
    public String count() {
        System.out.println("count方法执行了...");
        // return "redirect:/add2.jsp";
        return "redirect:/user/findAll";
    }



}
