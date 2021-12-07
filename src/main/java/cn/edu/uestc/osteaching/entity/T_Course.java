package cn.edu.uestc.osteaching.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class T_Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String name;
    private Integer hour;
    private String photo;
    private String video;
    private String introduction;
    private String homework;
    private String appendix;
    private Date date;
    private String place;
    private Integer tid;
}
