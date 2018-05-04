package com.reco.cn.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cpf on 2018/4/26.
 */
public class ToolConverter {
    /**


     * @return
     */
    public static String strDate(){
        Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            return  sdf.format(date);

    }
    public static String strDate( Date date){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH ");
        return  sdf.format(date);

    }
}
