package com.bsb.controller;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Hall;
import com.bsb.service.IHallService;
import javafx.scene.effect.Light;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping(value = "show_halls.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Hall>> showHalls(int start, int end) {
        return hallService.showHalls(start, end);
    }

    @RequestMapping(value = "check_valid.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkValid(String hallName) {
        return hallService.checkValid(hallName);
    }

    @RequestMapping(value = "delete_hall.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteHall(String hallName) {
        return hallService.deleteHall(hallName);
    }

    @RequestMapping(value = "update_hall.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateHall(Hall hall) {
        return hallService.updateHall(hall);
    }

    @RequestMapping(value = "get_info_by_hall_name.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Hall> getInfoByHallName(String hallName) {
        return hallService.getInfoByHallName(hallName);
    }

}
