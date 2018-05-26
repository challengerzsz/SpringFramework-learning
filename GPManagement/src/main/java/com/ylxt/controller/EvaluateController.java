package com.ylxt.controller;

import com.ylxt.common.Const;
import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.Evaluate;
import com.ylxt.pojo.User;
import com.ylxt.service.IEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/evaluate/")
public class EvaluateController {

    @Autowired
    private IEvaluateService evaluateService;

    @RequestMapping(value = "check_evaluate_valid.do", method = RequestMethod.POST)
    public ServerResponse<Evaluate> checkEvaluateValid(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorMsg("未登录");
        }

        return evaluateService.checkEvaluateValid(user.getNumber());
    }

    @RequestMapping(value = "submit_evaluate.do", method = RequestMethod.POST)
    public ServerResponse<String> submitEvaluate(HttpSession session, Evaluate evaluate) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorMsg("未登录");
        }

        return evaluateService.submitEvaluate(user, evaluate);
    }
}
