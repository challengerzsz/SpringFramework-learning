package com.ylxt.service.impls;

import com.ylxt.common.ServerResponse;

import com.ylxt.dao.SubjectMapper;
import com.ylxt.pojo.Subject;
import com.ylxt.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService implements ISubjectService {

    @Autowired
    private SubjectMapper subjectMapper;


    @Override
    public ServerResponse<String> publishTask(Subject newTask) {
        return null;
    }

    @Override
    public ServerResponse<String> declareSubject(Subject newSubject) {

        int numberResult = subjectMapper.checkNumberValid(newSubject.getNumber());
        if (numberResult != 0) {
            return ServerResponse.createByErrorMsg("您已申报过课题，请勿重复申报");
        }

        int resultCount = subjectMapper.checkNameValid(newSubject.getSubjectName());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMsg("申报课题已存在，申报失败");
        }

        int teacherCount = subjectMapper.checkTeacherValid(newSubject.getGuideTeacher());
        if (teacherCount == 0) {
            return ServerResponse.createByErrorMsg("导师不存在，申报失败");
        }


        int updateCount = subjectMapper.declareSubject(newSubject);
        if (updateCount != 0) {
            return ServerResponse.createBySuccessMsg("申报课题成功");
        }

        return ServerResponse.createByErrorMsg("申报课题失败");
    }

    @Override
    public ServerResponse<List<Subject>> refreshAuditList(String username) {
        List<Subject> subjects = subjectMapper.getAuditList(username);
        if (subjects == null) {
            return ServerResponse.createBySuccessMsg("无需要审批的申报课题");
        }

        return ServerResponse.createBySuccess("查询成功", subjects);
    }

    @Override
    public ServerResponse<String> confirmSubject(int id, int answer) {
//        校验课题是否存在
        boolean validResult = this.checkValid(id);
        if (!validResult) {
            return ServerResponse.createByErrorMsg("课题不存在");
        }

        int resultCount = subjectMapper.confirmSubject(id, answer);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("处理操作失败");
        }

        return ServerResponse.createBySuccessMsg("审核成功");
    }

    @Override
    public boolean checkValid(int id) {

        int resultCount = subjectMapper.checkIdValid(id);
        if (resultCount == 0) {
            return false;
        }
        return true;
    }

    @Override
    public ServerResponse<Subject> getDeclareSubject(String number) {
        Subject subject = subjectMapper.getDeclareSubject(number);
        if (subject == null) {
            return ServerResponse.createByErrorMsg("还未申报课题");
        }

        return ServerResponse.createBySuccess("查询成功", subject);
    }
}
