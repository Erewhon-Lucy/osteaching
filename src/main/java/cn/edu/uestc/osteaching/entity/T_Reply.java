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
    //private Integer count_good;
    private Integer qid;
    private Integer sid;
    private Integer tid;
    private boolean isReplied=false;
    private Integer r_rid;

    public Integer getR_rid() {
        return r_rid;
    }

    public void setR_rid(Integer r_rid) {
        this.r_rid = r_rid;
    }

    public boolean isReplied() {
        return isReplied;
    }

    public void setReplied(boolean replied) {
        isReplied = replied;
    }

    //second update by shuhan
   /* public void addCount_good() {
        this.count_good +=1;
    }
    public void deleteCount_good() {
        if(this.count_good<=0){
            throw new IllegalStateException("there is no thumb up.");
        }
        this.count_good -=1;
    }*/
    // 以下是书涵更新的
    public T_Reply() {
    }

    public T_Reply(Integer rid, String content, Date date, Integer qid, Integer sid, Integer tid, boolean isReplied, Integer r_rid) {
        this.rid = rid;
        this.content = content;
        this.date = date;
        this.qid = qid;
        this.sid = sid;
        this.tid = tid;
        this.isReplied = isReplied;
        this.r_rid = r_rid;
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

    /*public Integer getCount_good() {
        return count_good;
    }

    public void setCount_good(Integer count_good) {
        this.count_good = count_good;
    }*/

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
