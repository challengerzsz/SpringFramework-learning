package com.ylxt.controller;


import com.ylxt.common.Const;
import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.Task;
import com.ylxt.pojo.User;
import com.ylxt.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/task/")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    public ServerResponse<Task> get_selected_task(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByError();
        }

        //todo 查询自己已选信息传入什么参数
        ServerResponse<Task> response = taskService.getSelectedTask();



        return null;
    }
}
