package cn.ppj.sptdruiddemo;

import cn.ppj.sptdruiddemo.dao.UserDao;
import cn.ppj.sptdruiddemo.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
class SptdruiddemoApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        //增
//        User user = new User();
//        user.setUsername("pjj");
//        user.setTruename("潘俊杰");
//        userDao.add(user);

        //删
//        userDao.delete(7);

        //查
        User user = userDao.get(6);
        System.out.println(user);
        //改
        user.setTruename("hj");
        userDao.update(user);
    }

}
