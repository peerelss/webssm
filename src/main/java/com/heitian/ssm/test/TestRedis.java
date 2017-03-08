package com.heitian.ssm.test;

/**
 * Created by kevin on 2017/3/6.
 */
import redis.clients.jedis.Jedis;

public class TestRedis {
    public static void main(String[] args){
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //check whether server is running or not
        jedis.set("tutorialname", "Redis tutorial");
        // Get the stored data and print it
        System.out.println("Stored string in redis:: "+ jedis.get("tutorialname"));
    }
}
