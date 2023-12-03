package dev.yangsijun.rehello.application.domain.gradeCard;

import dev.yangsijun.rehello.application.domain.enums.GraduationStatus;
import dev.yangsijun.rehello.application.domain.enums.ScreeningCategory;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DiscriminatorValue(GraduationStatus.Values.GRADUATE)
public class GraduateGradeCard extends AbstractGradeCard {
    @NotNull
    private String graduateGrade1;
}
