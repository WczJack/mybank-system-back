package com.neuedu.mobilebank.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String dateFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = sdf.format(date);
        return str;
    }
}
