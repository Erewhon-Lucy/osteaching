package cn.edu.uestc.osteaching.controller;

import cn.edu.uestc.osteaching.entity.RetResponse;
import cn.edu.uestc.osteaching.entity.RetResult;
import cn.edu.uestc.osteaching.entity.T_Course;
import cn.edu.uestc.osteaching.repository.T_CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private T_CourseRepository courseRepository;

    @GetMapping("/findAll/{page}/{size}")
    public RetResult<List<T_Course>> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable= PageRequest.of(page,size);
        return RetResponse.makeOKRsp(courseRepository.findAll());
    }

    @PostMapping("/save")
    public RetResult<Void> save(@RequestBody T_Course course){
        T_Course result=courseRepository.save(course);
        if(result!=null){
            return RetResponse.makeOKRsp();
        }else {
            return RetResponse.makeErrRsp("error");
        }
    }

    @GetMapping("/findById/{id}")
    public RetResult<T_Course> findById(@PathVariable("id") Integer id){
        return RetResponse.makeOKRsp(courseRepository.findById(id).get());
    }

    @PutMapping("/update")
    public RetResult<Void> update(@RequestBody T_Course course){
        T_Course result=courseRepository.save(course);
        if(result!=null){
            return RetResponse.makeOKRsp();
        }else {
            return RetResponse.makeErrRsp("error");
        }
    }

//    @PutMapping("/update/{id}")
//    public String update(@PathVariable("id") Integer id){
//        T_Course result=courseRepository.findById(id).get();
//        if(result!=null){
//            return "success";
//        }else {
//            return "error";
//        }
//    }

    @DeleteMapping("/deleteById/{id}")
    public RetResult<Void> deleteById(@PathVariable("id") Integer id){
        courseRepository.deleteById(id);
        return RetResponse.makeOKRsp();
    }
}
