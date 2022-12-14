package com.library.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.library.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {


    @Size(min = 2, max = 30, message = "Your first name '${validatedValue}' must be between {min} and {max} chars long")
    @NotNull(message = "Please provide first name")
    private String firstName;

    @Size(min = 2, max = 30, message = "Your last name '${validatedValue}' must be between {min} and {max} chars long")
    @NotNull(message = "Please provide last name")
    private String lastName;

    @Size(min = 10, max = 100, message = "Your address '${validatedValue}' must be between {min} and {max} chars long")
    @NotNull(message = "Please provide a valid address")
    private String address;

    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4}$",message = "Please provide valid phone number")
    @NotNull(message = "Please provide phone number")
    private String phone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =
            "yyyy-MM-dd", timezone = "Turkey")
    private LocalDate birthDate;

    @Email()
    @Size(min = 10, max = 80, message = "Your email '${validatedValue}' must be between {min} and {max} chars long")
    private String email;

    private Integer score;

    private String password;

    private Boolean builtIn;

    private Set<Role> roles;


}
