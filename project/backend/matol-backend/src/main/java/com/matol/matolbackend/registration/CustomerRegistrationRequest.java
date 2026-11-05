package com.matol.matolbackend.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CustomerRegistrationRequest {
    private String username;
    private String password;
    private String email;
}
