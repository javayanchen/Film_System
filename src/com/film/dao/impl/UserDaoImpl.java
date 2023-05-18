package com.film.dao.impl;

import com.film.dao.BaseDao;
import com.film.dao.RoleDao;
import com.film.dao.UserDao;
import com.film.pojo.Role;
import com.film.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tianjibao
 * @version 1.0
 * @description: 登录注册
 * @date 2023/5/11 14:06
 */

public class UserDaoImpl implements UserDao {
    /**
     * @description: 登录验证
     * @param: username
     * password
     * @return: com.film.pojo.User
     * @author 田际宝
     * @date: 2023/5/11 20:11
     */


    @Override
    public User login(String username, String password) {
        User user = new User();
        Connection conn = null;
        PreparedStatement prs = null;
        String sql = "select * from `user` where user_name=? and user_password=? and status=1";
        ResultSet result = null;
        try {
            //创建与mysql的连接
            conn = BaseDao.getConnection();
            prs = conn.prepareStatement(sql);
            prs.setObject(1, username);
            prs.setObject(2, password);
            result = prs.executeQuery();
            if (result.next()) {
                user.setUserId(result.getInt(1));
                user.setUserName(result.getString(2));
                user.setUserPassword(result.getString(3));
                user.setEmail(result.getString(4));
                Role role = new Role();
                //将查询到的第5行数据RoleId赋值给Role对象的RoleId
                role.setRoleId(result.getInt(5));
                //将user的role对象
                user.setRole(role);
                user.setCreateTime(result.getDate(6));
                user.setStatus(result.getInt(7));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(result, prs, conn);
        }

        return null;

    }

    /**
     * @description: 用户注册账号
     * @param: user
     * @return: int
     * @author 田际宝
     * @date: 2023/5/11 20:10
     */


    @Override
    public boolean register(User user) {
        String sql = "insert into `user`(user_name,user_password,role_id,email,create_time) VALUES\n" +
                "(?,?,1,?,?) ";
        int result;
        return BaseDao.operation(sql, user.getUserName(), user.getUserPassword(), user.getEmail(), user.getCreateTime());

    }

    /**
     * @description: 判断用户名是否存在
     * @param:
     * @return: int
     * @author 田际宝
     * @date: 2023/5/12 11:15
     */


    @Override
    public boolean exsit(String user_name) {
        User user = new User();
        Connection conn = null;
        PreparedStatement prs = null;
        String sql = "select * from `user` where user_name=?";
        ResultSet result = null;
        try {
            //创建与mysql的连接
            conn = BaseDao.getConnection();
            prs = conn.prepareStatement(sql);
            prs.setObject(1, user_name);
            result = prs.executeQuery();
            if (result.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(result, prs, conn);
        }
        return false;
    }

    /**
     * @description:查用户的询总记录数
     * @param:
     * @return: int
     * @author
     * @date: 2023/5/12 14:15
     */

    @Override
    public int getCount(String user_name) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select count(*) from user where status=1 and user_name like ?";
        try {
            conn = BaseDao.getConnection();
            st = conn.prepareStatement(sql);
            st.setObject(1,"%"+user_name+"%");
            rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @description: 查询用户信息，并分页
     * @param: index
     * size
     * @return: List<User>
     * @author
     * @date: 2023/5/12 14:16
     */


    @Override
    public List<User> getUser(int index, int size, String user_name) {
        List<User> list = new ArrayList<>();
        RoleDao roleDao = new RoleDaoImpl();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM user  where  user_name like  ? and status=1 limit ?,?";
        try {
            conn = BaseDao.getConnection();
            st = conn.prepareStatement(sql);
            st.setObject(1, "%" + user_name + "%");
            st.setObject(2, (index - 1) * size);
            st.setObject(3, size);
            rs = st.executeQuery();
            while (rs.next()) {
                User user1 = new User();
                user1.setUserId(rs.getInt(1));
                user1.setUserName(rs.getString(2));
                user1.setUserPassword(rs.getString(3));
                user1.setEmail(rs.getString(4));
                user1.setRole(roleDao.getRoleById(rs.getInt(5)));
                user1.setCreateTime(rs.getDate(6));
                user1.setStatus(rs.getInt(7));
                list.add(user1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @description: 修改用户基本信息
     * @param: user
     * @return: boolean
     * @author 田际宝
     * @date: 2023/5/12 14:26
     */

    @Override
    public boolean modify(User user) {
        String sql = "update user set user_name=?,user_password=?,email=? where user_id=?";
        return BaseDao.operation(sql, user.getUserName(), user.getUserPassword(), user.getEmail(), user.getUserId());
    }

    /**
     * @description: 逻辑删除单个用户
     * @param: user_id
     * @return: boolean
     * @author
     * @date: 2023/5/12 14:26
     */

    @Override
    public boolean deleteUser(int user_id) {
        String sql = "update user set status=0 where user_id=?";
        return BaseDao.operation(sql, user_id);
    }

    /**
     * @description: 删除多个用户
     * @param: ids
     * @return: boolean
     * @author 田际宝
     * @date: 2023/5/12 15:11
     */

    @Override
    public int delAll(String ids) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "update user set status=0 where user_id in (" + ids + ")";
        conn = BaseDao.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(null, pstmt, conn);
        }
        return 0;
    }

    @Override
    public User getUserById(String user_id) {
        RoleDao roleDao = new RoleDaoImpl();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        User user1 = new User();
        String sql = "SELECT * FROM user  where user_id=? and status=1";
        try {
            conn = BaseDao.getConnection();
            st = conn.prepareStatement(sql);
            st.setObject(1, user_id);
            rs = st.executeQuery();
            if (rs.next()) {
                user1.setUserId(rs.getInt(1));
                user1.setUserName(rs.getString(2));
                user1.setUserPassword(rs.getString(3));
                user1.setEmail(rs.getString(4));
                user1.setRole(roleDao.getRoleById(rs.getInt(5)));
                user1.setCreateTime(rs.getDate(6));
                user1.setStatus(rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user1;
    }

    @Override
    public List getInfoForEcharts() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "select count(role_id) from user group by role_id";
        conn = BaseDao.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(null, pstmt, conn);
        }
        return null;
    }

    @Override
    public List<Integer> verifyIds(String ids) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Integer> list = new ArrayList();
        String sql = "select role_id from user where user_id in (" + ids + ")";
        conn = BaseDao.getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(null, pstmt, conn);
        }
        return null;
    }

}
