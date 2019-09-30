package com.tensquare.spit.qa.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 回答
    * </p>
*
* @author lxt
* @since 2019-09-22
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TbReply implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 编号
            */
    private String id;

            /**
            * 问题ID
            */
    private String problemid;

            /**
            * 回答内容
            */
    private String content;

            /**
            * 创建日期
            */
    private LocalDateTime createtime;

            /**
            * 更新日期
            */
    private LocalDateTime updatetime;

            /**
            * 回答人ID
            */
    private String userid;

            /**
            * 回答人昵称
            */
    private String nickname;


}
