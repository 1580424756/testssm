package com.ssm.conversion;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConveter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {

        try {
            if (s != null) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return dateFormat.parse(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
