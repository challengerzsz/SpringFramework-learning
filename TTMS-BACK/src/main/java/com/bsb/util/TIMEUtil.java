package com.bsb.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TIMEUtil {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date TimestampToDate(Timestamp timestamp) {
        long time = timestamp.getTime();
        String strTime = simpleDateFormat.format(time);
        return new Date(strTime);
    }
}
