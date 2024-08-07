package com.isudha.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends BaseModel {
    @OneToOne
    private User user;
    private String email;
    private String phone;
    private String fullName;
}
