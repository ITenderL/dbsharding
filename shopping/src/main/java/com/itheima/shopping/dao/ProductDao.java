package com.itheima.shopping.dao;

import com.itheima.shopping.entity.ProductDescript;
import com.itheima.shopping.entity.ProductInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator.
 */
@Mapper
@Component
public interface ProductDao {

    ////添加商品基本信息
    //@Insert("insert into product_info(store_info_id,product_name,spec,region_code,price) " +
    //        " values (#{storeInfoId},#{productName},#{spec},#{regionCode},#{price})")
    //@Options(useGeneratedKeys = true,keyProperty = "productInfoId",keyColumn = "product_info_id")
    //int insertProductInfo(ProductInfo productInfo);
    //
    ////添加商品描述信息
    //@Insert("insert into product_descript(product_info_id,descript,store_info_id) " +
    //        " value(#{productInfoId},#{descript},#{storeInfoId})")
    //@Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    //int insertProductDescript(ProductDescript productDescript);
    //
    //@Select("select i.*,d.descript,r.region_name placeOfOrigin from product_info i join product_descript d on i.product_info_id = d.product_info_id " +
    //        " join region r on i.region_code = r.region_code order by product_info_id desc limit #{start},#{pageSize}")
    //List<ProductInfo> selectProductList(@Param("start")int start, @Param("pageSize") int pageSize);
    //
    ////商品总数
    //@Select("select count(1) from product_info")
    //int selectCount();
    //
    ////商品分组统计
    //@Select("select t.region_code,count(1) as num from product_info t group by t.region_code having num > 1 order by region_code ")
    //List<Map> selectProductGroupList();

    /**
     * 添加商品基本信息
     * @param productInfo
     * @return
     */
    @Insert("insert into product_info(store_info_id, product_name, spec, region_code, price) " +
            " values (#{storeInfoId}, #{productName}, #{spec}, #{regionCode}, #{price})")
    @Options(useGeneratedKeys = true, keyProperty = "productInfoId", keyColumn = "product_info_id")
    int insertProductInfo(ProductInfo productInfo);

    /**
     * 添加商品描述信息
     * @param productDescript
     * @return
     */
    @Insert("insert into product_descript(product_info_id,descript,store_info_id) " +
            " value(#{productInfoId},#{descript},#{storeInfoId})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insertProductDescript(ProductDescript productDescript);

    /**
     *
     * @param start
     * @param pageSize
     * @return
     */
    @Select("select i.*,d.descript,r.region_name placeOfOrigin from product_info i join product_descript d on i.product_info_id = d.product_info_id " +
            " join region r on i.region_code = r.region_code order by product_info_id desc limit #{start},#{pageSize}")
    List<ProductInfo> selectProductList(@Param("start")int start, @Param("pageSize") int pageSize);

    //商品总数
    @Select("select count(1) from product_info")
    int selectCount();

    //商品分组统计
    @Select("select t.region_code,count(1) as num from product_info t group by t.region_code having num > 1 order by region_code ")
    List<Map> selectProductGroupList();

}
