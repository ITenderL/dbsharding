package com.itheima.shopping.service;

import com.itheima.shopping.entity.ProductInfo;

import java.util.List;

/**
 * Created by Administrator.
 */
public interface ProductService {
    //添加商品
    void createProduct(ProductInfo product);

    //查询商品
    List<ProductInfo> queryProduct(int page, int pageSize);
}
