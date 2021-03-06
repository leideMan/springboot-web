package org.leijie.redis.sublis;

import redis.clients.jedis.Jedis;

/**
 * Created with IDEA
 * User: LEIJIE
 * Date: 2017/7/18 0018
 * Time: 16:08
 */
//发布消息
public class Publisher {
    public void publish(final Jedis redisClient) {
        new Thread(new Runnable() {
            @SuppressWarnings("static-access")
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("发布：log");
                redisClient.publish("log.debug", "log is debug.");
                redisClient.publish("log.info", "log is info.");
                redisClient.publish("log.error", "log is error.");
            }
        }).start();
    }
}