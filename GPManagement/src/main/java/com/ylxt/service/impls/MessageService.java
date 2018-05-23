package com.ylxt.service.impls;

import com.ylxt.common.ServerResponse;
import com.ylxt.dao.IMessageMapper;
import com.ylxt.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ylxt.pojo.Message;

import java.util.List;

@Service
public class MessageService implements IMessageService {

    @Autowired
    private IMessageMapper messageMapper;

    @Override
    public ServerResponse<String> sendMessage(String username, String targetName, String message) {
        int resultCount = messageMapper.insert(username, targetName, message);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("发送消息失败");
        }

        return ServerResponse.createBySuccessMsg("发送成功");
    }

    @Override
    public ServerResponse<List<Message>> getUnread(String username) {
        List<Message> messages = messageMapper.getUnread(username);

        if (messages.size() == 0) {
            return ServerResponse.createByErrorMsg("无未读信息");
        }

        return ServerResponse.createBySuccess("查询成功", messages);
    }

    @Override
    public ServerResponse<String> read(int id) {
        int resultCount = messageMapper.read(id);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("已读失败");
        }

        return ServerResponse.createBySuccessMsg("已读邮件");
    }

    @Override
    public ServerResponse<List<Message>> getInBoxes(String username) {
        List<Message> messages = messageMapper.getInBoxes(username);
        if (messages.size() == 0) {
            return ServerResponse.createByErrorMsg("收信箱为空");
        }

        return ServerResponse.createBySuccess("查询成功", messages);
    }

    @Override
    public ServerResponse<List<Message>> getSendEmails(String username) {
        List<Message> messages = messageMapper.getSendMails(username);
        if (messages.size() == 0) {
            return ServerResponse.createByErrorMsg("发信箱为空");
        }

        return ServerResponse.createBySuccess("查询成功", messages);
    }
}
