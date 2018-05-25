package com.ylxt.controller;

import com.ylxt.common.Const;
import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.Log;
import com.ylxt.pojo.User;
import com.ylxt.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/log/")
public class LogController {

    @Autowired
    private ILogService logService;

    @RequestMapping(value = "get_guide_logs.do", method =  RequestMethod.POST)
    public ServerResponse<List<Log>> getGuideLogs(HttpSession session) {

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorMsg("未登录");
        }

        return logService.getGuideLogs(user.getUsername());
    }

    @RequestMapping(value = "publish_log.do", method = RequestMethod.POST)
    public ServerResponse<String> publishLog(HttpSession session, Log log) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorMsg("未登录");
        }
        if (user.getType() != 1) {
            return ServerResponse.createByErrorMsg("只有老师拥有权限");
        }

        if (log == null) {
            return ServerResponse.createByErrorMsg("发布的通知为空");
        }

        log.setPublisher(user.getUsername());
        return logService.publishLog(log);
    }

    @RequestMapping(value = "get_public_logs.do", method = RequestMethod.POST)
    public ServerResponse<List<Log>> getPublicLogs(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorMsg("未登录");
        }

        return logService.getPublicLogs();
    }
}
