package com.film.service.impl;

import com.film.dao.RoleDao;
import com.film.dao.impl.RoleDaoImpl;
import com.film.pojo.Role;
import com.film.service.RoleService;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 9:27
 */
public class RoleServiceImpl implements RoleService {
    RoleDao  role=new RoleDaoImpl();
    @Override
    public Role getRoleById(int id) {
        return role.getRoleById(id);
    }

}
