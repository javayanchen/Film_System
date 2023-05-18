package com.film.dao.impl;

import com.film.dao.BaseDao;
import com.film.dao.RoleDao;
import com.film.pojo.Role;
import com.film.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 9:24
 */
public class RoleDaoImpl implements RoleDao {
    public Role getRoleById(int id){
        Role role = new Role();
        Connection conn = null;
        PreparedStatement prs = null;
        String sql = "select * from `Role` where role_id=?";
        ResultSet result = null;
        try {
            //创建与mysql的连接
            conn = BaseDao.getConnection();
            prs = conn.prepareStatement(sql);
            prs.setObject(1, id);
            result = prs.executeQuery();
            if (result.next()) {
              role.setRoleId(result.getInt(1));
              role.setRoleName(result.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(result, prs, conn);
        }

        return role;

    }


}
