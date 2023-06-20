package com.neuedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neuedu.entity.ProductType;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
@CacheNamespace //open second cache of mybatis
public interface ProductTypeMapper extends BaseMapper<ProductType> {
}
