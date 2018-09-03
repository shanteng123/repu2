package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.domain.Orders;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Orders> findAll() throws Exception {
        return orderDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return orderDao.findById(id);
    }

//    @Override
//    public Orders findById(Integer id) throws Exception {
//        return orderDao.findById(id);
//    }
}
