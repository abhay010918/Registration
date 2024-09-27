package com.api.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegistrationDto {
        @NotEmpty
        @Size(min = 2, message = "minimum should be tow letter")
        private String name;

        @Email
        private String email;

        @Size(min = 10, max = 10, message = "mobile number should be 10 digit")
        private String mobile;


    }

