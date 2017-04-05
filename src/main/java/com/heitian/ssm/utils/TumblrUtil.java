package com.heitian.ssm.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-4-5.
 */
public class TumblrUtil {

    public static List<String> getListFromString(String str){
        if(str==null){
            return null;
        }
        List<String> list=new ArrayList<>();
        if(str.contains(",")){
            String[] strings=str.split(",");
            for(int i=0;i<strings.length;i++){
                if(strings[i]!=null&&!"".equals(strings[i])){
                    list.add(strings[i]);
                }
            }
            return list;
        }
        list.add(str);
        return list;
    }
}
