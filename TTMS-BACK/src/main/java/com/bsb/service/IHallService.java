package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Hall;

public interface IHallService {

    ServerResponse<String> addHall(Hall hall);
}
