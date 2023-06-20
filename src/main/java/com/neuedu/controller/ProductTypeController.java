package com.neuedu.controller;

import com.neuedu.common.ServerResponse;
import com.neuedu.entity.ProductType;
import com.neuedu.service.ProductTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/productType")
public class ProductTypeController {

    @Resource
    private ProductTypeService productTypeService;

    @RequestMapping("/list")
    public ServerResponse list(){
        List<ProductType> productTypeList = productTypeService.list();
        if (productTypeList.size() > 0)
            return ServerResponse.success("").addData("productTypeList", productTypeList);
        else
            return ServerResponse.failure("No Product Type Information!");
    }
}
