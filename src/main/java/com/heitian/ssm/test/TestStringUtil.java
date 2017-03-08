package com.heitian.ssm.test;

import com.heitian.ssm.utils.StringUtil;

/**
 * Created by root on 17-3-8.
 */
public class TestStringUtil {
    public static void main(String[] args){
        String url="https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=4&cad=rja&uact=8&ved=0ahUKEwj7l_SJz77SAhVX82MKHQS-D8cQFggzMAM&url=http://Fthegreatnnn.tumblr.com%2F&usg=AFQjCNGyr6kVzkwtpiDI0Iss3X8rBLbhiw&sig2=TvEQtDw0ZBmepFH9tceuyw";
        String result=StringUtil.patternTumblr(url);
        System.out.println("url = "+result);
    }
}
