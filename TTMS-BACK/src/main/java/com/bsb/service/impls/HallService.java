package com.bsb.service.impls;

import com.bsb.common.ServerResponse;
import com.bsb.dao.HallMapper;
import com.bsb.pojo.Hall;
import com.bsb.service.IHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService implements IHallService {

    @Autowired
    private HallMapper hallMapper;

    @Autowired
    private MovieService movieService;

    @Override
    public ServerResponse<String> addHall(Hall hall) {
        ServerResponse checkHallResponse = this.checkValid(hall.getHall_name());
        if (!checkHallResponse.isSuccess()) {
            return ServerResponse.createByErrorMsg("演出厅已存在，请勿重复添加");
        }
        ServerResponse checkMovieResponse = movieService.checkValid(hall.getOn_show_movie());
        if (checkMovieResponse.isSuccess()) {
            return ServerResponse.createByErrorMsg("影片不存在，添加演出厅失败");
        }

        int resultCount = hallMapper.insert(hall);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("演出厅添加失败");
        }
        return ServerResponse.createBySuccessMsg("演出厅添加成功");
    }

    @Override
    public ServerResponse<List<Hall>> showHalls(int start, int end) {
        List<Hall> halls = hallMapper.showHalls(start, end);
        if (halls == null) {
            return ServerResponse.createByErrorMsg("无演出厅信息");
        }
        return ServerResponse.createBySuccess("演出厅信息如下", halls);
    }

    @Override
    public ServerResponse<String> checkValid(String hallName) {
        int resultCount = hallMapper.checkValid(hallName);
        if (resultCount == 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMsg("演出厅已存在");
    }

    @Override
    public ServerResponse<String> deleteHall(String hallName) {
        ServerResponse checkValidResponse = this.checkValid(hallName);
        if (checkValidResponse.isSuccess()) {
            return ServerResponse.createByErrorMsg("演出厅不存在，删除失败");
        }
        int resultCount = hallMapper.deleteHallByName(hallName);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("删除演出厅失败");
        }
        return ServerResponse.createBySuccessMsg("删除演出厅成功");
    }

    @Override
    public ServerResponse<String> updateHall(Hall hall) {
        ServerResponse checkValidResponse = this.checkValid(hall.getHall_name());
        if (checkValidResponse.isSuccess()) {
            return ServerResponse.createByErrorMsg("演出厅不存在，无法修改");
        }
        int resultCount = hallMapper.updateHall(hall);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("更新演出厅信息失败");
        }
        return ServerResponse.createBySuccessMsg("更新演出厅成功");
    }

    @Override
    public ServerResponse<Hall> getInfoByHallName(String hallName) {
        ServerResponse checkValidResponse = this.checkValid(hallName);
        if (checkValidResponse.isSuccess()) {
            return ServerResponse.createByErrorMsg("演出厅不存在");
        }
        Hall hall = hallMapper.getInfoByHallName(hallName);
        if (hall == null) {
            return ServerResponse.createByErrorMsg("查询演出厅信息失败");
        }
        return ServerResponse.createBySuccess("查询演出厅信息成功", hall);
    }


}
