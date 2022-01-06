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

    @GetMapping("/changename/{sid}/{newName}/{password}")
    public RetResult<T_Student> changeName(@PathVariable("sid") Integer sid, @PathVariable("newName") String newName, @PathVariable("password") String password) {
        T_Student student = new T_Student();
        student.setSid(sid);
        student.setName(newName);
        student.setPassword(password);
        return RetResponse.makeOKRsp(studentRepository.save(student));
    }

    @GetMapping("/changepassword/{sid}/{name}/{newPassword}")
    public RetResult<T_Student> changePassword(@PathVariable("sid") Integer sid, @PathVariable("name") String name, @PathVariable("newPassword") String newPassword) {
        T_Student student = new T_Student();
        student.setSid(sid);
        student.setName(name);
        student.setPassword(newPassword);
        return RetResponse.makeOKRsp(studentRepository.save(student));
    }

    @GetMapping("/findall")
    public RetResult<List<T_Student>> findAll() {
        return RetResponse.makeOKRsp(studentRepository.findAll());
    }

    @DeleteMapping("/delete/{sid}")
    public RetResult<Void> delete(@PathVariable("sid") Integer sid) {
        studentRepository.deleteById(sid);
        return RetResponse.makeOKRsp();
    }

    @PutMapping("/update_read_count_1")
    public RetResult<Void> updateStuReadCountOne(@RequestBody T_Student student) {
        studentRepository.updateStuReadCountOne(student.getSid());
        return RetResponse.makeOKRsp();
    }

    @PutMapping("/update_read_count_0")
    public RetResult<Void> updateStuReadCountZero(@RequestBody T_Student student) {
        studentRepository.updateStuReadCountZero(student.getSid());
        return RetResponse.makeOKRsp();
    }

    @PutMapping("/update_all_read_count_1")
    public RetResult<Void> updateAllReadCountOne() {
        studentRepository.updateAllReadCountOne();
        return RetResponse.makeOKRsp();
    }
}
