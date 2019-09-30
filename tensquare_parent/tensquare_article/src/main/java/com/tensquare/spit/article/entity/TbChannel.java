package com.tensquare.spit.article.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 频道
    * </p>
*
* @author lxt
* @since 2019-09-22
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TbChannel implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * ID
            */
    private String id;

            /**
            * 频道名称
            */
    private String name;

            /**
            * 状态
            */
    private String state;


}
