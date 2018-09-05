package com.itheima.service;

import com.itheima.domain.Items;

import java.util.List;

public interface ItemsService {
    List<Items> findAll() throws Exception;

    Items updateItemsById(Integer id)throws Exception;
}
