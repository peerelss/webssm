package com.kevin.mybatis.main;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by root on 17-4-13.
 */
public class Foo implements Serializable {
    public Foo(){

    }
    int i=0;
    Point2D.Double mDouble=new Point2D.Double();
    City mCity=new City();
    byte[] mBytes={0,0};

    @Override
    public String toString() {
        return "Foo{" +
                "i=" + i +
                ", mDouble=" + mDouble +
                ", mCity=" + mCity +
                ", mBytes=" + Arrays.toString(mBytes) +
                '}';
    }


    class Bar {
        String str="str";
    }
}
class City implements Serializable{
    String name="cn";
}

