package org.springframework.boot.exam.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String Name;
    public String wage;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manage_Id",nullable = false)
    private Manage manage;
}
