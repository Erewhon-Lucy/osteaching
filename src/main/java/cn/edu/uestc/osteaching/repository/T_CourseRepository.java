package cn.edu.uestc.osteaching.repository;

import cn.edu.uestc.osteaching.entity.T_Course;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface T_CourseRepository extends JpaRepository<T_Course,Integer> {

}
