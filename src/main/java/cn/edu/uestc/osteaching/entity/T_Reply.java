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
public class T_Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;
    private String content;
    private Date date;
    private Integer count_good;
    private Integer qid;
    private Integer sid;
    private Integer tid;

    // 以下是书涵更新的
    public T_Reply() {
    }

    public T_Reply(Integer rid, String content, Date date, Integer count_good, Integer qid, Integer sid, Integer tid) {
        this.rid = rid;
        this.content = content;
        this.date = date;
        this.count_good = count_good;
        this.qid = qid;
        this.sid = sid;
        this.tid = tid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
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
}
