package cn.edu.uestc.osteaching.repository;

import cn.edu.uestc.osteaching.entity.T_Student;
import cn.edu.uestc.osteaching.entity.T_Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface T_TeacherRepository extends JpaRepository<T_Teacher, Integer> {
    List<T_Teacher> findByNameAndPassword(String name, String password);
}
