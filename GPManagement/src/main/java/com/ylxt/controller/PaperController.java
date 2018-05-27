package com.ylxt.controller;

import com.ylxt.common.Const;
import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.Paper;
import com.ylxt.pojo.User;
import com.ylxt.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/paper/")
public class PaperController {

    @Autowired
    private IPaperService paperService;

    @RequestMapping(value = "check_paper_valid.do", method = RequestMethod.POST)
    public ServerResponse<Paper> checkPaperValid(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }

        return paperService.checkPaperValid(user.getNumber());
    }

    @RequestMapping(value = "submit_paper.do", method = RequestMethod.POST)
    public ServerResponse<String> submitPaper(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }

        return paperService.initPaper(user);
    }

    @RequestMapping(value = "refresh_paper_audit_list.do", method = RequestMethod.POST)
    public ServerResponse<List<Paper>> refreshPaperAuditList(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }
        if (user.getType() != 1) {
            return ServerResponse.createByErrorMsg("仅老师可进行操作");
        }

        return paperService.refreshPaperAuditList(user.getUsername());
    }

    @RequestMapping(value = "confirm_paper.do", method = RequestMethod.POST)
    public ServerResponse<String> confirmPaper(HttpSession session, int id, int answer, int score) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }
        if (user.getType() != 1) {
            return ServerResponse.createByErrorMsg("仅老师可进行操作");
        }

        return paperService.confirmPaper(id, answer, score);
    }

    @RequestMapping(value = "check_result_valid.do", method = RequestMethod.POST)
    public ServerResponse<Paper> checkResultValid(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }

        return paperService.checkResultValid(user);
    }

}
