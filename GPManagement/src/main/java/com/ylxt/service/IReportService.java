package com.ylxt.service;

import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.StartReport;
import com.ylxt.pojo.User;

import java.util.List;

public interface IReportService {

    ServerResponse<StartReport> checkStartReportValid(String number);

    ServerResponse<String> submitStartReport(User user, StartReport startReport);

    ServerResponse<String> confirmStartReport(int id, int answer, String opinion);

    StartReport checkValidById(int id);

    ServerResponse<List<StartReport>> refreshAuditList(String username);
}
