package com.heitian.ssm.learn.test;

/**
 * Created by root on 17-3-2.
 */
public class Test {
    public static void main(String[] args) {
        PeopleTalk peopleTalk = (PeopleTalk) new CglibProxy().getInstance(new PeopleTalk());
        peopleTalk.talk("业务方法");
        peopleTalk.talk("业务方法");
    }
}
