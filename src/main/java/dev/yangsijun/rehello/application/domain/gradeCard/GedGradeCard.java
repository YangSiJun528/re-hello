package dev.yangsijun.rehello.application.domain.gradeCard;

import dev.yangsijun.rehello.application.domain.enums.GraduationStatus;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DiscriminatorValue(GraduationStatus.Values.GED)
public class GedGradeCard extends AbstractGradeCard {
    @NotNull
    private String gedGrade1;
}
