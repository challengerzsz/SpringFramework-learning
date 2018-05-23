package com.ylxt.service;

import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.Message;


import java.util.List;

public interface IMessageService {

    ServerResponse<String> sendMessage(String username, String targetName, String message);

    ServerResponse<List<Message>> getUnread(String username);

    ServerResponse<String> read(int id);

    ServerResponse<List<Message>> getInBoxes(String username);

    ServerResponse<List<Message>> getSendEmails(String username);

}
