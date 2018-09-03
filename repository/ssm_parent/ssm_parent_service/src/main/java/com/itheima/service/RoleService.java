package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll()throws Exception;
    void save(Role role) throws Exception;
}
