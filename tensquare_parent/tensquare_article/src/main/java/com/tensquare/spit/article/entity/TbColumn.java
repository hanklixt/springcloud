package com.tensquare.spit.article.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 专栏
    * </p>
*
* @author lxt
* @since 2019-09-22
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TbColumn implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * ID
            */
    private String id;

            /**
            * 专栏名称
            */
    private String name;

            /**
            * 专栏简介
            */
    private String summary;

            /**
            * 用户ID
            */
    private String userid;

            /**
            * 申请日期
            */
    private LocalDateTime createtime;

            /**
            * 审核日期
            */
    private LocalDateTime checktime;

            /**
            * 状态
            */
    private String state;


}
