package cn.edu.uestc.osteaching.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class T_Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer qid;
    private String title;
    private String content;
    private Integer count_reply;
    private Date date;
    private Integer sid;
    private Integer tid;
}
