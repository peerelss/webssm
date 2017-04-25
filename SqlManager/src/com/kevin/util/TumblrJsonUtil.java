package com.kevin.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.util.TextUtils;

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
    public static String getStringFromTxt(String file,String filter){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null&&s.contains(filter)){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();

    }
    public static void getStringFilterFromTxt(String file,String filter){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                if(s.contains(filter)){
                    System.out.println(formatString(s));
                }
            }
            br.close();
        }catch(Exception e) {

        }
    }
    public static void getImageUrlFromJson(String json){
        if(TextUtils.isEmpty(json)){
            json=getStringFromTxt("E:/tumblr/strumpfhose-pumpesjson.txt");
        }
        try{
            JSONObject jsonObject= JSON.parseObject(json);
            //    System.out.println(json.toString());
            JSONObject response=jsonObject.getJSONObject("response");
            JSONArray posts=response.getJSONArray("posts");
            for(Object o:posts){
                getPhotosFromO(o.toString());
            }
           /* if(!TextUtils.isEmpty(TumblrImagesManager.getInstance().getsFileName())&&!TextUtils.isEmpty(result)){
                putStringToTxt(TumblrImagesManager.getInstance().getsFileName(),result+"\n");
            }*/

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  static void getPhotosFromO(String o){
        JSONObject post=JSON.parseObject(o.toString());
        if(post.containsKey("photos")) {
            JSONArray photos=post.getJSONArray("photos");
            for(Object ob:photos){
                getPhotoFromAlt(ob.toString());
            }
        }else {
            return;
        }
        if(post.containsKey("photoset_photos")) {
            JSONArray photosets=post.getJSONArray("photoset_photos");
            for(Object obs:photosets){
                JSONObject js=JSON.parseObject(obs.toString());
                String jsStr=js.get("high_res").toString();
                if(!TextUtils.isEmpty(jsStr)){
                    System.out.println(jsStr);
                }

            }
        }
    }
    public static void getPhotoFromAlt(String alt){
        JSONObject js=JSON.parseObject(alt);
        JSONObject jsS=js.getJSONObject("original_size");
        String jsStr=jsS.get("url").toString();
        System.out.println(jsStr);
    }
    public static String formatString(String s){
        if(s==null||s.equals("")){
            return "";
        }else {
            s = s.replace("500.jpg", "1280.jpg");
            s = s.replace("540.jpg", "1280.jpg");
            s = s.replace("400.jpg", "1280.jpg");
            s = s.replace("250.jpg", "1280.jpg");
            s = s.replace("250.gif", "400.gif");
        }
        return s;
    }
}
