package cn.edu.uestc.osteaching.repository;

import cn.edu.uestc.osteaching.entity.T_Question;
import cn.edu.uestc.osteaching.entity.T_Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface T_QuestionRepository extends JpaRepository<T_Question, Integer> {
    List<T_Question> findAll();

    Optional<T_Question> findQuestionByQid(Integer qid);
}
