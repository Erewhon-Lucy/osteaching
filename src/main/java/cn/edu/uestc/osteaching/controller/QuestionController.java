package cn.edu.uestc.osteaching.controller;

import cn.edu.uestc.osteaching.entity.T_Question;
import cn.edu.uestc.osteaching.entity.T_Reply;
import cn.edu.uestc.osteaching.repository.T_QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//third update by shuhan
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private T_QuestionRepository t_questionRepository;

    @GetMapping
    public List<T_Question> getQuestion() {
        return t_questionRepository.findAll();
    }

    @GetMapping("/{qid}")
    public T_Question getQuestionById(@PathVariable("qid")Integer qid)
    {
        return t_questionRepository.findQuestionByQid(qid).orElseThrow(()->new IllegalStateException(
                "question with id"+qid+"does not exist"));
    }

    @PostMapping(path = "/addNewQuestion/{title}/{content}/{sid}/{tid}")
    @Transactional
    public void addNewQuestion(@PathVariable("title")String title,
                               @PathVariable("content") String content,
                               @PathVariable("sid") Integer sid,
                               @PathVariable("tid") Integer tid) {
            T_Question question=new T_Question();
            question.setTitle(title);
            question.setContent(content);
            question.setSid(sid);
            question.setTid(tid);
            question.setDate(new Date());
            /*Optional<T_Question> questionOptional = t_questionRepository
                .findQuestionByQid(question.getQid());
        if (questionOptional.isPresent()) {
            throw new IllegalStateException("question id should be unique.");
        }*/
        t_questionRepository.save(question);
        System.out.println(question);
    }

    /*问题点赞数接口
    @PutMapping(path="/addThumbUp/{qid}")
    @Transactional
    public void addNewGood(@PathVariable("qid") Integer qid) {
        T_Question question= t_questionRepository.findQuestionByQid(qid).orElseThrow(()->new IllegalStateException(
                "question with id"+qid+"does not exist"));
        question.addCount_good();
        System.out.println(question);
    }

    @PutMapping(path="/deleteThumbUp/{qid}")
    @Transactional
    public void deleteNewGood(@PathVariable("qid") Integer qid) {
        T_Question question= t_questionRepository.findQuestionByQid(qid).orElseThrow(()->new IllegalStateException(
                "question with id"+qid+"does not exist"));
        question.deleteCount_good();
        System.out.println(question);
    }
    */

    @DeleteMapping(path = "{qid}")
    @Transactional
    public void deleteQuestion(@PathVariable("qid") Integer qid) {
        T_Question question= t_questionRepository.findQuestionByQid(qid).orElseThrow(()->new IllegalStateException(
                "reply with id"+qid+"does not exist"));
        t_questionRepository.deleteById(qid);
        t_questionRepository.findQuestionByQid(question.getQid()).orElseThrow(()->new IllegalStateException(
                "question with id"+question.getQid()+"does not exist")).deleteCount_reply();
    }

    @Transactional//不需要sql
    @PutMapping(path="/update/{qid}/{content}")
    public void updateQuestion(@PathVariable("qid") Integer qid,
                               @PathVariable("content") String updateContent) {
        T_Question question=t_questionRepository.findQuestionByQid(qid)
                .orElseThrow(()->new IllegalStateException(
                        "question with id"+qid+"does not exist"));

        if(updateContent!=null &&
                updateContent.length()>0 &&
                !Objects.equals(question.getContent(),updateContent)){
            question.setContent(updateContent);
        }else {
            throw new IllegalStateException("question content cannot be NULL or the same as before!!");
        }
    }
}
