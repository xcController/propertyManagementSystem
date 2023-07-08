package com.learn.bean;

/**
 * @author shkstart
 * @ClassName: Customer
 * @create 2023-04-06 15:02
 * @Description:
 */
public class Customer {
    private int accountid;
    private String username;
    private String password;
    private String phone;
    private String addr;


    public Customer() {
    }

    public Customer(String username, String password, String phone, String addr) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.addr = addr;
    }

    public Customer(int accountid, String username, String password, String phone, String addr) {
        this.accountid = accountid;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.addr = addr;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accountid=" + accountid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
