package com.java.spring.service.impl;

import com.java.spring.entity.Authority;
import com.java.spring.entity.Roles;
import com.java.spring.service.RolesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 2020/2/22   11:18
 * Author:W.铭
 */
@Service
@Transactional(readOnly = false)
public class RolesServiceImpl extends BaseServiceImpl<Roles> implements RolesService{
    @Override
    public Map<String, Object> findPageByPramas(Integer page, Integer limit, Roles roles) throws Exception {
        //执行父类的分页查询方法，得到分页数据
        Map<String, Object> map = super.findPageByPramas(page, limit, roles);
        //取出map中的角色分页数据List<Roles>
        List<Roles> list = (List<Roles>) map.get("data");
        //通过循环将每一个角色拥有的一级权限数据查询出来
        for (int i=0;i<list.size();i++){
            //获取每一次循环的角色对象
            Roles role = list.get(i);
            //根据角色id查询其角色拥有的一级权限数据
            List<Authority> firstAuthorities = authorityMapper.selectAuthoritiesByRoleIdAndParent(role.getId(),0);
            //将一级权限循环得到权限名称字符串
            StringBuffer firstName = new StringBuffer();
            for (int j=0;j<firstAuthorities.size();j++){
                //得到角色的一级权限名称
                firstName.append(firstAuthorities.get(j).getAuthorityName()+",");
            }
            //4.将字符串设置到角色对象中
            role.setFirstName(firstName.toString().substring(0,firstName.length()-1));
        }
        return map;
    }
}
