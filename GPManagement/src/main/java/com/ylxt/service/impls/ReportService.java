package com.ylxt.service.impls;

import com.ylxt.common.ResponseCode;
import com.ylxt.common.ServerResponse;
import com.ylxt.dao.IReportMapper;
import com.ylxt.dao.ISubjectMapper;
import com.ylxt.pojo.StartReport;
import com.ylxt.pojo.Subject;
import com.ylxt.pojo.User;
import com.ylxt.service.ILogService;
import com.ylxt.service.IReportService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReportService implements IReportService {

    Logger logger = Logger.getLogger(ReportService.class);

    @Autowired
    private IReportMapper reportMapper;
    @Autowired
    private ISubjectMapper subjectMapper;
    @Autowired
    private ILogService logService;


    @Override
    public ServerResponse<StartReport> checkStartReportValid(String number) {
        StartReport startReport = reportMapper.checkStartReportValid(number);
        if (startReport == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.NONE_REPORT.getCode(), "未填写过开题报告");
        }

        return ServerResponse.createBySuccess("查询成功", startReport);
    }

    @Override
    public ServerResponse<String> submitStartReport(User user, StartReport startReport) {
        Subject mySubject = subjectMapper.getMySubject(user.getNumber());

        startReport.setStudentName(user.getUsername());
        startReport.setNumber(user.getNumber());
        startReport.setSubjectName(mySubject.getSubjectName());
        startReport.setSubjectId(mySubject.getId());
        startReport.setGuideTeacher(mySubject.getGuideTeacher());

        int resultCount = reportMapper.submitStartReport(startReport);

        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("提交开题报告失败");
        }

        return ServerResponse.createBySuccessMsg("提交开题报告成功");
    }

    @Override
    public ServerResponse<String> confirmStartReport(int id, int answer, String opinion) {
        StartReport startReport = this.checkValidById(id);
        if (startReport == null) {
            return ServerResponse.createByErrorMsg("不存在该前期报告，审核失败");
        }

        int resultCount = reportMapper.confirmStartReport(id, answer, opinion);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("审核前期报告失败");
        }


        if (answer == 1) {
            logService.sendGuideLog(startReport.getGuideTeacher(), startReport.getStudentName(), "您的前期报告审核已通过!");
        } else if (answer == -1) {
            reportMapper.deleteReportById(id);
            logService.sendGuideLog(startReport.getGuideTeacher(), startReport.getStudentName(), "您的前期报告审核已被拒绝!  原因:" + opinion);
        }


        return ServerResponse.createBySuccessMsg("审核成功");
    }

    @Override
    public StartReport checkValidById(int id) {
        StartReport startReport = reportMapper.checkValidById(id);
        if (startReport != null) {
            return startReport;
        }
        return null;
    }

    @Override
    public ServerResponse<List<StartReport>> refreshAuditList(String username) {
        List<StartReport> reports = reportMapper.getAuditList(username);

        if (reports.size() == 0) {
            return ServerResponse.createByErrorMsg("无需要审批的前期报告");
        }

        return ServerResponse.createBySuccess("查询成功", reports);
    }


}
