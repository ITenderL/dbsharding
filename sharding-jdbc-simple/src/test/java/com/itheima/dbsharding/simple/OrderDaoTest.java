package com.itheima.dbsharding.simple;

import com.itheima.dbsharding.simple.dao.DictDao;
import com.itheima.dbsharding.simple.dao.OrderDao;
import com.itheima.dbsharding.simple.dao.UserDao;
import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ShardingJdbcSimpleBootstrap.class})
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private DictDao dictDao;

    /**
     * 新增订单
     */
    @Test
    public void testInsertOrder(){
        for(int i=1;i<20;i++){
            orderDao.insertOrder(new BigDecimal(i),2L,"SUCCESS");
        }
            //orderDao.insertOrder(new BigDecimal(11),1L,"SUCCESS");
    }

    @Test
    public void testSelectOrderbyIds(){
        List<Long> ids = new ArrayList<>();
        ids.add(611678737271881728L);
        ids.add(611678736760176641L);
        //ids.add(611677851673952256L);
        //ids.add(611677851053195265L);

        List<Map> maps = orderDao.selectOrderbyIds(ids);
        System.out.println(maps);
    }

    @Test
    public void testSelectOrderbyUserAndIds(){
        List<Long> ids = new ArrayList<>();
        ids.add(611678737271881728L);
        ids.add(611678736760176641L);
        //ids.add(611677851673952256L);
        //ids.add(611677851053195265L);

        List<Map> maps = orderDao.selectOrderbyUserAndIds(2L,ids);
        System.out.println(maps);
    }

    @Test
    public void testInsertUser(){
        for (int i = 0 ; i < 10; i++){
            Long id = i + 1L;
            userDao.insertUser(id,"姓名"+ id );
        }
    }

    @Test
    public void testSelectUserbyIds(){
        List<Long> userIds = new ArrayList<>();
        userIds.add(1L);
        userIds.add(2L);
        List<Map> users = userDao.selectUserbyIds(userIds);
        System.out.println(users);
    }

    @Test
    public void testInsertDict(){
        dictDao.insertDict(1L,"user_type","0","管理员");
        dictDao.insertDict(2L,"user_type","1","操作员");
    }
    @Test
    public void testDeleteDict(){
        dictDao.deleteDict(1L);
        dictDao.deleteDict(2L);
    }

    @Test
    public void testSelectUserInfobyIds(){
        List<Long> userIds = new ArrayList<>();
        userIds.add(1L);
        userIds.add(2L);
        List<Map> users = userDao.selectUserInfobyIds(userIds);
        JSONArray jsonUsers = new JSONArray(users);
        System.out.println(jsonUsers);
    }

}
