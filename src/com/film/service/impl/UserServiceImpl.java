package com.film.service.impl;

import com.film.dao.RoleDao;
import com.film.dao.UserDao;
import com.film.dao.impl.RoleDaoImpl;
import com.film.dao.impl.UserDaoImpl;
import com.film.pojo.Role;
import com.film.pojo.User;
import com.film.service.UserService;
import com.film.util.PageUtil;

import java.util.List;

/**
 * @author lzl
 * @version 1.0
 * @description: 用户登录注册服务
 * @date 2023/5/11 9:27
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    RoleDao roleDao = new RoleDaoImpl();

    /**
     * @description: 登录业务服务
     * @param: username
     * password
     * @return: com.film.pojo.User
     * @author 田际宝
     * @date: 2023/5/12 12:51
     */


    @Override
    public User login(String username, String password) {
        //调用Dao层登录状态验证方法，查询数据库是否存在此账号，存在则返回此账号对象，不存在则为null
        User user = userDao.login(username, password);
        //查询成功将此对象存入user中
        if (user != null) {
            Role role = new Role();
            //通过此账号对象中的RoleId查询到Role对象
            role = roleDao.getRoleById(user.getRole().getRoleId());
            user.setRole(role);
        }
        return user;
    }

    /**
     * @description: 用户注册业务
     * @param: user
     * @return: boolean
     * @author 田际宝
     * @date: 2023/5/12 12:52
     */


    @Override
    public boolean register(User user) {
        return userDao.register(user);
    }

    /**
     * @description: 多选删除业务
     * @param: ids
     * @return: boolean
     * @author 田际宝
     * @date: 2023/5/12 15:09
     */

    @Override
    public int delAll(String ids) {
        List<Integer> roleIdList = userDao.verifyIds(ids);
        for (int i = 0; i < roleIdList.size(); i++) {
            if (roleIdList.get(i) == 2) {
                return 0;
            }
        }
        return userDao.delAll(ids);
    }

    /**
     * @description: 查询数据库中是否存在此用户
     * @param: user_name
     * @return: boolean
     * @author 田际宝
     * @date: 2023/5/12 13:17
     */

    @Override
    public boolean exsit(String user_name) {
        return userDao.exsit(user_name);
    }

    /**
     * @description: 修改用户信息
     * @param: user
     * @return: boolean
     * @author
     * @date: 2023/5/12 14:35
     */

    @Override
    public boolean modify(User user) {
        return userDao.modify(user);
    }

    /**
     * @description: 逻辑删除用户
     * @param: user_id
     * @return: boolean
     * @author
     * @date: 2023/5/12 14:36
     */

    @Override
    public boolean deleteUser(int user_id) {
        return userDao.deleteUser(user_id);
    }
    /**
     * @description: 定义方法，参数为页码和每页大小
     * @param: index
     * size
     * @return: com.film.util.PageUtil<com.film.pojo.User>
     * @author 王煜洪
     * @date: 2023/5/11 19:54
     */
    @Override
    public PageUtil<User> getPage(int index, int size, String user_name) {
        // 使用 userDao 对象查询用户数据
        List<User> list = userDao.getUser(index, size, user_name);
        // 查询用户总数
        int count = userDao.getCount(user_name);
        // 创建 PageUtil 对象，并设置分页信息和查询结果
        PageUtil<User> pageUtil = new PageUtil<>();
        // 设置每页大小
        pageUtil.setPageSize(size);
        // 设置当前页码
        pageUtil.setCurrentPage(index);
        // 设置当前页码的用户列表
        pageUtil.setPageList(list);
        // 设置总记录数
        pageUtil.setTotalCount(count);
        // 计算总页数，并设置到 PageUtil 对象中
        pageUtil.setTotalPageCount(index % size == 0 ? count / size : count / size + 1);
        // 返回 PageUtil 对象
        return pageUtil;
    }

    @Override
    public User getUserById(String user_id) {
        return userDao.getUserById(user_id);
    }

    @Override
    public List getInfoForEcharts() {
        return userDao.getInfoForEcharts();
    }


}
