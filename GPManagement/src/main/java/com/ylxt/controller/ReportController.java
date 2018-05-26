package com.ylxt.controller;

import com.ylxt.common.Const;
import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.MiddleReport;
import com.ylxt.pojo.StartReport;
import com.ylxt.pojo.Subject;
import com.ylxt.pojo.User;
import com.ylxt.service.IReportService;
import com.ylxt.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/report/")
public class ReportController {

    @Autowired
    private IReportService reportService;
    @Autowired
    private ISubjectService subjectService;

    /**
     * check是否符合提交开题报告的条件
     * @param session
     * @return
     */
    @RequestMapping(value = "check_start_report_valid.do", method = RequestMethod.POST)
    public ServerResponse<StartReport> checkStartReportValid(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }
        if (user.getType() != 2) {
            return ServerResponse.createByErrorMsg("仅学生有此权限操作");
        }

        ServerResponse<Subject> subjectServerResponse = subjectService.getMySubject(user.getNumber());
        if(!subjectServerResponse.isSuccess()) {
            return ServerResponse.createByErrorMsg(subjectServerResponse.getMsg());
        }

        return reportService.checkStartReportValid(user.getNumber());
    }

    @RequestMapping(value = "submit_start_report.do", method = RequestMethod.POST)
    public ServerResponse<String> submitStartReport(HttpSession session, StartReport startReport) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }
        if (user.getType() != 2) {
            return ServerResponse.createByErrorMsg("仅学生有此权限操作");
        }


        return reportService.submitStartReport(user, startReport);
    }

    @RequestMapping(value = "confirm_start_report.do", method = RequestMethod.POST)
    public ServerResponse<String> confirmStartReport(HttpSession session, int id, int answer, String opinion) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }
        if (user.getType() != 1) {
            return ServerResponse.createByErrorMsg("无权限进行此操作");
        }

        return reportService.confirmStartReport(id, answer, opinion);
    }

    @RequestMapping(value = "refresh_start_report_audit_list.do", method = RequestMethod.POST)
    public ServerResponse<List<StartReport>> refreshStartReportAuditList(HttpSession session) {

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }
        if (user.getType() != 1) {
            return ServerResponse.createByErrorMsg("无权限进行审批");
        }

        ServerResponse<List<StartReport>> response = reportService.refreshStartReportAuditList(user.getUsername());

        return response;
    }

    @RequestMapping(value = "check_middle_report_valid.do", method = RequestMethod.POST)
    public ServerResponse<MiddleReport> checkMiddleReportValid(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }
        if (user.getType() != 2) {
            return ServerResponse.createByErrorMsg("仅学生有此权限操作");
        }

        return reportService.checkMiddleReportValid(user.getNumber());
    }


    @RequestMapping(value = "refresh_middle_report_audit_list.do", method = RequestMethod.POST)
    public ServerResponse<List<MiddleReport>> refreshMiddleReportAuditList(HttpSession session) {

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }
        if (user.getType() != 1) {
            return ServerResponse.createByErrorMsg("无权限进行审批");
        }

        ServerResponse<List<MiddleReport>> response = reportService.refreshMiddleReportAuditList(user.getUsername());

        return response;
    }

    @RequestMapping(value = "confirm_middle_report.do", method = RequestMethod.POST)
    public ServerResponse<String> confirmMiddleReport(HttpSession session, int id, int answer) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }
        if (user.getType() != 1) {
            return ServerResponse.createByErrorMsg("无权限进行此操作");
        }

        return reportService.confirmMiddleReport(id, answer);
    }

    @RequestMapping(value = "submit_middle_report.do", method = RequestMethod.POST)
    public ServerResponse<String> submitMiddleReport(HttpSession session, MiddleReport middleReport) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }
        if (user.getType() != 2) {
            return ServerResponse.createByErrorMsg("仅学生有此权限操作");
        }


        return reportService.submitMiddleReport(user, middleReport);
    }

}
