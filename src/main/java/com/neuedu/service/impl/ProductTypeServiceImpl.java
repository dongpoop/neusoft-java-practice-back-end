package com.neuedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.entity.ProductType;
import com.neuedu.mapper.ProductTypeMapper;
import com.neuedu.service.ProductTypeService;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements ProductTypeService {
}
