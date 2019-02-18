package com.deng.mall.service;

import com.deng.mall.dao.ProductDAO;
import com.deng.mall.domain.Product;
import com.deng.mall.domain.ProductExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductService {
    final static Logger logger= LoggerFactory.getLogger(ProductService.class);
    @Autowired
    ProductDAO productDAO;

    public List<Product> getAllProduct(){
        List<Product> productList;
        ProductExample productExample=new ProductExample();
        productList=productDAO.selectByExample(productExample);
        return  productList;
    }

    public List<Product> getProductByType(String type){
        List<Product> productList;
        ProductExample productExample=new ProductExample();
        ProductExample.Criteria criteria=productExample.createCriteria();
        criteria.andTypeEqualTo(type);
        productExample.or(criteria);
        productList=productDAO.selectByExample(productExample);
        return  productList;
    }

    public void batchDeleteProduct(List<Integer> ids){
        ProductExample productExample=new ProductExample();
        ProductExample.Criteria criteria=productExample.createCriteria();
        criteria.andIdIn(ids);
        productExample.or(criteria);
        int deleteResult=productDAO.deleteByExample(productExample);
        logger.info("batch delete product num []",deleteResult);
    }

}
