package cn.edu.uestc.osteaching.repository;

import cn.edu.uestc.osteaching.entity.T_Message;
import cn.edu.uestc.osteaching.entity.T_Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface T_MessageRepository extends JpaRepository<T_Message, Integer> {
    List<T_Message> findAll();
    Optional<T_Message> findMessageByMid(Integer mid);
}
