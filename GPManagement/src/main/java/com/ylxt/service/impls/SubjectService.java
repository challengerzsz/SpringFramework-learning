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
    public ServerResponse<Subject> getSelectedTask() {
        return null;
    }

    @Override
    public ServerResponse<String> publishTask(Subject newTask) {
        return null;
    }

    @Override
    public ServerResponse<String> declareSubject(Subject newSubject) {
        int resultCount = subjectMapper.checkNameValid(newSubject.getSubjectName());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMsg("申报课题已存在，申报失败");
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
}
