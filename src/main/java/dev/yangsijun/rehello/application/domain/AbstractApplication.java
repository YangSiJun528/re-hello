package dev.yangsijun.rehello.application.domain;

import dev.yangsijun.rehello.application.domain.enums.Major;
import dev.yangsijun.rehello.application.domain.enums.Screening;
import dev.yangsijun.rehello.application.domain.gradeCard.AbstractGradeCard;
import dev.yangsijun.rehello.application.domain.personalInformation.AbstractPersonalInformation;
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
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC) //TODO 나중에 level 확인
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
    // -> 이름 일단 Manager 정도로 정함

    // TODO 로직 구싱
    //  생성/수정 시 받는 DTO는 상속 없이, 대신 validator 에서 null 등 유효성 검사함
    //  근데 그럼 특정 필드만 있는 DTO로 수정하려는 경우, Manager에서 특정 필드 DTO를 지원해야 하는데...
    //  그럼 Domain <-> ReqDto(전체 필드 정의, 수정) 매핑 기능을 만들고
    //  일부변경ReqDto, ReqDto -[wither 패턴]-> 수정 반영된 ReqDto 로 해결 가능함
    //  -> 근데 이게 맞나?
    //  차라리 ReqDto(전체 필드 정의, 수정) <-> 생성/변경 dto(domain 패키지 내)를 만드는게 더 나을듯?
    //  wither도 동일하게 쓰고

    // TODO 로직 정리
    //  필요 객체
    //      1. command, 원서 구현체마다 다름, 추상클래스 상속 사용해서 구현
    //      2. ReqDto - 하나
    //      3. validator - ReqDto를 읽고 전형 타입에 따라 유효성 검사 진행
    //      4. manager - 생성/변경 역할, 타입에 따라 다른 구현체 반환, input으로 1번 객체 받아서 처리
    //      5. x- mapper - ReqDto <-> command 변환 - 변환 시 validation 수행 - 여러번 쓰일거 같은데 확시 모르니까(구현 안함, 일단 command 생성자에 ReqDto 추가할꺼임, 나중에 변경)
    //        -> 근데 그러면 의존성 문제 때문에 음... - 어차피 manager에서도 의존하지 않나?
    //        -> 의존성 문제가 있는건 맞는데, 그냥 주의하라고 하고 일단 구현하는게 나을듯?
    //        -> 지금 당장으로서는 여기서 더 나을 설계를 만들 수 있을거 같지 않음
    //        -> mapper는 구현해도 되고 안해도 됨, 근데 하는게 가독성 좋을듯
}
