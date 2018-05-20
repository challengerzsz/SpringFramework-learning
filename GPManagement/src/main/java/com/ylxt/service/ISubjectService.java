package com.ylxt.service;

import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.Subject;

import java.util.List;

public interface ISubjectService {
    ServerResponse<Subject> getSelectedTask();

    ServerResponse<String> publishTask(Subject newTask);

    ServerResponse<String> declareSubject(Subject newSubject);

    ServerResponse<List<Subject>> refreshAuditList(String username);
}
