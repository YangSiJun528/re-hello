package dev.yangsijun.rehello.application.domain;

import dev.yangsijun.rehello.application.domain.enums.Major;
import dev.yangsijun.rehello.application.domain.enums.Screening;
import dev.yangsijun.rehello.application.domain.gradeCard.AbstractGradeCard;
import dev.yangsijun.rehello.application.domain.personalInformation.AbstractPersonalInformation;
import dev.yangsijun.rehello.application.domain.vo.ApplicationCreate;
import dev.yangsijun.rehello.application.domain.vo.ApplicationUpdate;
import dev.yangsijun.rehello.user.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;
import java.util.UUID;

/**
 * 원서 정보를 관리하는 엔티티.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED) //TODO 나중에 level 확인
@DiscriminatorColumn(name = "application_type", discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractApplication {

    /*
     * 필드에 @Column(nullable = false) 대신 @NotNull가 더 나을듯
     * 환경변수 설정하면 ddl-auto: none 에도 validation 수행 가능
     * https://jeong-pro.tistory.com/233 참고
     */
    @Id
    @NotNull
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, optional = false)
    private AbstractPersonalInformation personalInformation;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, optional = false)
    private AbstractGradeCard gradeCard;

    @Embedded
    private ApplicationStatus applicationStatus;

    @Enumerated(EnumType.STRING)
    private Screening screening;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    //TODO 객체 생성/변경을 어떻게 할 것인가?
    // Factory를 쓰기에는 변경도 있는데?
    // 그리고 음... 수정 작업이나 그런 걸 할 때, 이미 사용하는 객체 측에서 어떤 구현임을 알아야 하는거 아닌가?
    // -> Spring Security 인증 과정처럼 하면 되는거 아닌가?
    // -> 근데 이것도 마찬가지로 수정 작업 시 객체를 새로 생성해야 함
    // -> 뭐 크게 상관없을 듯?
//    public AbstractApplication(ApplicationCreate dto, User user) {
//    }

    public abstract AbstractApplication create(ApplicationCreate dto, User user);
    public abstract AbstractApplication update(ApplicationUpdate dto);

//    public AbstractApplication update(ApplicationUpdate dto) {
//        return new AbstractApplication(, this.user);
//    }
}
