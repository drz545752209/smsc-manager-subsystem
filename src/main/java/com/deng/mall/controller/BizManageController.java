package com.deng.mall.controller;

import java.util.ArrayList;
import java.util.List;

import com.deng.mall.domain.Product;
import com.deng.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value="/bizManage")
public class BizManageController {
	@Autowired
	ProductService productService;

	
	@RequestMapping(value="/index")
	public String toManageIndex() {
		return "bizmanager.html";
	}
	
	@RequestMapping(value="/product")
	public ModelAndView getProductList() {
		List<Product> productList=new ArrayList<Product>();

		productList=productService.getAllProduct();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("bizproduct.html");
		mv.addObject("productList",productList);

		return mv;
	}


	@RequestMapping(value = "/batchDelete")
	public String  batchDelete(String idStr){

		System.out.println("batchDelete");
		String[] ids=idStr.split(",");
		for (String id:ids){
			System.out.println(id);
		}
		return  "bizproduct.html";
	}

	@RequestMapping(value = "/delete")
	public  String delete(String deleteId){
		System.out.println(deleteId);
		return  "bizproduct.html";
	}

	@RequestMapping(value = "/create")
	public  String create(String idStr){
		String[] ids=idStr.split(",");
		return  "bizproduct.html";
	}

	@RequestMapping(value = "/downShelf")
	public  String downShelf(String idStr){
		return "bizproduct.html";
	}

	@RequestMapping(value = "/upShelf")
	public  String upShelf(String idStr){
		return "bizproduct.html";
	}

	@RequestMapping(value = "/showProductByType")
	public  ModelAndView showProductByType(String productType){
		return  null;
	}

}
