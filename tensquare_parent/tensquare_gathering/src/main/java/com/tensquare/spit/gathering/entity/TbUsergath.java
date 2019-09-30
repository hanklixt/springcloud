package com.tensquare.spit.gathering.entity;

    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 用户关注活动
    * </p>
*
* @author lxt
* @since 2019-09-22
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TbUsergath implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 用户ID
            */
    private String userid;

            /**
            * 活动ID
            */
    private String gathid;

            /**
            * 点击时间
            */
    private LocalDateTime exetime;


}
