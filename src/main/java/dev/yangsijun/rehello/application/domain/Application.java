package dev.yangsijun.rehello.application.domain;

import dev.yangsijun.rehello.application.domain.vo.ApplicationCreate;
import dev.yangsijun.rehello.application.domain.vo.ApplicationUpdate;
import dev.yangsijun.rehello.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

/**
 * 원서 정보를 관리하는 엔티티.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Application {

    /*
     * 필드에 @Column(nullable = false) 대신 @NotNull가 더 나을듯
     * 환경변수 설정하면 ddl-auto: none 에도 validation 수행 가능
     * https://jeong-pro.tistory.com/233 참고
     */
    @Id
    @NonNull
    private UUID id;

    //@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, optional = false)

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    public Application(ApplicationCreate dto, User user) {
        this.id = dto.id;
        this.user = user;
    }

    public Application update(ApplicationUpdate dto) {
        return new Application(new ApplicationCreate(UUID.randomUUID(), dto.any, dto.any1), this.user);
    }
}
