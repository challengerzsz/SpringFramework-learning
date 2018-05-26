package com.ylxt.service.impls;

import com.ylxt.common.ResponseCode;
import com.ylxt.common.ServerResponse;
import com.ylxt.dao.IReportMapper;
import com.ylxt.dao.ISubjectMapper;
import com.ylxt.pojo.MiddleReport;
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
    public ServerResponse<String> submitMiddleReport(User user, MiddleReport middleReport) {
        Subject mySubject = subjectMapper.getMySubject(user.getNumber());

        middleReport.setStudentName(user.getUsername());
        middleReport.setNumber(user.getNumber());
        middleReport.setSubjectName(mySubject.getSubjectName());
        middleReport.setSubjectId(mySubject.getId());
        middleReport.setGuideTeacher(mySubject.getGuideTeacher());

        int resultCount = reportMapper.submitMiddleReport(middleReport);

        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("提交中期报告失败");
        }

        return ServerResponse.createBySuccessMsg("提交中期报告成功");
    }

    @Override
    public ServerResponse<String> confirmStartReport(int id, int answer, String opinion) {
        StartReport startReport = this.checkStartReportValidById(id);
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
            reportMapper.deleteStartReportById(id);
            logService.sendGuideLog(startReport.getGuideTeacher(), startReport.getStudentName(), "您的前期报告审核已被拒绝!  原因:" + opinion);
        }


        return ServerResponse.createBySuccessMsg("审核成功");
    }

    @Override
    public StartReport checkStartReportValidById(int id) {
        StartReport startReport = reportMapper.checkStartReportValidById(id);
        if (startReport != null) {
            return startReport;
        }
        return null;
    }

    @Override
    public MiddleReport checkMiddleReportValidById(int id) {
        MiddleReport middleReport = reportMapper.checkMiddleReportValidById(id);
        if (middleReport != null) {
            return middleReport;
        }

        return null;
    }

    @Override
    public ServerResponse<List<StartReport>> refreshStartReportAuditList(String username) {
        List<StartReport> reports = reportMapper.getStartReportAuditList(username);

        if (reports.size() == 0) {
            return ServerResponse.createByErrorMsg("无需要审批的前期报告");
        }

        return ServerResponse.createBySuccess("查询成功", reports);
    }

    @Override
    public ServerResponse<MiddleReport> checkMiddleReportValid(String number) {
        Subject mySubject = subjectMapper.getMySubject(number);
        if (mySubject == null) {
            return ServerResponse.createByErrorMsg("未拥有课题或课题未通过审核");
        }

        StartReport myStartReport = reportMapper.getMyStartReport(number);
        if (myStartReport == null) {
            return ServerResponse.createByErrorMsg("未提交开题报告");
        }

        MiddleReport middleReport = reportMapper.getMyMiddleReport(number);
        if (middleReport == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.NONE_REPORT.getCode(), "未提交过中期报告");
        }

        return ServerResponse.createBySuccess("查询成功", middleReport);
    }

    @Override
    public ServerResponse<List<MiddleReport>> refreshMiddleReportAuditList(String username) {
        List<MiddleReport> reports = reportMapper.getMiddleReportAuditList(username);

        if (reports.size() == 0) {
            return ServerResponse.createByErrorMsg("无需要审批的中期报告");
        }

        return ServerResponse.createBySuccess("查询成功", reports);
    }

    @Override
    public ServerResponse<String> confirmMiddleReport(int id, int answer) {
        MiddleReport middleReport = this.checkMiddleReportValidById(id);
        if (middleReport == null) {
            return ServerResponse.createByErrorMsg("不存在该中期报告，审核失败");
        }

        logger.info(middleReport.getStudentName());

        int resultCount = reportMapper.confirmMiddleReport(id, answer);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("审核中期报告失败");
        }


        if (answer == 1) {
            logService.sendGuideLog(middleReport.getGuideTeacher(), middleReport.getStudentName(), "您的中期报告审核已通过!");
        } else if (answer == -1) {
            reportMapper.deleteMiddleReportById(id);
            logService.sendGuideLog(middleReport.getGuideTeacher(), middleReport.getStudentName(), "您的中期报告审核已被拒绝!");
        }


        return ServerResponse.createBySuccessMsg("审核成功");
    }


}
