package com.itheima.web;

import com.itheima.domain.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsControler {
    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Items> list = itemsService.findAll();
        mv.addObject("itemsList", list);
        mv.setViewName("itemsList");
        return mv;
    }
    @RequestMapping("/update.do")
    public ModelAndView updateItems(String id)throws Exception{

        Items items = itemsService.updateItemsById(id);
    }
}
