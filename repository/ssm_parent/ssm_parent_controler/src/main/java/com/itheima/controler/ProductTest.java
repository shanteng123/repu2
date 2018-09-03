package com.itheima.controler;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/test")
public class ProductTest {
    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> list = productService.findAll();
        mv.addObject("productList", list);
        mv.setViewName("product-list1");
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveProduct(Product product) throws Exception {
        productService.savePro(product);
        return "redirect:findAll.do";
    }
}
