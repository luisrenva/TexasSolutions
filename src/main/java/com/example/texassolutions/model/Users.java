package com.example.texassolutions.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int userId;

    @NotBlank(message = "User name is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;

    private LocalDate createdDate;

    @NotNull(message = "Application cannot be null")
    @OneToMany
    @JoinColumn(name = "application_id")
    @JsonProperty("application")
    private int applicationId;
}
