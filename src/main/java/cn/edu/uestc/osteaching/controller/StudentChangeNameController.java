package cn.edu.uestc.osteaching.controller;

import cn.edu.uestc.osteaching.entity.RetResponse;
import cn.edu.uestc.osteaching.entity.RetResult;
import cn.edu.uestc.osteaching.entity.T_Student;
import cn.edu.uestc.osteaching.repository.T_StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studentchangename")
public class StudentChangeNameController {
    @Autowired
    private T_StudentRepository studentChangeName;

    @GetMapping("/{sid}/{newName}/{password}")
    public RetResult<T_Student> changeName(@PathVariable("sid") Integer sid, @PathVariable("newName") String newName, @PathVariable("password") String password) {
        T_Student student = new T_Student();
        student.setSid(sid);
        student.setName(newName);
        student.setPassword(password);
        return RetResponse.makeOKRsp(studentChangeName.save(student));
    }
}
