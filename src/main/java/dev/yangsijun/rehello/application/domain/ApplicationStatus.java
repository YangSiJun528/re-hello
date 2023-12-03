package dev.yangsijun.rehello.application.domain;

import dev.yangsijun.rehello.application.domain.enums.EvaluationStatus;
import dev.yangsijun.rehello.application.domain.enums.Major;
import dev.yangsijun.rehello.application.domain.enums.Screening;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Embeddable
public class ApplicationStatus {

    @NotNull
    private Boolean isFinalSubmitted;

    @NotNull
    private Boolean isPrintsArrived;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EvaluationStatus firstEvaluation;

    @Nullable
    @Enumerated(EnumType.STRING)
    private EvaluationStatus secondEvaluation;

    @Nullable
    @Enumerated(EnumType.STRING)
    private Screening screeningFirstEvaluationAt;

    @Nullable
    @Enumerated(EnumType.STRING)
    private Screening screeningSecondEvaluationAt;

    @Nullable
    private Long registrationNumber;  // 접수 번호, 원서 제출 기간 후 배정됨

    @Nullable
    private BigDecimal secondScore;

    @Nullable
    @Enumerated(EnumType.STRING)
    private Major finalMajor;
}
