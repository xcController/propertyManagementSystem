package com.learn.bean;

/**
 * @author shkstart
 * @ClassName: Maintain
 * @create 2023-04-06 19:36
 * @Description:
 */
public class Maintain {

    private int id;
    private String thing;
    private String status;
    private String homesnumber;
    private String sdate;
    private String enddate;
    private Number precost;
    private Number relcost;
    private String maintainer;
    private String note;

    public Maintain() {
    }

    public Maintain(String thing, String status, String homesnumber, String sdate, String enddate, Number precost, Number relcost, String maintainer, String note) {
        this.thing = thing;
        this.status = status;
        this.homesnumber = homesnumber;
        this.sdate = sdate;
        this.enddate = enddate;
        this.precost = precost;
        this.relcost = relcost;
        this.maintainer = maintainer;
        this.note = note;
    }

    public Maintain(int id, String thing, String status, String homesnumber, String sdate, String enddate, Number precost, Number relcost, String maintainer, String note) {
        this.id = id;
        this.thing = thing;
        this.status = status;
        this.homesnumber = homesnumber;
        this.sdate = sdate;
        this.enddate = enddate;
        this.precost = precost;
        this.relcost = relcost;
        this.maintainer = maintainer;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHomesnumber() {
        return homesnumber;
    }

    public void setHomesnumber(String homesnumber) {
        this.homesnumber = homesnumber;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Number getPrecost() {
        return precost;
    }

    public void setPrecost(Number precost) {
        this.precost = precost;
    }

    public Number getRelcost() {
        return relcost;
    }

    public void setRelcost(Number relcost) {
        this.relcost = relcost;
    }

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Maintain{" +
                "id=" + id +
                ", thing='" + thing + '\'' +
                ", status='" + status + '\'' +
                ", homesnumber='" + homesnumber + '\'' +
                ", sdate='" + sdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", precost=" + precost +
                ", relcost=" + relcost +
                ", maintainer='" + maintainer + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
