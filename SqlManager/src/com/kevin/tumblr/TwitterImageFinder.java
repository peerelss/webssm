package com.kevin.tumblr;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kevin.util.TumblrJsonUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.kevin.tumblr.CurlUtilBigPunisher.runShell;
import static com.kevin.util.StringConstant.*;
import static com.kevin.util.StringContentDA.*;

/**
 * Created by root on 17-9-6.
 */
public class TwitterImageFinder {

    public static String FILE = "baidu1.html";
    public static String INIT_MIN = "755687637755817985";
    public static List<String> list=new ArrayList<>();
    public static void main(String[] args) {
       //   getPicUrlFromJson();
       /* for (int i = 1; i <= 200; i++) {
            String result = getPicUrlFromAD(i*24);
            if (result.equals("false")) {
                System.out.println(" end");
                break;
            }else {
                System.out.println(" goon page = "+i);
            }
        }*/
        geUrlByHtml();
    }
    public static void getTumlbrPage(int i){

    }
    public static void geUrlByHtml(){
     //   String str = TumblrJsonUtil.getStringFromTxt(FILE);
        try {
            String str = TumblrJsonUtil.getStringFromTxt("/media/kevin/SWAP/java/curl/baidu1.html");
       //     System.out.println("html = "+str);
            Document document = Jsoup.parse(str);
            Elements elements = document.getElementsByTag("img");
            for (Element element : elements) {
                String imgSrc = element.attr("abs:src");
                if(!imgSrc.contains("avatar")) {
                    System.out.println(imgSrc);
                }
            }
        }catch (Exception e){

        }

    }
    public static String getPicUrlFromAD(int index) {
        String cmd = DA_CELE1.replace("TAG_INDEX_PAGE_UNKNOWN", index + "");
        try {
            runShell(cmd);
            String str = TumblrJsonUtil.getStringFromTxt(FILE);
            JSONObject jsonObject = JSON.parseObject(str);
            JSONObject contentJson = jsonObject.getJSONObject("content");
            String result=contentJson.getString("has_more");
            System.out.println(" has_more = " +result);
            JSONArray jsonArray = contentJson.getJSONArray("results");
            int i = 0;
            for (Object html : jsonArray) {
                JSONObject jsonObject1 = JSON.parseObject(html.toString());
                String htmlStr = jsonObject1.getString("html");
                Document document = Jsoup.parse(htmlStr);
                Elements elements1 = document.getElementsByClass("thumb");
                for (Element element : elements1) {
                    String imgSrc = element.attr("data-super-full-img");

                        list.add(imgSrc);
                        System.out.println(imgSrc);
                        i++;

                }

            }
            System.out.println("offset = "+(index)+" count = " + i);
            return result;
        } catch (Exception e) {
            System.out.println(" error  i = "+index);
            return "error";
        }
    }

    public static void getPicUrlFromJson() {
        try {
            String cmd = TWITTER_LATEX_DARK.replace("TAG_INDEX_PAGE_UNKNOWN", INIT_MIN);
            runShell(cmd);
            String str = TumblrJsonUtil.getStringFromTxt(FILE);
            if (null != str) {
                JSONObject jsonObject = JSON.parseObject(str);
             //   JSONObject jsonObject=jsonObject1.getJSONObject("inner");
                INIT_MIN = jsonObject.getString("min_position");
                System.out.println(" INIT_MIN = " + INIT_MIN);
                String s = jsonObject.getString("items_html");
                Document document = Jsoup.parse(s);
                Elements elements = document.getElementsByTag("img");
                int i = 0;
                for (Element element : elements) {
                    String imgSrc = element.attr("abs:src");
                    if (!imgSrc.contains("bigger")&&!imgSrc.contains("emoji")) {
                        System.out.println(imgSrc.replace(".thumb.jpg", ""));
                        i++;
                    }
                }
                System.out.println(" i =  " + i);
                int count = jsonObject.getInteger("new_latent_count");
                if (count > 10) {
                    getPicUrlFromJson();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
