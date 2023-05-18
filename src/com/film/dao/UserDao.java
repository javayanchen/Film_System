package com.film.dao;

import com.film.pojo.Role;
import com.film.pojo.User;

import java.util.List;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 9:20
 */
public interface UserDao {
    User login(String username, String password) ;
    boolean register(User user);
    boolean exsit(String user_name);
   int getCount(String user_name);
    List<User> getUser(int index, int size,String user_name);
    //俢改对账号密码邮箱状态进行修改
    boolean modify(User user);
    //根据id进行删除
    boolean deleteUser(int user_id);
    int delAll(String  ids);
    User getUserById(String user_id);

    public List getInfoForEcharts();

    public List<Integer> verifyIds(String ids);

}
