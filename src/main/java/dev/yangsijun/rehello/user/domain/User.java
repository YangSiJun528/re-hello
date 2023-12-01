package dev.yangsijun.rehello.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

/**
 * 본인인증이 완료된 사용자 정보를 관리하는 엔티티.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    private UUID id;

    private String name;

    private String phoneNumber;

    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String provider;

    private String providerId;

    @Enumerated(EnumType.STRING)
    private Role role;
}
