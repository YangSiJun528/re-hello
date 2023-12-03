package dev.yangsijun.rehello.application.domain.personalInformation;

import dev.yangsijun.rehello.application.domain.enums.GraduationStatus;
import dev.yangsijun.rehello.application.domain.enums.Major;
import dev.yangsijun.rehello.user.domain.Gender;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DiscriminatorColumn(name = "personal_information_type", discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractPersonalInformation {

    @Id
    public UUID id;

    @NotNull
    private String applicantImageUri;

    @NotNull
    private String applicantName;

    @NotNull
    private Gender applicantGender;

    @NotNull
    private LocalDate applicantBirth;

    @NotNull
    private String address;

    @NotNull
    private String detailAddress;

    @NotNull
    private GraduationStatus graduation;

    @Nullable
    private String telephone;

    @NotNull
    private String applicantPhoneNumber;

    @NotNull
    private String guardianName;

    @NotNull
    private String relationWithApplicant;

    // 인적사항에 있는게 맞나?
    // 아니면 인적사항 엔티티 이름을 변경하거나
    @Size(min = 3, max = 3)
    private Set<Major> desiredMajors;

    @AssertFalse(message = "모든 필드는 정의되어야 합니다. null일 수 없습니다.")
    private boolean hasNullMajor() {
        return desiredMajors.contains(null);
    }
}
