package com.itheima.dbsharding.simple.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Author: HeWei·Yuan
 * @CreateTime: 2021-06-15 16:58
 * @Description:
 */
@Mapper
@Component
public interface OrderDao {

    @Insert("insert into t_order(price, user_id, status) values(#{price}, #{userId}, #{status}) ")
    int insertOrder(@Param("price")BigDecimal price, @Param("userId") Long userId, @Param("status") String status);

    /**
     * 根据订单id集合查询订单
     * @param orderIds
     * @return
     */
    @Select("<script>" +
            "select " +
            " * " +
            " from t_order " +
            " where order_id in " +
            " <foreach collection='orderIds' item='orderId' separator=',' open='(' close=')'>" +
            " #{orderId} " +
            "</foreach>" +
            "</script>")
    List<Map> selectOrderbyIds (@Param("orderIds") List<Long> orderIds);

    @Select("<script>" +
            "select " +
            " * " +
            " from t_order " +
            " where order_id in " +
            " <foreach collection='orderIds' item='orderId' separator=',' open='(' close=')'>" +
            " #{orderId} " +
            "</foreach>" +
            " and user_id = #{userId} " +
            "</script>")
    List<Map> selectOrderbyUserAndIds (@Param("userId") Long userId, @Param("orderIds") List<Long> orderIds);
}
