package com.java.spring.controller;

import com.java.spring.service.AuthorityService;
import com.java.spring.service.BaseService;
import com.java.spring.service.OrdersService;
import com.java.spring.service.RoomSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2020/2/20   11:38
 * Author:W.铭
 * 基础控制器层
 */
public class BaseController<T> {
    @Autowired
    protected BaseService<T> baseService;

    @Autowired
    protected OrdersService ordersService;

    @Autowired
    protected AuthorityService authorityService;

    @Autowired
    protected RoomSaleService roomSaleService;

    /**
     * 根据主键删除单个数据
     * @param id
     * @return
     */
    @RequestMapping("delByPrimaryKey")
    public @ResponseBody
    String delByPrimaryKey(Integer id) {
        try {
            return baseService.removeByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     *添加数据
     * @param t
     * @return
     */
    @RequestMapping("add")
    public @ResponseBody String add(T t){
        try {
            return baseService.save(t);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     *动态添加
     * @param t
     * @return
     */
    @RequestMapping("addSelective")
    public @ResponseBody String addSelective(T t){
        try {
            return baseService.saveSelective(t);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    /**
     * 根据主键查询单个数据
     * @param id
     * @return
     */
    @RequestMapping("getByPrimaryKey")
    public @ResponseBody T getByPrimaryKey(Integer id){
        try {
            return baseService.findByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
          return null;
        }
    }

    /**
     * 根据主键动态修改数据
     * @param t
     * @return
     */
    @RequestMapping("xgByPrimaryKeySelective")
    public @ResponseBody String xgByPrimaryKeySelective(T t){
        try {
            return baseService.modifyByPrimaryKeySelective(t);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    /**
     *根据主键修改所有数据
     * @param t
     * @return
     */
    @RequestMapping("xgByPrimaryKey")
    public @ResponseBody String xgByPrimaryKey(T t){
        try {
            return baseService.modifyByPrimaryKey(t);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 根据条件分页加载数据
     * @param page
     * @param limit
     * @param t
     * @return
     */
    @RequestMapping("loadPageByPramas")
    public @ResponseBody Map<String,Object> loadPageByPramas(Integer page,Integer limit,T t){
        Map<String, Object> pageMap = new HashMap<String, Object>();
        try {
           pageMap = baseService.findPageByPramas(page, limit, t);
           pageMap.put("code",0);
        } catch (Exception e) {
            e.printStackTrace();
            pageMap.put("code",200);
            pageMap.put("msg","亲，数据加载异常。。");
        }
            return pageMap;
    }

    /**
     * 根据条件加载单个数据
     * @param t
     * @return
     */
    @RequestMapping("getByPramas")
    public @ResponseBody T getByPramas(T t){
        try {
            return baseService.findByPramas(t);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据条件加载多个数据
     * @param t
     * @return
     */
    @RequestMapping("getManyByPramas")
    public @ResponseBody List<T> getManyByPramas(T t) {
        try {
            return baseService.findManyByPramas(t);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据主键动态修改多条数据状态
     * @param ids
     * @param t
     * @return
     */
    @RequestMapping("xgBatchByPrimaryKeySelective")
    public @ResponseBody String xgBatchByPrimaryKeySelective(Integer[] ids, T t){
        try {
            return baseService.modifyBatchByPrimaryKeySelective(ids,t);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    /**
     * 根据条件查询数据条数
     * @param t
     * @return
     */
    @RequestMapping("/getCountByPramas")
    public @ResponseBody Integer getCountByPramas(T t){
        try {
            return baseService.findCountByPramas(t);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询表的所有数据
     * @return
     */
    @RequestMapping("getAll")
    public @ResponseBody List<T> getAll(){
        try {
            return baseService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
