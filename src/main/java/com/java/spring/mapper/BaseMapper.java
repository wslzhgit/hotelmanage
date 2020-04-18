package com.java.spring.mapper;


import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 2020/2/20   10:45
 * Author:W.铭
 */
public interface BaseMapper<T> {
    /**
     * 根据主键删除单个数据
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Integer id)throws Exception;

    /**
     *添加数据
     * @param t
     * @return
     */
    Integer insert(T t)throws Exception;

    /**
     *动态添加
     * @param t
     * @return
     */
    Integer insertSelective(T t)throws Exception;

    /**
     * 根据主键查询单个数据
     * @param id
     * @return
     */
    T selectByPrimaryKey(Integer id)throws Exception;

    /**
     * 根据主键动态修改数据
     * @param t
     * @return
     */
    Integer updateByPrimaryKeySelective(T t)throws Exception;

    /**
     *根据主键修改所有数据
     * @param t
     * @return
     */
    Integer updateByPrimaryKey(T t)throws Exception;

    /**
     * 根据条件分页查询数据
     * @return
     * @throws Exception
     */
    List<T> selectPageByPramas(@Param("t") T t)throws Exception;

    /**
     * 根据条件加载单个数据
     * @param t
     * @return
     * @throws Exception
     */
    T selectByPramas(@Param("t") T t)throws Exception;

    /**
     * 根据条件加载单多数据
     * @param t
     * @return
     * @throws Exception
     */
    List<T> selectManyByPramas(@Param("t") T t)throws Exception;

    /**
     * 根据主键动态修改多条数据状态
     * @param ids
     * @param t
     * @return
     * @throws Exception
     */
    Integer updateBatchByPrimaryKeySelective(@Param("ids") Integer[] ids,@Param("t") T t)throws Exception;

    /**
     * 根据条件查询数据条数
     * @param t
     * @return
     * @throws Exception
     */
    Integer selectCountByPramas(@Param("t") T t) throws Exception;

    /**
     * 查询表的所以数据
     * @return
     * @throws Exception
     */
    List<T> selectAll()throws Exception;

}
