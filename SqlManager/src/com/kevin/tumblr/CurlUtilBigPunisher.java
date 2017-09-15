package com.kevin.tumblr;

import com.kevin.util.TumblrJsonUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-8-23.
 */
public class CurlUtilBigPunisher {
    public static String CURL_STRING = "curl -o 'baidu.html' -x '127.0.0.1:1080' 'https://www.tumblr.com/svc/indash_blog?tumblelog_name_or_id=bigpunisher2b&post_id=&limit=10&offset=INDEX_PAGE&should_bypass_safemode=false' -H 'Host: www.tumblr.com' -H 'User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:52.0) Gecko/20100101 Firefox/52.0' -H 'Accept: application/json, text/javascript, */*; q=0.01' -H 'Accept-Language: en-US,en;q=0.5' --compressed -H 'X-tumblr-form-key: u3NaZqO5AnmbCTlVv6YTS5tb8' -H 'X-Requested-With: XMLHttpRequest' -H 'Referer: https://www.tumblr.com/dashboard/blog/bigpunisher2b' -H 'Cookie: tmgioct=5861cb47b424f30747288660; rxx=c5xo455p98g.kekn23d&v=1; _ga=GA1.2.1543028043.1482804043; yx=59ucnvgp63vdo%26o%3D3%26f%3Dyu; __utma=189990958.1543028043.1482804043.1482892386.1494663601.6; __utmz=189990958.1494663601.6.6.utmcsr=beautiful-women-profiles.tumblr.com|utmccn=(referral)|utmcmd=referral|utmcct=/post/63393241654/bianca-beauchamp-aka-queen-of-latex-featured-in-my; language=%2Czh_CN; anon_id=MLSJFMDMRQTHXYAJGUYLSTKGVEZPKYXK; logged_in=1; pfp=4XipYCZOVWnPkvAdyNEYPerJO9nU9gzw3Yo1mJB2; pfs=mbWxYRTdvOlfIUv2AuhAQYZe6Uc; pfe=1506763822; pfu=220366685; __utmc=189990958; capture=u3NaZqO5AnmbCTlVv6YTS5tb8; nts=false; devicePixelRatio=1; documentWidth=1800; pfx=795bba77b381938cd79b03d43384fb07dbc2176205df471ee369558891a6acf1%230%234697250423' -H 'Connection: keep-alive'";
    public static String CURL_WOAI = "curl -o 'woai.html' 'http://www.woaikb.com/home.php?mod=space&do=album&view=all&catid=8&page=INDEX_PAGE' -H 'Host: www.woaikb.com' -H 'User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:52.0) Gecko/20100101 Firefox/52.0' -H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8' -H 'Accept-Language: en-US,en;q=0.5' --compressed -H 'Referer: http://www.woaikb.com/home.php?mod=space&do=album&catid=8&view=all' -H 'Cookie: lu18_2132_saltkey=xfK1U5mZ; lu18_2132_lastvisit=1504701355; lu18_2132_sid=x1mzLZ; lu18_2132_lastact=1504704975%09home.php%09space; lu18_2132_st_p=0%7C1504704963%7Ca22e2cded24d7e2953a8b6735eff7174; lu18_2132_visitedfid=169D227; lu18_2132_viewid=tid_13131; lu18_2132_sendmail=1' -H 'Connection: keep-alive' -H 'Upgrade-Insecure-Requests: 1'";
    public static String CURL_PIC = "curl -o 'woai.html' 'INDEX_PAGE' -H 'Host: www.woaikb.com' -H 'User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:52.0) Gecko/20100101 Firefox/52.0' -H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8' -H 'Accept-Language: en-US,en;q=0.5' --compressed -H 'Referer: http://www.woaikb.com/home.php?mod=space&do=album&view=all&catid=8&page=2' -H 'Cookie: lu18_2132_saltkey=xfK1U5mZ; lu18_2132_lastvisit=1504701355; lu18_2132_sid=x1mzLZ; lu18_2132_lastact=1504706094%09home.php%09misc; lu18_2132_st_p=0%7C1504704963%7Ca22e2cded24d7e2953a8b6735eff7174; lu18_2132_visitedfid=169D227; lu18_2132_viewid=tid_13131; lu18_2132_sendmail=1' -H 'Connection: keep-alive' -H 'Upgrade-Insecure-Requests: 1' -H 'Cache-Control: max-age=0'";
    public static String INDEX = "INDEX_PAGE";

    public static void main(String[] args) {
        getTumblr();
    }
    public static void getUrl(){

        try{
            BufferedReader br = new BufferedReader(new FileReader("/media/kevin/SWAP/ssm/webssm/url.txt"));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                System.out.println(s);
                getPicFromHtml(s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void getWoai() {
        List<String> list = new ArrayList<>();
        try {
            for (int i =1; i <= 6; i++) {
                String cmd = CURL_WOAI.replace(INDEX, i + "");
                System.out.println("index = " + i);
                runShell(cmd);
                String result = TumblrJsonUtil.getStringFromTxt("/media/kevin/SWAP/ssm/webssm/woai.html");
                //TumblrJsonUtil.getImageUrlFromJson(result);
                Document document = Jsoup.parse(result);
                Elements elements = document.getElementsByClass("c");
                for (Element element : elements) {
                    Elements links = element.select("a[href]");
                    String str = links.attr("href");
                    System.out.println(str);
                    list.add(str);
                }
            }
           /* for(String str:list){
                getPicFromHtml(str);
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getPicFromHtml(String url) {
        try {
            System.out.println(" url = "+url);
            String cmd = CURL_PIC.replace(INDEX, url);
            runShell(cmd);
            String result = TumblrJsonUtil.getStringFromTxt("/media/kevin/SWAP/ssm/webssm/woai.html");
            Document document = Jsoup.parse(result);
            Elements elements = document.getElementsByTag("img");
            for(Element element:elements){
                String imgSrc = element.attr("abs:src");
                if(imgSrc.contains(".thumb.jpg")){
                    System.out.println(imgSrc.replace(".thumb.jpg",""));
                }

            }
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getTumblr() {
        try {
            for (int i = 27; i < 40; i++) {
                String cmd = CURL_STRING.replace(INDEX, (i * 10) + "");
                System.out.println("index = " + i);
                runShell(cmd);
                String result = TumblrJsonUtil.getStringFromTxt("/media/kevin/SWAP/ssm/webssm/baidu.html");
                TumblrJsonUtil.getImageUrlFromJson(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<String> runShell(String shStr) throws Exception {
        List<String> strList = new ArrayList();

        Process process;
        process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", shStr}, null, null);

        InputStreamReader ir = new InputStreamReader(process
                .getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        String line;
        process.waitFor();
        while ((line = input.readLine()) != null) {
            strList.add(line);
        }

        return strList;
    }

}
