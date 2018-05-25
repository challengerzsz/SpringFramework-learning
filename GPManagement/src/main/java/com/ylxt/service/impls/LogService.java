package com.ylxt.service.impls;

import com.ylxt.common.ServerResponse;
import com.ylxt.dao.ILogMapper;
import com.ylxt.pojo.Log;
import com.ylxt.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService implements ILogService {

    @Autowired
    private ILogMapper logMapper;

    @Override
    public void sendGuideLog(String publisher, String targetName, String log) {
        logMapper.sendGuideLog(publisher, targetName, log);
    }

    @Override
    public ServerResponse<List<Log>> getGuideLogs(String username) {
        List<Log> logs = logMapper.getGuideLogs(username);
        if (logs.size() == 0) {
            return ServerResponse.createByErrorMsg("无指导日志");
        }

        return ServerResponse.createBySuccess("查询成功", logs);
    }

    @Override
    public ServerResponse<String> publishLog(Log log) {
        int resultCount = logMapper.publishLog(log);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("发布通知失败");
        }

        return ServerResponse.createBySuccessMsg("发布通知成功");
    }

    @Override
    public ServerResponse<List<Log>> getPublicLogs() {
        List<Log> logs = logMapper.getPublicLogs();
        if (logs.size() == 0) {
            return ServerResponse.createByErrorMsg("无公开通知");
        }

        return ServerResponse.createBySuccess("查询成功", logs);
    }
}
