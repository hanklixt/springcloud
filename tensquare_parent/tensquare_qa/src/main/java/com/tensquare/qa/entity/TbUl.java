package com.tensquare.qa.entity;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author lxt
* @since 2019-09-22
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TbUl implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 用户ID
            */
    private String uid;

            /**
            * 标签ID
            */
    private String lid;


}
