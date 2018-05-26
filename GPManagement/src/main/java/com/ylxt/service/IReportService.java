package com.ylxt.service;

import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.MiddleReport;
import com.ylxt.pojo.StartReport;
import com.ylxt.pojo.User;

import java.util.List;

public interface IReportService {

    ServerResponse<StartReport> checkStartReportValid(String number);

    ServerResponse<String> submitStartReport(User user, StartReport startReport);

    ServerResponse<String> submitMiddleReport(User user, MiddleReport middleReport);

    ServerResponse<String> confirmStartReport(int id, int answer, String opinion);

    StartReport checkStartReportValidById(int id);

    MiddleReport checkMiddleReportValidById(int id);

    ServerResponse<List<StartReport>> refreshStartReportAuditList(String username);

    ServerResponse<MiddleReport> checkMiddleReportValid(String number);

    ServerResponse<List<MiddleReport>> refreshMiddleReportAuditList(String username);

    ServerResponse<String> confirmMiddleReport(int id, int answer);


}
