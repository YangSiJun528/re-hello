package dev.yangsijun.rehello.application.domain.gradeCard;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DiscriminatorColumn(name = "grade_card_type", discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractGradeCard {
    @Id
    private UUID id;
}
