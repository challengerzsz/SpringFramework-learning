package com.bsb.controller;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Hall;
import com.bsb.service.IHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/hall/")
public class HallController {

    @Autowired
    private IHallService hallService;

    @RequestMapping(value = "add_hall.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addHall(Hall hall) {
        return hallService.addHall(hall);
    }
    

}
