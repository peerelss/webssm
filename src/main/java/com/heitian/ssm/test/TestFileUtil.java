package com.heitian.ssm.test;

import com.heitian.ssm.utils.FIleUtil;
import com.heitian.ssm.utils.StringUtil;

import javax.swing.plaf.TextUI;
import javax.xml.soap.Text;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by root on 17-3-8.
 */
public class TestFileUtil {
    public static String FILE_NAME="/media/kevin/SWAP/tumblr.txt";
    public static void main(String[] args){
        ArrayList<String> strings= FIleUtil.getStringListFromTxt(FILE_NAME);
        if(strings==null){
            return;
        }
        /*if(strings!=null){
            for(String str:strings){
                System.out.println(str);
            }
        }*/
       /* List<String> result=strings.stream().filter(a->a.contains("tumblr.com")&&a.contains("google")).collect(Collectors.toList());
        if(result!=null){
            for(String str:result){
                System.out.println(StringUtil.patternTumblr(str))*//*.substring(str.lastIndexOf("http"),str.lastIndexOf("tumblr.com")+8)*//*;
            }
        }*/
        /*List<String> strings1=strings.stream().filter(a->a.contains("tumblr.com")&&!a.contains("google")).collect(Collectors.toList());
        if(strings1!=null){
            for(String str:strings1){
                System.out.println(StringUtil.patternTumblr(str))*//*.substring(str.lastIndexOf("http"),str.lastIndexOf("tumblr.com")+8)*//*;
            }
        }*/
        List<String> strings1=strings.stream().filter(a->a.contains("tumblr.com")).collect(Collectors.toList());
        Map<String,Boolean> stringBooleanMap=new HashMap<>();
        if(strings1!=null){
            for(String str:strings1){
                String string=StringUtil.patternTumblr(str);
                if(string!=null&&!"".equals(string)) {
                    stringBooleanMap.put(StringUtil.patternTumblr(str), true);
                }
            }
        }

        Iterator iter = stringBooleanMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String)entry.getKey();
            System.out.println(key);
        }

    }
}
