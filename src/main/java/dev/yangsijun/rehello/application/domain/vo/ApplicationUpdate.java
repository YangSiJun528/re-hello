package dev.yangsijun.rehello.application.domain.vo;

import lombok.*;

@With
@Builder
@AllArgsConstructor
public class ApplicationUpdate {
    @NonNull
    public final String any;

    @NonNull
    public final String any1;
}
