package cn.agree.service;

public interface AccountService {

    /*
    *  保存测试
    * */
    void save();

    /*
    *  转账测试
    * */
    void transfer(String sourceName, String targetName, Float money);


}
