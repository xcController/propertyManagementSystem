package com.learn.bean;

/**
 * @author shkstart
 * @ClassName: House
 * @create 2023-04-06 18:20
 * @Description:
 */
public class House {

    private int id;
    private String num;
    private String unit;
    private String floor;
    private String type;
    private String area;
    private String sell;
    private String direction;
    private String note;
    //默认值为1
    private int ownerid = 1 ;


    public House() {
    }

    public House(String num, String unit, String floor, String type, String area, String sell, String direction, String note, int ownerid) {
        this.num = num;
        this.unit = unit;
        this.floor = floor;
        this.type = type;
        this.area = area;
        this.sell = sell;
        this.direction = direction;
        this.note = note;
        this.ownerid = ownerid;
    }

    public House(int id, String num, String unit, String floor, String type, String area, String sell, String direction, String note, int ownerid) {
        this.id = id;
        this.num = num;
        this.unit = unit;
        this.floor = floor;
        this.type = type;
        this.area = area;
        this.sell = sell;
        this.direction = direction;
        this.note = note;
        this.ownerid = ownerid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", unit='" + unit + '\'' +
                ", floor='" + floor + '\'' +
                ", type='" + type + '\'' +
                ", area='" + area + '\'' +
                ", sell='" + sell + '\'' +
                ", direction='" + direction + '\'' +
                ", note='" + note + '\'' +
                ", ownerid='" + ownerid + '\'' +
                '}';
    }
}
