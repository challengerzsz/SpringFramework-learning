package com.ylxt.service;

import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.Subject;

import java.util.List;

public interface ISubjectService {

    ServerResponse<String> publishSubject(Subject newTask);

    ServerResponse<String> declareSubject(Subject newSubject);

    ServerResponse<List<Subject>> refreshAuditList(String username);

    ServerResponse<String> confirmSubject(int id, int answer);

    boolean checkValid(int id);

    ServerResponse<String> selectSubject(String username, String number, int id);

    ServerResponse<Subject> getDeclaredSubject(String number);

    ServerResponse<Subject> getSelectedSubject(String number);

    ServerResponse<List<Subject>> getUnSelectedSubjects();

    ServerResponse<List<Subject>> getMyGuideSubjects(String username);
}
