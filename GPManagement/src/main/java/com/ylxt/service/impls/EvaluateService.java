package com.ylxt.service.impls;

import com.ylxt.common.ResponseCode;
import com.ylxt.common.ServerResponse;
import com.ylxt.dao.IEvaluateMapper;
import com.ylxt.dao.IPaperMapper;
import com.ylxt.pojo.Evaluate;
import com.ylxt.pojo.Paper;
import com.ylxt.pojo.User;
import com.ylxt.service.IEvaluateService;
import com.ylxt.service.IMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluateService implements IEvaluateService {

    Logger logger = Logger.getLogger(EvaluateService.class);

    @Autowired
    private IPaperMapper paperMapper;
    @Autowired
    private IMessageService messageService;
    @Autowired
    private IEvaluateMapper evaluateMapper;

    @Override
    public ServerResponse<Evaluate> checkEvaluateValid(String number) {
        Paper myPaper = paperMapper.getMyPaper(number);
        if (myPaper == null) {
            return ServerResponse.createByErrorMsg("未提交论文定稿，无法评价");
        }

        if (myPaper.getStatus() != 1) {
            return ServerResponse.createByErrorMsg("论文定稿未审核，请等待审核");
        }

        Evaluate myEvaluate = evaluateMapper.getMyEvaluate(number);
        if (myEvaluate == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.NONE_EVALUATE.getCode(), "未提交评价");
        }

        return ServerResponse.createBySuccess("查询成功", myEvaluate);
    }

    @Override
    public ServerResponse<String> submitEvaluate(User user, Evaluate evaluate) {
        Paper myPaper = paperMapper.getMyPaper(user.getNumber());

        evaluate.setNumber(user.getNumber());
        evaluate.setStudentName(user.getUsername());
        evaluate.setSubjectId(myPaper.getSubjectId());
        evaluate.setSubjectName(myPaper.getSubjectName());
        evaluate.setAttachment(myPaper.getAttachment());
        evaluate.setGuideTeacher(myPaper.getGuideTeacher());

        int resultCount = evaluateMapper.submitEvaluate(evaluate);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("评价失败");
        }

        messageService.sendMessage(user.getUsername(), evaluate.getGuideTeacher(),
                "做出了评价  " + evaluate.getEvaluate() + "  分数: " + evaluate.getScore());

        return ServerResponse.createBySuccessMsg("评价成功");
    }
}
