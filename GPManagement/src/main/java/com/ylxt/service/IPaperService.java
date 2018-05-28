package com.ylxt.service;

import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.Paper;
import com.ylxt.pojo.User;

import java.util.List;

public interface IPaperService {

    ServerResponse<Paper> checkPaperValid(String number);

    ServerResponse<String> initPaper(User user);

    ServerResponse<List<Paper>> refreshPaperAuditList(String username);

    ServerResponse<String> confirmPaper(int id, int answer, int score, String message);

    ServerResponse<Paper> checkResultValid(User user);
}
