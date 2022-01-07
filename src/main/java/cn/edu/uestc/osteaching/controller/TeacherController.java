package cn.edu.uestc.osteaching.controller;

import cn.edu.uestc.osteaching.entity.RetResponse;
import cn.edu.uestc.osteaching.entity.RetResult;
import cn.edu.uestc.osteaching.entity.T_Student;
import cn.edu.uestc.osteaching.entity.T_Teacher;
import cn.edu.uestc.osteaching.repository.T_TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private T_TeacherRepository teacherRepository;

    @CrossOrigin
    @GetMapping("/login/{name}/{password}")
    public RetResult<List<T_Teacher>> login(@PathVariable("name") String name, @PathVariable("password") String password) {
        if (teacherRepository.findByNameAndPassword(name, password).isEmpty()) {
            return RetResponse.makeErrRsp("Failed!");
        }
        return RetResponse.makeOKRsp(teacherRepository.findByNameAndPassword(name,password));
    }

    @CrossOrigin
    @GetMapping("/register/{name}/{password}")
    public RetResult<T_Teacher> save(@PathVariable("name") String name, @PathVariable("password") String password){
        T_Teacher teacher = new T_Teacher();
        teacher.setName(name);
        teacher.setPassword(password);
        return RetResponse.makeOKRsp(teacherRepository.save(teacher));
    }

    @CrossOrigin
    @GetMapping("/changename/{tid}/{newName}/{password}")
    public RetResult<T_Teacher> changeName(@PathVariable("tid") Integer tid, @PathVariable("newName") String newName, @PathVariable("password") String password) {
        T_Teacher teacher = new T_Teacher();
        teacher.setTid(tid);
        teacher.setName(newName);
        teacher.setPassword(password);
        return RetResponse.makeOKRsp(teacherRepository.save(teacher));
    }

    @CrossOrigin
    @GetMapping("/changepassword/{tid}/{name}/{newPassword}")
    public RetResult<T_Teacher> changePassword(@PathVariable("tid") Integer tid, @PathVariable("name") String name, @PathVariable("newPassword") String newPassword) {
        T_Teacher teacher = new T_Teacher();
        teacher.setTid(tid);
        teacher.setName(name);
        teacher.setPassword(newPassword);
        return RetResponse.makeOKRsp(teacherRepository.save(teacher));
    }
}
