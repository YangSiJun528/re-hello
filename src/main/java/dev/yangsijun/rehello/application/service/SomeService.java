package dev.yangsijun.rehello.application.service;

import dev.yangsijun.rehello.application.domain.AbstractApplication;
import dev.yangsijun.rehello.application.domain.ApplicationManager;
import dev.yangsijun.rehello.application.domain.vo.AbstractApplicationCommand;
import dev.yangsijun.rehello.application.presantation.dto.UpdateSomeFieldDto;

public class SomeService {
    public void aa(UpdateSomeFieldDto dto, AbstractApplicationCommand command) {
        AbstractApplication application;
        command.withApplicantName(dto.applicantName()).withApplicantImageUri(dto.applicantImageUri());
        return ApplicationManager.update(application, command);
    }
}
