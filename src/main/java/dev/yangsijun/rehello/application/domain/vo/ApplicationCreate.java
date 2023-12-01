package dev.yangsijun.rehello.application.domain.vo;

import lombok.*;

import java.util.UUID;

/**
 * Application 생성 시 사용하는 객체.
 *
 * lombok.NonNull가 정의된 경우, null 값이 들어온다면 에러 발생
 * @see ApplicationCreateTest
 */
@With
@Builder
@AllArgsConstructor
public class ApplicationCreate {
    @NonNull
    public final UUID id;

    @NonNull
    public final String any;

    @NonNull
    public final String any1;
}
