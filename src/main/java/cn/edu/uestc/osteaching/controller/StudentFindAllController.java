package cn.edu.uestc.osteaching.controller;

import cn.edu.uestc.osteaching.entity.RetResponse;
import cn.edu.uestc.osteaching.entity.RetResult;
import cn.edu.uestc.osteaching.entity.T_Student;
import cn.edu.uestc.osteaching.repository.T_StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentFindAllController {
    @Autowired
    private T_StudentRepository studentFindAll;

    @GetMapping("/studentFindAll")
    public RetResult<List<T_Student>> findAll() {
        return RetResponse.makeOKRsp(studentFindAll.findAll());
    }
}
