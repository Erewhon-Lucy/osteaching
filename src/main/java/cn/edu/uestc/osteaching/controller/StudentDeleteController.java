package cn.edu.uestc.osteaching.controller;

import cn.edu.uestc.osteaching.entity.RetResponse;
import cn.edu.uestc.osteaching.entity.RetResult;
import cn.edu.uestc.osteaching.repository.T_StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentDeleteController {
    @Autowired
    private T_StudentRepository studentDelete;

    @DeleteMapping("/studentdelete/{sid}")
    public RetResult<Void> delete(@PathVariable("sid") Integer sid) {
        studentDelete.deleteById(sid);
        return RetResponse.makeOKRsp();
    }
}
