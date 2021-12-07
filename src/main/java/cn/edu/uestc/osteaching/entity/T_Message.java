package cn.edu.uestc.osteaching.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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
}
