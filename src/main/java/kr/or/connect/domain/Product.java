package kr.or.connect.domain;

import java.time.LocalDateTime;

public class Product {

    private Integer id;
    private Integer categoryId;
    private String description;
    private String content;
    private String event;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    public Integer getId() {
        return id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public String getEvent() {
        return event;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

}
