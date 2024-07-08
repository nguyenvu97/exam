package org.springframework.boot.exam.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class PageDto extends PagingDto{
    @SuppressWarnings("rawtypes")
    public List content;
    public long totalElements;
    public int number;
    public int numberOfElements;
    public int totalPages;

}
