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
        return RetResponse.makeOKRsp(teacherRepository.findByNameAndPassword(name,password));
    }

    @GetMapping("/register/{name}/{password}")
    public RetResult<T_Teacher> save(@PathVariable("name") String name, @PathVariable("password") String password){
        T_Teacher teacher = new T_Teacher();
        teacher.setName(name);
        teacher.setPassword(password);
        return RetResponse.makeOKRsp(teacherRepository.save(teacher));
    }
}
