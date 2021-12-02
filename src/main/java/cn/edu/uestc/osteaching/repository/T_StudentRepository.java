package cn.edu.uestc.osteaching.repository;

import cn.edu.uestc.osteaching.entity.T_Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface T_StudentRepository extends JpaRepository<T_Student, Integer> {

    List<T_Student> findByNameAndPassword(String name, String password);
}
