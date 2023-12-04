package dev.yangsijun.rehello.application.domain.vo;

import dev.yangsijun.rehello.application.domain.enums.GraduationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.With;

@With
@Builder
public class GraduateApplicationCommand extends AbstractApplicationCommand {

    @NonNull
    private String schoolName;

    @NonNull
    private String schoolLocation;

    @NonNull
    private String teacherName;

    @NonNull
    private String teacherPhoneNumber;

    @Override
    public boolean isSupportGraduationStatus(GraduationStatus graduationStatus) {
        return graduationStatus == GraduationStatus.GRADUATE;
    }
}
