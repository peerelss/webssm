package com.heitian.ssm.utils;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by root on 17-3-8.
 */
public class StringUtil {
    public static String getTumblrUrlFromGoogle(String googleUrl){
        if(googleUrl.contains("http:")&&googleUrl.contains("tumblr.com")){
            googleUrl=googleUrl.substring(googleUrl.lastIndexOf("http:"),googleUrl.lastIndexOf("tumblr.com")+10);
            return googleUrl;
        }else {
            return "";
        }
    }
    public static String patternTumblr(String url){
       url=url.replace("https://www.google.com","").replace("t.tumblr.com","");
       return getTumblrUrlFromGoogle(url);
    }
    public static String list2String(List<String> list){
        if(list==null||list.size()==0){
            return "";
        }
        StringBuffer bf=new StringBuffer();
        for(String s:list){
            bf.append(s+"\n");
        }
        return bf.toString();
    }
}
