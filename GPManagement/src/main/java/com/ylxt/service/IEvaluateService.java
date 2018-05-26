package com.ylxt.service;

import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.Evaluate;
import com.ylxt.pojo.User;

public interface IEvaluateService {

    ServerResponse<Evaluate> checkEvaluateValid(String number);

    ServerResponse<String> submitEvaluate(User user, Evaluate evaluate);
}
