package com.itheima.dbsharding.simple.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Author: HeWei·Yuan
 * @CreateTime: 2021-06-15 22:38
 * @Description:
 */
@Mapper
@Component
public interface DictDao {
    /**
     * 新增字典
     * @param type 字典类型
     * @param code 字典编码
     * @param value 字典值
     * @return
     */
    @Insert("insert into t_dict(dict_id,type,code,value) value(#{dictId},#{type},#{code},#{value})")
    int insertDict(@Param("dictId") Long dictId,@Param("type") String type, @Param("code")String
            code, @Param("value")String value);
    /**
     * 删除字典
     * @param dictId 字典id
     * @return
     */
    @Delete("delete from t_dict where dict_id = #{dictId}")
    int deleteDict(@Param("dictId") Long dictId);
}
