package cn.agree.domain;

import java.util.List;

public class User {
    private String name;
    private Integer age;

    // 引用IdCard作为子属性
    private IdCard idCard;

    // 多个手机
    private List<Mobile> mobiles;

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
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

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", idCard=" + idCard +
                ", mobiles=" + mobiles +
                '}';
    }
}
