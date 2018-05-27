package com.ylxt.service;

import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.User;

public interface IFileService {

    ServerResponse<String> saveFilePath(User user, int type, String saveFilePath, String number);

    String checkPathExist(int type, String number);
}
