package com.deng.mall.controller;

import java.util.ArrayList;
import java.util.List;

import com.deng.mall.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value="/bizManage")
public class BizManageController {
	
	@RequestMapping(value="/index")
	public String toManageIndex() {
		return "bizmanager.html";
	}
	
	@RequestMapping(value="/product")
	public ModelAndView getProductList() {
		List productList=new ArrayList();
		Product product=new Product();
		product.setId(1);
		product.setImgUrl("/abd/123");
		product.setPrice("100");
		product.setName("paxos");
		product.setType("相机");
		productList.add(product);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("bizproduct.html");
		mv.addObject("productList",productList);
		
		return mv;
	}

}
