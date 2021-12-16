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
@RequestMapping("/studentchangepassword")
public class StudentChangePasswordController {
    @Autowired
    private T_StudentRepository studentChangePassword;

    @GetMapping("/{sid}/{name}/{newPassword}")
    public RetResult<T_Student> changeName(@PathVariable("sid") Integer sid, @PathVariable("name") String name, @PathVariable("newPassword") String newPassword) {
        T_Student student = new T_Student();
        student.setSid(sid);
        student.setName(name);
        student.setPassword(newPassword);
        return RetResponse.makeOKRsp(studentChangePassword.save(student));
    }
}
