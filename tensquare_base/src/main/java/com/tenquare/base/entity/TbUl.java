package com.tenquare.base.entity;

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
* @since 2019-09-21
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class TbUl implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userid;

    private String labelid;


}
