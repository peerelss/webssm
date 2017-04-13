package com.kevin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 17-3-27.
 */
public class Shell {
    public static void main(String[] args){
        List<String> list=new ArrayList();
        list.add("1");
        list.add("2");
        for(int i=0;i<list.size();i++){
            if(list.get(i).endsWith("1")){
                list.remove(i);
            }
        }
    }
}
