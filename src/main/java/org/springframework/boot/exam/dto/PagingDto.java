package org.springframework.boot.exam.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PagingDto {
    public int pageSize;
    public int pageNumber;
}
