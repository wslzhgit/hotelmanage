package com.java.spring.service;


import java.util.List;
import java.util.Map;

/**
 * 2020/2/20   11:12
 * Author:W.铭
 */
public interface BaseService<T> {
    /**
     * 根据主键删除单个数据
     * @param id
     * @return
     */
    String removeByPrimaryKey(Integer id)throws Exception;

    /**
     *添加数据
     * @param t
     * @return
     */
    String  save(T t)throws Exception;

    /**
     *动态添加
     * @param t
     * @return
     */
    String  saveSelective(T t)throws Exception;

    /**
     * 根据主键查询单个数据
     * @param id
     * @return
     */
    T findByPrimaryKey(Integer id)throws Exception;

    /**
     * 根据主键动态修改数据
     * @param t
     * @return
     */
    String  modifyByPrimaryKeySelective(T t)throws Exception;

    /**
     *根据主键修改所有数据
     * @param t
     * @return
     */
    String  modifyByPrimaryKey(T t)throws Exception;

     /**
     * 根据条件分页查询数据
     * @param page
     * @param limit
     * @param t
     * @return
     * @throws Exception
     */
    Map<String,Object> findPageByPramas(Integer page,Integer limit,T t)throws Exception;

    /**
     * 根据条件查询单个数据
     * @param t
     * @return
     * @throws Exception
     */
    T findByPramas( T t)throws Exception;

    /**
     * 根据条件加载单多数据
     * @param t
     * @return
     * @throws Exception
     */
    List<T> findManyByPramas(T t)throws Exception;

    /**
     * 根据主键动态修改多条数据状态
     * @param ids
     * @param t
     * @return
     * @throws Exception
     */
    String modifyBatchByPrimaryKeySelective( Integer[] ids, T t)throws Exception;

    /**
     * 根据条件查询数据条数
     * @param t
     * @return
     */
    Integer findCountByPramas(T t) throws Exception;

    /**
     * 查询表的所以数据
     * @return
     * @throws Exception
     */
    List<T> findAll()throws Exception;

}
