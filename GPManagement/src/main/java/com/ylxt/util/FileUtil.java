package com.ylxt.util;

import java.io.File;
import java.util.UUID;

public class FileUtil {

    public static final String DECLARE_SUBJECT_PATH = "/DECLARE_SUBJECT_PATH";

    public static final String START_REPORT = "/START_REPORT";

    public static final String MIDDLE_REPORT = "/MIDDLE_REPORT";

    public static final String DRAFT_PAPER = "/DRAFT_PAPER";

    public static final String FINALIZED_PAPER = "/FINALIZED_PAPER";




    public static String getPrefix(int type, String number) {
        String prefix = null;

        switch (type) {
            case 0:
                prefix = DECLARE_SUBJECT_PATH + "/" + number;
                break;
            case 1:
                prefix = START_REPORT + "/" + number;
                break;
            case 2:
                prefix = MIDDLE_REPORT + "/" + number;
                break;
            case 3:
                prefix = DRAFT_PAPER + "/" + number;
                break;
            case 4:
                prefix = FINALIZED_PAPER + "/" + number;
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
}
