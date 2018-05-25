package com.ylxt.controller;

import com.ylxt.common.Const;
import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.User;
import com.ylxt.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ylxt.pojo.Message;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/message/")
public class MessageController {

    @Autowired
    private IMessageService messageService;


    @RequestMapping(value = "send.do", method = RequestMethod.POST)
    public ServerResponse<String> send(HttpSession session, String targetName, String message) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorMsg("未登录");
        }

        ServerResponse<String> response = messageService.sendMessage(user.getUsername(), targetName, message);
        return response;
    }

    @RequestMapping(value = "get_unread.do", method = RequestMethod.POST)
    public ServerResponse<List<Message>> getUnread(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorMsg("未登录");
        }

        ServerResponse<List<Message>> response = messageService.getUnread(user.getUsername());
        return response;
    }

    @RequestMapping(value = "read.do", method = RequestMethod.POST)
    public ServerResponse<String> read(HttpSession session, int id) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorMsg("未登录");
        }

        return messageService.read(id);
    }

    @RequestMapping(value = "get_in_mails.do", method = RequestMethod.POST)
    public ServerResponse<List<Message>> getInBoxes(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorMsg("未登录");
        }

        return messageService.getInBoxes(user.getUsername());
    }

    @RequestMapping(value = "get_send_mails.do", method = RequestMethod.POST)
    public ServerResponse<List<Message>> getSendMails(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorMsg("未登录");
        }

        return messageService.getSendEmails(user.getUsername());
    }

}
