package dev.yangsijun.rehello.application.domain;

import dev.yangsijun.rehello.application.domain.enums.GraduationStatus;
import dev.yangsijun.rehello.application.presantation.dto.ApplicationReqDto;

public class ApplicationValidator {

    public static Boolean isValid(ApplicationReqDto req) {
        if (req.graduationStatus().equals(GraduationStatus.CANDIDATE)) {
            requireNotNull(req.graduationStatus());
        } else if (req.graduationStatus().equals(GraduationStatus.GRADUATE)) {
            requireNotNull(req.graduationStatus());
            requireNotNull(req.graduationStatus());
        } else if (req.graduationStatus().equals(GraduationStatus.GED)) {
            requireNotNull(req.graduationStatus());
            requireNotNull(req.graduationStatus());
            requireNotNull(req.graduationStatus());
        } else {
            throw new IllegalArgumentException("지원하지 않는 GraduationStatus : " + req.graduationStatus());
        }
        return true;
    }

    private static void requireNotNull(Object ojb) {
        if(ojb == null) throw new IllegalArgumentException(ojb + "must not null");
    }
}
