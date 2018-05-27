package com.ylxt.service.impls;

import com.ylxt.common.ServerResponse;
import com.ylxt.dao.IFileMapper;
import com.ylxt.pojo.User;
import com.ylxt.service.IFileService;
import com.ylxt.service.IPaperService;
import com.ylxt.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService implements IFileService {

    @Autowired
    private IFileMapper fileMapper;
    @Autowired
    private IPaperService paperService;

    @Override
    public ServerResponse<String> saveFilePath(User user, int type, String saveFilePath, String number) {
        if (saveFilePath == null) {
            return ServerResponse.createByErrorMsg("保存至数据库文件路径为空");
        }

        String table = FileUtil.getFileTable(type);

        if (table == null) {
            return ServerResponse.createByErrorMsg("type类型错误，文件上传失败");
        }

        if (type == 4) {
            paperService.initPaper(user);
        }

        int resultCount = fileMapper.insertSaveFilePath(table, saveFilePath, number);

        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("保存文件路径至数据库失败");
        }

        return ServerResponse.createBySuccess("上传文件成功", saveFilePath);
    }

    @Override
    public String checkPathExist(int type, String number) {
        return null;
    }


}
