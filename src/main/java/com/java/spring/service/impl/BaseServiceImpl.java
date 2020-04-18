package com.java.spring.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.spring.mapper.*;
import com.java.spring.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 基础业务实践类
 * 2020/2/20   11:18
 * Author:W.铭
 */

public class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    protected BaseMapper<T> baseMapper;
    @Autowired
    protected InRoomInfoMapper inRoomInfoMapper;
    @Autowired
    protected RoomsMapper roomsMapper;
    @Autowired
    protected RoomSaleMapper roomSaleMapper;
    @Autowired
    protected AuthorityMapper authorityMapper;


    /**
     * 根据主键删除单个数据
     * @param id
     * @return
     */
    @Override
    public String removeByPrimaryKey(Integer id)throws Exception {
        if(baseMapper.deleteByPrimaryKey(id)>0){
            return "success";
        }else {
            return "fail";
        }
    }

    /**
     *添加数据
     * @param t
     * @return
     */
    @Override
    public String save(T t) throws Exception{
       if (baseMapper.insert(t)>0){
           return "success";
       }else {
           return "fail";
       }

    }

    /**
     *动态添加
     * @param t
     * @return
     */
    @Override
    public String saveSelective(T t)throws Exception {
        if (baseMapper.insertSelective(t)>0){
            return "success";
        }else {
            return "fail";
        }
    }

    /**
     * 根据主键查询单个数据
     * @param id
     * @return
     */
    @Override
    public T findByPrimaryKey(Integer id)throws Exception {
        return baseMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据主键动态修改数据
     * @param t
     * @return
     */
    @Override
    public String modifyByPrimaryKeySelective(T t) throws Exception{
        if (baseMapper.updateByPrimaryKeySelective(t)>0){
            return "success";
        }else {
            return "fail";
        }
    }

    /**
     *根据主键修改所有数据
     * @param t
     * @return
     */
    @Override
    public String modifyByPrimaryKey(T t)throws Exception {
        if (baseMapper.updateByPrimaryKey(t)>0){
            return "success";
        }else {
            return "fail";
        }
    }

    /**
     * 根据条件分页查询数据
     * @param page
     * @param limit
     * @param t
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> findPageByPramas(Integer page, Integer limit, T t) throws Exception {
        Map<String, Object> pageMap = new HashMap<String, Object>();
        PageHelper.startPage(page,limit);
        PageInfo<T> pageInfo=new PageInfo<T>(baseMapper.selectPageByPramas(t));
        pageMap.put("count",pageInfo.getTotal());
        pageMap.put("data",pageInfo.getList());
        return pageMap;
    }

    /**
     * 根据条件加载单个数据
     * @param t
     * @return
     * @throws Exception
     */
    @Override
    public T findByPramas(T t) throws Exception {
        return baseMapper.selectByPramas(t);

    }

    /**
     * 根据条件加载多个数据
     * @param t
     * @return
     * @throws Exception
     */
    @Override
    public List<T> findManyByPramas(T t) throws Exception {
        return baseMapper.selectManyByPramas(t);
    }

    /**
     * 根据主键动态修改多条数据状态
     * @param ids
     * @param t
     * @return
     * @throws Exception
     */
    @Override
    public String modifyBatchByPrimaryKeySelective(Integer[] ids, T t) throws Exception {
        if (baseMapper.updateBatchByPrimaryKeySelective(ids,t)>0){
            return "success";
        }else {
            return "fail";
        }
    }

    /**
     * 根据条件查询数据条数
     * @param t
     * @return
     * @throws Exception
     */
    @Override
    public Integer findCountByPramas(T t) throws Exception {
        return baseMapper.selectCountByPramas(t);
    }

    /**
     * 查询表的所以数据
     * @return
     * @throws Exception
     */
    @Override
    public List<T> findAll() throws Exception {
        return baseMapper.selectAll();
    }

}
