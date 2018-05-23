package com.ylxt.service.impls;

import com.ylxt.common.ServerResponse;

import com.ylxt.dao.ISubjectMapper;
import com.ylxt.pojo.Subject;
import com.ylxt.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService implements ISubjectService {

    @Autowired
    private ISubjectMapper subjectMapper;


    @Override
    public ServerResponse<String> publishSubject(Subject newSubject) {
        int resultCount = subjectMapper.publishSubject(newSubject);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("发布课题失败");
        }

        return ServerResponse.createBySuccessMsg("发布课题成功");
    }

    @Override
    public ServerResponse<String> declareSubject(Subject newSubject) {

        int numberResult = subjectMapper.checkNumberValid(newSubject.getNumber());
        if (numberResult != 0) {
            return ServerResponse.createByErrorMsg("您已申报过课题，请勿重复申报");
        }

        int resultCount = subjectMapper.checkNameValid(newSubject.getSubjectName());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMsg("课题名称重复，申报失败");
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

        if (subjects.size() == 0) {
            return ServerResponse.createByErrorMsg("无需要审批的申报课题");
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
    public ServerResponse<String> selectSubject(String username, String number, int id) {
        int resultCount = subjectMapper.selectSubject(username, number, id);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("选题失败");
        }

        return ServerResponse.createBySuccessMsg("选题成功");
    }

    @Override
    public ServerResponse<Subject> getDeclaredSubject(String number) {

        Subject declaredSubject = subjectMapper.checkDeclaredSubject(number);
        Subject selectedSubject = subjectMapper.checkSelectedSubject(number);

        if (declaredSubject == null && selectedSubject == null) {
            return ServerResponse.createByErrorMsg("未申报过或选择过课题");
        } else if (declaredSubject != null && selectedSubject == null) {
            return ServerResponse.createBySuccess("已查询到申报的课题", declaredSubject);
        } else if (declaredSubject == null && selectedSubject != null) {
            return ServerResponse.createByErrorMsg("已选择过课题");
        }

        return ServerResponse.createByErrorMsg("查询失败");
    }

    @Override
    public ServerResponse<Subject> getSelectedSubject(String number) {

        Subject declaredSubject = subjectMapper.checkDeclaredSubject(number);
        Subject selectedSubject = subjectMapper.checkSelectedSubject(number);

        if (declaredSubject == null && selectedSubject == null) {
            return ServerResponse.createByErrorMsg("未申报过或选择过课题");
        } else if (declaredSubject != null && selectedSubject == null) {
            return ServerResponse.createByErrorMsg("已申报过课题");
        } else if (declaredSubject == null && selectedSubject != null) {
            return ServerResponse.createBySuccess("已查询到选择的课题", selectedSubject);
        }

        return ServerResponse.createByErrorMsg("查询失败");
    }

    @Override
    public ServerResponse<List<Subject>> getUnSelectedSubjects() {

        List<Subject> unSelectedSubjects = subjectMapper.getUnSelectedSubjects();

        if (unSelectedSubjects.size() == 0) {
            return ServerResponse.createByErrorMsg("无未选课题");
        }

        return ServerResponse.createBySuccess("查询成功", unSelectedSubjects);
    }

    @Override
    public ServerResponse<List<Subject>> getMyGuideSubjects(String username) {
        List<Subject> subjects = subjectMapper.getMyGuideSubject(username);
        if (subjects.size() == 0) {
            return ServerResponse.createByErrorMsg("查询成功，无负责课题");
        }

        return ServerResponse.createBySuccess("查询成功", subjects);
    }
}
