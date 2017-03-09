package com.heitian.ssm.utils;

import com.heitian.ssm.model.TumblrModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-3-9.
 */
public class ClassUtil {
    public static String tumblrModel2String(TumblrModel tumblrModel){
        return tumblrModel.getName()+","+tumblrModel.getTags()+","+tumblrModel.getLevel();
    }
    public static List<String> tumblrModelList2StringList(List<TumblrModel> list){
        if(list==null){
            return new ArrayList<String>();
        }else {
            ArrayList<String> strings=new ArrayList<>();
            for(TumblrModel tumblrModel:list){
                strings.add(tumblrModel2String(tumblrModel));
            }
            return strings;
        }
    }
}
