package com.neuedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neuedu.entity.Product;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
