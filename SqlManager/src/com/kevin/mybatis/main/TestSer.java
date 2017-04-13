package com.kevin.mybatis.main;

import java.io.*;

/**
 * Created by root on 17-4-13.
 */
public class TestSer  {
    public static void main (String[] args)throws Exception{
        Foo f=new Foo();
        File file=new File("f.out");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(f);
        objectOutputStream.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject(); // 没有强制转换到Person类型
        oin.close();
        System.out.println(newPerson);
    }
}
