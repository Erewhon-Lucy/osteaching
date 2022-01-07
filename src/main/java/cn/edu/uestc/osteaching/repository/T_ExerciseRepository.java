package cn.edu.uestc.osteaching.repository;

import cn.edu.uestc.osteaching.entity.T_Course;
import cn.edu.uestc.osteaching.entity.T_Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface T_ExerciseRepository extends JpaRepository<T_Exercise,Integer> {
    T_Exercise findByTitle(String title);
}
