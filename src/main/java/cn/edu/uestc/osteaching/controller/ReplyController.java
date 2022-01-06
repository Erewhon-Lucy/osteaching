package cn.edu.uestc.osteaching.controller;

import cn.edu.uestc.osteaching.entity.T_Reply;
import cn.edu.uestc.osteaching.repository.T_QuestionRepository;
import cn.edu.uestc.osteaching.repository.T_ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private T_ReplyRepository t_replyRepository;

    @Autowired
    private T_QuestionRepository t_questionRepository;

    @GetMapping
    public List<T_Reply> getReply() {
        return t_replyRepository.findAll();
    }

    @PostMapping(path = "/addNewReply/{content}/{qid}/{sid}/{tid}/{r_rid}") // 如果是回复问题那么rrid==qid
    @Transactional
    public void addNewReply(@PathVariable("content") String content, @PathVariable("qid") Integer qid,
            @PathVariable("sid") Integer sid, @PathVariable("tid") Integer tid, @PathVariable("r_rid") Integer r_rid) {
        T_Reply reply = new T_Reply();
        reply.setContent(content);
        reply.setDate(new Date());
        reply.setQid(qid);
        reply.setSid(sid);
        reply.setTid(tid);
        reply.setR_rid(r_rid);

        T_Reply bereply = t_replyRepository.findReplyByRid(r_rid).orElseThrow(() -> new IllegalStateException(
                "reply with id" + r_rid + "does not exist"));
        bereply.setReplied(true);

        /*
         * Optional<T_Reply> replyOptional = t_replyRepository
         * .findReplyByRid(reply.getRid());
         * if (replyOptional.isPresent()) {
         * throw new IllegalStateException("reply taken.");
         * }
         */
        t_replyRepository.save(reply);

        t_questionRepository.findQuestionByQid(reply.getQid()).orElseThrow(() -> new IllegalStateException(
                "question with id" + reply.getQid() + "does not exist")).addCount_reply();
        System.out.println(reply);
    }

    @GetMapping(path = "/getNotBeReplied") // 小红点
    public List<T_Reply> getNotBeReplied() {

        return t_replyRepository.findAll().stream().filter(reply -> reply.isReplied() == false)
                .collect(Collectors.toList());
    }

    /*
     * @PutMapping(path="/addThumbUp/{rid}")
     * 
     * @Transactional
     * public void addNewGood(@PathVariable("rid") Integer rid) {
     * T_Reply reply= t_replyRepository.findReplyByRid(rid).orElseThrow(()->new
     * IllegalStateException(
     * "reply with id"+rid+"does not exist"));
     * reply.addCount_good();
     * System.out.println(reply);
     * }
     * 
     * @PutMapping(path="/deleteThumbUp/{rid}")
     * 
     * @Transactional
     * public void deleteNewGood(@PathVariable("rid") Integer rid) {
     * T_Reply reply= t_replyRepository.findReplyByRid(rid).orElseThrow(()->new
     * IllegalStateException(
     * "reply with id"+rid+"does not exist"));
     * reply.deleteCount_good();
     * System.out.println(reply);
     * }
     */

    @DeleteMapping(path = "{rid}")
    @Transactional
    public void deleteReply(@PathVariable("rid") Integer rid) {
        T_Reply reply = t_replyRepository.findReplyByRid(rid).orElseThrow(() -> new IllegalStateException(
                "reply with id" + rid + "does not exist"));
        t_replyRepository.deleteById(rid);
        t_questionRepository.findQuestionByQid(reply.getQid()).orElseThrow(() -> new IllegalStateException(
                "question with id" + reply.getQid() + "does not exist")).deleteCount_reply();
    }
}