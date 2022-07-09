package cn.agree.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 implements HandlerInterceptor {

    /*
    *
    *  controller方法前执行,进行拦截的方法
    *  return true 放行
    *  return false 拦截
    *  可以使用转发或者重定向直接跳转到指定的页面
    * */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器执行了...");
        return true;
    }
}
