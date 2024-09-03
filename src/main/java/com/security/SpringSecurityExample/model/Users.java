package com.security.SpringSecurityExample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users {

    @Id
    private int id;
    private String username;
    private String password;
}
