package com.tensquare.spit.base.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 城市
    * </p>
*
* @author lxt
* @since 2019-09-21
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TbCity implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * ID
            */
    private String id;

            /**
            * 城市名称
            */
    private String name;

            /**
            * 是否热门
            */
    private String ishot;


}
