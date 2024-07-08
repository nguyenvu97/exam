package org.springframework.boot.exam.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

public class EmployeeDto extends PageDto{
    public long id;
    public String Name;
    public String wage;
    public String managename;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    public String getManagename() {
        return managename;
    }

    public void setManagename(String managename) {
        this.managename = managename;
    }
}
