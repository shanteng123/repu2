package com.itheima.dao;

import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
//根据id 查询详情
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "email", property = "email"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles",javaType =java.util.List.class,many=@Many(select = "com.itheima.dao.RoleDao.findRoleByuserId")),
    })
    UserInfo findById(String id) throws  Exception;
    //根据用户名查询用户
    @Select("select * from users where username=#{username}")
    @Results({
            /**
             *   private String username;
             private String email;
             private String password;
             private String phoneNum;
             private int status;
             private String statusStr;
             private List<Role> roles;
             */
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "email", property = "email"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles",javaType =java.util.List.class,many=@Many(select = "com.itheima.dao.RoleDao.findRoleByuserId")),
    })
    UserInfo findByUsername(String username) throws Exception;




    @Select("select * from users")
    List<UserInfo> findAll()throws Exception;
  //  @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo)throws Exception;
}
