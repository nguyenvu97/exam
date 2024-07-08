package org.springframework.boot.exam.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class EmployeeDto extends PageDto{
    public long id;
    public String Name;
    public String wage;
    public String managename;
}
