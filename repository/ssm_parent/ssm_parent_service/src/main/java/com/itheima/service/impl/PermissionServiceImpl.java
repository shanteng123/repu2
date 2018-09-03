package com.itheima.service.impl;

import com.itheima.dao.PermissionsDao;
import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionsDao permissionsDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionsDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionsDao.save(permission);
    }
}
