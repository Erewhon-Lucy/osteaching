package cn.edu.uestc.osteaching.controller;

import cn.edu.uestc.osteaching.entity.T_Message;
import cn.edu.uestc.osteaching.entity.T_Reply;
import cn.edu.uestc.osteaching.repository.T_MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private T_MessageRepository t_messageRepository;


    @GetMapping
    public List<T_Message> getMessage() {
        return t_messageRepository.findAll();
    }

    @PutMapping(path="/addThumbUp/{mid}")
    @Transactional
    public void addNewGood(@PathVariable("mid") Integer mid) {
        T_Message message= t_messageRepository.findMessageByMid(mid).orElseThrow(()->new IllegalStateException(
                "message with id"+mid+"does not exist"));
        message.addCount_good();
        //System.out.println(message);
    }

    @PutMapping(path="/deleteThumbUp/{mid}")
    @Transactional
    public void deleteNewGood(@PathVariable("mid") Integer mid) {
       T_Message message= t_messageRepository.findMessageByMid(mid).orElseThrow(()->new IllegalStateException(
                "message with id"+mid+"does not exist"));
        message.deleteCount_good();
        System.out.println(message);
    }

    @DeleteMapping(path = "{mid}")
    @javax.transaction.Transactional
    public void deleteMessage(@PathVariable("mid") Integer mid) {
        T_Message message= t_messageRepository.findMessageByMid(mid).orElseThrow(()->new IllegalStateException(
                "message with id"+mid+"does not exist"));
        t_messageRepository.deleteById(mid);
    }
}
