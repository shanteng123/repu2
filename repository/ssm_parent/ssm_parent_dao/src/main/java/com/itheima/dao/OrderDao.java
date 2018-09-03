package com.itheima.dao;

import com.itheima.domain.Member;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.domain.Traveller;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * String id;
 * private String orderNum;
 * private Date orderTime;
 * private String orderTimeStr;
 * private int orderStatus;
 * private int peopleCount;
 * private Product product;
 * private List<Traveller> travellers;
 * private Member member;
 * private Integer payType;
 * private String payTypeStr;
 * private String orderDesc;
 */
public interface OrderDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product", javaType = Product.class, one = @One(select = "com.itheima.dao.ProductDao.findById"))

    })
    List<Orders> findAll() throws Exception;


    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTimeStr", property = "orderTimeStr"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "orderStatusStr", property = "orderStatusStr"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "payTypeStr", property = "payTypeStr"),
            @Result(column = "orderDesc", property = "orderDesc"),
//            查询product产品信息
            @Result(column = "ProductId", property = "product",javaType = Product.class,one=@One(select = "com.itheima.dao.ProductDao.findById")),
            @Result(column = "MemberId", property = "member",javaType = Member.class,one=@One(select = "com.itheima.dao.MemberDao.findById")),
            @Result(column = " id", property = " travellers",javaType = Traveller.class,many = @Many(select = "com.itheima.dao.TravellerDao.findByOrdersId")),

    })
    Orders findById(String id) throws Exception;
}
