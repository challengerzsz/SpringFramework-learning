package com.ylxt.service;

import com.ylxt.common.ServerResponse;

public interface IFileService {

    ServerResponse<String> saveFilePath(String saveFilePath, String number);
}
