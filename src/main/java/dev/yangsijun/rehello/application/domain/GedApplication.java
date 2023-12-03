package dev.yangsijun.rehello.application.domain;

import dev.yangsijun.rehello.application.domain.enums.GraduationStatus;
import dev.yangsijun.rehello.application.domain.enums.Screening;
import dev.yangsijun.rehello.application.domain.gradeCard.AbstractGradeCard;
import dev.yangsijun.rehello.application.domain.gradeCard.GedGradeCard;
import dev.yangsijun.rehello.application.domain.personalInformation.AbstractPersonalInformation;
import dev.yangsijun.rehello.application.domain.personalInformation.GedPersonalInformation;
import dev.yangsijun.rehello.application.domain.vo.ApplicationCreate;
import dev.yangsijun.rehello.application.domain.vo.ApplicationUpdate;
import dev.yangsijun.rehello.user.domain.User;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue(GraduationStatus.Values.GED)
public class GedApplication extends AbstractApplication {
    protected GedApplication(@NotNull UUID id, GedPersonalInformation personalInformation, GedGradeCard gradeCard, ApplicationStatus applicationStatus, Screening screening, User user) {
        super(id, personalInformation, gradeCard, applicationStatus, screening, user);
    }

    @Override
    public AbstractApplication create(ApplicationCreate dto, User user) {
        return null;
    }

    @Override
    public AbstractApplication update(ApplicationUpdate dto) {
        return null;
    }
}
