package com.tensquare.spit.recruit.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 企业
    * </p>
*
* @author lxt
* @since 2019-09-22
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TbEnterprise implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * ID
            */
    private String id;

            /**
            * 企业名称
            */
    private String name;

            /**
            * 企业简介
            */
    private String summary;

            /**
            * 企业地址
            */
    private String address;

            /**
            * 标签列表
            */
    private String labels;

            /**
            * 坐标
            */
    private String coordinate;

            /**
            * 是否热门
            */
    private String ishot;

            /**
            * LOGO
            */
    private String logo;

            /**
            * 职位数
            */
    private Integer jobcount;

            /**
            * URL
            */
    private String url;


}
