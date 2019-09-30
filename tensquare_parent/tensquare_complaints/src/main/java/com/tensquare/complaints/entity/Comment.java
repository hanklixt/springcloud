package com.tensquare.complaints.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Comment implements Serializable {
    @Id
    private String _id;

    private String articleid;

    private String content;

    private String userid;

    private String parentid;
    /**
     * 评论日期
     */
    private LocalDate publishdate;
}
