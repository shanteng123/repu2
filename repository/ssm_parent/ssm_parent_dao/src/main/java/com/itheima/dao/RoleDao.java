package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {
    @Select("select * from role where id in(select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType =java.util.List.class,many = @Many(select = "com.itheima.dao.PermissionsDao.findById"))
    })
    List<Role> findRoleByuserId(String userId)throws Exception;
    @Select("select * from role")
    List<Role> findAll()throws Exception;

@Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role)throws  Exception;
}







