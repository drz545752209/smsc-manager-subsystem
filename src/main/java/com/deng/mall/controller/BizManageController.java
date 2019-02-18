package com.deng.mall.controller;

import java.util.List;

import com.deng.mall.domain.Product;
import com.deng.mall.service.ProductService;
import com.deng.mall.utils.StrUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;


@Controller
@RequestMapping(value = "/bizManage")
public class BizManageController {
    @Autowired
    ProductService productService;


    @RequestMapping(value = "/index")
    public String toManageIndex() {
        return "bizmanager.html";
    }

    @RequestMapping(value = "/product")
    public ModelAndView getProductList(String type) {
        List<Product> productList;

        if (type != null && !"".equals(type)) {
            productList = productService.getProductByType(type);
        } else {
            productList = productService.getAllProduct();
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("bizproduct.html");
        mv.addObject("productList", productList);

        return mv;
    }

    @RequestMapping("/getProductForSave")
    public  ModelAndView getProductForSave(String saveId){
        ModelAndView mv=new ModelAndView();
        Product product;
        product = productService.getProductById(saveId);
        mv.addObject("product",product);
        mv.setViewName("bizproduct.html");

        return mv;
    }


    @RequestMapping(value = "/batchDelete")
    public String batchDelete(String idStr) {
        List<Integer> ids = StrUntils.getIds(idStr);
        productService.batchDeleteProduct(ids);

        return "bizproduct.html";
    }

    @RequestMapping(value = "/delete")
    public String delete(String deleteId) {
        System.out.println(deleteId);
        return "bizproduct.html";
    }

    @RequestMapping(value = "/create")
    public String create(String idStr) {

        return "bizproduct.html";
    }

    @RequestMapping(value = "/downShelf")
    public String downShelf(String idStr) {
        return "bizproduct.html";
    }

    @RequestMapping(value = "/upShelf")
    public String upShelf(String idStr) {
        return "bizproduct.html";
    }


}
