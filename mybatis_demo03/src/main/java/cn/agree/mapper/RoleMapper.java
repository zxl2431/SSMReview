package cn.agree.mapper;

import cn.agree.domain.Role;

import java.util.List;

public interface RoleMapper {

    /*
    * 查询所有角色信息, 包含User信息
    *
    * */
    List<Role> findRoleUserList();
}
