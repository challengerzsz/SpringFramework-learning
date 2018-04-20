package com.bsb.service.impls;

import com.bsb.common.ServerResponse;
import com.bsb.dao.HallMapper;
import com.bsb.pojo.Hall;
import com.bsb.service.IHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HallService implements IHallService {

    @Autowired
    private HallMapper hallMapper;

    @Autowired
    private MovieService movieService;

    @Override
    public ServerResponse<String> addHall(Hall hall) {
        ServerResponse checkHallResponse = this.checkValid(hall.getHallName());
        if (!checkHallResponse.isSuccess()) {
            return ServerResponse.createByErrorMsg("演出厅已存在，请勿重复添加");
        }
        ServerResponse checkMovieResponse = movieService.checkValid(hall.getOnShowMovie());
        if (checkHallResponse.isSuccess()) {
            return ServerResponse.createByErrorMsg("影片不存在，添加演出厅失败");
        }

        int resultCount = hallMapper.insert(hall);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("演出厅添加失败");
        }
        return ServerResponse.createBySuccessMsg("演出厅添加成功");
    }

    public ServerResponse<String> checkValid(String hallName) {
        int resultCount = hallMapper.checkValid(hallName);
        if (resultCount == 0) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByErrorMsg("演出厅已存在");
    }
}
