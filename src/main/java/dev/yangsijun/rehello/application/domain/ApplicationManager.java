package dev.yangsijun.rehello.application.domain;

import dev.yangsijun.rehello.application.domain.enums.GraduationStatus;
import dev.yangsijun.rehello.application.domain.vo.AbstractApplicationCommand;
import dev.yangsijun.rehello.application.domain.vo.CandidateApplicationCommand;
import dev.yangsijun.rehello.application.domain.vo.GedApplicationCommand;
import dev.yangsijun.rehello.application.domain.vo.GraduateApplicationCommand;

import java.util.UUID;

public class ApplicationManager {

    public static AbstractApplication create(AbstractApplicationCommand cmd) {

        UUID id = UUID.randomUUID();
        AbstractApplication app;
        if (cmd.getGraduation().equals(GraduationStatus.CANDIDATE)) {
            CandidateApplicationCommand command = (CandidateApplicationCommand) cmd;
            app = CandidateApplication.builder().build();
        } else if (cmd.getGraduation().equals(GraduationStatus.GRADUATE)) {
            GraduateApplicationCommand command = (GraduateApplicationCommand) cmd;
            app = GraduateApplication.builder().build();
        } else if (cmd.getGraduation().equals(GraduationStatus.GED)) {
            GedApplicationCommand command = (GedApplicationCommand) cmd;
            app = GedApplication.builder().build();
        } else {
            throw new IllegalArgumentException("지원하지 않는 GraduationStatus : " + cmd.getGraduation());
        }
        return app;
    }

    public static AbstractApplication update(AbstractApplication application , AbstractApplicationCommand cmd) {

        UUID id = application.getId();
        AbstractApplication app;
        if (cmd.getGraduation().equals(GraduationStatus.CANDIDATE)) {
            CandidateApplicationCommand command = (CandidateApplicationCommand) cmd;
            app = CandidateApplication.builder().build();
        } else if (cmd.getGraduation().equals(GraduationStatus.GRADUATE)) {
            GraduateApplicationCommand command = (GraduateApplicationCommand) cmd;
            app = GraduateApplication.builder().build();
        } else if (cmd.getGraduation().equals(GraduationStatus.GED)) {
            GedApplicationCommand command = (GedApplicationCommand) cmd;
            app = GedApplication.builder().build();
        } else {
            throw new IllegalArgumentException("지원하지 않는 GraduationStatus : " + cmd.getGraduation());
        }
        return app;
    }
}


//
