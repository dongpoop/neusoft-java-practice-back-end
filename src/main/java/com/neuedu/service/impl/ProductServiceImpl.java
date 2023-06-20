package com.neuedu.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.VO.ProductVO;
import com.neuedu.entity.Product;
import com.neuedu.entity.ProductType;
import com.neuedu.mapper.ProductMapper;
import com.neuedu.mapper.ProductTypeMapper;
import com.neuedu.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public List<Product> recommendList() {
        return this.query().eq("is_recommend", 1).last("limit 6").list();
    }

    @Override
    public List<Product> newestList() {
        return this.query().orderByDesc("create_time").last("limit 6").list();
    }

    @Override
    public List<Product> topList() {
        return this.query().orderByDesc("sell_count").last("limit 6").list();
    }

//    @Override
//    public List<Product> getTypeList(int typeId) {
//        return this.query().eq("type_id", typeId).list();
//
//    }


    @Override
    public Page<Product> getTypeList(Integer typeId, Integer currentPage, Integer pageSize) {

        Page page = new Page(currentPage, pageSize);
        return this.query().eq("type_id", typeId).page(page);
    }

    @Override
    public List<Product> getProductList(String productName) {
        return this.query().like("product_name", productName).list();
    }

    @Override
    public Page<Product> getProductPage(String productName, int currentPage, int pageSize) {

        Page page = new Page(currentPage, pageSize);

        return this.query().like("product_name", productName).page(page);
    }

    @Override
    public List<Product> recommendSameType() {

//        find the most sole product type id
        Product sell_count = this.query().orderByDesc("sell_count").last("limit 1").one();
        Integer productId = null;
        Integer typeId = null;
        productId = sell_count.getProductId();
        typeId = sell_count.getTypeId();

//        find other products in this type
        return this.query().eq("type_id", typeId).ne("product_id", productId).last("limit 6").list();

    }

    @Override
    public ProductVO getProductVO(Integer productId) {

        ProductVO productVO = new ProductVO();

//        select product table first
        Product product = this.getById(productId);
        if (product == null)
            return null;
        BeanUtils.copyProperties(product, productVO);

//        select product_type
        ProductType productType = productTypeMapper.selectById(product.getTypeId());
        productVO.setTypeName(productType.getTypeName());

        return productVO;

    }
}
