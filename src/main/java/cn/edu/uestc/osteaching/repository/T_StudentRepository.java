package cn.edu.uestc.osteaching.repository;

import cn.edu.uestc.osteaching.entity.T_Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface T_StudentRepository extends JpaRepository<T_Student, Integer> {
    @Modifying
    @Transactional
    @Query("update T_Student set read_count = 1")
    void updateAllReadCountOne();

    @Modifying
    @Transactional
    @Query("update T_Student set read_count = 0")
    void updateAllReadCountZero();

    @Modifying
    @Transactional
    @Query("update T_Student set read_count = 0 where sid = :sid")
    void updateStuReadCountZero(Integer sid);

    @Modifying
    @Transactional
    @Query("update T_Student set read_count = 1 where sid = :sid")
    void updateStuReadCountOne(Integer sid);
}