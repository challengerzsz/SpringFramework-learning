import com.bsb.mapper.RoleMapper;
import com.bsb.model.Role;
import com.bsb.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;


public class Test {

//    private static ApplicationContext applicationContext;
//
//    static {
//        applicationContext = new ClassPathXmlApplicationContext("classpath*:config/applicationContext.xml");
//    }
//
//    public static void main(String[] args) {
//        RoleMapper mapper = (RoleMapper) applicationContext.getBean("RoleMapper");
//        System.out.println("获取user");
//        Role user = mapper.selectByName("zsz");
//        System.out.println(user.getId() + "username:" + user.getUsername() + "pwd:" + user.getPassword());
//    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Test.class);
        SqlSession sqlSession = null;


        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            System.out.println(role.getRoleName());
            logger.info(role.getRoleName());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
