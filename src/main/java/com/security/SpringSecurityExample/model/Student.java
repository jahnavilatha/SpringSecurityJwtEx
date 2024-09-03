package com.security.SpringSecurityExample.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int marks;
}
