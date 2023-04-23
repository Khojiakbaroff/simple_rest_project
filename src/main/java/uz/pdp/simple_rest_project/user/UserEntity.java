package uz.pdp.simple_rest_project.user;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @Column(unique = true, nullable = false, length = 30)
    String username;

    @Column(nullable = false)
    String password;

    @Column(length = 50)
    String firstname;

    @Column(length = 50)
    String lastname;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Enumerated(EnumType.STRING)
    List<Role> roles;

    @CreatedDate
    @Column(updatable = false)
    @CreationTimestamp
    LocalDateTime createdDateTime;

    @LastModifiedDate
    LocalDateTime lastModifiedDateTime;

}
