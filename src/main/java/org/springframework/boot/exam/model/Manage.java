package org.springframework.boot.exam.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Manage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Name")
    private String name;
    @OneToMany(mappedBy = "manage",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Employee> employees;
}
