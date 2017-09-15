package com.kevin.tumblr;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by root on 17-3-27.
 */
public class GetTumblrImage {
    public static String fileName="bigpunisher2b_json1";
    public static void main(String[] args) {
        for(int i=0;i<=100;i++){
            requestByGetMethod(i*10);
        }
    }
    public static void getDirectHtml(int i){
        CloseableHttpClient httpClient = getHttpClient();
        HttpHost proxy=new HttpHost("127.0.0.1",1080);
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        try{
            HttpGet get = new HttpGet("http://"+fileName+".tumblr.com/page/"+i);
            CloseableHttpResponse httpResponse = null;
            //发送get请求
            httpResponse = httpClient.execute(get);
            httpResponse = httpClient.execute(get);
            try{
                //response实体
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity){
               /*     System.out.println("响应状态码:"+ httpResponse.getStatusLine());
                    System.out.println("-------------------------------------------------");
                    System.out.println("响应内容:" + EntityUtils.toString(entity));
                    System.out.println("-------------------------------------------------");*/
                  //  TumbrJsonUtil.getImageUrlFromHtml(EntityUtils.toString(entity),null);
                    //    TumbrJsonUtil.putStringToTxt("strphose",EntityUtils.toString(entity));
                }
            }
            finally{
                httpResponse.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void requestByGetMethod(int i){
       /* if(TumbrJsonUtil.count==0){
            System.out.println("end ,and page = "+i);
            return;
        }*/
        System.out.println("page = "+i);
        //创建默认的httpClient实例
        CloseableHttpClient httpClient = getHttpClient();
        HttpHost proxy=new HttpHost("127.0.0.1",1080);
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        try {
            //用get方法发送http请求
            HttpGet get = new HttpGet("https://www.tumblr.com/svc/indash_blog?tumblelog_name_or_id=bigpunisher2b&post_id=&limit=10&offset=10&should_bypass_safemode=false");
            get.addHeader("Cookie",
                    "tmgioct=5861cb47b424f30747288660; rxx=c5xo455p98g.kekn23d&v=1; _ga=GA1.2.1543028043.1482804043; yx=59ucnvgp63vdo%26o%3D3%26f%3Dyu; __utma=189990958.1543028043.1482804043.1482892386.1494663601.6; __utmz=189990958.1494663601.6.6.utmcsr=beautiful-women-profiles.tumblr.com|utmccn=(referral)|utmcmd=referral|utmcct=/post/63393241654/bianca-beauchamp-aka-queen-of-latex-featured-in-my; language=%2Czh_CN; anon_id=MLSJFMDMRQTHXYAJGUYLSTKGVEZPKYXK; logged_in=1; pfp=4XipYCZOVWnPkvAdyNEYPerJO9nU9gzw3Yo1mJB2; pfs=mbWxYRTdvOlfIUv2AuhAQYZe6Uc; pfe=1506763822; pfu=220366685; __utmc=189990958; capture=u3NaZqO5AnmbCTlVv6YTS5tb8; pfx=6d8a124e69d7040f5a284300c50ac7ced1c8a9db4ad112f49898afd11564ea06%230%239412220959; nts=false; devicePixelRatio=1; documentWidth=1907");
            get.addHeader("Accept",
                    "application/json, text/javascript, */*; q=0.01");

            get.addHeader("Accept-Language",
                    "en-US,en;q=0.5 --compressed");
            get.addHeader("Connection",
                    "keep-alive");
            get.addHeader("Host",
                    "www.tumblr.com");
            get.addHeader("Referer",
                    "https://www.tumblr.com/dashboard/blog/bigpunisher2b");
            get.addHeader("Host",
                    "www.tumblr.com");
            get.addHeader("X-Requested-With",
                    "XMLHttpRequest");
            get.addHeader("User-Agent",
                    "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:52.0) Gecko/20100101 Firefox/52.0");
            get.addHeader("X-tumblr-form-key",
                    "u3NaZqO5AnmbCTlVv6YTS5tb8");
            get.setConfig(config);

            //    System.out.println("执行get请求:...."+get.getURI());
            CloseableHttpResponse httpResponse = null;
            //发送get请求
            httpResponse = httpClient.execute(get);
            try{
                //response实体
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity){
               /*     System.out.println("响应状态码:"+ httpResponse.getStatusLine());
                    System.out.println("-------------------------------------------------");
                    System.out.println("响应内容:" + EntityUtils.toString(entity));
                    System.out.println("-------------------------------------------------");*/
               System.out.println(EntityUtils.toString(entity));
                  //  TumbrJsonUtil.getImageUrlFromJson(EntityUtils.toString(entity),null);
                    //    TumbrJsonUtil.putStringToTxt("strphose",EntityUtils.toString(entity));
                }
            }
            finally{
                httpResponse.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                closeHttpClient(httpClient);
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }
    private static CloseableHttpClient getHttpClient(){
        return HttpClients.createDefault();
    }

    private static void  closeHttpClient(CloseableHttpClient client) throws IOException{
        if (client != null){
            client.close();
        }
    }
}
