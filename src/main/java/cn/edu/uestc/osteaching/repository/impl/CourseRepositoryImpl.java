package cn.edu.uestc.osteaching.repository.impl;

import cn.edu.uestc.osteaching.entity.RetResponse;
import cn.edu.uestc.osteaching.entity.T_Course;
import cn.edu.uestc.osteaching.entity.T_Teacher;
import cn.edu.uestc.osteaching.repository.T_CourseRepository;
import cn.edu.uestc.osteaching.repository.T_TeacherRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseRepositoryImpl  {

    public List<T_Course> latest2Week(List<T_Course> list) {
        Date date=new Date();
        for(int i=0;i<list.size();i++){
            Date courseDate=list.get(i).getDate();
            long difference =  (courseDate.getTime()-date.getTime())/86400000;
            if(difference>14){
                list.remove(list.get(i));
            }
        }
        return list;
    }


}
