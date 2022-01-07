package cn.edu.uestc.osteaching.controller;

import cn.edu.uestc.osteaching.entity.RetResponse;
import cn.edu.uestc.osteaching.entity.RetResult;
import cn.edu.uestc.osteaching.entity.T_Course;
import cn.edu.uestc.osteaching.entity.T_Exercise;
import cn.edu.uestc.osteaching.repository.T_ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    @Autowired
    private T_ExerciseRepository exerciseRepository;

    @GetMapping("/findAll/{page}/{size}")
    public RetResult<List<T_Exercise>> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable= PageRequest.of(page,size);
        return RetResponse.makeOKRsp(exerciseRepository.findAll());
    }


    @PostMapping("/save")
    public RetResult<Void> save(@RequestBody T_Exercise exercise){
        T_Exercise result=exerciseRepository.save(exercise);
        if(result!=null){
            return RetResponse.makeOKRsp();
        }else {
            return RetResponse.makeErrRsp("error");
        }
    }

    @GetMapping("/findByTitle/{title}")
    public RetResult<Integer> findIdByTitle(@PathVariable("title") String title){
        T_Exercise exercise=exerciseRepository.findByTitle(title);
        Integer eid=exercise.getEid();
        return RetResponse.makeOKRsp(eid);
    }

    @GetMapping("/findById/{id}")
    public RetResult<T_Exercise> findById(@PathVariable("id") Integer id){
        return RetResponse.makeOKRsp(exerciseRepository.findById(id).get());
    }


    @PutMapping("/update")
    public RetResult<Void> update(@RequestBody T_Exercise exercise){
        T_Exercise result=exerciseRepository.save(exercise);
        if(result!=null){
            return RetResponse.makeOKRsp();
        }else {
            return RetResponse.makeErrRsp("error");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public RetResult<Void> deleteById(@PathVariable("id") Integer id){
        exerciseRepository.deleteById(id);
        return RetResponse.makeOKRsp();
    }
}
