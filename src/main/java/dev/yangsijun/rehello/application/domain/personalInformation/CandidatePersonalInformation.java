package dev.yangsijun.rehello.application.domain.personalInformation;

import dev.yangsijun.rehello.application.domain.enums.GraduationStatus;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DiscriminatorValue(GraduationStatus.Values.CANDIDATE)
public class CandidatePersonalInformation extends AbstractPersonalInformation{
    @NotNull
    private String schoolName;

    @NotNull
    private String schoolLocation;

    @NotNull
    private String teacherName;

    @NotNull
    private String teacherPhoneNumber;
}
