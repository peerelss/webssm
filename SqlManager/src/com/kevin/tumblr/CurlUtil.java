package com.kevin.tumblr;


import com.kevin.util.TumblrJsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by root on 17-2-21.
 */
public class CurlUtil {
    public static String getStringFromCurl(String url,String fileName){

        String []cmds = {"curl"
                ,"-x","127.0.0.1:1080"
                ,"-o"+fileName
              //  ,url
                , "https://www.tumblr.com/svc/indash_blog?tumblelog_name_or_id=bigpunisher2b&post_id=&limit=10&offset="+url+"&should_bypass_safemode=false"
                , "-H","Host: www.tumblr.com"
                , "-H","User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:52.0) Gecko/20100101 Firefox/52.0"
                , "-H","Accept: application/json, text/javascript, */*; q=0.01"
                , "-H","Accept-Language: en-US,en;q=0.5' --compressed"
                , "-H","X-tumblr-form-key: u3NaZqO5AnmbCTlVv6YTS5tb8"
                , "-H","X-Requested-With: XMLHttpRequest"
                , "-H","Referer: https://www.tumblr.com/dashboard/blog/bigpunisher2b"
                , "-H","Cookie: tmgioct=5861cb47b424f30747288660; rxx=c5xo455p98g.kekn23d&v=1; _ga=GA1.2.1543028043.1482804043; yx=59ucnvgp63vdo%26o%3D3%26f%3Dyu; __utma=189990958.1543028043.1482804043.1482892386.1494663601.6; __utmz=189990958.1494663601.6.6.utmcsr=beautiful-women-profiles.tumblr.com|utmccn=(referral)|utmcmd=referral|utmcct=/post/63393241654/bianca-beauchamp-aka-queen-of-latex-featured-in-my; pfp=2jdsRSLcCB1dsu7SFuvAoV8vMgMTb36oyIuPVD1r; pfs=wYARlm9YRt5bZc226EsU9wkNzQI; pfe=1498360616; pfu=220366685; language=%2Czh_CN; logged_in=1; anon_id=MXPIOLUVAZTPKZSQWQIACCLUDECQUOWG; __utmc=189990958; capture=u3NaZqO5AnmbCTlVv6YTS5tb8; nts=false"
                , "-H","Connection: keep-alive"
        };
        ProcessBuilder pb=new ProcessBuilder(cmds);
        pb.redirectErrorStream(true);
        Process p;
        try {
            p = pb.start();
            BufferedReader br=null;
            String line=null;

            br=new BufferedReader(new InputStreamReader(p.getInputStream()));
            String result=getStringFromBuffer(br);
            br.close();
            return result;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }
    }
    public static void main(String[] args) {
       /* String []cmds = {"curl", "-l","-o baidu.html","http://www.baidu.com"};
        ProcessBuilder pb=new ProcessBuilder(cmds);
        pb.redirectErrorStream(true);
        Process p;
        try {
            p = pb.start();
            BufferedReader br=null;
            String line=null;

            br=new BufferedReader(new InputStreamReader(p.getInputStream()));
            while((line=br.readLine())!=null){
                System.out.println("\t"+line);
            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        for(int i=0;i<20;i++){
            getStringFromCurl(i*10+"","baidu3.html");
            String result = TumblrJsonUtil.getStringFromTxt("baidu3.html");
            TumblrJsonUtil.getImageUrlFromJson(result);
        }
       // TumblrJsonUtil.getStringFilterFromTxt("/media/kevin/SWAP/java/big0417.txt","tumblr");
       // System.out.println(result);
    }
    public static String getStringFromBuffer(BufferedReader br){
        try{
            String result="",line="";
            while((line=br.readLine())!=null){
                /*if(line.contains("{")){
                    if(line.startsWith("\"")){
                        result=result+line;
                    }else {
                        result=result+line.substring(line.indexOf("{"));
                    }
                }*/
                System.out.println(line);
                result=result+line;
            }
            System.out.println(result);
            return  result;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
