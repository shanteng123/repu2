package com.itheima.controler;

import com.itheima.domain.Orders;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orderControler")
public class OrdersTest {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> orders = orderService.findAll();
        mv.addObject("ordersList", orders);
        mv.setViewName("orders-list");
        return mv;
    }
    @RequestMapping("/findById.do")
    public  ModelAndView findById(String id)throws Exception{
        ModelAndView mv=new ModelAndView();
        Orders orders = orderService.findById(id);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
