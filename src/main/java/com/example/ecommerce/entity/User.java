package com.example.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;

@Entity
@Table(name = "user", schema = "ecommerce")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(max = 50)
    @Column(name = "full_name")
    private String fullName;

    @NotBlank
    @NotEmpty
    @NotNull
    @Size(max = 100)
    @Column(name = "email")
    private String email;

    @NotBlank
    @NotEmpty
    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDate createdAt;

}
