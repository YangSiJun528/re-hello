package dev.yangsijun.rehello.application.domain;

import dev.yangsijun.rehello.application.domain.enums.GraduationStatus;
import dev.yangsijun.rehello.application.domain.vo.AbstractApplicationCommand;
import dev.yangsijun.rehello.application.domain.vo.CandidateApplicationCommand;
import dev.yangsijun.rehello.application.domain.vo.GedApplicationCommand;
import dev.yangsijun.rehello.application.domain.vo.GraduateApplicationCommand;
import dev.yangsijun.rehello.application.presantation.dto.ApplicationReqDto;

public class ApplicationMapper {

    public AbstractApplicationCommand create(ApplicationReqDto req) {
        ApplicationValidator.isValid(req);

        AbstractApplicationCommand command;
        if (req.graduationStatus().equals(GraduationStatus.CANDIDATE)) {
            command = CandidateApplicationCommand.builder().build();
        } else if (req.graduationStatus().equals(GraduationStatus.GRADUATE)) {
            command = GraduateApplicationCommand.builder().build();
        } else if (req.graduationStatus().equals(GraduationStatus.GED)) {
            command = GedApplicationCommand.builder().build();
        } else {
            throw new IllegalArgumentException("지원하지 않는 GraduationStatus : " + req.graduationStatus());
        }
        return command;
    }
}


//
