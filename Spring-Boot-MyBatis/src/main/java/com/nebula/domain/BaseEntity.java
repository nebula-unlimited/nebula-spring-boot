package com.nebula.domain;

import org.springframework.data.annotation.Transient;

public class BaseEntity {
    @Transient
    private Integer page = 1;

    @Transient
    private Integer rows = 5;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
