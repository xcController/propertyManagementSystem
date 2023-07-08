package com.learn.bean;

/**
 * @author shkstart
 * @ClassName: Notice
 * @create 2023-04-06 19:33
 * @Description:
 */
public class Notice {
    private int id;
    private String content;
    private String sdate;
    private String title;
    private String publisher;

    public Notice() {
    }

    public Notice(int id, String content, String sdate, String title, String publisher) {
        this.id = id;
        this.content = content;
        this.sdate = sdate;
        this.title = title;
        this.publisher = publisher;
    }

    public Notice(String content, String sdate, String title, String publisher) {
        this.content = content;
        this.sdate = sdate;
        this.title = title;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", sdate='" + sdate + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
