package cn.agree.domain;

public class Address {

    private String addressName;
    private String addressNum;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(String addressNum) {
        this.addressNum = addressNum;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressName='" + addressName + '\'' +
                ", addressNum='" + addressNum + '\'' +
                '}';
    }
}
