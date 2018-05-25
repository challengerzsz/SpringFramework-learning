package com.ylxt.service;

import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.Log;

import java.util.List;

public interface ILogService {

    void sendGuideLog(String publisher, String targetName, String log);

    ServerResponse<List<Log>> getGuideLogs(String username);

    ServerResponse<String> publishLog(Log log);

    ServerResponse<List<Log>> getPublicLogs();
}
