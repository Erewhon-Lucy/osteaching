package cn.edu.uestc.osteaching.controller;

import cn.edu.uestc.osteaching.entity.RetResponse;
import cn.edu.uestc.osteaching.entity.RetResult;
import cn.edu.uestc.osteaching.entity.T_Student;
import cn.edu.uestc.osteaching.repository.StudentLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentlogin")
public class StudentLoginController {
    @Autowired
    private StudentLoginRepository studentLoginRepository;

    @CrossOrigin
    @GetMapping("/{name}/{password}")
    public RetResult<List<T_Student>> findByNameAndPassword(@PathVariable("name") String name, @PathVariable("password") String password) {
        return RetResponse.makeOKRsp(studentLoginRepository.findByNameAndPassword(name,password));
    }
}
