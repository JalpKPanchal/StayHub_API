package com.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "user")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment integer ID
    @Column(nullable = false, unique = true)
    Integer userId;

    @Column(length = 20, unique = true, nullable = false)
    String email;

    @Column(length = 20, nullable = false)
    String password;

    @Column(length = 20)
    String mobileNo;

    @Column(nullable = false, length = 15) // Role is now a String (e.g., "admin", "member", "security")
    String role;

    @Column(length = 30, nullable = false)
    String firstName;

    @Column(length = 30)
    String lastName;

    @Column(length = 50)
    String profilePhoto;
}
