package cn.agree.log;

public class Logger {

    /*
    *
    *  前置通知
    *  用于打印日志
    * */
    public void printLog() {
        System.out.println("Logger类中printLog方法开始记录日志了before...");
    }

    /*
    * 后置通知
    * */
    public void afterLog() {
        System.out.println("--------afterReturning-------------------");
    }

    /***
     * after-throwing
     * 异常通知
     */
    public void error(){
        System.out.println("--------after-throwing--------");
    }

    /***
     * after
     * 最终通知
     */
    public void after(){
        System.out.println("---------after----------");
    }



}
