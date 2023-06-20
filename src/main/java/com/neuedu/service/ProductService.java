package com.neuedu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.VO.ProductVO;
import com.neuedu.entity.Product;
import com.neuedu.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProductService extends IService<Product>{

//    recommend list
    List<Product> recommendList();

//    newest products recommend list
    List<Product> newestList();

//    top products recommend list
    List<Product> topList();

//    get products by type id
//    List<Product> getTypeList(int typeId);
    Page<Product> getTypeList(Integer typeId, Integer currentPage, Integer pageSize);

//    search products with vague product name
    List<Product> getProductList(String productName);

//    search products with vague product name by page
    Page<Product> getProductPage(String productName, int currentPage, int pageSize);

//    recommend other products with the same type id by purchase number
    List<Product> recommendSameType();

//    get VO objection by product id
    ProductVO getProductVO(Integer productId);

}
