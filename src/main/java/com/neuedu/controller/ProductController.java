package com.neuedu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.VO.ProductVO;
import com.neuedu.common.ServerResponse;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping("/recommendList")
    public ServerResponse recommendList(){
        List<Product> productList = productService.recommendList();
        if (productList.size() > 0)
            return ServerResponse.success("").addData("productList", productList);
        else
            return ServerResponse.failure("No Recommend Product Information!");
    }

    @RequestMapping("/newestList")
    public ServerResponse newestList(){
        List<Product> productList = productService.newestList();
        if (productList.size() > 0)
            return ServerResponse.success("").addData("productList", productList);
        else
            return ServerResponse.failure("No Newest Product Information!");
    }

    @RequestMapping("/topList")
    public ServerResponse topList(){
        List<Product> productList = productService.topList();
        if (productList.size() > 0)
            return ServerResponse.success("").addData("productList", productList);
        else
            return ServerResponse.failure("No Top Product Information!");
    }

    @RequestMapping("/typeList")
    public ServerResponse getTypeList(Integer typeId,
                                      @RequestParam(required = false, defaultValue = "1") Integer currentPage) {
//        List<Product> productList = productService.getTypeList(typeId);
        Page<Product> productPage = productService.getTypeList(typeId, currentPage, pageSize);

        if (productPage.getRecords().size() > 0)
            return ServerResponse.success("").addData("productPage", productPage);
        else
            return ServerResponse.failure("No Such Kind Products!");
    }

    @Value("${config.pageSize}")
    private int pageSize;


    @RequestMapping("/list")
    public ServerResponse getList(@RequestParam(required = false, defaultValue = "") String productName,
                                  @RequestParam(required = false, defaultValue = "1") int currentPage){
        Page<Product> productPage = productService.getProductPage(productName, currentPage, pageSize);
        if (productPage.getRecords().size() > 0)
            return ServerResponse.success("").addData("productPage", productPage);
        else
            return ServerResponse.failure("No Any Products!");
    }

    @RequestMapping("/recommendSameList")
    public ServerResponse recommendSameList(){
        List<Product> productList = productService.recommendSameType();
        if (productList.size() > 0)
            return ServerResponse.success("").addData("productList", productList);
        else
            return ServerResponse.failure("No Recommend Product Information!");
    }

    @RequestMapping("/detail/{productId}")
    public ServerResponse getTypeList(@PathVariable Integer productId){
        ProductVO productVO = productService.getProductVO(productId);
        if (productVO != null)
            return ServerResponse.success("").addData("productVO", productVO);
        else
            return ServerResponse.failure("No Products!");
    }

}
