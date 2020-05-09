package geektime.im.lecture.controller;


import geektime.im.lecture.service.MessageService;
import geektime.im.lecture.vo.MessageContactVO;
import geektime.im.lecture.vo.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;


    @PostMapping(path = "/sendMsg")
    public MessageVO sendMsg(@RequestParam Long senderUid, @RequestParam Long recipientUid, String content, Integer msgType, Model model) {
        MessageVO messageContent = messageService.sendNewMsg(senderUid, recipientUid, content, msgType);
        return messageContent;
    }

    @GetMapping(path = "/queryMsg")
    public List<MessageVO> queryMsg(@RequestParam Long ownerUid, @RequestParam Long otherUid, Model model) {
        List<MessageVO> messageVO = messageService.queryConversationMsg(ownerUid, otherUid);
        return messageVO;
    }

    @GetMapping(path = "/queryMsgSinceMid")
    public List<MessageVO> queryMsgSinceMid(@RequestParam Long ownerUid, @RequestParam Long otherUid, @RequestParam Long lastMid, Model model) {
        List<MessageVO> messageVO = messageService.queryNewerMsgFrom(ownerUid, otherUid, lastMid);
        return messageVO;
    }

    @GetMapping(path = "/queryContacts")
    public MessageContactVO queryContacts(@RequestParam Long ownerUid, Model model) {
        MessageContactVO contactVO = messageService.queryContacts(ownerUid);
        return contactVO;
    }
}
