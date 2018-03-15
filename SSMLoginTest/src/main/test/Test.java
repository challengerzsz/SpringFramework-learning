import com.bsb.dao.IUserDao;
import com.bsb.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;


public class Test {

//    private static ApplicationContext applicationContext;
//
//    static {
//        applicationContext = new ClassPathXmlApplicationContext("classpath*:config/applicationContext.xml");
//    }
//
//    public static void main(String[] args) {
//        IUserDao mapper = (IUserDao) applicationContext.getBean("IUserDao");
//        System.out.println("获取user");
//        User user = mapper.selectByName("zsz");
//        System.out.println(user.getId() + "username:" + user.getUsername() + "pwd:" + user.getPassword());
//    }

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = null;
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
