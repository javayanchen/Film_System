package com.film.service.impl;

import com.film.dao.FilmDao;
import com.film.dao.impl.FilmDaoImpl;
import com.film.pojo.Film;
import com.film.service.FilmService;
import com.film.util.PageUtil;

import java.util.List;
import java.util.Map;

/**
 * @author lzl
 * @version 1.0
 * @description: TODO
 * @date 2023/5/11 9:26
 */
public class FilmServiceImpl implements FilmService {

    FilmDao filmDao = new FilmDaoImpl();

    /**
     * @description: 按浏览量查询上映影视
     * @param:
     * @return: java.util.List<com.film.pojo.Film>
     * @author lzl
     * @date: 2023/5/11 17:05
     */
    @Override
    public List<Film> getFilmsByfilmViews() {
        return filmDao.getFilmsByfilmViews();
    }

    /**
     * @description: 根据filmId查询影视
     * @param: typeId
     * @return: java.util.List<com.film.pojo.Film>
     * @author lzl
     * @date: 2023/5/11 17:16
     */
    @Override
    public Film getFilmsByFilmId(Integer filmId) {
        return filmDao.getFilmsByFilmId(filmId);
    }

    /**
     * @description: 查询不同类型的上映影视
     * @param: typeId
     * @return: java.util.List<com.film.pojo.Film>
     * @author lzl
     * @date: 2023/5/11 17:16
     */
    @Override
    public List<Film> getFilmsByTypeId(Integer typeId) {
        return filmDao.getFilmsByTypeId(typeId);
    }

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
    @Override
    public PageUtil<Film> searchFilms(int pageIndex, int pageSize, String fileName, String fileAuthor, Integer typeId) {
        int totalCount = filmDao.getTotalCounts(fileName, fileAuthor, typeId);
        List<Film> filmList = filmDao.getFilmsByMulti(pageIndex, pageSize, fileName, fileAuthor, typeId);
        PageUtil<Film> filmPageUtil = new PageUtil<>();
        filmPageUtil.setCurrentPage(pageIndex);
        filmPageUtil.setPageSize(pageSize);
        filmPageUtil.setTotalCount(totalCount);
        filmPageUtil.setPageList(filmList);
        filmPageUtil.setTotalPageCount((int) Math.ceil((double) totalCount / pageSize));
        return filmPageUtil;
    }

    /**
     * @description: 普通用户查询不同影视的不同类型
     * @param: typeId
     * typeIdId
     * @return: java.util.List<com.film.pojo.Film>
     * @author lzl
     * @date: 2023/5/15 17:03
     */
    @Override
    public List<Film> getFilmsByTypeIdId(Integer typeId, Integer typeIdId) {
        return filmDao.getFilmsByTypeIdId(typeId, typeIdId);
    }

    /**
     * @description: 添加影视
     * @param: film
     * @return: boolean
     * @author lzl
     * @date: 2023/5/11 18:30
     */
    @Override
    public boolean addFilm(Film film) {
        return filmDao.addFilm(film);
    }

    /**
     * @description: 增加浏览量
     * @param:
     * @return: boolean
     * @author lzl
     * @date: 2023/5/12 16:30
     */
    @Override
    public boolean addFilmViews(Integer filmId) {
        return filmDao.addFilmViews(filmId);
    }

    /**
     * @description: 修改影视状态，实现影视逻辑删除
     * @param: filmIds
     * @return: boolean
     * @author lzl
     * @date: 2023/5/11 18:28
     */
    @Override
    public boolean updateFilmByStatus(String filmIds) {
        return filmDao.updateFilmByStatus(filmIds);
    }

    /**
     * @description: 修改影视
     * @param: film
     * @return: boolean
     * @author lzl
     * @date: 2023/5/11 18:35
     */
    @Override
    public boolean updateFilm(Film film) {
        return filmDao.updateFilm(film);
    }

    /**
     * @return java.util.List<com.film.pojo.Film>
     * @Author yanchen
     * @Description //TODO 给到持久层，持久层处理数据
     * @Date 19:07 2023/5/16 0016
     * @Param []
     **/
    @Override
    public List<Film> getFilms() {
        return filmDao.getFilms();
    }
}
