package com.learn.bean;

/**
 * @author shkstart
 * @ClassName: Admin
 * @create 2023-04-05 14:56
 * @Description:
 */
public class Admin {
    private int id;
    private String name;
    private String password;
    private String sex;
    private Number age;
    private String phone;
    private String addr;
    private String note;
    private String perms;

    public Admin() {
    }

    public Admin(String name, String password, String sex, Number age, String phone, String addr, String note, String perms) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.addr = addr;
        this.note = note;
        this.perms = perms;
    }

    public Admin(int id, String name, String password, String sex, Number age, String phone, String addr, String note, String perms) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.addr = addr;
        this.note = note;
        this.perms = perms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Number getAge() {
        return age;
    }

    public void setAge(Number age) {
        this.age = age;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", addr='" + addr + '\'' +
                ", note='" + note + '\'' +
                ", perms='" + perms + '\'' +
                '}';
    }
}
