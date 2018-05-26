package com.ylxt.service.impls;

import com.ylxt.common.ResponseCode;
import com.ylxt.common.ServerResponse;
import com.ylxt.dao.IPaperMapper;
import com.ylxt.dao.IReportMapper;
import com.ylxt.dao.ISubjectMapper;
import com.ylxt.pojo.*;
import com.ylxt.service.ILogService;
import com.ylxt.service.IPaperService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperService implements IPaperService {

    Logger logger = Logger.getLogger(PaperService.class);

    @Autowired
    private IPaperMapper paperMapper;
    @Autowired
    private IReportMapper reportMapper;
    @Autowired
    private ISubjectMapper subjectMapper;
    @Autowired
    private ILogService logService;

    @Override
    public ServerResponse<Paper> checkPaperValid(String number) {
        Subject mySubject = subjectMapper.getMySubject(number);
        if (mySubject == null) {
            return ServerResponse.createByErrorMsg("未拥有课题或课题未通过审核");
        }

        MiddleReport myMiddleReport = reportMapper.getMyMiddleReport(number);
        if (myMiddleReport == null) {
            return ServerResponse.createByErrorMsg("未提交中期报告，或中期报告未通过审核");
        }

        Paper myPaper = paperMapper.getMyPaper(number);
        if (myPaper == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.NONE_PAPER.getCode(), "未提交论文定稿");
        }

        return ServerResponse.createBySuccess("查询成功", myPaper);
    }

    @Override
    public ServerResponse<String> submit(User user) {
        Subject mySubject = subjectMapper.getMySubject(user.getNumber());

        Paper paper = new Paper();
        paper.setNumber(user.getNumber());
        paper.setStudentName(user.getUsername());
        paper.setSubjectId(mySubject.getId());
        paper.setSubjectName(mySubject.getSubjectName());
        paper.setGuideTeacher(mySubject.getGuideTeacher());

        int resultCount = paperMapper.submitPaper(paper);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("提交论文定稿失败");
        }

        return ServerResponse.createBySuccessMsg("论文定稿提交成功");
    }

    @Override
    public ServerResponse<List<Paper>> refreshPaperAuditList(String username) {
        List<Paper> papers = paperMapper.refreshPaperAuditList(username);
        if (papers.size() == 0) {
            return ServerResponse.createByErrorMsg("查询成功，无待审核的论文定稿");
        }

        return ServerResponse.createBySuccess("查询成功", papers);
    }

    @Override
    public ServerResponse<String> confirmPaper(int id, int answer, int score) {
        Paper paper = paperMapper.checkValidById(id);
        if (paper == null) {
            return ServerResponse.createByErrorMsg("该论文定稿不存在，审核失败");
        }

        int resultCount = paperMapper.confirmPaper(id, answer, score);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("审核失败");
        }

        if (answer == 1) {
            logService.sendGuideLog(paper.getGuideTeacher(), paper.getStudentName(), "论文定稿审核成功 成绩是" + score);
        } else if (answer == -1) {
            paperMapper.deletePaper(id);
            logService.sendGuideLog(paper.getGuideTeacher(), paper.getStudentName(), "论文定稿审核失败");
        }

        return ServerResponse.createBySuccessMsg("审核成功");
    }

    @Override
    public ServerResponse<Paper> checkResultValid(User user) {
        Paper myPaper = paperMapper.getMyPaper(user.getNumber());
        if (myPaper == null) {
            return ServerResponse.createByErrorMsg("未提交论文定稿，查看答辩结果失败");
        }

        if (myPaper.getStatus() == 0) {
            return ServerResponse.createByErrorMsg("论文定稿未审核，请等待");
        }

        Paper paper = paperMapper.getResult(user.getNumber());

        return ServerResponse.createBySuccess("查询成功", paper);
    }

}
