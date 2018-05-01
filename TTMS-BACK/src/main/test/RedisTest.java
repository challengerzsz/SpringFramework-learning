import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {
    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大空闲数量
        jedisPoolConfig.setMaxIdle(50);
        //最大连接数
        jedisPoolConfig.setMaxTotal(100);
        //最大等待毫秒数
        jedisPoolConfig.setMaxWaitMillis(20000);
        //使用配置创建连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost");

        //从连接池获取连接
        Jedis jedis = jedisPool.getResource();
        int i = 0;
        try {
            long start = System.currentTimeMillis();//开始毫秒数
            while (true) {
                long end = System.currentTimeMillis();
                if (end - start >= 1000) {
                    break;
                }
                i++;
                jedis.set("test" + i, i + "");
            }
        } finally {
            jedis.close();
        }

        System.out.println("每秒" + i + "次");
    }
}
