package dev.yangsijun.rehello.application.domain.vo;

import dev.yangsijun.rehello.application.domain.enums.GraduationStatus;
import dev.yangsijun.rehello.application.domain.enums.Major;
import dev.yangsijun.rehello.application.domain.enums.Screening;
import dev.yangsijun.rehello.user.domain.Gender;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

/**
 * Application 생성/수정 시 사용하는 객체.
 *
 * 생성/수정 객체 분리하기 귀찮아서 하나로 구현했는데, 실제 구현 시에는 따로 구현
 *
 * lombok.NonNull가 정의된 경우, null 값이 들어온다면 에러 발생
 * @see ApplicationCreateTest
 */
@With
@Getter
@AllArgsConstructor
public class AbstractApplicationCommand { // 추상 클래스 쓰면 구현체에서 wither 구현해야 해서 일단 추상클래스 사용 X

    @NonNull
    private String applicantImageUri;

    @NonNull
    private String applicantName;

    @NonNull
    private Gender applicantGender;

    @NonNull
    private LocalDate applicantBirth;

    @NonNull
    private String address;

    @NonNull
    private String detailAddress;

    @NonNull
    private GraduationStatus graduation;

    @Nullable
    private String telephone;

    @NonNull
    private String applicantPhoneNumber;

    @NonNull
    private String guardianName;

    @NonNull
    private String relationWithApplicant;

    @NonNull
    private String guardianPhoneNumber;

    @NonNull
    private Screening screening;

    @NonNull
    @Size(min = 3, max = 3)
    public Set<Major> desiredMajors;

    @AssertFalse(message = "모든 필드는 정의되어야 합니다. null일 수 없습니다.")
    private boolean hasNullMajor() {
        return desiredMajors.contains(null);
    }

    public abstract boolean isSupportGraduationStatus(GraduationStatus graduationStatus);
}
