package com.film.service;

import com.film.pojo.Film;
import com.film.util.PageUtil;

import java.util.List;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 9:25
 */
public interface FilmService {
    /**
     * @description: 按浏览量查询上映影视
     * @param:
     * @return: java.util.List<com.film.pojo.Film>
     * @author lzl
     * @date: 2023/5/11 17:05
     */
    List<Film> getFilmsByfilmViews();

    /**
     * @description: 根据filmId查询影视
     * @param: typeId
     * @return: java.util.List<com.film.pojo.Film>
     * @author lzl
     * @date: 2023/5/11 17:16
     */
    Film getFilmsByFilmId(Integer filmId);

    /**
     * @description: 查询不同类型的上映影视
     * @param: typeId
     * @return: java.util.List<com.film.pojo.Film>
     * @author lzl
     * @date: 2023/5/11 17:16
     */
    List<Film> getFilmsByTypeId(Integer typeId);

    /**
     * @description: 模糊查询的分页数据
     * @param: pageIndex
     * pageSize
     * fileName
     * fileAuthor
     * typeId
     * @return: java.util.List<com.film.pojo.Film>
     * @author lzl
     * @date: 2023/5/11 18:20
     */
    PageUtil<Film> searchFilms(int pageIndex, int pageSize, String fileName, String fileAuthor, Integer typeId);

    /**
     * @description: 普通用户查询不同影视的不同类型
     * @param: typeId
     * typeIdId
     * @return: java.util.List<com.film.pojo.Film>
     * @author lzl
     * @date: 2023/5/15 17:04
     */
    List<Film> getFilmsByTypeIdId(Integer typeId, Integer typeIdId);

    /**
     * @description: 添加影视
     * @param: film
     * @return: boolean
     * @author lzl
     * @date: 2023/5/11 18:30
     */
    boolean addFilm(Film film);

    /**
     * @description: 增加浏览量
     * @param:
     * @return: boolean
     * @author lzl
     * @date: 2023/5/12 16:30
     */
    boolean addFilmViews(Integer filmId);

    /**
     * @description: 修改影视状态，实现影视逻辑删除
     * @param: filmIds
     * @return: boolean
     * @author lzl
     * @date: 2023/5/11 18:28
     */
    boolean updateFilmByStatus(String filmIds);

    /**
     * @description: 修改影视
     * @param: film
     * @return: boolean
     * @author lzl
     * @date: 2023/5/11 18:35
     */
    boolean updateFilm(Film film);

    /*
     * @Author yanchen
     * @Description //TODO 数据以图表形式展示
     * @Date 19:04 2023/5/16 0016
     * @Param []
     * @return java.util.List<com.film.pojo.Film>
     **/
    public List<Film> getFilms();

}
