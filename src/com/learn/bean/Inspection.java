package com.learn.bean;

/**
 * @author shkstart
 * @ClassName: Inspection
 * @create 2023-04-06 19:47
 * @Description:
 */
public class Inspection {
    private int id;
    private String person;
    private String type;
    private String itime;
    private String conductor;
    private String party;
    private String result;
    private String note;

    public Inspection() {
    }

    public Inspection(String person, String type, String itime, String conductor, String party, String result, String note) {
        this.person = person;
        this.type = type;
        this.itime = itime;
        this.conductor = conductor;
        this.party = party;
        this.result = result;
        this.note = note;
    }

    public Inspection(int id, String person, String type, String itime, String conductor, String party, String result, String note) {
        this.id = id;
        this.person = person;
        this.type = type;
        this.itime = itime;
        this.conductor = conductor;
        this.party = party;
        this.result = result;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItime() {
        return itime;
    }

    public void setItime(String itime) {
        this.itime = itime;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Inspection{" +
                "id=" + id +
                ", person='" + person + '\'' +
                ", type='" + type + '\'' +
                ", itime='" + itime + '\'' +
                ", conductor='" + conductor + '\'' +
                ", party='" + party + '\'' +
                ", result='" + result + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
