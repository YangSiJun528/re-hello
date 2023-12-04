package dev.yangsijun.rehello.application.domain.vo;

import dev.yangsijun.rehello.application.domain.enums.GraduationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.With;

@With
@Builder
public class GedApplicationCommand extends AbstractApplicationCommand {
    @Override
    public boolean isSupportGraduationStatus(GraduationStatus graduationStatus) {
        return graduationStatus == GraduationStatus.GED;
    }
}
