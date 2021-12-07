package cn.edu.uestc.osteaching.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//shuhan's work
@Entity
@Data
public class T_Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mid;
    private String title;
    private String content;
    private Date date;
    private Integer count_good;
    private Integer sid;
    private Integer tid;
    private Integer parentid;

    // 以下是书涵更新的
    public T_Message() {
    }

    public T_Message(Integer mid, String title, String content, Date date, Integer count_good, Integer sid, Integer tid,
            Integer parentid) {
        this.mid = mid;
        this.title = title;
        this.content = content;
        this.date = date;
        this.count_good = count_good;
        this.sid = sid;
        this.tid = tid;
        this.parentid = parentid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount_good() {
        return count_good;
    }

    public void setCount_good(Integer count_good) {
        this.count_good = count_good;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}
