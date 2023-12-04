package dev.yangsijun.rehello.application.presantation.dto;

import lombok.NonNull;

public record UpdateSomeFieldDto(
        @NonNull String applicantImageUri,
        @NonNull String applicantName
) {
}
