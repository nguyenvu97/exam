package org.springframework.boot.exam.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


public class PageDto extends PagingDto{
    @SuppressWarnings("rawtypes")
    public List content;
    public long totalElements;
    public int number;
    public int numberOfElements;
    public int totalPages;

  



    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List getContent() {
        return content;
    }

    public void setContent(List content) {
        this.content = content;
    }
}
