package com.inorise.consumer.domain;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {

    private List<?> rows;

    private Long total;

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
