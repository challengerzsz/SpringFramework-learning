package com.ylxt.controller;


import com.ylxt.common.Const;
import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.Subject;
import com.ylxt.pojo.User;
import com.ylxt.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/subject/")
public class SubjectController {

    @Autowired
    private ISubjectService subjectService;


    @RequestMapping(value = "publish_subject.do", method = RequestMethod.POST)
    public ServerResponse<String> publishTask(HttpSession session, Subject newTask) {

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }
//        老师才能进行操作
        if (user.getType() != 1) {
            return ServerResponse.createByErrorMsg("无权限");
        }

        ServerResponse<String> response = subjectService.publishTask(newTask);

        if (!response.isSuccess()) {
            return ServerResponse.createByErrorMsg("发布新选题失败");
        }

        return response;
    }

    @RequestMapping(value = "declare_subject.do", method = RequestMethod.POST)
    public ServerResponse<String> declareSubject(HttpSession session, Subject newSubject) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }

        if (user.getType() != 2) {
            return ServerResponse.createByErrorMsg("仅学生可申报项目");
        }

        newSubject.setNumber(user.getNumber());
        newSubject.setStudentName(user.getUsername());
        ServerResponse<String> response = subjectService.declareSubject(newSubject);
        if (response.isSuccess()) {
            return ServerResponse.createBySuccessMsg("申报课题成功");
        }

        return response;
    }

    @RequestMapping(value = "refresh_audit_list.do", method = RequestMethod.POST)
    public ServerResponse<List<Subject>> refreshAuditList(HttpSession session) {

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }
        if (user.getType() != 1) {
            return ServerResponse.createByErrorMsg("无权限进行审批");
        }

        ServerResponse<List<Subject>> response = subjectService.refreshAuditList(user.getUsername());
        if (response.isSuccess()) {
            return ServerResponse.createByErrorMsg("查询失败");
        }

        return response;
    }

    /**
     * 审核申报课题
     * @param id 传入的学生申报课题的id
     * @param answer 拒绝 -1, 通过 1
     * @return
     */
    @RequestMapping(value = "confirm_subject.do", method = RequestMethod.POST)
    public ServerResponse<String> confirmSubject(HttpSession session, int id, int answer) {

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }
        if (user.getType() != 1) {
            return ServerResponse.createByErrorMsg("无权限进行审核");
        }

        ServerResponse<String> response = subjectService.confirmSubject(id, answer);
        if (response.isSuccess()) {
            return ServerResponse.createBySuccessMsg("审核成功");
        }

        return response;
    }

    @RequestMapping(value = "get_declare_subject.do", method = RequestMethod.POST)
    public ServerResponse<Subject> getDeclareSubject(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }

        if (user.getType() != 2) {
            return ServerResponse.createByErrorMsg("仅学生有此选项");
        }

        ServerResponse<Subject> response = subjectService.getDeclareSubject(user.getNumber());

        return response;
    }
}
