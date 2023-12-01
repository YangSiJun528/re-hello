package dev.yangsijun.rehello.user.domain;

import jakarta.persistence.*;
import lombok.*;

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
    @NonNull
    private UUID id;

    @NonNull
    private String name;

    @NonNull
    private String phoneNumber;

    @NonNull
    private LocalDate birth;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NonNull
    private String provider;

    @NonNull
    private String providerId;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Role role;
}
