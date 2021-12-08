package cn.edu.uestc.osteaching.controller;

import cn.edu.uestc.osteaching.entity.RetResponse;
import cn.edu.uestc.osteaching.entity.RetResult;
import cn.edu.uestc.osteaching.entity.T_Student;
import cn.edu.uestc.osteaching.repository.StudentLoginRepository;
import cn.edu.uestc.osteaching.repository.T_StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentLoginRepository studentLoginRepository;

    @Autowired
    private T_StudentRepository studentRepository;

    @CrossOrigin
    @GetMapping("/login/{name}/{password}")
    public RetResult<List<T_Student>> findByNameAndPassword(@PathVariable("name") String name, @PathVariable("password") String password) {
        return RetResponse.makeOKRsp(studentLoginRepository.findByNameAndPassword(name,password));
    }

    @GetMapping("/register/{name}/{password}")
    public RetResult<T_Student> save(@PathVariable("name") String name, @PathVariable("password") String password){
        T_Student student = new T_Student();
        student.setName(name);
        student.setPassword(password);
        student.setRead_count(0);
        return RetResponse.makeOKRsp(studentRepository.save(student));
    }


}
