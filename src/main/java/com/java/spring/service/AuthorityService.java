package com.java.spring.service;

import com.java.spring.entity.Authority;
import com.java.spring.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 2020/2/22   11:17
 * Author:W.铭
 */
public interface AuthorityService extends BaseService<Authority> {
    /**
     *   根据用户登陆之后查询其拥有的权限菜单
     * @param user
     * @return
     * @throws Exception
     */
    List<Map<String,Object>> findAuthoritiesByLogin(User user) throws Exception;

    /**
     *   根据角色id查询角色拥有的权限
     * @param roleId  角色id
     * @return   权限的集合
     * @throws Exception
     */
    List<Authority> findAuthoritiesByRoleId(Integer roleId) throws Exception;
}
