package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Hall;

import java.util.List;

public interface IHallService {

    ServerResponse<String> addHall(Hall hall);

    ServerResponse<List<Hall>> showHalls(int start, int end);

    ServerResponse<String> checkValid(String hallName);

    ServerResponse<String> deleteHall(String hallName);

    ServerResponse<String> updateHall(Hall hall);

    ServerResponse<Hall> getInfoByHallName(String hallName);
}
