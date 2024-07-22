package com.example.model;

import com.example.model.enums.EmployeeRole;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employee_data")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String givenName;

    @NotNull
    private String familyName;

    @NotNull
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

    @OneToMany(mappedBy = "employee")
    private List<Absence> absences = new ArrayList<>();

}
