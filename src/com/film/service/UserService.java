package com.film.service;

import com.film.pojo.User;
import com.film.util.PageUtil;

import java.util.List;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 9:25
 */
public interface UserService {
    /**
     * @description: 用户登录
     * @param: username
     * password
     * @return: com.film.pojo.User
     * @author 田际宝
     * @date: 2023/5/12 14:32
     */

    User login(String username, String password);

    /**
     * @description: 用户注册
     * @param: user
     * @return: boolean
     * @author 田际宝
     * @date: 2023/5/12 14:33
     */

    boolean register(User user);

    /**
     * @description: 判断用户是否存在
     * @param: user_name
     * @return: boolean
     * @author 田际宝
     * @date: 2023/5/12 14:39
     */

    boolean exsit(String user_name);

    /**
     * @description: 多选删除
     * @param: ids
     * @return: boolean
     * @author 田际宝
     * @date: 2023/5/12 15:07
     */

    int delAll(String ids);

    /**
     * @description: 俢改对账号密码邮箱状态进行修改
     * @param: null
     * @return:
     * @author 王煜洪
     * @date: 2023/5/11 17:17
     */
    public boolean modify(User user);

    /**
     * @description: 根据id进行删除
     * @author 王煜洪
     * @date 2023/5/11 17:17
     * @version 1.0
     */
    public boolean deleteUser(int user_id);

    /**
     * @description: 分页
     * @param: null
     * @return:
     * @author 王煜洪
     * @date: 2023/5/11 19:07
     */
    PageUtil<User> getPage(int index, int size, String user_name);

    /**
     * @description: 根据用户id查找用户
     * @param: user_id
     * @return: com.film.pojo.User
     * @author 田际宝
     * @date: 2023/5/16 0:40
     */

    User getUserById(String user_id);

    /**
     * @return java.util.List
     * @Author yanchen
     * @Description //TODO 以图表形式展示数据
     * @Date 19:11 2023/5/16 0016
     * @Param []
     **/
    public List getInfoForEcharts();


}
