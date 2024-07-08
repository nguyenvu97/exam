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

    private String firstName;
    @NonNull
    private String userName;
    @NonNull
    private String lastName;
    @NonNull
    private String address;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manage_Id",nullable = false)
    private Manage manage;


}
