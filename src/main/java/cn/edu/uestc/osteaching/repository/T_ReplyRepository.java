package cn.edu.uestc.osteaching.repository;

import cn.edu.uestc.osteaching.entity.T_Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface T_ReplyRepository extends JpaRepository<T_Reply, Integer> {
    List<T_Reply> findAll();

    Optional<T_Reply> findReplyById(Integer rid);
}