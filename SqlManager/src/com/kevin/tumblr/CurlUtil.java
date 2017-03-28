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
                , "https://www.tumblr.com/svc/indash_blog/posts?tumblelog_name_or_id=bigpunisher2b&post_id=&limit=10&offset=10&should_bypass_safemode=false"
                , "-H","Host: www.tumblr.com"
                , "-H","User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:50.0) Gecko/20100101 Firefox/50.0"
                , "-H","Accept: application/json, text/javascript, */*; q=0.01"
                , "-H","Accept-Language: en-US,en;q=0.5' --compressed"
                , "-H","X-tumblr-form-key: u3NaZqO5AnmbCTlVv6YTS5tb8"
                , "-H","X-Requested-With: XMLHttpRequest"
                , "-H","X-Pinterest-ExperimentHash: 2546638680766220712"
                , "-H","Referer: https://www.tumblr.com/dashboard/blog/bigpunisher2b"
                , "-H","Cookie: tmgioct=5861cb47b424f30747288660; rxx=c5xo455p98g.kekn23d&v=1; _ga=GA1.2.1543028043.1482804043; anon_id=CYXBPBUFVSEQAQBRQIMEDLJTIMDIMBEV; yx=59ucnvgp63vdo%26o%3D3%26f%3Dyu; __utma=189990958.1543028043.1482804043.1482889002.1482892386.5; __utmz=189990958.1482892386.5.5.utmcsr=girlwiththegypsyheart.tumblr.com|utmccn=(referral)|utmcmd=referral|utmcct=/archive; pfp=2jdsRSLcCB1dsu7SFuvAoV8vMgMTb36oyIuPVD1r; pfs=wYARlm9YRt5bZc226EsU9wkNzQI; pfe=1498360616; pfu=220366685; language=%2Czh_CN; logged_in=1; nts=false; devicePixelRatio=1; documentWidth=1744; capture=u3NaZqO5AnmbCTlVv6YTS5tb8; __utmc=189990958' -H 'Connection: keep-alive"
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
        /*String []cmds = {"curl", "-l","-o baidu.html","http://www.baidu.com"};
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
        getStringFromCurl("","baidu.html");
        String result = TumblrJsonUtil.getStringFromTxt("../../../../baidu.html");

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
