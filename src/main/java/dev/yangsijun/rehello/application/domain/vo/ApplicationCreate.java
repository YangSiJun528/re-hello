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
import java.util.UUID;

/**
 * Application 생성 시 사용하는 객체.
 * lombok.NonNull가 정의된 경우, null 값이 들어온다면 에러 발생
 * @see ApplicationCreateTest
 */
@With
@Builder
@AllArgsConstructor
public class ApplicationCreate {
    @NonNull
    public final UUID id;

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

    @Nullable
    private String schoolName;

    @Nullable
    private String schoolLocation;

    @Nullable
    private String teacherName;

    @Nullable
    private String teacherPhoneNumber;

    @NonNull
    private Screening screening;

    @NonNull
    @Size(min = 3, max = 3)
    public final Set<Major> desiredMajors;

    @AssertFalse(message = "모든 필드는 정의되어야 합니다. null일 수 없습니다.")
    private boolean hasNullMajor() {
        return desiredMajors.contains(null);
    }
}
