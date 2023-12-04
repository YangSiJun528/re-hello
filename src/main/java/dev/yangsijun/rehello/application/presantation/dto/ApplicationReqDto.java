package dev.yangsijun.rehello.application.presantation.dto;

import dev.yangsijun.rehello.application.domain.enums.GraduationStatus;
import dev.yangsijun.rehello.application.domain.enums.Major;
import dev.yangsijun.rehello.application.domain.enums.Screening;
import dev.yangsijun.rehello.user.domain.Gender;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.Set;

/**
 * 해당 객체를 도메인에서 의존하는 문제가 있음.
 * 나중에 수정해야 함
 * 그 헥사고날 core 필요한 DTO 정의하는 것 처럼 그정도만 해도 될거 같긴 한데
 */
public record ApplicationReqDto(
        @NonNull String applicantImageUri,
        @NonNull String applicantName,
        @NonNull Gender applicantGender,
        @NonNull LocalDate applicantBirth,
        @NonNull String address,
        @NonNull String detailAddress,
        @NonNull GraduationStatus graduationStatus,
        @Nullable String telephone,
        @NonNull String applicantPhoneNumber,
        @NonNull String guardianName,
        @NonNull String relationWithApplicant,
        @NonNull String guardianPhoneNumber,
        @NonNull Screening screening,
        @Nullable String schoolName, // @Nullable 은 딱히 valid 용은 아니고 의미 상 사용
        @Nullable String schoolLocation,
        @Nullable String teacherName,
        @Nullable String teacherPhoneNumber,
        @NotNull @Size(min = 3, max = 3) Set<Major> desiredMajors
) {

    @AssertFalse(message = "모든 필드는 정의되어야 합니다. null일 수 없습니다.")
    private boolean hasNullMajor() {
        return desiredMajors.contains(null);
    }
}
