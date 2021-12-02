package cn.edu.uestc.osteaching.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class T_Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    private String name;
    private String password;
    private String phone;
    private String email;
    private String gender;
    private String avatar;
    private String read_count;
    private String tid;
}
