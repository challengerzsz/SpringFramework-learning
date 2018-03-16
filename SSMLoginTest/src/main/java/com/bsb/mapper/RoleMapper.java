package com.bsb.mapper;

import com.bsb.model.Role;

import java.util.List;


/**
 * 接口模式
 */
public interface RoleMapper {

    //以接口形式定义数据库操作方法 只需要在MyBatis映射文件中对齐进行映射就可使用
    int insertRole(Role role);

    int deleteRole(Long id);

    int updateRole(Role role);

    Role getRole(Long id);

    List<Role> findRoles(String roleName);
}
