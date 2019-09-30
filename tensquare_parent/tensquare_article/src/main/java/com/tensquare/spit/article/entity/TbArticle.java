package com.tensquare.spit.article.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 文章
    * </p>
*
* @author lxt
* @since 2019-09-22
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TbArticle implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * ID
            */
    private String id;

            /**
            * 专栏ID
            */
    private String columnid;

            /**
            * 用户ID
            */
    private String userid;

            /**
            * 标题
            */
    private String title;

            /**
            * 文章正文
            */
    private String content;

            /**
            * 文章封面
            */
    private String image;

            /**
            * 发表日期
            */
    private LocalDateTime createtime;

            /**
            * 修改日期
            */
    private LocalDateTime updatetime;

            /**
            * 是否公开
            */
    private String ispublic;

            /**
            * 是否置顶
            */
    private String istop;

            /**
            * 浏览量
            */
    private Integer visits;

            /**
            * 点赞数
            */
    private Integer thumbup;

            /**
            * 评论数
            */
    private Integer comment;

            /**
            * 审核状态
            */
    private String state;

            /**
            * 所属频道
            */
    private String channelid;

            /**
            * URL
            */
    private String url;

            /**
            * 类型
            */
    private String type;


}
