package com.learn.bean;

/**
 * @author shkstart
 * @ClassName: Carport
 * @create 2023-04-06 19:40
 * @Description:
 */
public class Carport {

    private int id;

    private String state;

    //默认值为1
    private int ownerid = 1;

    private String phone;

    public Carport() {
    }

    public Carport(String state, int ownerid, String phone) {
        this.state = state;
        this.ownerid = ownerid;
        this.phone = phone;
    }

    public Carport(int id, String state, int ownerid, String phone) {
        this.id = id;
        this.state = state;
        this.ownerid = ownerid;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Carport{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", ownerid=" + ownerid +
                ", phone='" + phone + '\'' +
                '}';
    }
}
