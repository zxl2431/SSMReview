package cn.agree.Exception;


import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {
        // 创建mv
        ModelAndView md = new ModelAndView();
        // 指定友好的错误提示页面
        md.setViewName("error");
        // 创建StringWriter
        StringWriter stringWriter = new StringWriter();
        // 将错误信息输入进 stringWriter对象中
        ex.printStackTrace(new PrintWriter(stringWriter));
        // 输出错误信息
        System.out.println("异常信息:"+stringWriter.toString());

        return md;
    }
}
