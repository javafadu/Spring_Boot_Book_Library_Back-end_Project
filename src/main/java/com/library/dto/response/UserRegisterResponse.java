package com.library.dto.response;


import com.library.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private Integer score;

    private String address;

    private String phone;

    private LocalDate birthDate;

    private String email;

    private LocalDateTime createDate;

    private Boolean builtIn;

    private Set<Role> roles;

}
