package com.ylxt.service.impls;

import com.ylxt.common.ServerResponse;
import com.ylxt.dao.FileMapper;
import com.ylxt.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService implements IFileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public ServerResponse<String> saveFilePath(String saveFilePath, String number) {
        if (saveFilePath == null) {
            return ServerResponse.createByErrorMsg("保存至数据库文件路径为空");
        }

        int resultCount = fileMapper.insertSaveFilePath(saveFilePath, number);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("保存文件路径至数据库失败");
        }

        return ServerResponse.createBySuccessMsg("保存文件路径成功");
    }
}
