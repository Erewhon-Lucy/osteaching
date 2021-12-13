package cn.edu.uestc.osteaching.controller;

import cn.edu.uestc.osteaching.entity.T_Reply;
import cn.edu.uestc.osteaching.repository.T_ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private T_ReplyRepository t_replyRepository;

    @GetMapping
    public List<T_Reply> getReply() {
        return t_replyRepository.findAll();
    }

    @PostMapping
    public void addNewReply(@RequestBody T_Reply reply) {
        Optional<T_Reply> replyOptional = t_replyRepository
                .findReplyByRid(reply.getRid());
        if (replyOptional.isPresent()) {
            throw new IllegalStateException("reply taken.");
        }
        t_replyRepository.save(reply);
        System.out.println(reply);
    }

    @PutMapping(path="/addThumbUp/{rid}")
    @Transactional
    public void addNewGood(@PathVariable("rid") Integer rid) {
        T_Reply reply= t_replyRepository.findReplyByRid(rid).orElseThrow(()->new IllegalStateException(
                "reply with id"+rid+"does not exist"));
        reply.addCount_good();
        System.out.println(reply);
    }

    @PutMapping(path="/deleteThumbUp/{rid}")
    @Transactional
    public void deleteNewGood(@PathVariable("rid") Integer rid) {
        T_Reply reply= t_replyRepository.findReplyByRid(rid).orElseThrow(()->new IllegalStateException(
                "reply with id"+rid+"does not exist"));
        reply.deleteCount_good();
        System.out.println(reply);
    }

    @DeleteMapping(path = "{rid}")
    public void deleteStudent(@PathVariable("rid") Integer rid) {
        boolean exists = t_replyRepository.existsById(rid);
        if (!exists) {
            throw new IllegalStateException(
                    "reply with id" + rid + "does not exist");
        }
        t_replyRepository.deleteById(rid);
    }
}