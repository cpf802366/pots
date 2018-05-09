package com.reco.cn.util;

import java.util.List;

/**
 * Created by cpf on 2018/5/9.
 */
public class NotEmptyUtil {

    public static  boolean  listEmpty(List  obj){
        if (obj != null && obj.size()>0){
            return  true;
        }else{
            return  false;
        }
    }
}
