package cn.edu.uestc.osteaching.controller;

import cn.edu.uestc.osteaching.entity.RetResponse;
import cn.edu.uestc.osteaching.entity.RetResult;
import cn.edu.uestc.osteaching.entity.T_Course;
import cn.edu.uestc.osteaching.repository.T_CourseRepository;
import cn.edu.uestc.osteaching.repository.impl.CourseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private T_CourseRepository courseRepository;

    @Autowired
    private CourseRepositoryImpl courseRepositoryImpl;

    @CrossOrigin
    @GetMapping("/findLatest")
    public RetResult<List<T_Course>> findLatest(){
        List<T_Course> list=courseRepository.findAll();
        if(list==null){
            throw new IllegalArgumentException();
        }
        List<T_Course> courses = courseRepositoryImpl.latest2Week(list);
        return RetResponse.makeOKRsp(courses);
    }

    @CrossOrigin
    @GetMapping("/findAll")
    public RetResult<List<T_Course>> findAll(){
        return RetResponse.makeOKRsp(courseRepository.findAll());
    }

    @CrossOrigin
    @GetMapping("/findAll/{page}/{size}")
    public RetResult<List<T_Course>> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable= PageRequest.of(page,size);
        return RetResponse.makeOKRsp(courseRepository.findAll());
    }

    @CrossOrigin
    @PostMapping("/save")
    public RetResult<Void> save(@RequestBody T_Course course){
        T_Course result=courseRepository.save(course);
        if(result!=null){
            return RetResponse.makeOKRsp();
        }else {
            return RetResponse.makeErrRsp("error");
        }
    }

    @CrossOrigin
    @GetMapping("/findById/{id}")
    public RetResult<T_Course> findById(@PathVariable("id") Integer id){
        return RetResponse.makeOKRsp(courseRepository.findById(id).get());
    }

    @GetMapping("/findByName/{cname}")
    public RetResult<Integer> findIdByName(@PathVariable("cname") String cname){
        T_Course course=courseRepository.findByName(cname);
        Integer cid=course.getCid();
        return RetResponse.makeOKRsp(cid);
    }


    @CrossOrigin
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

    @CrossOrigin
    @DeleteMapping("/deleteById/{id}")
    public RetResult<Void> deleteById(@PathVariable("id") Integer id){
        courseRepository.deleteById(id);
        return RetResponse.makeOKRsp();
    }
}
