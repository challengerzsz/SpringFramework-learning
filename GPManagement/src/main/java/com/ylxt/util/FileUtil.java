package com.ylxt.util;

import com.ylxt.common.Const;

import java.io.File;
import java.util.UUID;

public class FileUtil {

    public static final String SUBJECT_PATH = "/SUBJECT_PATH";

    public static final String START_REPORT_PATH = "/START_REPORT";

    public static final String MIDDLE_REPORT_PATH = "/MIDDLE_REPORT";

    public static final String DRAFT_PAPER_PATH = "/DRAFT_PAPER";

    public static final String FINALIZED_PAPER_PATH = "/FINALIZED_PAPER";


    public static String getPrefix(int type, String number) {
        String prefix = null;

        switch (type) {
            case 0:
                prefix = SUBJECT_PATH + "/" + number;
                break;
            case 1:
                prefix = START_REPORT_PATH + "/" + number;
                break;
            case 2:
                prefix = MIDDLE_REPORT_PATH + "/" + number;
                break;
            case 3:
                prefix = DRAFT_PAPER_PATH + "/" + number;
                break;
            case 4:
                prefix = FINALIZED_PAPER_PATH + "/" + number;
                break;
        }

        return prefix;
    }

    /**
     * 初始化对应场景下对学号初始化文件夹
     * @param type 类型
     * @param realPath
     * @param number 学号
     * @return
     */
    public static String initUserDir(int type, String realPath, String number) {

        String prefix = realPath + getPrefix(type, number);

        File prefixDir = new File(prefix);
        if (!prefixDir.exists()) {
            prefixDir.mkdirs();
        }

        return prefix;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getSavePaths(String serverName, String serverPort, String contextPath, int type, String number, File targetFileName) {
        return "http://" + serverName + ":" + serverPort + contextPath + getPrefix(type, number) + "/" + targetFileName.getName();
    }

    public static File getTargetFile(String saveFilePrefixDir, String originalFilename) {
//        根据上传文件的后缀辨识转换后文件的格式
        String fileSuffix = originalFilename.substring(originalFilename.indexOf("."));
//        创建待转换的文件
        File targetFile = new File(saveFilePrefixDir + "/" + getUUID() + fileSuffix);
        if (!targetFile.exists()) {
            targetFile.mkdir();
        }

        return targetFile;
    }

    public static String getFileTable(int type) {
        String table = null;

        switch (type) {
            case 0:
                table = Const.SUBJECT_TABLE;
                break;
            case 1:
                table = Const.START_REPORT_TABLE;
                break;
            case 2:
                table = Const.MIDDLE_REPORT_TABLE;
                break;
            case 3:
                table = Const.DRAFT_PAPER_TABLE;
                break;
            case 4:
                table = Const.FINALIZED_PAPER_TABLE;
                break;
        }

        return table;

    }
}
