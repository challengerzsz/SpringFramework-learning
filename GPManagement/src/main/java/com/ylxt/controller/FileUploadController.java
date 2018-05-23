package com.ylxt.controller;

import com.ylxt.common.Const;
import com.ylxt.common.ServerResponse;
import com.ylxt.pojo.User;
import com.ylxt.service.IFileService;
import com.ylxt.util.FileUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file/")
public class FileUploadController {

    Logger logger = Logger.getLogger(FileUploadController.class);

    @Autowired
    private IFileService fileService;


    /**
     * 根据type判断上传的文件属于什么场景
     * @param session
     * @param type 0 申报课题， 1 开题报告， 2 中期汇报表， 3 论文草稿， 4 论文定稿
     * @param request
     * @return
     */
    @RequestMapping(value = "upload.do", method = RequestMethod.POST)
    public ServerResponse<String> upload(HttpSession session, int type, MultipartHttpServletRequest request) {

//        用户需登录进行操作
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }

//        根据type判断是哪个场景 然后根据用户number进行初始化文件夹
        String saveFilePrefixDir = FileUtil.initUserDir(type, request.getSession().getServletContext().getRealPath("/"), user.getNumber());



//        从请求中获取需要上传的多文件
        List<MultipartFile> multipartFiles = request.getFiles("file");
        if (multipartFiles.size() == 0) {
            return ServerResponse.createByErrorMsg("文件列表为空，上传文件失败");
        }


//        String serverIp = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + FileUtil.DECLARE_SUBJECT_PATH + "/" + "04163209" + "/" + "1.png";


        String serverName = request.getServerName();
        String serverPort = String.valueOf(request.getServerPort());
        String contextPath = request.getContextPath();

        logger.info(request.getRequestURL());
        logger.info(serverName);
        logger.info(serverPort);
        logger.info(contextPath);

        String uploadFilesPath = null;

        for (MultipartFile file : multipartFiles) {

            File targetFile = FileUtil.getTargetFile(saveFilePrefixDir, file.getOriginalFilename());

            try {
                file.transferTo(targetFile);
            } catch (IOException e) {
                return ServerResponse.createByErrorMsg("文件上传失败");
            }

            if (uploadFilesPath == null) {
                uploadFilesPath = FileUtil.getSavePaths(serverName, serverPort, contextPath, type, user.getNumber(), targetFile);
            } else {
                uploadFilesPath = uploadFilesPath + "," + FileUtil.getSavePaths(serverName, serverPort, contextPath, type, user.getNumber(), targetFile);
            }
        }

        ServerResponse<String> response = fileService.saveFilePath(type, uploadFilesPath, user.getNumber());

        return response;
    }
}
