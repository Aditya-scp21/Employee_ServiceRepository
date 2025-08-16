package org.aditya.p11.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                   // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor      // Generates default constructor
@AllArgsConstructor     // Generates constructor with all fields
public class EmployeeDetails {

    private int eid;
    private String name;
    private String city;
    private String email;
    private int age;
    private String department;
}
