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
public class T_Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer qid;
    private String title;
    private String content;
    private Integer count_reply=0;
    private Integer count_good;
    private Date date;
    private Integer sid;
    private Integer tid;


    //third update by shuhan
    /*public void addCount_good() {
        this.count_good +=1;
    }
    public void deleteCount_good() {
        if(this.count_good<=0){
            throw new IllegalStateException("there is no thumb up for question.");
        }
        this.count_good -=1;
    }*/

    //second update by shuhan
    public void addCount_reply() {
        this.count_reply +=1;
    }

    public void deleteCount_reply() {
        if(this.count_reply<=0){
            throw new IllegalStateException("there is no thumb up for reply.");
        }
        this.count_reply -=1;
    }

    // 以下是书涵更新的
    public T_Question() {
    }

    public T_Question(Integer qid, String title, String content, Integer count_reply, Date date, Integer sid,
            Integer tid) {
        this.qid = qid;
        this.title = title;
        this.content = content;
        this.count_reply = count_reply;
        this.date = date;
        this.sid = sid;
        this.tid = tid;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
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

    public Integer getCount_reply() {
        return count_reply;
    }

    public void setCount_reply(Integer count_reply) {
        this.count_reply = count_reply;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
