package org.springframework.boot.exam.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;


public class PagingDto {
    public int pageSize;
    public int pageNumber;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
