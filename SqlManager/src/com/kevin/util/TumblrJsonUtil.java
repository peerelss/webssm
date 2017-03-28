package com.kevin.util;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by root on 17-3-28.
 */
public class TumblrJsonUtil {
    public static String getStringFromTxt(String file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();

    }
}
