package com.tensquare.spit.qa.entity;

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
    public class TbPl implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * 问题ID
            */
    private String problemid;

            /**
            * 标签ID
            */
    private String labelid;


}
