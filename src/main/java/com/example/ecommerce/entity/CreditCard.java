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
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Entity
@Table(name = "credit_card", schema = "ecommerce")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "card_np")
    private Integer cardNo;

    @NotNull
    @Column(name = "expire_month")
    private Integer expireMonth;

    @NotNull
    @Column(name = "expire_year")
    private Integer expireYear;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(max = 50)
    @Column(name = "name_on_card")
    private String nameOnCard;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDate createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private LocalDate updatedAt;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
