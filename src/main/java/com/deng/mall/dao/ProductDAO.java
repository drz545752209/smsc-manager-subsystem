package com.deng.mall.dao;

import com.deng.mall.domain.Product;
import com.deng.mall.domain.ProductExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * ProductDAO继承基类
 */
@Mapper
@Repository
public interface ProductDAO extends MyBatisBaseDao<Product, Integer, ProductExample> {
}