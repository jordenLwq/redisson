package org.mvnsearch.spring.boot.redisson.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * redisson auto configuration tests
 *
 * @author jorden.li
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedissonDemoApplication.class)
public class RedissonAutoConfigurationTests {


    @Autowired
       RedissonClient redissonClient;
    /**
     * 分布式锁
     */
    private  static final  String REDISLOCK_="redisLock_";


    @Test
    public  void testRedisson() throws Exception {


                    System.out.println("redissonClient:"+redissonClient);

                    String key = REDISLOCK_ + "test123";

                    RLock mylock = redissonClient.getLock(key);
                    mylock.lock(2, TimeUnit.MINUTES);
                    //lock提供带timeout参数，timeout结束强制解锁，防止死锁
                    System.err.println("======lock======"+Thread.currentThread().getName());


                    redissonClient.getLock(key).unlock();
                    System.err.println("======unlock======"+Thread.currentThread().getName());


    }






}
