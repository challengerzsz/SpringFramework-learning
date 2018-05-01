import com.bsb.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

public class RedisTest {
    public static void main(String[] args) {

        //使用PoolConfig获取Redis的连接，然后计算每秒能进行的存操作
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        //最大空闲数量
//        jedisPoolConfig.setMaxIdle(50);
//        //最大连接数
//        jedisPoolConfig.setMaxTotal(100);
//        //最大等待毫秒数
//        jedisPoolConfig.setMaxWaitMillis(20000);
//        //使用配置创建连接池
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost");
//
//        //从连接池获取连接
//        Jedis jedis = jedisPool.getResource();
//        int i = 0;
//        try {
//            long start = System.currentTimeMillis();//开始毫秒数
//            while (true) {
//                long end = System.currentTimeMillis();
//                if (end - start >= 1000) {
//                    break;
//                }
//                i++;
//                jedis.set("test" + i, i + "");
//            }
//        } finally {
//            jedis.close();
//        }
//
//        System.out.println("每秒" + i + "次");

        //使用RedisTemplate操作存储一个对象到Redis
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
//        User user = new User();
//        user.setUsername("testRedis");
//        user.setId(50);
//        user.setPassword("123456");
//        redisTemplate.opsForValue().set("user1", user);
//        User user1 = (User) redisTemplate.opsForValue().get("user1");
//        System.out.println(user1.getUsername() + user1.getPassword());

        //使用SessionCallBack接口 保证get/set方法都来自于一个连接
//        final User user = new User();
//        user.setUsername("testRedis");
//        SessionCallback callback = new SessionCallback<User>() {
//            @Override
//            public User execute(RedisOperations redisOperations) throws DataAccessException {
//                redisOperations.boundValueOps("user1").set(user);
//                return (User) redisOperations.boundValueOps("user1").get();
//            }
//        };
//        User user1 = (User) redisTemplate.execute(callback);
//        System.out.println(user1.getUsername());

        //测试Redis字符串操作
//        redisTemplate.opsForValue().set("key1", "value1");
//        redisTemplate.opsForValue().set("key2", "value2");
//
//        String value1 = (String) redisTemplate.opsForValue().get("key1");
//        System.out.println(value1);
//
//        //删除key值
//        redisTemplate.delete("key1");
//        Long length = redisTemplate.opsForValue().size("key2");
//        System.out.println(length);


        //操作hash结构
        String key = "hash";
        Map<String,String> map = new HashMap<>();
        map.put("f1", "val1");
        map.put("f2", "val2");
        //相当于hmset
        redisTemplate.opsForHash().putAll(key, map);
        //相当于hset
        redisTemplate.opsForHash().put(key, "f3", "6");
        printValueForHash(redisTemplate, key, "f3");
    }

    private static void printValueForHash(RedisTemplate redisTemplate, String key, String field) {
        //相当于hget
        Object value = redisTemplate.opsForHash().get(key, field);
        System.out.println(value);
    }
}
