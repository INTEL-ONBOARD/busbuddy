package com.userservice.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    @NotNull
    @Size(min = 5, message = "Username must be at least 5 characters")
    private String username;

    @NotNull
    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$",
            message = "Password must be at least 8 characters, contain at least one letter and one number")
    private String password;
}
