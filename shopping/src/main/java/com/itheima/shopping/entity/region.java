package com.itheima.shopping.entity;

import lombok.Data;

/**
 * 地理区域信息
 */
@Data
public class region {

    private Long id;

    /**
     * 地理区域编码
     */
    private String regionCode;

    /**
     * 地理区域名称
     */
    private String regionName;

    /**
     * 地理区域级别(省、市、县)
     */
    private int level;

    /**
     * 上级地理区域编码
     */
    private String parentRegionCode;

}
