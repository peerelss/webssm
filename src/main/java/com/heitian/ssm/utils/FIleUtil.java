package com.heitian.ssm.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-3-8.
 */
public class FIleUtil {
    public static ArrayList<String> getStringListFromTxt(String fileName){
        ArrayList<String> arrayList=new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                 arrayList.add(s);
            }
            br.close();
            return arrayList;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
