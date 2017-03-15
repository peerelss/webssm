package com.heitian.ssm.utils;

import java.io.*;
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
    public static void putStringToTxt(String name ,String content) {
        if(content==null){
            return;
        }
        System.out.println(" file = "+name);
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            File f=new File(name);
            if(!f.exists()){
                f.createNewFile();
            }
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
