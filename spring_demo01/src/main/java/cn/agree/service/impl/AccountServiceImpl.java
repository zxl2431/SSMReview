package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.dao.impl.AccountDaoImpl;
import cn.agree.domain.Account;
import cn.agree.service.AccountService;

import java.util.*;

public class AccountServiceImpl implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public AccountServiceImpl() {
    }

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    @Override
    public void init() {
        System.out.println("AccountServiceImpl初始化了...");
    }

    @Override
    public void destory() {
        System.out.println("AccountServiceImpl销毁了...");
    }

    @Override
    public void save(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void delete(Integer accountId) {
        accountDao.delete(accountId);
    }

    @Override
    public Account findById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

   /* @Override
    public void saveAccount() {
        System.out.println("service层调用dao层");
        System.out.println(name+"-"+age+"-"+birthday);
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);
        accountDao.saveAccount();
    }*/
}
