package com.deng.mall.service;

import com.deng.mall.dao.ProductDAO;
import com.deng.mall.domain.Product;
import com.deng.mall.domain.ProductExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductService {
    @Autowired
    ProductDAO productDAO;

    public List<Product> getAllProduct(){
        List<Product> productList;
        ProductExample productExample=new ProductExample();
        productList=productDAO.selectByExample(productExample);

        return  productList;
    }
}
